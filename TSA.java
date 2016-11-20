/**
* TSA extends Person and applies more traits to a TSA agent
* @author Michael Osorio
*/
public class TSA extends Person 
{

	private int paranoia;
	private int[] likes;
	private int[] dislikes;

/**
* TSA constructs the traits of a TSA agent
* @param fn 	first name
* @param ln 	last name
* @param a 		age
* @param g 		gender
* @param p 		paranoia of the TSA officer
* @param larr 	an array of the TSA officer's likes
* @param darr 	an array of the TSA officer's dislikes
*/

	public TSA(String fn, String ln, int a, int g, int p, int[] larr, int[] darr) 
	{
		firstName = fn;
		lastName = ln;
		age = a;
		gender = g;
		paranoia = p;
		likes = larr;
		dislikes = darr;
	}
	
	/**
	* gets the paranoia of the officer
	* @return 	the paranois of the TSA officer
	*/
	public int getParanoia() 
	{
		return paranoia;
	}
	
	/**
	* gets the list of likes of the officer
	* @return likes 	the list of likes
	*/
	public int[] getLikes() 
	{
		/*for(int i = 0; i < likes.length; i++)
			System.out.println(likes[i]);
		*/
		return likes;
	}
	/**
	* getDislikes get the list of dislikes of the agent
	* @return dislikes 	the list of dislikes of the agent
	*/
	public int[] getDislikes() 
	{
		/*for(int i = 0; i < dislikes.length; i++)
			System.out.println(dislikes[i]);
		*/
		return dislikes;
	}
	
	/**
	* prints the name of the officer
	* @return firstName+lastName 	the full name of the officer
	*/
	public String toString() 
	{
		return firstName + " " + lastName;
	}
	
	/**
	*compareTo method for the TSA officer
	* @param officer 	the TSA officer
	* @return 1 		if the danger level is greater thanthat of the officer's
	* @return -1 		if the danger level is less than that of the officer's
	* @return 0 		if the previous returns don't hold
	*/
	public int compareTo(TSA officer) 
	{
		if(this.getDangerLevel() > officer.getDangerLevel())
			return 1;
		if(this.getDangerLevel() < officer.getDangerLevel())
			return -1;
		return 0;
	}
}