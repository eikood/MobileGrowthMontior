package de.hs_mannheim.planb.mobilegrowthmonitor.imageprocessing;

import android.annotation.SuppressLint;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Environment;
import android.util.Log;
import android.widget.Toast;

import org.opencv.android.Utils;
import org.opencv.core.CvException;
import org.opencv.core.Mat;
import org.opencv.core.MatOfPoint;
import org.opencv.core.MatOfPoint2f;
import org.opencv.core.Point;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;
import org.opencv.core.Size;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

/**
 * Created by eikood on 05.05.2016.
 */
public class ImageProcess {

    private static final String TAG = "ImageProcess";

    private static Context context;
    private final double REFERENCEOBJECTHEIGHT = 14.9;
    private final double PERSONPOSITION = 3;

    public ImageProcess(Context c) {
        context = c;
    }

    public ImageProcess() {
    }

    // this is our prototype function!!
    public double sizeMeasurement(String path) throws IllegalArgumentException {
        // init
        Mat source = Imgcodecs.imread(path);
        Imgproc.resize(source, source, new Size(source.width() / 2, source.height() / 2));


        Mat hierarchy = new Mat();
        Size size = new Size(7, 7);
        List<MatOfPoint> contours = new ArrayList<>();

        Bitmap bmp = null;
        double heightOfPerson = 0;
        double yCoordinateHorizontalLine = 0;
        double heightReferenceObject = 0;
        int yCoordinateHighestPoint = 0;
        int xCoordinateHighestPoint = 0;
        boolean breakForLoop = false;
        try {
            Mat destination;
            destination = source.clone();


            Imgproc.cvtColor(source, destination, Imgproc.COLOR_BGR2GRAY);
            Imgproc.GaussianBlur(destination, destination, size, 0);
            Imgproc.Canny(destination, destination, 50, 100);
            Imgproc.findContours(destination, contours, hierarchy, Imgproc.RETR_LIST, Imgproc.CHAIN_APPROX_SIMPLE);

            List<MatOfPoint> rectContour = getRectContour(contours);
            if (rectContour == null) {
                Log.i(TAG,"calculate 2");
                double calculatedWith2 = sizeMeasurement2(destination,source);
                if(calculatedWith2 < 50|| calculatedWith2 >250){
                    throw new IllegalArgumentException("No reference Object found or another error hihi");

                }
                return calculatedWith2;

            }
            yCoordinateHorizontalLine = getYLowerHorizontalLine(destination);

            // Find Contour of ReferenceObject in middle of left side of the picture

            Collections.sort(rectContour, new Comparator<MatOfPoint>() {
                @Override
                public int compare(MatOfPoint lhs, MatOfPoint rhs) {
                    return Imgproc.boundingRect(lhs).x - Imgproc.boundingRect(rhs).x;
                }
            });
            int i = 0;
            for (MatOfPoint m : rectContour) {
                if (Imgproc.boundingRect(m).y < source.height() / 2) { //reference object should be in the upper half
                    Imgproc.drawContours(source, rectContour, i, new Scalar(0, 255, 0), 2);
                    heightReferenceObject = Imgproc.boundingRect(m).height;
                    break;
                }
            }

            for (int j = destination.rows() / 10; j < destination.rows() * 2 / 3; j++) {
                for (int k = (int) (destination.cols() / PERSONPOSITION); k < destination.cols() * 2 / PERSONPOSITION; k++) {
                    if (destination.get(j, k)[0] > 0) {
                        yCoordinateHighestPoint = j;
                        xCoordinateHighestPoint = k;

                        breakForLoop = true;
                        break;
                    }

                }
                if (breakForLoop) {
                    break;
                }
            }

            //draw Line from lowest to highest point
            Imgproc.line(source, new Point(xCoordinateHighestPoint, yCoordinateHorizontalLine),
                    new Point(xCoordinateHighestPoint, yCoordinateHighestPoint), new Scalar(0, 255, 0), 3);
            // Height of ReferenceObject and SizeMeasurement
            // TODO: change to alertDialog
            double heightInPixels = yCoordinateHorizontalLine - yCoordinateHighestPoint;
            heightOfPerson = heightInPixels / heightReferenceObject * REFERENCEOBJECTHEIGHT;
            DecimalFormat df = new DecimalFormat("####0.00");
            String resultString = df.format(heightOfPerson);
            Toast.makeText(context, "Height is: " + resultString + " cm", Toast.LENGTH_LONG).show();
            Log.i("Size = ", resultString);
            Imgproc.cvtColor(source, source, Imgproc.COLOR_BGR2RGB);
            bmp = Bitmap.createBitmap(source.cols(), source.rows(), Bitmap.Config.ARGB_8888);
            Utils.matToBitmap(source, bmp);

        } catch (CvException e) {
            Log.e("sizeMeasurement(): ", e.getMessage());
        }
        imageWriter(bmp);
        return heightOfPerson;
    }

