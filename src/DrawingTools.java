import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.glu.GLU;
import com.jogamp.opengl.util.awt.AWTGLReadBufferUtil;
import com.jogamp.opengl.util.awt.TextRenderer;
import com.jogamp.opengl.util.texture.Texture;
import com.jogamp.opengl.util.texture.TextureIO;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.lang.Math;

import static com.jogamp.opengl.GL.*;

public class DrawingTools  implements GLEventListener {

    static MouseLogger ML = new MouseLogger();

    public void display(GLAutoDrawable drawable) {
        GL2 gl = drawable.getGL().getGL2();

        PenTool pen1 = new PenTool(ML);
        LineTool line1 = new LineTool(ML);
        TextTool Text1 = new TextTool(ML);
        TriangleTool triangle1 = new TriangleTool();
        PolygonTool poly1 = new PolygonTool();
        RectangleTool rect1 = new RectangleTool(ML);
        FileSave save1 = new FileSave();
        FileOpen open1 = new FileOpen();
        ClearTool clear1 = new ClearTool();

        if (GlobalVariable.penToolButton) {
            if (GlobalVariable.eraser_flag)
                pen1.pen(gl, true);
            else
                pen1.pen(gl, false);
        }
        else if ((GlobalVariable.lineToolButton || GlobalVariable.rectToolButton) && !GlobalVariable.mouse_drag) {
            if(GlobalVariable.lineToolButton){ line1.line(gl); }
            else { rect1.rect(gl); };
        }
        else if (GlobalVariable.textToolButton && GlobalVariable.mouse_pressed) {
            Text1.Text(drawable, gl);
        }

        else if (GlobalVariable.triangleToolButton) {
            triangle1.triangle(gl);
        }
        else if (GlobalVariable.polygonToolButton) {
            poly1.poly(gl);
        }
        else if(GlobalVariable.save) {
            save1.screenshot(drawable);
        }
        else if(GlobalVariable.open) {
            open1.openSesame(gl);
        }
        else if(GlobalVariable.clearToolButton) {
            clear1.clearScreen(gl);
        }
    }

    public void dispose(GLAutoDrawable arg0) {

    }


    public void init(GLAutoDrawable drawable) {
        final GL2 gl = drawable.getGL().getGL2();
        gl.glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
        gl.glClearColor(1.0f, 1.0f, 1.0f, 1.0f);
        gl.glMatrixMode(GL2.GL_PROJECTION);
        gl.glMatrixMode(GL2.GL_MODELVIEW);
        gl.glLoadIdentity();
    }

    public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
        GL2 gl = drawable.getGL().getGL2();

        gl.glViewport(0, 0, width, height);
        gl.glMatrixMode(GL2.GL_PROJECTION);
        gl.glLoadIdentity();

        ML.ht = (double)height;
        ML.wd = (double)width;

        GlobalVariable.frameWidth = width;
        GlobalVariable.frameHeight = height;
    }
}

class PenTool {
    private MouseLogger ML;

    PenTool(MouseLogger ML) {
        this.ML = ML;
    }

    public void pen(GL2 gl, boolean flag) {

        if (flag) {
            gl.glLineWidth(GlobalVariable.lineWidth);
            gl.glColor3f(1f, 1f, 1f);
        }
        else {
            gl.glLineWidth(GlobalVariable.lineWidth);
            gl.glColor3f(GlobalVariable.r, GlobalVariable.g, GlobalVariable.b);
        }

        gl.glEnable( GL_LINE_SMOOTH );
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

        gl.glLineWidth(GlobalVariable.lineWidth);

        gl.glColor3f(GlobalVariable.r,GlobalVariable.g,GlobalVariable.b);

        if (GlobalVariable.lineCreator) {
            GlobalVariable.slope = ( ML.lineY - ML.lineYEnd)/(ML.lineX - ML.lineXEnd);
            System.out.println(GlobalVariable.slope+"  "+GlobalVariable.axial);

            if(!GlobalVariable.axial) {
                    gl.glEnable( GL_LINE_SMOOTH );
                    gl.glBegin(GL2.GL_LINES);
                    gl.glVertex2d(ML.lineX, ML.lineY);
                    gl.glVertex2d(ML.lineXEnd, ML.lineYEnd);
                    gl.glEnd();
                    GlobalVariable.lineCreator = false;
                }
            else {
                gl.glEnable(GL_LINE_SMOOTH);
                gl.glBegin(GL2.GL_LINES);
                if (GlobalVariable.slope < 1 || GlobalVariable.slope < -1) {
                    gl.glVertex2d(ML.lineX, ML.lineY);
                    gl.glVertex2d(ML.lineXEnd, ML.lineY);
                } else {
                    gl.glVertex2d(ML.lineX, ML.lineY);
                    gl.glVertex2d(ML.lineX, ML.lineYEnd);
                }
                gl.glEnd();
                GlobalVariable.lineCreator = false;
            }
        }

        gl.glFlush();
    }
}

