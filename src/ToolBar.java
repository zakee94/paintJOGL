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
    private JLabel label1;


    public ToolBar(){
        penTool = new JToggleButton("Pen");
        lineTool = new JToggleButton("Lines");
        triangleTool = new JToggleButton("Triangles");
        quadTool = new JToggleButton("Quads");
        circleTool = new JToggleButton("Circle Var");
        label1 = new JLabel(""+GlobalVariable.polygonCreator+"Points Chosen For PolyGon");

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
        add(label1 );


        ButtonGroup group = new ButtonGroup();
        group.add(penTool);
        group.add(lineTool);
        group.add(triangleTool);
        group.add(quadTool);
        group.add(circleTool);

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
    }




    //@Override
    public void actionPerformed(ActionEvent e) {
        JToggleButton clicked = (JToggleButton)e.getSource();

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
