/**
*Passenger extends Person and adds traits to the passenger at the airport
* @author Michael Osorio
*/
public class Passenger extends Person 
{

	private int origin;
	private int species;
	private int dangerLevel;
	private int isThreat;
	/**
	* Constructs the passenger and his or her traits
	* @param fn 	first name
	* @param ln 	last name
	* @param a 		age
	* @param g 		gender
	* @param o 		origin of the passenger
	* @param s 	    Species of the passenger
	* @param dl 	danger level of the passenger
	* @param it 	tell if the passenger is a threat
	*/
	public Passenger(String fn, String ln, int a, int g, int o, int s, int dl, int it) 
	{
		firstName = fn;
		lastName = ln;
		age = a;
		gender = g;
		origin = o;
		species = s;
		dangerLevel = dl;
		isThreat = it;
	}
	
	/**
	* gets the origin of the passenger
	* @return origin 	the origin of the passenger
	*/
	public int getOrigin() 
	{
		return origin;
	}
	
	/**
	* gets the species of the passenger
	* @return species 	the species of the passenger
	*/
	public int getSpecies() 
	{
		return species;
	}
	
	/**
	* gets the danger level of the passenger
	* @return dangerLevel 	the Danger level of the passenger
	*/
	public int getDangerLevel() 
	{
		return dangerLevel;
	}
	
	/**
	* gets the threat level of the passenger
	* @return isThreat 	tells if the passenger is actually a threat
	*/
	public int getIsThreat() 
	{
		return isThreat;
	}
	
	/**
	*compareTo method for the passenger
	* @param pass 	     the passenger
	* @return 1 		if the danger level is greater than that of the passenger's
	* @return -1 		if the danger level is less than that of the passenger's
	* @return 0 		if the previous returns don't hold
	*/
	public int compareTo(Passenger pass) 
	{
		if(this.getDangerLevel() > pass.getDangerLevel())
			return 1;
		if(this.getDangerLevel() < pass.getDangerLevel())
			return -1;
		return 0;
	}

	/**
	* prints the name of the passenger
	* @return firstName+lastName 	the full name of the passenger
	*/
	public String toString()
	{
		return this.firstName + " " + this.lastName;
	}

	/**
	* gets the index of where the passenger is located
	* @return this.age - this.gender + this.origin + this.species 	algorithm for where the index of the passenger is
	*/
	public int getIndex()
	{
		return this.age - this.gender + this.origin + this.species; 
	}

}