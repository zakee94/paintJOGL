import com.jogamp.opengl.awt.GLCanvas;
import javax.swing.*;
import java.awt.*;
import java.io.File;

public class MyFrame extends JFrame {

    private JFileChooser fileChooser;

    private ToolBar toolbar1;
    private ColorSelector colorpick1;

    MyFrame(GLCanvas myCanvas){

        super("Paint");

        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
            // If Nimbus is not available, you can set the GUI to another look and feel.
        }

        setLayout(new BorderLayout());

        /*Threading*/
        fileChooser = new JFileChooser();
        new Thread(new MenuThreading(fileChooser)).start();

        /*RThreading*/
        toolbar1 = new ToolBar();
        colorpick1 = new ColorSelector();



        add(toolbar1, BorderLayout.NORTH);
        add(myCanvas, BorderLayout.CENTER);
        add(colorpick1, BorderLayout.WEST);

        setSize(1280, 720);
        setResizable(false);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setVisible(true);

    } // Constructor Finishes Here


    // Multi-threading for the menu-bar
    class MenuThreading extends Thread{
        JFileChooser fileChooser;

        MenuThreading(JFileChooser fileChooser){
            this.fileChooser = fileChooser;
        }

        public void run(){
            fileChooser.setCurrentDirectory(new File(System.getProperty("user.home") + "/Pictures"));
            fileChooser.addChoosableFileFilter(new FileType());
            MenuBarClass MBC = new MenuBarClass(fileChooser);
            setJMenuBar(MBC.menuBar());
        }
    }
}
