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
    private JToggleButton orangeColor;
    private JToggleButton cyanColor;
    private JToggleButton violetColor;
    private JToggleButton brownColor;

    Color BROWN = new Color(139, 69, 19);

    public ColorSelector(){

        redColor = new JToggleButton("Red");
        greenColor = new JToggleButton("Green");
        blueColor = new JToggleButton("Blue");
        yellowColor = new JToggleButton("Yellow");
        greyColor = new JToggleButton("Grey");
        blackColor = new JToggleButton("Black");
        cyanColor = new JToggleButton("Cyan");
        orangeColor = new JToggleButton("Orange");
        violetColor = new JToggleButton("Violet");
        brownColor = new JToggleButton("Brown");

        // Select black color as default
        blackColor.setSelected(true);
        blackColor.setBackground(Color.BLACK);
        blackColor.setForeground(Color.WHITE);

        redColor.addActionListener(this);
        greenColor.addActionListener(this);
        blueColor.addActionListener(this);
        yellowColor.addActionListener(this);
        greyColor.addActionListener(this);
        blackColor.addActionListener(this);
        cyanColor.addActionListener(this);
        orangeColor.addActionListener(this);
        violetColor.addActionListener(this);
        brownColor.addActionListener(this);

        GridLayout colorLayout = new GridLayout(10, 0);
        setLayout(colorLayout);

        add(violetColor);
        add(cyanColor);
        add(blueColor);
        add(greenColor);
        add(yellowColor);
        add(orangeColor);
        add(redColor);
        add(brownColor);
        add(greyColor);
        add(blackColor);


        ButtonGroup group = new ButtonGroup();
        group.add(redColor);
        group.add(greenColor);
        group.add(blueColor);
        group.add(yellowColor);
        group.add(greyColor);
        group.add(blackColor);
        group.add(violetColor);
        group.add(orangeColor);
        group.add(cyanColor);
        group.add(brownColor);

        redColor.setIcon(new ImageIcon(getClass().getResource("/red.png")));
        redColor.setToolTipText("Open");
        blackColor.setIcon(new ImageIcon(getClass().getResource("/black.png")));
        blackColor.setToolTipText("Open");
        blueColor.setIcon(new ImageIcon(getClass().getResource("/blue.png")));
        blueColor.setToolTipText("Open");
        violetColor.setIcon(new ImageIcon(getClass().getResource("/violet.png")));
        violetColor.setToolTipText("Open");
        greenColor.setIcon(new ImageIcon(getClass().getResource("/green.png")));
        greenColor.setToolTipText("Open");
        cyanColor.setIcon(new ImageIcon(getClass().getResource("/cyan.png")));
        cyanColor.setToolTipText("Open");
        greyColor.setIcon(new ImageIcon(getClass().getResource("/gray.png")));
        greyColor.setToolTipText("Open");
        yellowColor.setIcon(new ImageIcon(getClass().getResource("/yellow.png")));
        yellowColor.setToolTipText("Open");
        orangeColor.setIcon(new ImageIcon(getClass().getResource("/orange.png")));
        orangeColor.setToolTipText("Open");
        brownColor.setIcon(new ImageIcon(getClass().getResource("/brown.png")));
        brownColor.setToolTipText("Open");


        redColor.setForeground(Color.RED);
        greenColor.setForeground(Color.GREEN);
        blueColor.setForeground(Color.BLUE);
        yellowColor.setForeground(Color.YELLOW);
        greyColor.setForeground(Color.GRAY);
        violetColor.setForeground(Color.MAGENTA);
        cyanColor.setForeground(Color.CYAN);
        orangeColor.setForeground(Color.ORANGE);
        brownColor.setForeground(BROWN);
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
        cyanColor.setForeground(Color.CYAN);
        violetColor.setForeground(Color.MAGENTA);
        orangeColor.setForeground(Color.ORANGE);
        brownColor.setForeground(BROWN);

        redColor.setBackground(null);
        greenColor.setBackground(null);
        blueColor.setBackground(null);
        yellowColor.setBackground(null);
        greyColor.setBackground(null);
        blackColor.setBackground(null);
        cyanColor.setBackground(null);
        orangeColor.setBackground(null);
        violetColor.setBackground(null);
        brownColor.setBackground(null);

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
        else if(clicked == violetColor) {
            GlobalVariable.r = 0.6f;
            GlobalVariable.g = 0.196f;
            GlobalVariable.b = 0.8f;
            violetColor.setBackground(Color.MAGENTA);
            violetColor.setForeground(Color.BLACK);
        }
        else if(clicked == orangeColor) {
            GlobalVariable.r = 1f;
            GlobalVariable.g = 0.647f;
            orangeColor.setBackground(Color.ORANGE);
            orangeColor.setForeground(Color.BLACK);
        }
        else if(clicked == cyanColor) {
            GlobalVariable.g = 1;
            GlobalVariable.b = 1;
            cyanColor.setBackground(Color.CYAN);
            cyanColor.setForeground(Color.BLACK);
        }
        else if(clicked == brownColor) {
            GlobalVariable.r = 0.545f;
            GlobalVariable.g = 0.271f;
            GlobalVariable.b = 0.0745f;
            brownColor.setBackground(BROWN);
            brownColor.setForeground(Color.BLACK);
        }
    }
}
