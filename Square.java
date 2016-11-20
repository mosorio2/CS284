/**
	*Square extends Rectangle and defines the perimeter and area of a square
	*@author Michael Osorio
	*/
public class Square extends Rectangle
{
	private int side;
	/* gives the side of the square
		*@param s 	length of the side of the square
		*/
	public Square(int s)
	{
		if (s <= 0)
			side = 1;
		else
			side = s;
	}
	/* ives the default square with side 1
		*/
	public Square()
	{
		side = 1;
	}
	/* gets the side of the square
		*@return 	side of the square
		*/	
	public int getSide()
	{
		return getHeight();
	}
	/* checks that the sides of the square have a positive value
		*@param s 	length of the side of the square
		*@return 	false if s <= 0
		*@return 	true if s > 0
		*/
	public boolean setSide(int s)
	{
		if (s<=0)
			return false;
		else
		{
			setHeight(s);
			setBase(s);
			return true;
		}
	}
	/* shortPrint prints the parameters, area, and perimeter of a shape
		*/
	public void shortPrint()
	{
		System.out.println("Side: " + getHeight() + "\nArea: " + area() 
			+ "\nPerimeter: " + perimeter());
	}
	/* longPrint prints the information from shortPrint in complete sentences
		*/
	public void longPrint()
	{
		System.out.println("The side is " + getHeight() + ". The area is " + area()
			+ ". The perimeter is " + perimeter() + ".");
	}
	/* Puts outputs in an easily understood way
		*@return 	Outputs in easily understood way
		*/
	public String toString()
	{
		return "Side is " + getBase() + ". The area is " + area() + ". The perimeter is "
		+ perimeter() + ".";
	}
	/* main method for testing
		*/
	public static void main(String[] args)
	{
		Square sq = new Square();
		System.out.println("Square: \nExpected to return false: " + sq.setSide(-1));
		System.out.println("Expected to return true: " + sq.setSide(3));
		System.out.println("Expected to return side of length 3: " + sq.getSide());
		sq.setSide(10);
		System.out.println("Expected side is 10");
		System.out.println("Expected area of square is 100");
		System.out.println("Expected perimeter of square is 40");
		sq.longPrint();
	}
}