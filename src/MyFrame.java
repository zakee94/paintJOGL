import com.jogamp.opengl.awt.GLCanvas;

import javax.swing.*;
import java.awt.*;

/**
 * Created by aakash on 28/8/16.
 */
public class MyFrame extends JFrame {

    private ToolBar toolbar1;
    private ColorSelector colorpick1;

    MyFrame(GLCanvas myCanvas){

        super("Paint");

        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
            // If Nimbus is not available, you can set the GUI to another look and feel.
        }

        setLayout(new BorderLayout());

        toolbar1 = new ToolBar();
        colorpick1 = new ColorSelector();


        add(toolbar1, BorderLayout.NORTH);
        add(myCanvas, BorderLayout.CENTER);
        add(colorpick1, BorderLayout.WEST);


        setSize(1200,800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

    }

}
