import java.awt.image.BufferedImage;

/**
 * Created by aakash on 26/8/16.
 */
public class GlobalVariable {

    //public static boolean animator = false;

    public static boolean mouse_drag = false;
    public static boolean eraser_flag = false;

    public static float r = 0, g = 1, b = 0;
    public static boolean lineCreator = false;
    public static int polygonCreator = -1;
    public static double X_poly[] = new double[4];
    public static double Y_poly[] = new double[4];

    public static boolean penToolButton = true;
    public static boolean lineToolButton = false;
    public static boolean triangleToolButton = false;
    public static boolean quadToolButton = false;
    public static boolean circleToolButton = false;
    public static boolean clearToolButton = false;
    public static boolean save = false;
    public static boolean open = false;

    public static int frameWidth, frameHeight;
    public static String text;

    public static BufferedImage shot;
    public static MyFrame currentFrame;

    public static String fileExtension(String name) {
        String ext = null;
        // write a code that returns file name extension
        return ext;
    }
}
