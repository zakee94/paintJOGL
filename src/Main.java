/**
 * Created by zakee94 on 24/8/16.
 */

import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.awt.GLCanvas;
import com.jogamp.opengl.util.FPSAnimator;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Main {

    private static GLCanvas myCanvas;

    public static void main(String[] args) {

        System.setProperty("sun.awt.noerasebackground", "true");

        final GLProfile profile = GLProfile.get(GLProfile.GL2);
        GLCapabilities capabilities = new GLCapabilities(profile);

        /**/
        myCanvas = new GLCanvas(capabilities);

        DrawingTools mainInstance = new DrawingTools();

        MyFrame frame1 = new MyFrame(myCanvas);

        MyMouse mouse1 = new MyMouse(DrawingTools.ML);
        /**/

        myCanvas.addGLEventListener(mainInstance);
        myCanvas.addMouseListener(mouse1);
        myCanvas.addMouseMotionListener(mouse1);

        //
        final FPSAnimator animator = new FPSAnimator(myCanvas, 120, true);

        //
        animator.start();
    }
}

