/**
 * Created by zakee94 on 24/8/16.
 */

import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.awt.GLCanvas;
import com.jogamp.opengl.util.FPSAnimator;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.File;
import java.io.IOException;

public class Main {

    private static GLCanvas myCanvas;

    public static void main(String[] args) {

        System.setProperty("sun.awt.noerasebackground", "true");

        final GLProfile profile = GLProfile.get(GLProfile.GL2);
        GLCapabilities capabilities = new GLCapabilities(profile);

        /**/
        myCanvas = new GLCanvas(capabilities);

        DrawingTools mainInstance = new DrawingTools();

        final MyFrame frame1 = new MyFrame(myCanvas);
        GlobalVariable.currentFrame = frame1;

        MyMouse mouse1 = new MyMouse(DrawingTools.ML);
        /**/

        myCanvas.addGLEventListener(mainInstance);
        myCanvas.addMouseListener(mouse1);
        myCanvas.addMouseMotionListener(mouse1);

        //
        final FPSAnimator animator = new FPSAnimator(myCanvas, 30, true);

        //
        animator.start();

        //
        frame1.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                if (JOptionPane.showConfirmDialog(frame1,
                        "Save on exit ?\n(save will only work if you have previously\nused save button before)",
                        "You are about to exit !",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION){
                    if (GlobalVariable.shot != null) {
                        try {
                            String extension = GlobalVariable.text.substring(GlobalVariable.text.length() - 3);
                            if (extension.equals("png"))
                                ImageIO.write(GlobalVariable.shot, "png", new File(GlobalVariable.text));
                            else if (extension.equals("jpg"))
                                ImageIO.write(GlobalVariable.shot, "jpg", new File(GlobalVariable.text));
                            else
                                System.out.println("Give proper name !");
                        } catch (IOException ex) {
                            // You know ... what to do here :P
                        }
                    }
                }
            }
        });
    }
}