class TriangleTool {

    public void triangle(GL2 gl) {

        gl.glLineWidth(GlobalVariable.lineWidth);

        gl.glColor3f(GlobalVariable.r,GlobalVariable.g,GlobalVariable.b);
        if(GlobalVariable.polygonCreator == 2) {
            gl.glEnable( GL_LINE_SMOOTH );
            if(!GlobalVariable.empty) { gl.glBegin(GL2.GL_TRIANGLES); }
            else { gl.glBegin(GL2.GL_LINE_LOOP); }
                gl.glVertex2d(GlobalVariable.X_poly[0], GlobalVariable.Y_poly[0]);
                gl.glVertex2d(GlobalVariable.X_poly[1], GlobalVariable.Y_poly[1]);
                gl.glVertex2d(GlobalVariable.X_poly[2], GlobalVariable.Y_poly[2]);
            gl.glEnd();
            GlobalVariable.polygonCreator = -1;
        }
        gl.glFlush();

    }
}

 class PolygonTool {

    public void poly(GL2 gl) {

        gl.glLineWidth(GlobalVariable.lineWidth);

         gl.glColor3f(GlobalVariable.r,GlobalVariable.g,GlobalVariable.b);
        if(GlobalVariable.polygonCreator == (GlobalVariable.polySides - 1)) {
            gl.glEnable( GL_LINE_SMOOTH );
            if(!GlobalVariable.empty) { gl.glBegin(GL2.GL_POLYGON); }
            else { gl.glBegin(GL2.GL_LINE_LOOP); }
                gl.glVertex2d(GlobalVariable.X_poly[0], GlobalVariable.Y_poly[0]);
                gl.glVertex2d(GlobalVariable.X_poly[1], GlobalVariable.Y_poly[1]);
                gl.glVertex2d(GlobalVariable.X_poly[2], GlobalVariable.Y_poly[2]);
                gl.glVertex2d(GlobalVariable.X_poly[3], GlobalVariable.Y_poly[3]);
                gl.glVertex2d(GlobalVariable.X_poly[4], GlobalVariable.Y_poly[4]);
                gl.glVertex2d(GlobalVariable.X_poly[5], GlobalVariable.Y_poly[5]);
                gl.glVertex2d(GlobalVariable.X_poly[6], GlobalVariable.Y_poly[6]);
                gl.glVertex2d(GlobalVariable.X_poly[7], GlobalVariable.Y_poly[7]);
                gl.glVertex2d(GlobalVariable.X_poly[8], GlobalVariable.Y_poly[8]);
                gl.glVertex2d(GlobalVariable.X_poly[9], GlobalVariable.Y_poly[9]);
                gl.glVertex2d(GlobalVariable.X_poly[0], GlobalVariable.Y_poly[0]);
            gl.glEnd();
            GlobalVariable.polygonCreator = -1;
        }
         gl.glFlush();

    }
 }

class RectangleTool {

    private MouseLogger ML;

    RectangleTool(MouseLogger ML) {
        this.ML = ML;
    }

    public void rect(GL2 gl) {

        gl.glLineWidth(GlobalVariable.lineWidth);

        gl.glColor3f(GlobalVariable.r,GlobalVariable.g,GlobalVariable.b);

        if (GlobalVariable.lineCreator) {
            gl.glEnable( GL_LINE_SMOOTH );
            if(!GlobalVariable.empty) { gl.glBegin(GL2.GL_QUADS); }
            else { gl.glBegin(GL2.GL_LINE_LOOP); }
                gl.glVertex2d(ML.lineX, ML.lineY);
                gl.glVertex2d(ML.lineX, ML.lineYEnd);
                gl.glVertex2d(ML.lineXEnd, ML.lineYEnd);
                gl.glVertex2d(ML.lineXEnd, ML.lineY);
            gl.glEnd();
            GlobalVariable.lineCreator = false;
        }

        gl.glFlush();
    }
}

class TextTool {
    private MouseLogger ML;