    public static boolean isContourSquare(MatOfPoint thisContour) {
        MatOfPoint2f approxCurve = new MatOfPoint2f();
        //Convert contours from MatOfPoint to MatOfPoint2f
        MatOfPoint2f contour2f = new MatOfPoint2f(thisContour.toArray());
        //Processing on mMOP2f1 which is in type MatOfPoint2f
        double approxDistance = Imgproc.arcLength(contour2f, true) * 0.02;

        if (approxDistance > 5) {

            //Find Polygons
            Imgproc.approxPolyDP(contour2f, approxCurve, approxDistance, true);


            //Convert back to MatOfPoint
            MatOfPoint points = new MatOfPoint(approxCurve.toArray());


            //Rectangle Checks - Points, area, convexity
            if (points.total() == 4 && Math.abs(Imgproc.contourArea(points)) > 1000 && Imgproc.isContourConvex(points)) {


                Rect rect = Imgproc.boundingRect(points);

                if (Math.abs(rect.height - rect.width) < 100) {
                    // draw enclosing rectangle
                    //TODO Change back to picori

                    return true;

                }

            }
        }
        return false;
    }

    public static List<MatOfPoint> getRectContour(List<MatOfPoint> contours) {

        List<MatOfPoint> squares = null;

        for (MatOfPoint c : contours) {

            if ((ImageProcess.isContourSquare(c))) {

                if (squares == null)
                    squares = new ArrayList<MatOfPoint>();
                squares.add(c);
            }
        }

        return squares;
    }

    // finding lower horizontal Line
    public int getYLowerHorizontalLine(Mat img) {
        // init
        Mat source = img;
        int threshold = 50;
        int minLineLength = 10;
        int maxLineGap = 10;
        Mat lines = new Mat();
        int miny = 0;
        try {
            Mat destination;
            destination = source;

            //
            //    Imgproc.cvtColor(source, destination, Imgproc.COLOR_BGR2GRAY);
            //    Imgproc.Canny(destination, destination, 50, 100, 3, true); TODO: Maybe change this with the upper canny edge
            Imgproc.HoughLinesP(destination, lines, 1, Math.PI / 360, threshold, minLineLength, maxLineGap);
            for (int x = 0; x < lines.rows(); x++) {
                double[] vec = lines.get(x, 0);
                double x1 = vec[0],
                        y1 = vec[1],
                        x2 = vec[2],
                        y2 = vec[3];
                if ((Math.atan2(y2 - y1, x2 - x1) * 180 / Math.PI == 0)) {
                    //   if (source.width() / 4.0 < x2 && x2 < source.width() * 3.0 / 4.0 && y1 > miny && y1 < source.height()) {
                    if (source.width() / 4.0 > x1 && y1 > miny && y1 < source.height()) {

                        miny = (int) y1;
                    }
                }
            }
        } catch (CvException e) {
            Log.e("backgroundSub():", e.getMessage());
        }
        return miny;
    }

