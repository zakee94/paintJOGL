/**
 * Created by zakee94 on 24/8/16.
 */
public class MouseLogger {

    double X, Y, xOld , yOld;
    double ht, wd;

    //double X[] = new double[2];
    //double Y[] = new double[2];

    public void setXCoordinate(int i) {
        xOld = getXCoordinate();
        X = i;
    }

    public void setYCoordinate(int i) {
        yOld = getYCoordinate();
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

        if (X != wd/2)
            return ((2*X - wd)/wd);

        return 0;
    }

    public double getYCoordinate(){

        if (Y != ht/2)
            return ((ht - 2*Y)/ht);

        return 0;
    }

}
