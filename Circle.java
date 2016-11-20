/**
	*Circle extends Shape which implements Printable and defines the radius, area, and perimeter of a circle
	*@author Michael Osorio
	*/
public class Circle extends Shape
{
	private int radius;
	/* This method gives the radius of the circle
		*@param r 	radius of the circle
		*/
	public Circle(int r)
	{
		if (r <= 0)
			radius = 1;
		else
			radius=r;
	}
	/* This method gives a default circle with radius 1
		*/
	public Circle()
	{
		radius = 1;
	}
	/* gets the radius and returns it
		*@return 	radius of circle
		*/
	public int getRadius()
	{
		return radius;
	}
	/* checks that the radius has a positive value
		*@param r 	radius of circle
		*@return 	false if r <= 0
		*@return	true if r > 0
		*/
	public boolean setRadius(int r)
	{
		if (r <= 0)
			return false;
		else
		{
			radius = r;
			return true;
		}
	}
	/* gives the area of the circle
		*@return 	area of the circle
		*/
	public double area()
	{
		return Math.PI * radius * radius;
	}
	/* gives the perimeter (circumfrence) of the circle
		*@return 	perimeter (circumfrence) of the circle
		*/
	public double perimeter()
	{
		return 2 * Math.PI * radius;
	}
	/* shortPrint prints the parameters, area, and perimeter of a shape
		*/
	public void shortPrint()
	{
		System.out.println("Radius: " + radius + "\nArea: " + area() + "\nPerimeter: " + perimeter());
	}
	/* longPrint prints the information from shortPrint in complete sentences
		*/
	public void longPrint()
	{
		System.out.println("The radius is " + radius + ". The area is " +
			area() + ". The perimeter is " + perimeter() + ".");
	}
	/* Puts outputs in an easily understood way
		*@return 	Outputs in easily understood way
		*/
	public String toString()
	{
		return "Radius is " + radius + ". Area is " +
			area() + ". Perimeter is " + perimeter() + ".";
	}
	/* Main method for testing
		*/
	public static void main(String[] args)
	{
		Circle circle = new Circle(3);
		System.out.println("Circle: \nExpected to return false: " + circle.setRadius(-1));
		System.out.println("Expected to return false: " + circle.setRadius(0));
		System.out.println("Expected to return true: " + circle.setRadius(4));
		System.out.println("Expected to return newly set radius: " + circle.getRadius());
		circle.setRadius(4);
		System.out.println("Expected radius of circle is 4");
		System.out.println("Expected area of circle is 50.26548");
		System.out.println("Expected perimeter (circumfrence) of circle is 25.132741");
		circle.longPrint();
	}
}