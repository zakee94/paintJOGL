import com.jogamp.opengl.awt.GLCanvas;

import javax.swing.*;
import java.awt.*;

/**
 * Created by aakash on 28/8/16.
 */
public class MyFrame extends JFrame {

    private ToolBar toolbar1;

    MyFrame(GLCanvas myCanvas){

        super("Paint");

        setLayout(new BorderLayout());

        toolbar1 = new ToolBar();

        add(toolbar1, BorderLayout.NORTH);
        add(myCanvas, BorderLayout.CENTER);


        setSize(1200,800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

    }

}
