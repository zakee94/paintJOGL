import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;

public class MenuBarClass {
    private JFileChooser  fileChooser;
    MenuBarClass(JFileChooser fileChooser) {
        this.fileChooser = fileChooser;
    }

    public JMenuBar menuBar() {
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        fileMenu.setMnemonic(KeyEvent.VK_F);
        JMenu toolsMenu = new JMenu("Tools");
        toolsMenu.setMnemonic(KeyEvent.VK_T);
        JMenu helpMenu = new JMenu("Help");
        helpMenu.setMnemonic(KeyEvent.VK_H);

        menuBar.add(fileMenu);
        JMenuItem openFileJMI = new JMenuItem("Open");
        fileMenu.add(openFileJMI);
        JMenuItem saveFileJMI = new JMenuItem("Save");
        fileMenu.add(saveFileJMI);
        JMenuItem saveAsJMI = new JMenuItem("Save As");
        fileMenu.add(saveAsJMI);
        JMenuItem exitJMI = new JMenuItem("Exit");
        fileMenu.add(exitJMI);
        openFileJMI.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK));
        saveFileJMI.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
        exitJMI.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.CTRL_MASK));

        openFileJMI.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                    File file = fileChooser.getSelectedFile();
                    GlobalVariable.tField.setText(file.getAbsolutePath());
                }
            }
        });
        saveFileJMI.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (fileChooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) ;
            }
        });


        exitJMI.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        menuBar.add(toolsMenu);
        JMenu colorJMM = new JMenu("Color");
        toolsMenu.add(colorJMM);
        final JCheckBox redJCB = new JCheckBox("Red");
        colorJMM.add(redJCB);
        final JCheckBox blueJCB = new JCheckBox("Blue");
        colorJMM.add(blueJCB);
        final JCheckBox greenJCB = new JCheckBox("Green");
        colorJMM.add(greenJCB);

        ButtonGroup group = new ButtonGroup();
        group.add(redJCB);
        group.add(blueJCB);
        group.add(greenJCB);

        redJCB.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                GlobalVariable.r = 0;
                GlobalVariable.g = 0;
                GlobalVariable.b = 0;
                if (redJCB.isSelected())
                    GlobalVariable.r = 1;
            }
        });
        blueJCB.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                GlobalVariable.r = 0;
                GlobalVariable.g = 0;
                GlobalVariable.b = 0;
                if (blueJCB.isSelected())
                    GlobalVariable.b = 1;
            }
        });
        greenJCB.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                GlobalVariable.r = 0;
                GlobalVariable.g = 0;
                GlobalVariable.b = 0;
                if (greenJCB.isSelected())
                    GlobalVariable.g = 1;
            }
        });


        menuBar.add(helpMenu);
        JMenuItem helpJMI = new JMenuItem("Help");
        helpMenu.add(helpJMI);
        return menuBar;

    }
}
