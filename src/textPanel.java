import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

/**
 * Created by zakee94 on 13/11/16.
 */
public class textPanel extends JPanel implements ActionListener, FocusListener {
    private JLabel label1;
    private JComboBox combo1;
    private JLabel label2;
    private JComboBox combo2;
    private JLabel label3;
    private JTextField textField1;
    private JLabel label4;
    private JTextField textField2;

    String fontStrings[] = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
    String[] ftypeStrings = {"Plain", "Bold", "Italics"};

    public textPanel() {
        label1 = new JLabel("Font :");
        combo1 = new JComboBox(fontStrings);
        combo1.setSelectedIndex(0);
        //
        label2 = new JLabel("Type :");
        combo2 = new JComboBox(ftypeStrings);
        combo2.setSelectedIndex(GlobalVariable.fontType);
        //
        label3 = new JLabel("Size (10-100) :");
        textField1 = new JTextField(5);
        textField1.setText(Integer.toString(GlobalVariable.textSize));
        //
        label4 = new JLabel("Your Text :");
        textField2 = new JTextField(5);
        textField2.setText(GlobalVariable.myText);

        combo1.addActionListener(this);
        combo2.addActionListener(this);
        textField1.addFocusListener(this);
        textField2.addFocusListener(this);

        GridLayout textLayout = new GridLayout(4, 0);
        setLayout(textLayout);

        add(label1);
        add(combo1);
        add(label2);
        add(combo2);
        add(label3);
        add(textField1);
        add(label4);
        add(textField2);
    }

    //@Override
    public void actionPerformed(ActionEvent e) {
        JComboBox cb = (JComboBox)e.getSource();

        if (cb == combo1)
            GlobalVariable.textFont = (String)cb.getSelectedItem();

        if (cb == combo2) {
            String type = (String) cb.getSelectedItem();

            if (type.equals("Plain"))
                GlobalVariable.fontType = 0;
            if (type.equals("Bold"))
                GlobalVariable.fontType = 1;
            if (type.equals("Italics"))
                GlobalVariable.fontType = 2;
        }
    }

    public void focusGained(FocusEvent e) {
        // Do whatever you want
    }

    public void focusLost(FocusEvent e) {
        int size = Integer.parseInt(textField1.getText());

        if (size < 10)
            GlobalVariable.textSize = 10;
        else if (size > 100)
            GlobalVariable.textSize = 100;
        else
            GlobalVariable.textSize = size;

        GlobalVariable.myText = textField2.getText();
    }
}
