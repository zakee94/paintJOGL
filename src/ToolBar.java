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
    private JToggleButton saveTool;
    private JLabel label1;


    public ToolBar(){
        penTool = new JToggleButton("Pen");
        lineTool = new JToggleButton("Lines");
        triangleTool = new JToggleButton("Triangles");
        quadTool = new JToggleButton("Quads");
        circleTool = new JToggleButton("Circle Var");
        eraserTool = new JToggleButton("Eraser");
        saveTool = new JToggleButton("Save");
        label1 = new JLabel("By Default Pen(Green) has been selected!");

        penTool.addActionListener(this);
        lineTool.addActionListener(this);
        triangleTool.addActionListener(this);
        quadTool.addActionListener(this);
        circleTool.addActionListener(this);
        eraserTool.addActionListener(this);
        saveTool.addActionListener(this);

        setLayout(new FlowLayout(FlowLayout.CENTER));

        add(penTool);
        add(lineTool);
        add(triangleTool);
        add(quadTool);
        add(circleTool);
        add(eraserTool);
        add(saveTool);
        add(label1 );


        ButtonGroup group = new ButtonGroup();
        group.add(penTool);
        group.add(lineTool);
        group.add(triangleTool);
        group.add(quadTool);
        group.add(circleTool);
        group.add(eraserTool);
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
        GlobalVariable.save = false;

        if(clicked == penTool) {
            GlobalVariable.penToolButton = true;
            GlobalVariable.eraser_flag = false;
            label1.setText("");
        }
        else if(clicked == lineTool) {
            GlobalVariable.lineToolButton = true;
            label1.setText("");
        }
        else if(clicked == circleTool) {
            GlobalVariable.circleToolButton = true;
            //label1.setText("Circle selected");
        }
        else if(clicked == triangleTool) {
            GlobalVariable.triangleToolButton = true;
            //label1.setText("Triangle selected");
        }
        else if(clicked == quadTool) {
            GlobalVariable.quadToolButton = true;
            //label1.setText("Quadrilateral selected");
        }
        else if(clicked == eraserTool) {
            GlobalVariable.penToolButton = true;
            GlobalVariable.eraser_flag = true;
            //label1.setText("Eraser selected");
        }
        else if(clicked == saveTool) {
            GlobalVariable.save = true;
        }

    }
}
