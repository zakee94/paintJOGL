/**
 * Created by zakee94 on 24/8/16.
 */
public class MouseLogger {

    double X, Y, xOld , yOld, getX, getY;
    double lineX, lineY,lineXEnd, lineYEnd;



    public void setXCoordinate(int i) {
        xOld = getX;
        X = i;
    }

    public void setYCoordinate(int i) {
        yOld = getY;
        Y = i;
    }

    public double getXOld(){
        if (GlobalVariable.mouse_drag = false)
            return getX;

        return xOld;
    }

    public double getYOld(){

        if (GlobalVariable.mouse_drag = false)
            return getY;

        return yOld;
    }

    public double getXCoordinate() {
        getX = X;
        return X;
    }

    public double getYCoordinate(){
        getY = Y;
        return Y;
    }

}
