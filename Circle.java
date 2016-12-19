//This class brought to you by Don Landrum
public class Circle implements Shape{//must have getArea() and toString()
	private double radius;
	private double area;
	public Circle(double aRadius){//parameterized constructor
		radius = aRadius;
		area = Math.PI*aRadius*aRadius;
	}
	public double getRadius(){
		return radius;
	}
	public double getArea(){
		return area;
	}
	public String toString(){//prints out info about the circle
		String aString = "Circle Radius: "+getRadius()+" Area: "+getArea();
		return aString;
	}
}