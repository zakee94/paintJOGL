/**
 * Created by zakee94 on 24/8/16.
 */
public class KeyLogger {

    int Button1 = 0, Button2 = 0;
    double X, Y, x_old , y_old;
    double ht, wd;

    //double X[] = new double[2];
    //double Y[] = new double[2];

    public void setButton1(int i) {
        Button1 = i;
    }

    public void setButton2(int i) {
        Button2 = i;
    }

    public int getButton1(){ return Button1; }

    public int getButton2(){ return Button2; }


    public void setXCoordinate(int i) {
        x_old = getXCoordinate();
        X = i;
    }

    public void setYCoordinate(int i) {
        y_old = getYCoordinate();
        Y = i;
    }

    public double getXOld(){
        if (GlobalVariable.mouse_drag = false)
            return getXCoordinate();
        return x_old;
    }

    public double getYOld(){

        if (GlobalVariable.mouse_drag = false)
            return getYCoordinate();

        return y_old;
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
