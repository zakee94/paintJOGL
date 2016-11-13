/**
 * Created by zakee94 on 24/8/16.
 */
public class MouseLogger {

    double X, Y, xOld , yOld, xSend, ySend, lineX, lineY,lineXEnd, lineYEnd;
    double ht, wd;



    public void setXCoordinate(int i) {
        xOld = xSend;
        X = i;
    }

    public void setYCoordinate(int i) {
        yOld = ySend;
        Y = i;
    }

    public double getXOld(){
        if (GlobalVariable.mouse_drag = false)
            return getXCoordinate();
        return xOld;
    }

    public double getYOld(){

        if (GlobalVariable.mouse_drag = false)
            return getYCoordinate();

        return yOld;
    }

    public double getXCoordinate(){

        if (X != wd/2) {
            xSend = (2 * X - wd) / wd;
            return xSend;
        }
        return 0;
    }

    public double getYCoordinate(){

        if (Y != ht/2) {
            ySend = (ht - 2 * Y) / ht;
            return ySend;
        }
        return 0;
    }

}
