/**
 * Created by zakee94 on 24/8/16.
 */

import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.awt.GLCanvas;
import com.jogamp.opengl.util.FPSAnimator;


public class Main {

    private static GLCanvas myCanvas;

    public static void main(String[] args) {

        System.setProperty("sun.awt.noerasebackground", "true");

        final GLProfile profile = GLProfile.get(GLProfile.GL2);
        GLCapabilities capabilities = new GLCapabilities(profile);

        /**/
        myCanvas = new GLCanvas(capabilities);

        DrawingTools mainInstance = new  DrawingTools();

        MyFrame frame1 = new MyFrame();

        MyMouse mouse1 = new MyMouse(DrawingTools.ML);
        /**/

        myCanvas.addGLEventListener(mainInstance);
        myCanvas.addMouseListener(mouse1);
        myCanvas.addMouseMotionListener(mouse1);

        //
        final FPSAnimator animator = new FPSAnimator(myCanvas, 80, true);

        //
        myCanvas.setSize(800, 600);

        frame1.makeCanvas(myCanvas);
        animator.start();
    }


}

