import com.jogamp.common.nio.Buffers;
import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.glu.GLU;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;

import static com.jogamp.opengl.GL.GL_BYTE;
import static com.jogamp.opengl.GL.GL_RGB;
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
        gl.glViewport(0, 0, width, height);
        gl.glMatrixMode(GL2.GL_PROJECTION);
        gl.glLoadIdentity();
        ML.ht = (double)height;
        ML.wd = (double)width;
        GlobalVariable.frameWidth = width;
        GlobalVariable.frameHeight = height;
        System.out.println(width);
        System.out.println(height);
    }

    /*public BufferedImage makeScreenshot(GLAutoDrawable drawable) {
        int width = 1854, height = 996;

        GL2 gl = drawable.getGL().getGL2();

        BufferedImage screenshot = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics graphics = screenshot.getGraphics();

        ByteBuffer buffer = Buffers.newDirectByteBuffer(width * height * 3);

        gl.glReadPixels(0, 0, width, height, GL_RGB, GL_BYTE, buffer);


        for (int h = 0; h < height; h++) {
            for (int w = 0; w < width; w++) {
                // The color are the three consecutive bytes, it's like referencing
                // to the next consecutive array elements, so we got red, green, blue..
                // red, green, blue, and so on..
                graphics.setColor(new Color( buffer.get()*2, buffer.get()*2, buffer.get()*2 ));
                graphics.drawRect(w,height - h, 1, 1); // height - h is for flipping the image
            }
        }
        return screenshot;
    }*/
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
        /*double radius = 0;
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
        gl.glFlush();*/
        int width = GlobalVariable.frameWidth + 6, height = GlobalVariable.frameHeight;
        //int width = 1140, height = 739;

        //GL2 gl = drawable.getGL().getGL2();

        BufferedImage screenshot = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics graphics = screenshot.getGraphics();

        ByteBuffer buffer = Buffers.newDirectByteBuffer(width * height * 3);

        gl.glReadPixels(0, 0, width, height, GL_RGB, GL_BYTE, buffer);


        for (int h = 0; h < height; h++) {
            for (int w = 0; w < width; w++) {
                // The color are the three consecutive bytes, it's like referencing
                // to the next consecutive array elements, so we got red, green, blue..
                // red, green, blue, and so on..
                graphics.setColor(new Color( buffer.get()*2, buffer.get()*2, buffer.get()*2 ));
                graphics.drawRect(w,height - h, 1, 1); // height - h is for flipping the image
            }
        }

        try {
            ImageIO.write(screenshot, "png", new File("/home/zakee94/Java_Project/Codes/paintJOGL/screen.png"));
        } catch (IOException ex) {
            // You know ... what to do here :P
        }
    }
}