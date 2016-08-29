import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.glu.GLU;

import static java.lang.Math.cos;
import static java.lang.StrictMath.sin;
import static java.lang.StrictMath.sqrt;

/**
 * Created by aakash on 28/8/16.
 */
public class DrawingTools  implements GLEventListener {

    static MouseLogger ML = new MouseLogger();

    public void display(GLAutoDrawable drawable) {

        GL2 gl = drawable.getGL().getGL2();
        PenTool pen1 = new PenTool(ML);
        LineTool line1 = new LineTool(ML);
        CircleTool circle1 = new CircleTool(ML);
        /**
        TriangleTool triangle1 = new TriangleTool(ML);
        QuadTool quad1 = new QuadTool(ML);
        */

        if (GlobalVariable.penToolButton) {
            pen1.pen(gl);
        }
        else if (GlobalVariable.lineToolButton && !GlobalVariable.mouse_drag) {
            line1.line(gl);
        }
        else if (GlobalVariable.circleToolButton && GlobalVariable.lineCreator) {
            circle1.circle(gl);
        }

        /**
        else if (GlobalVariable.triangleToolButton) {
            triangle1.triangle(gl);
        }
        else if (GlobalVariable.quadToolButton) {
            quad1.quad(gl);
        }
        */

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

class LineTool {

    private MouseLogger ML;

    LineTool(MouseLogger ML) {
        this.ML = ML;
    }

    public void line(GL2 gl) {

        gl.glPointSize(4.0f);
        gl.glLineWidth(4.0f);

        gl.glColor3f(GlobalVariable.r,GlobalVariable.g,GlobalVariable.b);

        if (GlobalVariable.lineCreator) {
            gl.glBegin(GL2.GL_LINES);
            gl.glVertex2d(ML.lineX, ML.lineY);
            gl.glVertex2d(ML.lineXEnd, ML.lineYEnd);
            gl.glEnd();
        }

        gl.glFlush();
    }

}
/**
class TriangleTool {
    private MouseLogger ML;


    TriangleTool(MouseLogger ML) {
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
}
 class QuadTool {
    private MouseLogger ML;


     QuadTool(MouseLogger ML) { this.ML = ML; }

    public void quad(GL2 gl) {

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
class CircleTool {
    private MouseLogger ML;


    CircleTool(MouseLogger ML) {
        this.ML = ML;
    }

    public void circle(GL2 gl) {
        double radius = 0;
        double theta, n, x, y, x1, y1, a, b;
        n = 3.141/180;
        a = (ML.lineX - ML.lineXEnd)*(ML.lineX - ML.lineXEnd);
        b = (ML.lineY - ML.lineYEnd)*(ML.lineY - ML.lineYEnd);
        radius = sqrt(a + b);
        for(theta=0;theta<=45;theta++) {
            x1=radius*cos(theta*n);
            y1=radius*sin(theta*n);
            x=ML.lineX + x1;
            y=ML.lineY + y1;
            gl.glColor3f(1,0,0);
            gl.glBegin(GL2.GL_LINES);
                gl.glVertex2d(y, -x);
                gl.glVertex2d(-y, x);
            gl.glEnd();

            gl.glColor3f(0,1,0);
            gl.glBegin(GL2.GL_LINES);
                gl.glVertex2d(y, x);
                gl.glVertex2d(-y, -x);
            gl.glEnd();

            gl.glColor3f(1,0,1);
            gl.glBegin(GL2.GL_LINES);
                gl.glVertex2d(x, -y);
                gl.glVertex2d(-x, y);
            gl.glEnd();

            gl.glColor3f(0,1,1);
            gl.glBegin(GL2.GL_LINES);
                gl.glVertex2d(x, y);
                gl.glVertex2d(-x, -y);
            gl.glEnd();
        }
        gl.glFlush();
    }
}