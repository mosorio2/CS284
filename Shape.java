/**
	*Shape implements Printable and lists the abstract methods to be implemented by the extended classes
	*@author Michael Osorio
	*/
public abstract class Shape implements Printable
{
	public abstract double area();
	public abstract double perimeter();
	/* tells user to call extended classes
		*/
	public static void main(String[] args) 
	{
		System.out.println("Call extended classes");
	}
}