import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.glu.GLU;

/**
 * Created by aakash on 28/8/16.
 */
public class DrawingTools  implements GLEventListener {

    static MouseLogger ML = new MouseLogger();

    public void display(GLAutoDrawable drawable) {

        GL2 gl = drawable.getGL().getGL2();
        PenTool pen1 = new PenTool(ML);
        pen1.pen(gl);

    }

    public void dispose(GLAutoDrawable arg0) {

    }


    public void init(GLAutoDrawable drawable) {
        final GL2 gl = drawable.getGL().getGL2();
        gl.glClearColor(1.0f, 1.0f, 1.0f, 1.0f);
        gl.glMatrixMode(GL2.GL_PROJECTION);
        gl.glMatrixMode(GL2.GL_MODELVIEW);
        gl.glLoadIdentity();
    }

    public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
        System.out.println("If1");
        GL2 gl = drawable.getGL().getGL2();
        final GLU glu = new GLU();
        gl.glViewport(0, 0, width, height);
        gl.glMatrixMode(GL2.GL_PROJECTION);
        gl.glLoadIdentity();
        ML.ht = (double)height;
        ML.wd = (double)width;
    }

}

class PenTool {
    private MouseLogger ML;


    PenTool(MouseLogger ML) {
        this.ML = ML;
    }


    public void pen(GL2 gl) {

        gl.glPointSize(4.0f);
        gl.glLineWidth(4.0f);

        if (GlobalVariable.lineToolButton) {
            gl.glColor3f(GlobalVariable.r,GlobalVariable.g,GlobalVariable.b);
            gl.glBegin(GL2.GL_LINES);
            gl.glVertex2d(0,0);
            gl.glVertex2d(ML.getXCoordinate(), ML.getYCoordinate());
            gl.glEnd();
            gl.glFlush();

        }

        if (GlobalVariable.penToolButton) {

            //gl.glClear(GL.GL_COLOR_BUFFER_BIT);
            gl.glColor3f(GlobalVariable.r, GlobalVariable.g, GlobalVariable.b);
            gl.glBegin(GL2.GL_LINES);
            if (GlobalVariable.mouse_drag) {
                gl.glVertex2d(ML.getXOld(), ML.getYOld());
                gl.glVertex2d(ML.getXCoordinate(), ML.getYCoordinate());
            }
            gl.glEnd();
            gl.glFlush();

        }

    }
}
/**
class PolygonTool {
    private MouseLogger ML;


    PolygonTool(MouseLogger ML) {
        this.ML = ML;
    }


    public void triangle(GL2 gl) {

        gl.glPointSize(4.0f);
        gl.glLineWidth(4.0f);

        gl.glColor3f(GlobalVariable.r,GlobalVariable.g,GlobalVariable.b);
        gl.glBegin(GL2.GL_TRIANGLES);
        gl.glVertex2d(0,0);
        gl.glVertex2d(0,0);
        gl.glVertex2d(ML.getXCoordinate(), ML.getYCoordinate());
        gl.glEnd();
        gl.glFlush();


    }
    public void quads(GL2 gl) {

        gl.glPointSize(4.0f);
        gl.glLineWidth(4.0f);

        gl.glColor3f(GlobalVariable.r,GlobalVariable.g,GlobalVariable.b);
        gl.glBegin(GL2.GL_QUADS);
        gl.glVertex2d(0,0);
        gl.glVertex2d(0,0);
        gl.glVertex2d(0,0);
        gl.glVertex2d(ML.getXCoordinate(), ML.getYCoordinate());
        gl.glEnd();
        gl.glFlush();


    }
}
 */