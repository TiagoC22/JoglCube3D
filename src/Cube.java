import java.util.ArrayList;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLEventListener;

/**
 *
 * @author Tiago
 */

public class Cube implements GLEventListener{
		
	ArrayList<simpleJOGL> tab = new ArrayList<simpleJOGL>();

	simpleJOGL cube_1 = new simpleJOGL(0.0f,0.0f,0.0f,1.0f,-1f,0.0f,0.1f, "img/earth.jpg");
	simpleJOGL cube_2 = new simpleJOGL(0.0f,0.3f,0.0f, 3f, 1f, 0f,0.1f, "img/moon.jpg");
	simpleJOGL cube_3 = new simpleJOGL(0.0f,0.6f,0.0f, 0.0f, 0.1f,4f,0.1f, "img/soleil.jpg");

	  
	public void update(){
		 cube_1.update();
		 cube_2.update();
		 cube_3.update();
	}
	
	public void render(GLAutoDrawable dr){
		tab.add(cube_1);
		tab.add(cube_2);
		tab.add(cube_3);
		for(simpleJOGL MonCube: tab){
			MonCube.render(dr);		
		}
	}

	@Override
	public void display(GLAutoDrawable dr) {
		GL2 gl = dr.getGL().getGL2();	
		gl.glClear(gl.GL_COLOR_BUFFER_BIT | gl.GL_DEPTH_BUFFER_BIT);
		update();
		render(dr);
	}

	@Override
	public void dispose(GLAutoDrawable gl) {
	}

	@Override
	public void init(GLAutoDrawable dr) {
		GL2 gl = dr.getGL().getGL2();
		gl.glEnable(gl.GL_DEPTH_TEST);
		gl.glEnable(gl.GL_TEXTURE_2D);
		gl.glLoadIdentity();
		cube_1.init(dr);
		cube_2.init(dr);
		cube_3.init(dr);
	}
	
	@Override
	public void reshape(GLAutoDrawable dr, int arg1, int arg2, int arg3, int arg4) {
	}
}