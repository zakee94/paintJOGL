import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.glu.GLU;

import static java.lang.Math.*;


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
        TriangleTool triangle1 = new TriangleTool();
        QuadTool quad1 = new QuadTool();

        if (GlobalVariable.penToolButton) {
            if (GlobalVariable.eraser_flag)
                pen1.pen(gl, true);
            else
                pen1.pen(gl, false);
        }
        else if (GlobalVariable.lineToolButton && !GlobalVariable.mouse_drag) {
            line1.line(gl);
        }
        else if (GlobalVariable.circleToolButton && GlobalVariable.lineCreator) {
            circle1.circle(gl);
        }

        else if (GlobalVariable.triangleToolButton) {
            triangle1.triangle(gl);
        }
        else if (GlobalVariable.quadToolButton) {
            quad1.quad(gl);
        }

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
        glu.gluOrtho2D( 0, width, height, 0);

        gl.glViewport(0, 0, width, height);
        gl.glMatrixMode(GL2.GL_PROJECTION);
        gl.glLoadIdentity();
    }

}

class PenTool {
    private MouseLogger ML;

    PenTool(MouseLogger ML) {
        this.ML = ML;
    }

    public void pen(GL2 gl, boolean flag) {

        if (flag) {
            gl.glPointSize(100f);
            gl.glLineWidth(100f);
            gl.glColor3f(1f, 1f, 1f);

        }
        else {
            gl.glPointSize(4.0f);
            gl.glLineWidth(4.0f);
            gl.glColor3f(GlobalVariable.r, GlobalVariable.g, GlobalVariable.b);
        }

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
            GlobalVariable.lineCreator = false;
        }

        gl.glFlush();
    }

}

class TriangleTool {

    public void triangle(GL2 gl) {

        gl.glPointSize(4.0f);
        gl.glLineWidth(4.0f);

        gl.glColor3f(GlobalVariable.r,GlobalVariable.g,GlobalVariable.b);
        if(GlobalVariable.polygonCreator == 2) {
            gl.glBegin(GL2.GL_TRIANGLES);
                gl.glVertex2d(GlobalVariable.X_poly[0], GlobalVariable.Y_poly[0]);
                gl.glVertex2d(GlobalVariable.X_poly[1], GlobalVariable.Y_poly[1]);
                gl.glVertex2d(GlobalVariable.X_poly[2], GlobalVariable.Y_poly[2]);
            gl.glEnd();
            GlobalVariable.polygonCreator = -1;
        }
        gl.glFlush();

    }
}

 class QuadTool {

    public void quad(GL2 gl) {

         gl.glPointSize(4.0f);
         gl.glLineWidth(4.0f);

         gl.glColor3f(GlobalVariable.r,GlobalVariable.g,GlobalVariable.b);
        if(GlobalVariable.polygonCreator == 3) {
            gl.glBegin(GL2.GL_QUADS);
                gl.glVertex2d(GlobalVariable.X_poly[0], GlobalVariable.Y_poly[0]);
                gl.glVertex2d(GlobalVariable.X_poly[1], GlobalVariable.Y_poly[1]);
                gl.glVertex2d(GlobalVariable.X_poly[2], GlobalVariable.Y_poly[2]);
                gl.glVertex2d(GlobalVariable.X_poly[3], GlobalVariable.Y_poly[3]);
            gl.glEnd();
            GlobalVariable.polygonCreator = -1;
        }
         gl.glFlush();

    }
 }

class CircleTool {
    private MouseLogger ML;


    CircleTool(MouseLogger ML) {
        this.ML = ML;
    }

    public void circle(GL2 gl) {

        double x, y, xi, yi, a, b, Di, radius;

        a = (ML.lineX - ML.lineXEnd);
        b = (ML.lineY - ML.lineYEnd);

        radius = (int) sqrt((a*a)+ (b*b));

        System.out.println(a+" "+ML.lineX+" "+ML.lineXEnd);
        System.out.println(b+" "+ML.lineY+" "+ML.lineYEnd);
        System.out.println(radius);

        Di = 1 - radius;
        xi = 0;
        yi = radius;

        while(yi > xi) {
            xi = xi + 1;
            if(Di < 0){
                Di = Di + (2*xi) + 3;
            }
            else{
                yi = yi - 1;
                Di = Di + (2*xi) - (2*yi) + 5;
            }
            x = ML.lineX + xi;
            y = ML.lineY + yi;

            gl.glBegin(GL2.GL_LINES);

            gl.glColor3f(1,0,0);
                gl.glVertex2d(y, -x);
                gl.glVertex2d(-x, y);

            gl.glColor3f(0,1,0);
                gl.glVertex2d(y, x);
                gl.glVertex2d(x, y);

            gl.glColor3f(1,0,1);
                gl.glVertex2d(x, -y);
                gl.glVertex2d(-y, x);

            gl.glColor3f(0,1,1);
                gl.glVertex2d(-y, -x);
                gl.glVertex2d(-x, -y);

            gl.glEnd();
        }
        gl.glFlush();
    }
}