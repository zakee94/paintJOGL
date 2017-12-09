import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class filterPanel extends JPanel implements ActionListener, FocusListener {
    private JLabel label1;
    private JLabel labelR;
    private JLabel labelG;
    private JLabel labelB;
    private JComboBox combo1;
    private JTextField textFieldR;
    private JTextField textFieldG;
    private JTextField textFieldB;

    String[] filterStrings = {"NONE", "Violet", "Cyan", "Blue", "Green", "Yellow", "Orange", "Red"};

    public filterPanel() {
        label1 = new JLabel("Filter Color :");
        combo1 = new JComboBox(filterStrings);
        combo1.setSelectedIndex(0);

        labelR = new JLabel("Red :");
        textFieldR = new JTextField(5);
        textFieldR.setText(Double.toString(GlobalVariable.filterR));

        labelG = new JLabel("Green :");
        textFieldG = new JTextField(5);
        textFieldG.setText(Double.toString(GlobalVariable.filterG));

        labelB = new JLabel("Blue :");
        textFieldB = new JTextField(5);
        textFieldB.setText(Double.toString(GlobalVariable.filterB));

        combo1.addActionListener(this);
        textFieldR.addFocusListener(this);
        textFieldG.addFocusListener(this);
        textFieldB.addFocusListener(this);

        GridLayout filterLayout = new GridLayout(4, 0);
        setLayout(filterLayout);

        add(label1);
        add(combo1);
        add(labelR);
        add(textFieldR);
        add(labelG);
        add(textFieldG);
        add(labelB);
        add(textFieldB);
    }

    //@Override
    public void actionPerformed(ActionEvent e) {
        JComboBox cb = (JComboBox)e.getSource();

        if (cb == combo1) {
            String fColor = (String)cb.getSelectedItem();

            if (fColor.equals("NONE")) {
                setField(1.0, 1.0, 1.0);
                setGlobal(1.0, 1.0, 1.0);
            }
            else if (fColor.equals("Violet")) {
                setField(0.6, 0.196, 0.8);
                setGlobal(0.6, 0.196, 0.8);
            }
            else if (fColor.equals("Cyan")) {
                setField(0.0, 1.0, 1.0);
                setGlobal(0.0, 1.0, 1.0);
            }
            else if (fColor.equals("Green")) {
                setField(0.0, 1.0, 0.0);
                setGlobal(0.0, 1.0, 0.0);
            }
            else if (fColor.equals("Blue")) {
                setField(0.0, 0.0, 1.0);
                setGlobal(0.0, 0.0, 1.0);
            }
            else if (fColor.equals("Orange")) {
                setField(1.0, 0.647, 0.0);
                setGlobal(1.0, 0.647, 0.0);
            }
            else if (fColor.equals("Red")) {
                setField(1.0, 0.0, 0.0);
                setGlobal(1.0, 0.0, 0.0);
            }
            else if (fColor.equals("Yellow")) {
                setField(1.0, 1.0, 0.0);
                setGlobal(1.0, 1.0, 0.0);
            }
        }
    }

    public void focusGained(FocusEvent e) {
        textFieldR.selectAll();
        textFieldG.selectAll();
        textFieldB.selectAll();
    }

    public void focusLost(FocusEvent e) {
        double fR = Double.parseDouble(textFieldR.getText());

        if (fR < 0)
            GlobalVariable.filterR = 1.0;
        else if (fR > 1)
            GlobalVariable.filterR = 1.0;
        else
            GlobalVariable.filterR = fR;

        double fG = Double.parseDouble(textFieldR.getText());

        if (fG < 0)
            GlobalVariable.filterG = 1.0;
        else if (fG > 1)
            GlobalVariable.filterG = 1.0;
        else
            GlobalVariable.filterG = fG;

        double fB = Double.parseDouble(textFieldB.getText());

        if (fB < 0)
            GlobalVariable.filterB = 1.0;
        else if (fB > 1)
            GlobalVariable.filterB = 1.0;
        else
            GlobalVariable.filterB = fB;
    }

    public void setField(double r, double g, double b) {
        textFieldR.setText(Double.toString(r));
        textFieldG.setText(Double.toString(g));
        textFieldB.setText(Double.toString(b));
    }

    public void setGlobal(double r, double g, double b) {
        GlobalVariable.filterR = r;
        GlobalVariable.filterG = g;
        GlobalVariable.filterB = b;
    }
}
