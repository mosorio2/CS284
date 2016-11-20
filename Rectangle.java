/**
	*Rectangle extends Shape which implements Printable and defines the base, height, area, and perimeter of a rectangle.
	*@author Michael Osorio
	*/
public class Rectangle extends Shape
{
	private int base;
	private int height;
	/* gives the base and height of the rectangle
		*@param b 	base of rectangle
		*@param h 	height of rectangle
		*/
	public Rectangle(int b, int h)
	{
		if (b <= 0)
			base=1;
		else
			base = b;
		if (h <= 0)
			height=1;
		else
			height = h;
	}
	/* gives default rectangle with size of 1x1
		*/
	public Rectangle()
	{
		base = 1;
		height = 1;
	}
	/* gets the height of the rectangle
		*@return 	height of rectangle
		*/
	public int getHeight()
	{
		return height;
	}
	/* gets the base of the rectangle
		*@return 	base of rectangle
		*/
	public int getBase()
	{
		return base;
	}
	/* checks to make sure the height has a positive value
		*@param h 	height of rectangle
		*@return 	false if h <= 0
		*@return 	true if h > 0
		*/
	public boolean setHeight(int h)
	{
		if (h<=0)
			return false;
		else
		{
			height=h;
			return true;
		}
	}
	/* checks to make sure the base has a positive value
		*@param b 	base of rectangle
		*@return 	false if b <= 0
		*@return 	true if b > 0
		*/
	public boolean setBase (int b)
	{
		if (b<=0)
			return false;
		else
		{
			base=b;
			return true;
		}
	}
	/* gives the area of the rectangle by multiplying the base by the height
		*@return 	area of the rectangle
		*/
	public double area()
	{
		return base * height;
	}
	/* gives the perimeter of the rectangle by adding together the bases and heights
		*@return 	perimeter of the rectangle
		*/
	public double perimeter()
	{
		return (2* base) + (2 * height);	
	}
	/* shortPrint prints the parameters, area, and perimeter of a shape
		*/
	public void shortPrint()
	{
		System.out.println("Base: " + base + "\nHeight: " + height + "\nArea: "
			+ area() + "\nPerimeter: " + perimeter()); 
	}
	/* longPrint prints the information from shortPrint in complete sentences
		*/
	public void longPrint()
	{
		System.out.println("The base is " + base + ". The height is " + height + 
			". The area is " + area() + ". The perimeter is " + perimeter() + ".");
	}
	/* Puts outputs in an easily understood way
		*@return 	Outputs in easily understood way
		*/
	public String toString()
	{
		return "Base is " + base + ". Height is " + height + ". Area is " + area() + 
		". Perimeter is " + perimeter() + ".";
	}
	/* Main method for testing
		*/
	public static void main(String [] args)
	{
		Rectangle rec = new Rectangle(4, 5);
		System.out.println("Rectangle: \nExpected height: 5");
		System.out.println("Expected to return height: " + rec.getHeight());
		System.out.println("Expected to return base: " + rec.getBase());
		System.out.println("Expected to return false: " + rec.setBase(-1));
		System.out.println("Expected to return false: " + rec.setHeight(0));
		System.out.println("Expected to return true: " + rec.setHeight(6));
		System.out.println("Expected to return true: " + rec.setBase(7));
		rec.setHeight(2);
		rec.setBase(3);
		System.out.println("Expected height is 2");
		System.out.println("Expected base is 3");
		System.out.println("Expected area is 6");
		System.out.println("Expected perimeter is 10");
		rec.longPrint();
	}
}