import java.util.*;
import java.applet.*;
import java.awt.*;
public class TriangleFractal extends Applet {
	private Image display;
	private Graphics drawingArea;
	public void init(){
		int height = getSize().height;
		int width = getSize().width;
		display = createImage(width, height);
		drawingArea = display.getGraphics();
		drawFirstTriangle(height, drawingArea); //draws background triangle
		int side = height/2;
		int [] xArray = {side/2, side+side/2, side};
		int [] yArray = {side, side, 2*side};
		drawTriangle(xArray, yArray, side, drawingArea);//draws all other triangles on top
	}
	public void paint(Graphics g){ //this is called by the engine and is what actually paints everything
		g.drawImage(display, 0, 0, null);
	}
	public static void drawFirstTriangle(int side, Graphics g){
		int [] xArray = {side/2, side, 0};
		int [] yArray = {0, side, side};
		g.setColor(Color.black);
		g.fillPolygon(xArray, yArray, 3);
	}
	public static void drawTriangle(int [] xArray, int [] yArray, int side, Graphics g){		
		g.setColor(Color.white);
		g.fillPolygon(xArray, yArray, 3);
		if(side>=4){
			side = side/2;
			int [] axArray = new int [3]; //axArray, ayArray is the top triangle
			int [] ayArray = new int [3];
			axArray[0] = xArray[2]-side/2;
			axArray[1] = xArray[2]+side/2;
			axArray[2] = xArray[2];
			ayArray[0] = yArray[0]-side;
			ayArray[1] = yArray[0]-side;
			ayArray[2] = yArray[0];
			drawTriangle(axArray, ayArray, side, g);
			int [] bxArray = new int [3]; //bxArray, byArray is the left triangle
			int [] byArray = new int [3];
			bxArray[0] = xArray[0]-side/2;
			bxArray[1] = xArray[0]+side/2;
			bxArray[2] = xArray[0];
			byArray[0] = yArray[0]+side;
			byArray[1] = yArray[0]+side;
			byArray[2] = yArray[0]+2*side;
			drawTriangle(bxArray, byArray, side, g);
			int [] cxArray = new int [3]; //cxArray, cyArray is the right triangle
			int [] cyArray = new int [3];
			cxArray[0] = xArray[1]-side/2;
			cxArray[1] = xArray[1]+side/2;
			cxArray[2] = xArray[1];
			cyArray[0] = yArray[0]+side;
			cyArray[1] = yArray[0]+side;
			cyArray[2] = yArray[0]+2*side;
			drawTriangle(cxArray, cyArray, side, g);
		}
		else{
			return;
		}
	}
}