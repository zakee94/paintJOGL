import com.jogamp.opengl.util.FPSAnimator;
import javax.swing.*;
import java.awt.image.BufferedImage;

/**
 * Created by aakash on 26/8/16.
 */
public class GlobalVariable {

    public static boolean mouse_drag = false;
    public static boolean mouse_pressed = false;
    public static boolean eraser_flag = false;

    public static float r = 0, g = 0, b = 0;
    public static double filterR = 1.0, filterG = 1.0, filterB = 1.0;

    public static boolean lineCreator = false;
    public static int polygonCreator = -1;
    public static double X_poly[] = new double[10];
    public static double Y_poly[] = new double[10];

    public static boolean penToolButton = true;
    public static boolean lineToolButton = false;
    public static boolean triangleToolButton = false;
    public static boolean polygonToolButton = false;
    public static boolean textToolButton = false;
    public static boolean clearToolButton = false;
    public static boolean rectToolButton = false;
    public static boolean save = false;
    public static boolean open = false;

    public static boolean axial = false;
    public static boolean empty = false;
    public static double slope = 0;
    public static int polySides = 4;

    public static float lineWidth = 5;

    public static int frameWidth, frameHeight;
    public static String text;

    public static BufferedImage shot;
    public static MyFrame currentFrame;
    public static FPSAnimator currentAnimator;

    public static String textFont, myText = "Your text here";
    public static int fontType, textSize = 50;

    public static JTextField tField;

    public static String fileExtension(String name) {
        int pointIndex = name.lastIndexOf(".");

        if(pointIndex == -1){
            return null;
        }
        if(pointIndex == name.length() - 1){
            return null;
        }
        return name.substring(pointIndex + 1, name.length());
        // write a code that returns file name extension
    }
}
