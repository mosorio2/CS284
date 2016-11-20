/**
	*Triangle extends Shape and defines the sides, perimeter, and area of a triangle
	*@author Michael Osorio
	*/
public class Triangle extends Shape
{
	private int side1;
	private int side2;
	private int side3;
	/* gives the three sides of a triangle
		*@param a 	side1 of the triangle
		*@param b 	side2 of the triangle
		*@param c 	side3 of the triangle
		*/
	public Triangle(int a, int b, int c)
	{
		if (a <= 0)
			side1 = 1;
		else
			side1 = a;
		if (b <= 0)
			side2 = 1;
		else
			side2 = b;
		if (c <= 0)
			side3 = 1;
		else
			side3 = c;
	}
	/* gives the default triangle of size 1x1x1
		*/
	public Triangle()
	{
		side1 = 1;
		side2 = 1;
		side3 = 1;
	}
	/* checks that the sides of the triangle can change to valid values
		*@param a 	value of side1 of the triangle
		*@param b 	value of side2 of the triangle
		*@param c 	value of side3 of the triangle
		*@return 	false if a, b, or c <= 0
		*@return 	true if a, b, or c > 0
		*/
	public boolean setSides(int a, int b, int c)
	{
		if (a <= 0 || b <= 0 || c <= 0)
			return false;
		else
		{
			side1=a;
			side2=b;
			side3=c;
			return true;
		}
	}
	/* gets the first side of the triangle
		*@return 	side1 of the triangle
		*/

	public int getSide1()
	{
		return side1;
	}
	/* gets the second side of the triangle
		*@return 	side2 of the triangle
		*/
	public int getSide2()
	{
		return side2;
	}
	/* gets the third side of the triangle
		*@return 	side3 of the triangle
		*/
	public int getSide3()
	{
		return side3;
	}
	/* checks to make sure that the first side of the triangle has a positive value
		*@param s 	side1 of the triangle
		*@return 	false if s <= 0
		*@return 	true if s > 0
		*/ 	
	public boolean setSide1(int s)
	{
		if (s<=0)
			return false;
		else
		{
			side1 = s;
			return true;
		}
	}
	/* checks to make sure that the second side of the triangle has a positive value
		*@param s 	side2 of the triangle
		*@return 	false if s <= 0
		*@return 	true if s > 0
		*/
	public boolean setSide2(int s)
	{
		if (s<=0)
			return false;
		else
		{
			side2 = s;
			return true;
		}
	}
	/* checks to make sure that the third side of the triangle has a positive value
		*@ param s 	side3 of the triangle
		*@return 	false if s <= 0
		*@return 	true if s > 0
		*/
	public boolean setSide3(int s)
	{
		if (s<=0)
			return false;
		else
		{
			side3 = s;
			return true;
		}
	}
	/* returns the area of a triangle given 3 known sides using Heron's formula
		*@return 	area of the triangle
		*/
	public double area()
	{
		double heron = (0.5 * (side1 + side2 + side3));
		return Math.sqrt(heron * (heron-side1)*(heron-side2)*(heron-side3));
	}
	/* returns the perimeter of a triangle with 3 known sides
		*@return 	perimter of the triangle
		*/
	public double perimeter()
	{
		return side1 + side2 + side3;
	}
	/* shortPrint prints the parameters, area, and perimeter of a shape
		*/
	public void shortPrint() 
	{
		System.out.println("Side1: " + side1 + "\nSide2: " + side2 + "\nSide3: "
		 + side3 + "\nArea: " + area() + "\nPerimeter: " + perimeter());
	}
	/* longPrint prints the information from shortPrint in complete sentences
		*/
	public void longPrint() 
	{
		System.out.println("The first side is " + side1 + ". The second side is "
		 + side2 + ". The third side is " + side3 + ". The area is " + area()
			+ ". The perimeter is " + perimeter() + ".");
	}
	/* Puts outputs in an easily understood way
		*@return 	Outputs in easily understood way
		*/

	public String toString() 
	{
		return "First side is " + side1 + ". Second side is " + side2 + ". Third side is " 
		+ side3 + ". Area is " + area() + ". Perimeter is " + perimeter() + ".";
	}
	/* main method for testing
		*/

	public static void main(String[] args) 
	{
		Triangle tri = new Triangle(3, 5, 6);
		System.out.println("Expected to return false: " + tri.setSide2(-20));
		System.out.println("Expected to return true: " + tri.setSide2(6));
		System.out.println("Expected to return value of side1: " + tri.getSide1());
		System.out.println("Expected to return value of side2: " + tri.getSide2());
		System.out.println("Expected to return value of side3: " + tri.getSide3());
		tri.setSide1(10);
		tri.setSide2(16);
		tri.setSide3(12);
		System.out.println("Expected length of side1 is 10");
		System.out.println("Expected length of side2 is 16");
		System.out.println("Expected length of side3 is 12");
		System.out.println("Expected area of the triangle is 59.925");
		System.out.println("Expected perimeter of the triangle is 38");
		tri.longPrint();
	}
}