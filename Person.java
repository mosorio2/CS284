/**
	*Person constructs and lists the traits all people share
	*@author Michae Osorio
	*/
public class Person 
{

	String firstName;
	String lastName;
	int age;
	int gender;

/**
* getFirst() gets the first name of a person
* @return firstName 	the first name of the person
*/ 	
	public String getFirst() 
	{
		return firstName;
	}

/**
* getLast() gets the last name of a person
* @return lastName 	The last name of the person
*/
	public String getLast() 
	{
		return lastName;
	}

/**
* getAge() gets the age of the person
* @return age 	the age of the person
*/
	public int getAge() 
	{
		return age;
	}

/**
* getGender gets the gender of the person from the list of traits
* @return gender 	the gender of the person
*/
	public int getGender() 
	{
		return gender;
	}
}