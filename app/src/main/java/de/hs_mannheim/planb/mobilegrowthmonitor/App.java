package de.hs_mannheim.planb.mobilegrowthmonitor;

/**
 * Main Application - needed for PinLock all activities of MobileGrowthMonitor
 * concerning security purposes
 *
 * Starts MainView:Activity or when App is locked AppLock:Activity
 *
 */

import android.app.Application;
import android.util.Log;

import org.opencv.android.BaseLoaderCallback;
import org.opencv.android.LoaderCallbackInterface;
import org.opencv.android.OpenCVLoader;

import de.hs_mannheim.planb.mobilegrowthmonitor.pinlock.LockManager;


public class App extends Application {
    public static final String TAG = App.class.getSimpleName();



    @Override
    public void onCreate() {
        super.onCreate();
        LockManager.getInstance().enableAppLock(this);
    }



}