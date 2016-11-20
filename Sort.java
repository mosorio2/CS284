import java.io.IOException;

public class Sort 
{
	public static MyPriorityQueue[] lines;

	private static void swap(Object[] arr, int x, int y) 
	{
        	if (x != y) 
		{
            		Object temp = arr[x];
            		arr[x] = arr[y];
            		arr[y] = temp;
		}
        }

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
		public static TSA[] sort() throws IOException
		 {
			TSA[] tsa = ReadFile.createTsa();
			insert(tsa, tsa.length);
			return tsa;
		}
	
	public static MyPriorityQueue[] buildLines() throws IOException
	{
		Passenger[] passArr = ReadFile.buildPass();
		System.out.println(passArr[0].toString());
		int agents = ReadFile.buildAgents().length + 1;
		lines = new MyPriorityQueue[agents];

		for(int i = 0; i < lines.length; i++)
		{
			System.out.println(i);
			lines[i] = new MyPriorityQueue(passArr.length / agents);
		}

		for(int i = 0; i < passArr.length; i++)
		{
			int index = passArr[i].getIndex() % agents;
			if((lines[index].size) < (passArr.length/agents))
			{
				lines[index].parse();
				System.out.println(i);
				lines[index].enqueue(passArr[i]);
				lines[index].parse();
			}
			lines[(passArr[i].getIndex() + 1) % agents].enqueue(passArr[i]);
		}
		return lines;
	}
	

		
	public static void main(String[] args) throws IOException
	{
		TSA[] sortedArr = sort();
		for(int i = 0; i < sortedArr.length; i++)
			System.out.println(sortedArr[i]);
		MyPriorityQueue[] lineQueue = buildLines();
		for(int i =0; i < lineQueue.length; i++)
			lineQueue[i].parse();
	}
}