    TextTool(MouseLogger ML) {
        this.ML = ML;
    }

    public void Text(GLAutoDrawable drawable, GL2 gl) {
        TextRenderer renderer = new TextRenderer(new Font (GlobalVariable.textFont, GlobalVariable.fontType,
                                                            GlobalVariable.textSize));
        //System.out.println(GlobalVariable.textSize);

        int width = drawable.getSurfaceWidth();
        int height = drawable.getSurfaceHeight();
        double x = ML.getXCoordinate();
        double y = ML.getYCoordinate();

        int fx = (int)((width/2) + (x*width/2));
        int fy = (int)((height/2) + (y*height/2));
        //System.out.println(fx + " , " + fy);


        renderer.beginRendering(width, height);
        renderer.setColor(GlobalVariable.r, GlobalVariable.g, GlobalVariable.b, 0.8f);
        renderer.draw(GlobalVariable.myText, fx, fy);
        renderer.endRendering();
    }
}

class FileSave {
    public void screenshot(GLAutoDrawable glad) {

        AWTGLReadBufferUtil glReadBufferUtil = new AWTGLReadBufferUtil(glad.getGLProfile(), false);
        BufferedImage screenshot = glReadBufferUtil.readPixelsToBufferedImage(glad.getGL(), true);

        GlobalVariable.shot = screenshot;

        try {
            String extension = GlobalVariable.text.substring(GlobalVariable.text.length() - 3);
            if (extension.equals("png"))
                ImageIO.write(GlobalVariable.shot, "png", new File(GlobalVariable.text));
            else if (extension.equals("jpg"))
                ImageIO.write(GlobalVariable.shot, "jpg", new File(GlobalVariable.text));
            else
                System.out.println("Give proper name !");
        } catch (IOException ex) {
            // You know ... what to do here :P
        }

        GlobalVariable.currentAnimator.stop();
    }
}

class FileOpen {
    public void openSesame(GL2 gl) {
        // This part dynamically resizes the window to adjust the given image
        // according to its resolution while maintaining compatibiltiy with
        // the device's resolution.
        // Also works on multi monitor systems !!!
        try {
            BufferedImage bimg = ImageIO.read(new File(GlobalVariable.text));
            int width = bimg.getWidth() + 74;
            int height = bimg.getHeight() + 60;

            GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
            int screenWidth = gd.getDisplayMode().getWidth();
            int screenHeight = gd.getDisplayMode().getHeight();

            if (width >= screenWidth)
                width = screenWidth - 100;
            if (height >= screenHeight)
                height = screenHeight - 80;
            if (width < 1280)
                width = 1280;
            if (height < 720)
                height = 720;


            GlobalVariable.currentFrame.setSize(width, height);
        }
        catch(IOException ex) {
            // You know ... what to do here :P
        }

        // From here actual image opening starts
        try {
            Texture texture = TextureIO.newTexture(new File(GlobalVariable.text), true);
            texture.setTexParameteri(gl, GL2.GL_TEXTURE_MIN_FILTER, GL2.GL_LINEAR);
            texture.setTexParameteri(gl, GL2.GL_TEXTURE_MAG_FILTER, GL2.GL_LINEAR);
            texture.enable(gl);
            texture.bind(gl);

            gl.glPointSize(4.0f);
            gl.glLineWidth(4.0f);
            gl.glColor3d(GlobalVariable.filterR, GlobalVariable.filterG, GlobalVariable.filterB);

            gl.glBegin(GL2.GL_QUADS);
            gl.glTexCoord2d(0, 1);
            gl.glVertex2d(-1, 1);
            gl.glTexCoord2d(1, 1);
            gl.glVertex2d(1, 1);
            gl.glTexCoord2d(1, 0);
            gl.glVertex2d(1, -1);
            gl.glTexCoord2d(0, 0);
            gl.glVertex2d(-1, -1);
            gl.glEnd();

            texture.disable(gl);
            GlobalVariable.currentAnimator.stop();
        }
        catch(IOException ex) {
            // You know ... what to do here :P
        }
    }
}

class ClearTool {
    public void clearScreen(GL2 gl) {
        gl.glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
        gl.glClearColor(1.0f, 1.0f, 1.0f, 1.0f);
        gl.glMatrixMode(GL2.GL_PROJECTION);
        gl.glMatrixMode(GL2.GL_MODELVIEW);
        gl.glLoadIdentity();

        GlobalVariable.currentFrame.setSize(1280, 720);
    }
}
