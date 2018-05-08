import java.io.File;
import java.io.IOException;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.glu.GLU;
import com.jogamp.opengl.util.texture.Texture;
import com.jogamp.opengl.util.texture.TextureIO;

/**
 *
 * @author Tiago
 */

public class simpleJOGL{

    private float x, y, z;
    private float mx, my, mz;
    private float l;
    private float RX,RY,RZ;
    private String texture;
    private int inc;



    public void update(){
        RX+=mx;
        RY+=my;
        RZ+=mz;
    }

    public void init(GLAutoDrawable render){
        GL2 gl = render.getGL().getGL2();


        try{
            File file = new File(texture);
            Texture t = TextureIO.newTexture(file, false);
            inc = t.getTextureObject(gl);

        }catch (IOException exc) {
            System.exit(1);
        }

    }

    public simpleJOGL(float x, float y, float z, float tx, float ty, float tz, float l, String texture) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.mx = tx;
        this.my = ty;
        this.mz = tz;
        this.l= l;
        this.texture = texture;
    }


    public void render(GLAutoDrawable render){
        GL2 gl = render.getGL().getGL2();
        GLU glu = GLU.createGLU(gl);

        gl.glBindTexture(gl.GL_TEXTURE_2D, inc);

        gl.glPushMatrix(); //Push la matrice actuelle

        gl.glRotatef(RX, 1f, 0f, 0f);
        gl.glRotatef(RY, 0f, 1f, 0f);
        gl.glRotatef(RZ, 0f, 0f, 1f);


        //Dessin
        gl.glBegin(gl.GL_QUADS);

        gl.glTexCoord2d(0, 0); gl.glVertex3f(x-l,y-l,z-l);
        gl.glTexCoord2d(1, 0); gl.glVertex3f(x+l,y-l,z-l);
        gl.glTexCoord2d(1, 1); gl.glVertex3f(x+l,y+l,z-l);
        gl.glTexCoord2d(0, 1); gl.glVertex3f(x-l,y+l,z-l);

        gl.glTexCoord2d(0, 0); gl.glVertex3f(x-l,y-l,z+l);
        gl.glTexCoord2d(1, 0); gl.glVertex3f(x+l,y-l,z+l);
        gl.glTexCoord2d(1, 1); gl.glVertex3f(x+l,y+l,z+l);
        gl.glTexCoord2d(0, 1); gl.glVertex3f(x-l,y+l,z+l);

        gl.glTexCoord2d(0, 0); gl.glVertex3f(x-l,y-l,z-l);
        gl.glTexCoord2d(1, 0); gl.glVertex3f(x-l,y-l,z+l);
        gl.glTexCoord2d(1, 1); gl.glVertex3f(x-l,y+l,z+l);
        gl.glTexCoord2d(0, 1); gl.glVertex3f(x-l,y+l,z-l);

        gl.glTexCoord2d(0, 0); gl.glVertex3f(x+l,y-l,z-l);
        gl.glTexCoord2d(1, 0); gl.glVertex3f(x+l,y-l,z+l);
        gl.glTexCoord2d(1, 1); gl.glVertex3f(x+l,y+l,z+l);
        gl.glTexCoord2d(0, 1); gl.glVertex3f(x+l,y+l,z-l);

        gl.glTexCoord2d(0, 0); gl.glVertex3f(x-l,y-l,z-l);
        gl.glTexCoord2d(1, 0); gl.glVertex3f(x-l,y-l,z+l);
        gl.glTexCoord2d(1, 1); gl.glVertex3f(x+l,y-l,z+l);
        gl.glTexCoord2d(0, 1); gl.glVertex3f(x+l,y-l,z-l);

        gl.glTexCoord2d(0, 0); gl.glVertex3f(x-l,y+l,z-l);
        gl.glTexCoord2d(1, 0); gl.glVertex3f(x-l,y+l,z+l);
        gl.glTexCoord2d(1, 1); gl.glVertex3f(x+l,y+l,z+l);
        gl.glTexCoord2d(0, 1); gl.glVertex3f(x+l,y+l,z-l);

        gl.glEnd();
        gl.glPopMatrix();

    }

}
