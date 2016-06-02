
package de.hs_mannheim.planb.mobilegrowthmonitor;
        import android.graphics.Bitmap;
        import android.hardware.Camera;
        import org.junit.Test;
        import org.opencv.core.Core;
        import java.util.ArrayList;
        import java.util.List;
        import de.hs_mannheim.planb.mobilegrowthmonitor.database.ProfileData;
        import de.hs_mannheim.planb.mobilegrowthmonitor.datavisual.ImageAdapter;
        import de.hs_mannheim.planb.mobilegrowthmonitor.datavisual.ListAdapter;
        import de.hs_mannheim.planb.mobilegrowthmonitor.imageprocessing.ImageProcess;
        import de.hs_mannheim.planb.mobilegrowthmonitor.imageprocessing.NativeCam;
        import de.hs_mannheim.planb.mobilegrowthmonitor.pinlock.AppLock;
        import de.hs_mannheim.planb.mobilegrowthmonitor.pinlock.Encryptor;
        import de.hs_mannheim.planb.mobilegrowthmonitor.pinlock.LockManager;

        import static org.junit.Assert.*;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
public class ExampleUnitTest {


    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void testApp(){
        LockManager lm = LockManager.getInstance();
        assertNotNull(lm);
        assertTrue(lm instanceof LockManager);
        lm = null;
    }

    @Test
    public void testNativeCam(){
        NativeCam n = new NativeCam();
        assertNotNull(n);
        assertTrue(n instanceof NativeCam);
        n = null;
    }

  /*  @Test
    public void testGetCameraInstance(){
        Camera c = NativeCam.getCameraInstance();
        assertNotNull(NativeCam.getCameraInstance());
        assertTrue(c instanceof Camera);
        c = null;
    }
  */

    @Test
    public void testImageAdapter(){
        ArrayList<Bitmap> list = new ArrayList<>();
        ArrayList<String> pathlist = new ArrayList<>();
        ImageAdapter ia = new ImageAdapter(null, list, pathlist);
        assertEquals(0, ia.getCount());
        ia = null;
    }

    /*Mocked
    @Test
    public void testListAdapter(){
        List<ProfileData> list = new ArrayList<ProfileData>();
        ListAdapter la = new ListAdapter(null, list);
        assertEquals(0, la.getItemCount());
        la = null;
    }
    */

    @Test
    public void testPasscode(){
        AppLock al = new AppLock(/*App als Parameter*/ null);
        // MEthode aufrufen mit gespeichertem Passwort, dann assertTrue(PASSWORD, al.checkPassword)
        //setPasscode aufrufen , danach prüfen ob !PASSWORD_PREFERENCE_KEY.equals("passcode");
        // wenn Password gesetzt ist, kann isPasscode getestet werden
    }

    @Test
    public void testEncryptor() {
        String v = Encryptor.getSHA1("test");
        String b = Encryptor.getSHA1(null);
        assertEquals("da39a3ee5e6b4b0d3255bfef95601890afd80709", v);
        assertEquals(null, b);
    }

    public void sizeIsMeasured() throws Exception{
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        ImageProcess ip = new ImageProcess();
        assertEquals(171,ip.sizeMeasurement("C:\\Users\\Yogi\\Desktop\\growpics\\torsten.png"),5);
    }

}