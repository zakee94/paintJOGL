import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Arrays;

public class MyMouse implements  MouseListener, MouseMotionListener {

    private static int i;

    private final MouseLogger ML;
    MyMouse(MouseLogger ML) {
        this.ML = ML;
    }
    //
    public void mouseClicked(MouseEvent e) {

        GlobalVariable.lineCreator = false;
        if(GlobalVariable.triangleToolButton){
            GlobalVariable.polygonCreator++;

            //
            i = GlobalVariable.polygonCreator;
            GlobalVariable.X_poly[i] = ML.getXCoordinate();
            GlobalVariable.Y_poly[i] = ML.getYCoordinate();
            Arrays.fill(GlobalVariable.X_poly, i, 10, GlobalVariable.X_poly[i]);
            Arrays.fill(GlobalVariable.Y_poly, i, 10, GlobalVariable.Y_poly[i]);
            GlobalVariable.polygonCreator = GlobalVariable.polygonCreator % GlobalVariable.polySides;
        }
        else if(GlobalVariable.polygonToolButton){
            GlobalVariable.polygonCreator++;
            i = GlobalVariable.polygonCreator;
            GlobalVariable.X_poly[i] = ML.getXCoordinate();
            GlobalVariable.Y_poly[i] = ML.getYCoordinate();
            Arrays.fill(GlobalVariable.X_poly, i, 10, GlobalVariable.X_poly[i]);
            Arrays.fill(GlobalVariable.Y_poly, i, 10, GlobalVariable.Y_poly[i]);
            GlobalVariable.polygonCreator = GlobalVariable.polygonCreator % GlobalVariable.polySides;
            System.out.println(GlobalVariable.empty);
        }
    }

    public void mousePressed(MouseEvent e) {


        ML.setXCoordinate(e.getX());
        ML.setYCoordinate(e.getY());
        ML.xSend = ML.getXCoordinate();
        ML.ySend = ML.getYCoordinate();

        ML.lineX = ML.xSend;
        ML.lineY = ML.ySend;
        GlobalVariable.mouse_pressed = true;
        GlobalVariable.lineCreator = false;

    }

    public void mouseReleased(MouseEvent e) {
        GlobalVariable.mouse_drag = false;
        if(GlobalVariable.penToolButton) {
            ML.setXCoordinate(e.getX());
            ML.setYCoordinate(e.getY());
        }

        if(GlobalVariable.lineToolButton || GlobalVariable.textToolButton || GlobalVariable.rectToolButton) {
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
