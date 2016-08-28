import com.jogamp.opengl.awt.GLCanvas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by aakash on 28/8/16.
 */
public class MyFrame extends JFrame {
    private JFrame myFrame;

    public void makeCanvas(GLCanvas myCanvas) {
        //
        myFrame = new JFrame("Paint");
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //
        myFrame.getContentPane().add(BorderLayout.CENTER, myCanvas);

        //
        JButton button1 = new JButton("CentreDraw");
        button1.addActionListener(new button1_listener());
        myFrame.getContentPane().add(BorderLayout.NORTH, button1);

        //
        JButton button2 = new JButton("PencilDraw");
        button2.addActionListener(new button2_listener());
        myFrame.getContentPane().add(BorderLayout.SOUTH, button2);

        //
        myFrame.setSize(myFrame.getContentPane().getPreferredSize());
        myFrame.setVisible(true);

    }

    class button1_listener implements ActionListener {

        public void actionPerformed(ActionEvent event) {
            GlobalVariable.button_1 = true;
            GlobalVariable.button_2 = false;
        }
    }

    class button2_listener implements ActionListener {

        public void actionPerformed(ActionEvent event) {
            GlobalVariable.button_1 = false;
            GlobalVariable.button_2 = true;
        }
    }
}
