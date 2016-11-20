/**
*Sorter sorts the officers and passengers according to agorithms and rules
*@author Michael Osorio
*/
import java.io.IOException;

public class Sorter 
{
	public static MyQueue[] lines;

	private static void swap(Object[] arr, int x, int y) 
	{
        	if (x != y) 
		{
            		Object temp = arr[x];
            		arr[x] = arr[y];
            		arr[y] = temp;
		}
    }

     /**
     * inserts for sorting (insertion sort)
     *@param arr 	array of officers
     *@param n 		number for sorting
     */
  	public static void insert(TSA[] arr, int n) 
	{
		if (arr != null && n > 1) 
		{
			if (n > arr.length)
				n = arr.length;
		}
		for (int i = 1; i < n; i++) 
		{
			for (int j = i; j > 0 && arr[j].compareTo(arr[j-1]) > 0; j--)
				swap(arr, j, j-1);
		}
	}
	/**
	* sorts the arrays using insertion sort
	* @return tsaArr 	array of tsa officers
	*/
	public static TSA[] sort() throws IOException
	 {
		TSA[] tsaArr = ReadFile.createTSA();
		insert(tsaArr, tsaArr.length);
		return tsaArr;
	}

	/**
	* createes the lines for the simulator	
	* @Exception IOException 	throws this exception
	* @return lines 	the lines for the TSA simulator
	*/
	public static MyQueue[] createLines() throws IOException
	{
		Passenger[] passArr = ReadFile.createPass();
		System.out.println(passArr[0].toString());
		int officers = ReadFile.createTSA().length + 1;
		lines = new MyQueue[officers];

		for(int i = 0; i < lines.length; i++)
		{
			System.out.println(i);
			lines[i] = new MyQueue(passArr.length / officers);
		}

		for(int i = 0; i < passArr.length; i++)
		{
			int index = passArr[i].getIndex() % officers;
			if((lines[index].size) < (passArr.length/officers))
			{
				lines[index].parse();
				System.out.println(i);
				lines[index].enqueue(passArr[i]);
				lines[index].parse();
			}
			lines[(passArr[i].getIndex() + 1) % officers].enqueue(passArr[i]);
		}
		return lines;
	}
}
