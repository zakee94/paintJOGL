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
        circleTool = new JButton("Circle");

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
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        JButton clicked = (JButton)e.getSource();

        if(clicked == penTool) {
            GlobalVariable.lineToolButton = false;
            GlobalVariable.penToolButton = true;
        }
        else if(clicked == lineTool) {
            GlobalVariable.lineToolButton = true;
            GlobalVariable.penToolButton = false;
        }
        else if(clicked == triangleTool) {

        }
        else if(clicked == quadTool) {

        }
        else if(clicked == circleTool) {

        }

    }
}
