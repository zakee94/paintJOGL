import java.util.Random;

/**
 * Created by aakash on 28/8/16.
 */
public class ColorSelector {



    private void setColor(int r, int g, int b) {

        GlobalVariable.r = r;
        GlobalVariable.g = g;
        GlobalVariable.b = b;
    }

    public void setRandomColor() {
        Random rand = new Random();

        GlobalVariable.r = rand.nextFloat()%1;
        GlobalVariable.g = rand.nextFloat()%1;
        GlobalVariable.b = rand.nextFloat()%1;
    }

}
