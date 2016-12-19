//This class brought to you by Don Landrum
public class Rectangle implements Shape{//must have getArea() and toString()
	private double side1;
	private double side2;
	private double area;
	public Rectangle(double aSide1, double aSide2){//parameterized constructor
		side1 = aSide1;
		side2 = aSide2;
		area = aSide1*aSide2;
	}
	public double getArea(){
		return area;
	}
	public double getSide1(){
		return side1;
	}
	public double getSide2(){
		return side2;
	}
	public String toString(){//prints out info about the rectangle
		String aString = "Rectangle Side 1: "+getSide1()+" Side 2: "+getSide2()+" Area: "+getArea();
		return aString;
	}
}