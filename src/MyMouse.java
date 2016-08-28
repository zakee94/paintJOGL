import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

/**
 * Created by aakash on 28/8/16.
 */
public class MyMouse implements  MouseListener, MouseMotionListener {

    //MouseLogger ML = new MouseLogger();

    private final MouseLogger ML;
    MyMouse(MouseLogger ML) {
        this.ML = ML;
    }
    //
    public void mouseClicked(MouseEvent e) {
    }

    public void mousePressed(MouseEvent e) {
        ML.setXCoordinate(e.getX());
        ML.setYCoordinate(e.getY());
    }

    public void mouseReleased(MouseEvent e) {
        GlobalVariable.mouse_drag = false;
        ML.setXCoordinate(e.getX());
        ML.setYCoordinate(e.getY());
    }

    public void mouseEntered(MouseEvent e) {
    }

    public void mouseExited(MouseEvent e) {
        GlobalVariable.mouse_drag = false;
    }

    public void mouseDragged(MouseEvent e) {
        GlobalVariable.mouse_drag = true;
        ML.setXCoordinate(e.getX());
        ML.setYCoordinate(e.getY());
        System.out.println("Mouse Dragged: ("+e.getX()+", "+e.getY() +")");
    }

    public void mouseMoved(MouseEvent e){

    }
}