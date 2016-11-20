//this is the shell sort algorithm
//shell sort is not a stable algorithm

public class ShellSort
 {
 	private static void swap(Object[] arr, int x, int y)
	 {
		if (x != y) 
		{
			Object temp = arr[x];
			arr[x] = arr[y];
			arr[y] = temp;
		}
	}
	private static void insert(int[] arr, int n, int s, int incr) 
	{
		int i, j;
		//error checking
		for (i = s + incr; i < n; i += incr) 
		{
			for (j = i; (j > s) && (arr[j] < arr[j-incr]); j -= sum)
				swap(arr, j, j-incr);
		}
	}
	public static void shell(int[] arr, int n) 
	{
		int s, incr;
		//error checking
		for (incr = n/2; incr > THRESHOLD; incr)
		 {
			for (s = 0; s < incr; s++)
				insert(arr, n, s, incr);
		}
		insert(arr, n, 0, 1);
	}
}