    @SuppressLint("SimpleDateFormat")
    private void imageWriter(Bitmap bmp) {
        FileOutputStream out = null;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
            String timeStamp = sdf.format(new Date());
            String fileName = Environment.getExternalStorageDirectory().getPath() +
                    "/growpics/" + timeStamp + "_filter.jpg";
            out = new FileOutputStream(fileName, true);
            bmp.compress(Bitmap.CompressFormat.JPEG, 50, out);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (out != null) {
                    out.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    /**
     * This function is called when our first size Measurement doesnt wield any results
     * @param source
     * @return
     */
    public double sizeMeasurement2(Mat destination,Mat original) {

       // Mat destination = source.clone();
        Mat hierarchy = new Mat();
        Size size = new Size(7, 7);
        List<MatOfPoint> contours = new ArrayList<>();
        int erosion_size = 5;
        int dilation_size = 5;
        Mat element = Imgproc.getStructuringElement(Imgproc.MORPH_RECT, new Size(2 * erosion_size + 1,
                2 * erosion_size + 1));
        Mat element1 = Imgproc.getStructuringElement(Imgproc.MORPH_RECT, new Size(2 * dilation_size + 1,
                2 * dilation_size + 1));
        Bitmap bmp = null;
        Rect rect_small;
        double heightOfPerson = 0;
        double yCoordinateHorizontalLine;
        double heightReferenceObject = 0;
        int yCoordinateHighestPoint = 0;
        int xCoordinateHighestPoint = 0;
        boolean breakForLoop = false;
        try {

            yCoordinateHorizontalLine =  getYLowerHorizontalLine(destination);
            Imgproc.dilate(destination, destination, element);
            Imgproc.erode(destination, destination, element1);
            Imgproc.findContours(destination, contours, hierarchy, Imgproc.RETR_LIST, Imgproc.CHAIN_APPROX_SIMPLE);
            Collections.sort(contours, new Comparator<MatOfPoint>() {
                @Override
                public int compare(MatOfPoint lhs, MatOfPoint rhs) {
                    return Imgproc.boundingRect(lhs).x - Imgproc.boundingRect(rhs).x;
                }
            });

            // Find Contour of ReferenceObject in middle of left side of the picture
            int i = 0;
            for (MatOfPoint m : contours) {
                Rect temp = Imgproc.boundingRect(m);

                if (temp.y+temp.height < original.height() / 2 && temp.y+temp.height
                        > original.height() / 10.0) {
                    Imgproc.drawContours(original, contours, i, new Scalar(0, 255, 0), 2);
                    heightReferenceObject = temp.height;
                    break;
                }
                i++;
            }
            rect_small = Imgproc.boundingRect(contours.get(i));
            Imgproc.rectangle(original, new Point(rect_small.x, rect_small.y), new Point(rect_small.x +
                    rect_small.width, rect_small.y + rect_small.height), new Scalar(0, 255, 0), 3);
            for (int j = destination.rows() / 50; j < destination.rows() * 2 / 3; j++) {
                for(int k =(int)(destination.cols()/PERSONPOSITION);k<destination.cols()*2/PERSONPOSITION;k++){
                    if (destination.get(j, k)[0] > 0) {
                        yCoordinateHighestPoint = j;
                        xCoordinateHighestPoint = k;

                        breakForLoop = true;
                        break;
                    }

                }
                if(breakForLoop){
                    break;
                }
            }
            Imgproc.line(original, new Point(xCoordinateHighestPoint, yCoordinateHorizontalLine),
                    new Point(xCoordinateHighestPoint, yCoordinateHighestPoint), new Scalar(0, 255, 0), 3);
            // Height of ReferenceObject and SizeMeasurement
            // TODO: change to alertDialog
            double heightInPixels = yCoordinateHorizontalLine - yCoordinateHighestPoint;
            heightOfPerson = heightInPixels / heightReferenceObject * REFERENCEOBJECTHEIGHT;
            DecimalFormat df = new DecimalFormat("####0.00");
            String resultString = df.format(heightOfPerson);
            Log.i("Size = ", resultString);

            Toast.makeText(context, "Height is: " + resultString + " cm", Toast.LENGTH_LONG).show();
            Imgproc.cvtColor(original, original, Imgproc.COLOR_BGR2RGB);
            bmp = Bitmap.createBitmap(original.cols(), original.rows(), Bitmap.Config.ARGB_8888);
            Utils.matToBitmap(original, bmp);

        } catch (CvException e) {
            Log.e("sizeMeasurement(): ", e.getMessage());
        }
        imageWriter(bmp);
        return heightOfPerson;
    }
}
