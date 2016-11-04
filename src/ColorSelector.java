import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by aakash on 28/8/16.
 */
public class ColorSelector extends JPanel implements ActionListener {

    private JToggleButton redColor;
    private JToggleButton greenColor;
    private JToggleButton blueColor;
    private JToggleButton yellowColor;
    private JToggleButton greyColor;
    private JToggleButton blackColor;

    public ColorSelector(){


        redColor = new JToggleButton("Red");
        greenColor = new JToggleButton("Green");
        blueColor = new JToggleButton("Blue");
        yellowColor = new JToggleButton("Yellow");
        greyColor = new JToggleButton("Grey");
        blackColor = new JToggleButton("Black");

        redColor.addActionListener(this);
        greenColor.addActionListener(this);
        blueColor.addActionListener(this);
        yellowColor.addActionListener(this);
        greyColor.addActionListener(this);
        blackColor.addActionListener(this);

        setLayout(new GridLayout(6,0));
        // add(Box.createVerticalGlue());

        add(redColor);
        add(greenColor);
        add(blueColor);
        add(yellowColor);
        add(greyColor);
        add(blackColor);


        ButtonGroup group = new ButtonGroup();
        group.add(redColor);
        group.add(greenColor);
        group.add(blueColor);
        group.add(yellowColor);
        group.add(greyColor);
        group.add(blackColor);

        redColor.setForeground(Color.RED);
        greenColor.setForeground(Color.GREEN);
        blueColor.setForeground(Color.BLUE);
        yellowColor.setForeground(Color.YELLOW);
        greyColor.setForeground(Color.GRAY);
        blackColor.setForeground(Color.BLACK);
    }


    private void setColor(int r, int g, int b) {

        GlobalVariable.r = r;
        GlobalVariable.g = g;
        GlobalVariable.b = b;
    }


    public void actionPerformed(ActionEvent e) {
        JToggleButton clicked = (JToggleButton)e.getSource();

        GlobalVariable.r = 0;
        GlobalVariable.g = 0;
        GlobalVariable.b = 0;

        redColor.setForeground(Color.RED);
        greenColor.setForeground(Color.GREEN);
        blueColor.setForeground(Color.BLUE);
        yellowColor.setForeground(Color.YELLOW);
        greyColor.setForeground(Color.GRAY);
        blackColor.setForeground(Color.BLACK);

        redColor.setBackground(null);
        greenColor.setBackground(null);
        blueColor.setBackground(null);
        yellowColor.setBackground(null);
        greyColor.setBackground(null);
        blackColor.setBackground(null);

        if(clicked == redColor) {
            GlobalVariable.r = 1;
            redColor.setBackground(Color.RED);
            redColor.setForeground(Color.BLACK);
        }
        else if(clicked == greenColor) {
            GlobalVariable.g = 1;
            greenColor.setBackground(Color.GREEN);
            greenColor.setForeground(Color.BLACK);
        }
        else if(clicked == blueColor) {
            GlobalVariable.b = 1;
            blueColor.setBackground(Color.BLUE);
            blueColor.setForeground(Color.BLACK);
        }
        else if(clicked == yellowColor) {
            GlobalVariable.r = 1;
            GlobalVariable.g = 1;
            yellowColor.setBackground(Color.YELLOW);
            yellowColor.setForeground(Color.BLACK);
        }
        else if(clicked == greyColor) {
            GlobalVariable.r = 0.753f;
            GlobalVariable.g = 0.753f;
            GlobalVariable.b = 0.753f;
            greyColor.setBackground(Color.LIGHT_GRAY);
            greyColor.setForeground(Color.BLACK);
        }
        else if(clicked == blackColor) {
            GlobalVariable.r = 0;
            GlobalVariable.g = 0;
            GlobalVariable.b = 0;
            blackColor.setBackground(Color.BLACK);
            blackColor.setForeground(Color.WHITE);
        }

    }
}
