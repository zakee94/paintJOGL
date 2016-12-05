/**
 * Created by zakee94 on 24/8/16.
 */

import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.awt.GLCanvas;
import com.jogamp.opengl.util.FPSAnimator;
import javax.swing.*;

public class Main {

    private static GLCanvas myCanvas;

    public static void main(String[] args) {

        //System.setProperty("sun.awt.noerasebackground", "true");

        final GLProfile profile = GLProfile.get(GLProfile.GL2);
        GLCapabilities capabilities = new GLCapabilities(profile);

        myCanvas = new GLCanvas(capabilities);

        DrawingTools mainInstance = new DrawingTools();

        final MyFrame frame1 = new MyFrame(myCanvas);
        GlobalVariable.currentFrame = frame1;

        MyMouse mouse1 = new MyMouse(DrawingTools.ML);

        myCanvas.addGLEventListener(mainInstance);
        myCanvas.addMouseListener(mouse1);
        myCanvas.addMouseMotionListener(mouse1);

        //
        final FPSAnimator animator = new FPSAnimator(myCanvas, 30, true);
        GlobalVariable.currentAnimator = animator;

        //
        animator.start();

        //
        frame1.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                if (JOptionPane.showConfirmDialog(frame1,
                        "Really exit ?\nMake sure to save your work before exiting !",
                        "You are about to exit !",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION){
                    animator.stop();
                    frame1.dispose();
                    System.exit(0);
                }
            }
        });
    }
}
