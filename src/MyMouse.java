import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

/**
 * Created by aakash on 28/8/16.
 */
public class MyMouse implements  MouseListener, MouseMotionListener {

    private static int i;
    //MouseLogger ML = new MouseLogger();

    private final MouseLogger ML;
    MyMouse(MouseLogger ML) {
        this.ML = ML;
    }
    //
    public void mouseClicked(MouseEvent e) {

        GlobalVariable.lineCreator = false;
        if(GlobalVariable.triangleToolButton){
            GlobalVariable.polygonCreator++;
            i = GlobalVariable.polygonCreator;
            GlobalVariable.X_poly[i] = ML.getXCoordinate();
            GlobalVariable.Y_poly[i] = ML.getYCoordinate();
            System.out.println(GlobalVariable.polygonCreator);
            GlobalVariable.polygonCreator = GlobalVariable.polygonCreator % 3;
        }
        else if(GlobalVariable.quadToolButton){
            GlobalVariable.polygonCreator++;
            i = GlobalVariable.polygonCreator;
            GlobalVariable.X_poly[i] = ML.getXCoordinate();
            GlobalVariable.Y_poly[i] = ML.getYCoordinate();
            System.out.println(GlobalVariable.polygonCreator);
            GlobalVariable.polygonCreator = GlobalVariable.polygonCreator % 4;
        }
    }

    public void mousePressed(MouseEvent e) {


        ML.setXCoordinate(e.getX());
        ML.setYCoordinate(e.getY());
        ML.xSend = ML.getXCoordinate();
        ML.ySend = ML.getYCoordinate();

        ML.lineX = ML.xSend;
        ML.lineY = ML.ySend;
        GlobalVariable.lineCreator = false;

    }

    public void mouseReleased(MouseEvent e) {
        GlobalVariable.mouse_drag = false;
        if(GlobalVariable.penToolButton) {
            ML.setXCoordinate(e.getX());
            ML.setYCoordinate(e.getY());
        }

        if(GlobalVariable.lineToolButton || GlobalVariable.circleToolButton) {
            ML.lineXEnd = ML.getXCoordinate();
            ML.lineYEnd = ML.getYCoordinate();
            GlobalVariable.lineCreator = true;
        }
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
    }

    public void mouseMoved(MouseEvent e){

    }
}