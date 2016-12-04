import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ToolBar extends JPanel implements ActionListener {
    private JToggleButton penTool;
    private JToggleButton lineTool;
    private JToggleButton triangleTool;
    private JToggleButton quadTool;
    private JToggleButton rectTool;
    private JToggleButton textTool;
    private JToggleButton eraserTool;
    private JToggleButton clearTool;
    private JToggleButton saveTool;
    private JToggleButton openTool;
    private JTextField textField;
    private JSeparator sep1, sep2, sep3, sep4;
    private JSlider slider;


    public ToolBar(){
        penTool = new JToggleButton();
        lineTool = new JToggleButton();
        triangleTool = new JToggleButton();
        quadTool = new JToggleButton();
        rectTool = new JToggleButton();
        textTool = new JToggleButton();
        eraserTool = new JToggleButton();
        clearTool = new JToggleButton();
        saveTool = new JToggleButton();
        openTool = new JToggleButton();
        textField = new JTextField(25);

        textField.setText(System.getProperty("user.dir"));
        GlobalVariable.tField = textField;

        penTool.setIcon(new ImageIcon(getClass().getResource("/pen.png")));
        penTool.setToolTipText("Pen");
        eraserTool.setIcon(new ImageIcon(getClass().getResource("/eraser.png")));
        eraserTool.setToolTipText("Eraser");
        lineTool.setIcon(new ImageIcon(getClass().getResource("/line.png")));
        lineTool.setToolTipText("Line");
        rectTool.setIcon(new ImageIcon(getClass().getResource("/rect.png")));
        rectTool.setToolTipText("Rectangle");
        triangleTool.setIcon(new ImageIcon(getClass().getResource("/triangle.png")));
        triangleTool.setToolTipText("Triangle");
        quadTool.setIcon(new ImageIcon(getClass().getResource("/polygon.png")));
        quadTool.setToolTipText("Polygon");
        textTool.setIcon(new ImageIcon(getClass().getResource("/text.png")));
        textTool.setToolTipText("Text");
        clearTool.setIcon(new ImageIcon(getClass().getResource("/clear.png")));
        clearTool.setToolTipText("Clear");
        openTool.setIcon(new ImageIcon(getClass().getResource("/open.png")));
        openTool.setToolTipText("Open");
        saveTool.setIcon(new ImageIcon(getClass().getResource("/save.png")));
        saveTool.setToolTipText("Save");


        sep1 = new JSeparator(JSeparator.VERTICAL);
        sep1.setPreferredSize(new Dimension(5, 30));
        sep2 = new JSeparator(JSeparator.VERTICAL);
        sep2.setPreferredSize(new Dimension(5, 30));
        sep3 = new JSeparator(JSeparator.VERTICAL);
        sep3.setPreferredSize(new Dimension(5, 30));
        sep4 = new JSeparator(JSeparator.VERTICAL);
        sep4.setPreferredSize(new Dimension(5, 30));

        slider = new JSlider(JSlider.HORIZONTAL, 0, 10, 7);

        slider.setMajorTickSpacing(2);
        slider.setMinorTickSpacing(1);
        slider.setPaintLabels(true);
        slider.setPaintTicks(true);
        slider.addChangeListener(new ChangeListener(){
            
            public void stateChanged(ChangeEvent e) {
                JSlider slideMark = (JSlider)e.getSource();
                GlobalVariable.lineWidth = slideMark.getValue();
            }
        });

        // Select pen-tool as default
        penTool.setSelected(true);

        penTool.addActionListener(this);
        lineTool.addActionListener(this);
        triangleTool.addActionListener(this);
        quadTool.addActionListener(this);
        rectTool.addActionListener(this);
        textTool.addActionListener(this);
        eraserTool.addActionListener(this);
        clearTool.addActionListener(this);
        saveTool.addActionListener(this);
        openTool.addActionListener(this);

        textField.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                // Lets leave it blank
            }
        });

        setLayout(new FlowLayout(FlowLayout.CENTER));

        add(penTool);
        add(eraserTool);
        add(sep1);
        add(lineTool);
        add(triangleTool);
        add(quadTool);
        add(rectTool);
        add(textTool);
        add(sep2);
        add(openTool);
        add(saveTool);
        add(textField);
        add(sep3);
        add(clearTool);
        add(sep4);
        add(slider);

        ButtonGroup group = new ButtonGroup();
        group.add(penTool);
        group.add(lineTool);
        group.add(triangleTool);
        group.add(quadTool);
        group.add(rectTool);
        group.add(textTool);
        group.add(eraserTool);
        group.add(clearTool);
        group.add(saveTool);
        group.add(openTool);

        penTool.setBackground(Color.LIGHT_GRAY);
        penTool.setForeground(Color.BLACK);
        lineTool.setBackground(Color.LIGHT_GRAY);
        lineTool.setForeground(Color.BLACK);
        textTool.setBackground(Color.LIGHT_GRAY);
        textTool.setForeground(Color.BLACK);
        triangleTool.setBackground(Color.LIGHT_GRAY);
        triangleTool.setForeground(Color.BLACK);
        quadTool.setBackground(Color.LIGHT_GRAY);
        quadTool.setForeground(Color.BLACK);
        rectTool.setBackground(Color.LIGHT_GRAY);
        rectTool.setForeground(Color.BLACK);
        eraserTool.setBackground(Color.LIGHT_GRAY);
        eraserTool.setForeground(Color.BLACK);
        clearTool.setBackground(Color.LIGHT_GRAY);
        clearTool.setForeground(Color.BLACK);
        saveTool.setBackground(Color.LIGHT_GRAY);
        saveTool.setForeground(Color.BLACK);
        openTool.setBackground(Color.LIGHT_GRAY);
        openTool.setForeground(Color.BLACK);
    }

    //@Override
    public void actionPerformed(ActionEvent e) {
        JToggleButton clicked = (JToggleButton)e.getSource();

        GlobalVariable.penToolButton = false;
        GlobalVariable.lineToolButton = false;
        GlobalVariable.triangleToolButton = false;
        GlobalVariable.quadToolButton = false;
        GlobalVariable.rectToolButton = false;
        GlobalVariable.textToolButton = false;
        GlobalVariable.eraser_flag = false;
        GlobalVariable.clearToolButton = false;
        GlobalVariable.open = false;
        GlobalVariable.save = false;

        GlobalVariable.mouse_pressed = false;

        GlobalVariable.currentAnimator.start();

        if(clicked == penTool) {
            GlobalVariable.penToolButton = true;
            GlobalVariable.eraser_flag = false;
        }
        else if(clicked == lineTool) {
            GlobalVariable.lineToolButton = true;
        }
        else if(clicked == textTool) {
            textPanel textPanel1 = new textPanel();

            int result = JOptionPane.showConfirmDialog(GlobalVariable.currentFrame, textPanel1,
                    "Please Enter Values", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

            if (result == JOptionPane.OK_OPTION) {
                GlobalVariable.textToolButton = true;
            }
        }
        else if(clicked == triangleTool) {
            GlobalVariable.triangleToolButton = true;
        }
        else if(clicked == quadTool) {
            GlobalVariable.quadToolButton = true;
        }
        else if(clicked == rectTool) {
            GlobalVariable.rectToolButton = true;
        }
        else if(clicked == eraserTool) {
            GlobalVariable.penToolButton = true;
            GlobalVariable.eraser_flag = true;
        }
        else if(clicked == clearTool) {
            if (JOptionPane.showConfirmDialog(GlobalVariable.currentFrame,
                    "Clear everything ?", "",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {
                GlobalVariable.clearToolButton = true;
            }
        }
        else if(clicked == saveTool) {
            String extension = GlobalVariable.tField.getText().substring(GlobalVariable.tField.getText().length() - 3);

            if (extension.equals("png") || extension.equals("jpg")) {
                if (JOptionPane.showConfirmDialog(GlobalVariable.currentFrame,
                        "Save this image ?", "Save Image",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {
                    GlobalVariable.save = true;
                    GlobalVariable.text = textField.getText();
                }
            }
            else {
                String message = "Please give a proper file-name !\n" +
                        "Note that saving is only supported in '.png' & '.jpg' formats";

                JOptionPane.showMessageDialog(GlobalVariable.currentFrame, message);
            }
        }
        else if(clicked == openTool) {
            String extension = GlobalVariable.tField.getText().substring(GlobalVariable.tField.getText().length() - 3);

            if (extension.equals("png") || extension.equals("jpg") || extension.equals("jpeg")) {
                if (JOptionPane.showConfirmDialog(GlobalVariable.currentFrame,
                        "Opening a new image will clear everything.\nSure to continue ?", "Open Image",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {
                    filterPanel filterPanel1 = new filterPanel();

                    int result = JOptionPane.showConfirmDialog(GlobalVariable.currentFrame, filterPanel1,
                            "Filter Choice", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

                    if (result == JOptionPane.OK_OPTION) {
                        GlobalVariable.open = true;
                        GlobalVariable.text = textField.getText();
                    }
                }
            }
            else {
                String message = "Please give a proper file-name !\n" +
                        "Note that opening is only supported in '.png,' '.jpg' & '.jpeg' formats";

                JOptionPane.showMessageDialog(GlobalVariable.currentFrame, message);
            }
        }
    }
}
