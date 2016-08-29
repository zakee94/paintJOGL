import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by LENOVO on 8/28/2016.
 */
public class ToolBar extends JPanel implements ActionListener {
    private JButton penTool;
    private JButton lineTool;
    private JButton triangleTool;
    private JButton quadTool;
    private JButton circleTool;

    public ToolBar(){
        penTool = new JButton("Pen");
        lineTool = new JButton("Lines");
        triangleTool = new JButton("Triangles");
        quadTool = new JButton("Quads");
        circleTool = new JButton("Circle Var");

        penTool.addActionListener(this);
        lineTool.addActionListener(this);
        triangleTool.addActionListener(this);
        quadTool.addActionListener(this);
        circleTool.addActionListener(this);

        setLayout(new FlowLayout(FlowLayout.CENTER));

        add(penTool);
        add(lineTool);
        add(triangleTool);
        add(quadTool);
        add(circleTool);

        ButtonGroup group = new ButtonGroup();
        group.add(penTool);
        group.add(lineTool);
        group.add(triangleTool);
        group.add(quadTool);
        group.add(circleTool);
    }


    //@Override
    public void actionPerformed(ActionEvent e) {
        JButton clicked = (JButton)e.getSource();

        GlobalVariable.penToolButton = false;
        GlobalVariable.lineToolButton = false;
        GlobalVariable.triangleToolButton = false;
        GlobalVariable.quadToolButton = false;
        GlobalVariable.circleToolButton = false;

        if(clicked == penTool) {
            GlobalVariable.penToolButton = true;
        }
        else if(clicked == lineTool) {
            GlobalVariable.lineToolButton = true;
        }
        else if(clicked == circleTool) {
            GlobalVariable.circleToolButton = true;
            //GlobalVariable.animator = false;
        }
        else if(clicked == triangleTool) {
            GlobalVariable.triangleToolButton = true;
        }
        else if(clicked == quadTool) {
            GlobalVariable.quadToolButton = true;
        }


    }
}
