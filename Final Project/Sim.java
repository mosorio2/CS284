/**
* Runs the simulation of the TSA simulator
*@author Michael Osorio
*I pledge my honor that I have abided by the Stevens Honor System
*/
import java.io.IOException;
public class Sim
{
	/**
	*runs a simulation for when each passenger gets checked
	*@param officer 	a TSA officer
	*@param pass 	a passenger in an officer's line
	*@return true 	if a passenger is checked
	*@return false 	if a passenger is not checked
	*/
	public static boolean whenChecked(TSA officer, Passenger pass)
	{
		int[] dislikes = officer.getDislikes();
		int[] likes = officer.getLikes();
		int dang = pass.getDangerLevel();
		for(int i = 0; i < dislikes.length; i++)
		{
			if(dislikes[i] == pass.getOrigin())
				dang+= 2;
			if(dislikes[i] == pass.getSpecies())
				dang+= 2;
			if(dislikes[i] == pass.getGender())
				dang+= 2;
		}
		for(int i = 0; i < likes.length; i++)
		{
			if(likes[i] == pass.getOrigin())
				dang-= 2;
			if(likes[i] == pass.getSpecies())
				dang-= 2;
			if(likes[i] == pass.getGender())
				dang-= 2;
		}
		if(dang > 10 - officer.getParanoia())
			return true;
		return false;
	}
	/**
	*main method for testing
	*/
	public static void main(String[] args) throws IOException
	{
		TSA[] officerArray = Sorter.sort();
		MyQueue[] lines = Sorter.createLines();
		for(int i = 0; i < officerArray.length; i++)
		{
			int theLineSize = lines[i].getSize();
			for(int j = 0; j < theLineSize; j++)
			{
				if(j == 0)
					System.out.println(officerArray[i].toString() + " to line " + i + "\n");
				if((whenChecked(officerArray[i], lines[i].peek())) && (lines[i].peek().getIsThreat() == 1))
					System.out.println(officerArray[i].toString() + " checks on " + lines[i].peek().toString() + "... To the interrogation room. Successfull! \n");
				if((whenChecked(officerArray[i], lines[i].peek())) && (lines[i].peek().getIsThreat() == 0))
					System.out.println(officerArray[i].toString() + " checks on " + lines[i].peek().toString() + "... To the interrogation room. Unnecessary Screening! \n");
				if((!whenChecked(officerArray[i], lines[i].peek())) && (lines[i].peek().getIsThreat() == 1))
					System.out.println(officerArray[i].toString() + " checks on " + lines[i].peek().toString() + "... Free to Go. .... Missed a threat...Oops. \n");
				if((!whenChecked(officerArray[i], lines[i].peek())) && (lines[i].peek().getIsThreat() == 0))
					System.out.println(officerArray[i].toString() + " checks on " + lines[i].peek().toString() + "... Free to Go. Good job! \n");
				lines[i].dequeue();
			}
		}
	}
}
