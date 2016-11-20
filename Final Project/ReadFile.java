/**
* ReadFile reads the file with all the TSA simulator information
* @author Michael Osorio
*/
import java.util.Scanner;
import java.io.FileInputStream;
import java.nio.file.Paths;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.charset.Charset;

public class ReadFile 
{
	public static int[] larr;
	public static int[] darr;
	public static String tsaCount;
	public static String passengerCount;
	public static TSA[] tsaArr;
	public static Passenger[] passArr;	
	public static final String FILE = "input.dat";
	/**
	* gets the TSA officers
	* @Exception FileNotFound 	throws this exception
	* @return officers 	returns the officers for the TSA simulator
	*/
	public static int getTSA() throws FileNotFoundException 
	{	
		int officers = 0;
		FileInputStream is = new FileInputStream(FILE);
	    Scanner scan = new Scanner(is);
	    String tsaCount = scan.nextLine();
	    String[] tsaLine = tsaCount.split(" ");
	    officers = Integer.parseInt(tsaLine[0]);
		return officers;
	}
	/**
	* gets the passengers
	* @Exception FileNotFound 	throws this exception
	* @return 	pass 	the passengers for the siulator
	*/
	public static int getPass() throws FileNotFoundException 
	{	
		int pass = 0;
		FileInputStream is = new FileInputStream(FILE);
		Scanner scanner = new Scanner(is);
		String passengerCount = scanner.nextLine();
	    String[] passengerLine = passengerCount.split(" ");
	    pass = Integer.parseInt(passengerLine[1]);
		return pass;
	}
	
	/**
	* collects the data for the simulator and helps set it up
	* @Exception IOException 	throws this exception
	* @return readFile 		reads the file used for the simulator
	*/
	public static String[] data() throws IOException 
	{
		int officers = getTSA();
		int pass = getPass();
		int i = 0;
		int j = 1;
		int tsaLines = officers * 7;
		int passengerLines = pass * 8;
		int ttlLines = 2 + tsaLines + passengerLines;
		String[] readFile = new String[ttlLines];
		for(String readLine : Files.readAllLines(Paths.get(FILE), Charset.defaultCharset())) 
		{
			if(readLine.length() <= 0)
				;
			else
			{
				if( (i >= j*7) && (i <= j*7 + 1) && (j <= officers)) 
				{
					readFile[i] = readLine;
					i++;
					if((i < j*7) || (i > j*7 + 1))
						j++;
				}
				else 
				{
					for(String part : readLine.split(" ")) 
					{
						readFile[i] = part;
						i++;
					}
				}
			}
		}
		return readFile;
	}
	/**
	* gets the list of likes of the officers 
	* @Exception IOExeption 	throws this exception
	* @param officers 	the tsa officers
	* @return larr 	the list of likes of the officer
	*/
	public static int[] getLikes(int officers) throws IOException 
	{
		String data[] = data();
		String likes = data[officers*7];
		String[] arrayNumber = likes.split(" ");
		larr = new int[arrayNumber.length];
		for(int i = 0; i < arrayNumber.length; i++) 
			larr[i] = Integer.parseInt(arrayNumber[i]);
		return larr;
	}
	
	/**
	* gets the list of dislikes of the officer
	* @Exception IOException 	throws this exception
	* @param 	officers 	the tsa officers
	*@return darr 	the list of dislikes of the officer
	*/
	public static int[] getDislikes(int officers) throws IOException 
	{
		String data[] = data();
		String dislikes = data[officers*7+1];
		String[] arrayNumber = dislikes.split(" ");
		darr = new int[arrayNumber.length];
		for(int i = 0; i < arrayNumber.length; i++) 
		{
			darr[i] = Integer.parseInt(arrayNumber[i]);
		}
		return darr;
	}
	/**
	* creates the TSA agents
	*@Exception IOException 	throws this exception
	*@return tsaARR 	an array of TSA officers
	*/
	public static TSA[] createTSA() throws IOException 
	{
		int officers = getTSA();
		String[] data = data();
		tsaArr = new TSA[officers];
		for(int i = 0; i < tsaArr.length; i++)
			tsaArr[i] = new TSA(data[7*i+2], data[7*i+3], Integer.parseInt(data[7*i+4]), Integer.parseInt(data[7*i+5]), Integer.parseInt(data[7*i+6]), getLikes(i+1), getDislikes(i+1));
		return tsaArr;
	}
	/**
	* creates the passengers
	* @Exception IOException 	throws this exception
	* @return passArr 	an array of passengers
	*/
	public static Passenger[] createPass() throws IOException 
	{
		int pass = getPass();
		int officers = getTSA();
		int tsaLines = officers * 7;
		String[] data = data();
		passArr = new Passenger[pass];
		for(int i = 0; i < passArr.length; i++) {
			passArr[i] = new Passenger(data[tsaLines+2+i*8], data[officers*7+3+i*8], Integer.parseInt(data[tsaLines+4+i*8]), Integer.parseInt(data[tsaLines+5+i*8]), Integer.parseInt(data[tsaLines+6+i*8]), Integer.parseInt(data[tsaLines+7+i*8]), Integer.parseInt(data[tsaLines+8+i*8]), Integer.parseInt(data[tsaLines+9+i*8]));
		}
		return passArr;
	}
}
