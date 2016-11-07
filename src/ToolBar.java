import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ToolBar extends JPanel implements ActionListener {
    private JToggleButton penTool;
    private JToggleButton lineTool;
    private JToggleButton triangleTool;
    private JToggleButton quadTool;
    private JToggleButton circleTool;
    private JToggleButton eraserTool;
    private JToggleButton clearTool;
    private JToggleButton saveTool;
    private JTextField textField;
    private JLabel label1;


    public ToolBar(){
        penTool = new JToggleButton("Pen");
        lineTool = new JToggleButton("Lines");
        triangleTool = new JToggleButton("Triangles");
        quadTool = new JToggleButton("Quads");
        circleTool = new JToggleButton("Circle Var");
        eraserTool = new JToggleButton("Eraser");
        clearTool = new JToggleButton("Clear");
        saveTool = new JToggleButton("Save");
        textField = new JTextField(25);

        label1 = new JLabel("|||");
        textField.setText(System.getProperty("user.dir"));

        penTool.addActionListener(this);
        lineTool.addActionListener(this);
        triangleTool.addActionListener(this);
        quadTool.addActionListener(this);
        circleTool.addActionListener(this);
        eraserTool.addActionListener(this);
        clearTool.addActionListener(this);
        saveTool.addActionListener(this);

        textField.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                // Lets leave it blank
            }
        });

        setLayout(new FlowLayout(FlowLayout.CENTER));

        add(penTool);
        add(lineTool);
        add(triangleTool);
        add(quadTool);
        add(circleTool);
        add(eraserTool);
        add(clearTool);
        add(label1);
        add(saveTool);
        add(textField);

        ButtonGroup group = new ButtonGroup();
        group.add(penTool);
        group.add(lineTool);
        group.add(triangleTool);
        group.add(quadTool);
        group.add(circleTool);
        group.add(eraserTool);
        group.add(clearTool);
        group.add(saveTool);

        penTool.setBackground(Color.LIGHT_GRAY);
        penTool.setForeground(Color.BLACK);
        lineTool.setBackground(Color.LIGHT_GRAY);
        lineTool.setForeground(Color.BLACK);
        circleTool.setBackground(Color.LIGHT_GRAY);
        circleTool.setForeground(Color.BLACK);
        triangleTool.setBackground(Color.LIGHT_GRAY);
        triangleTool.setForeground(Color.BLACK);
        quadTool.setBackground(Color.LIGHT_GRAY);
        quadTool.setForeground(Color.BLACK);
        eraserTool.setBackground(Color.LIGHT_GRAY);
        eraserTool.setForeground(Color.BLACK);
        clearTool.setBackground(Color.LIGHT_GRAY);
        clearTool.setForeground(Color.BLACK);
        saveTool.setBackground(Color.LIGHT_GRAY);
        saveTool.setForeground(Color.BLACK);
    }




    //@Override
    public void actionPerformed(ActionEvent e) {
        JToggleButton clicked = (JToggleButton)e.getSource();

        GlobalVariable.penToolButton = false;
        GlobalVariable.lineToolButton = false;
        GlobalVariable.triangleToolButton = false;
        GlobalVariable.quadToolButton = false;
        GlobalVariable.circleToolButton = false;
        GlobalVariable.eraser_flag = false;
        GlobalVariable.clearToolButton = false;
        GlobalVariable.save = false;

        if(clicked == penTool) {
            GlobalVariable.penToolButton = true;
            GlobalVariable.eraser_flag = false;
        }
        else if(clicked == lineTool) {
            GlobalVariable.lineToolButton = true;
        }
        else if(clicked == circleTool) {
            GlobalVariable.circleToolButton = true;
        }
        else if(clicked == triangleTool) {
            GlobalVariable.triangleToolButton = true;
        }
        else if(clicked == quadTool) {
            GlobalVariable.quadToolButton = true;
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
            GlobalVariable.save = true;
            GlobalVariable.text = textField.getText();
        }
    }
}
