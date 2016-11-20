//this is the insertion sort algorithm
//complexity in the best case is n, complexity in the worst case is n squared

public class Insert implements Comparable
 {
 	//complexity of 1
	private static void swap(Object[] arr, int x, int y) 
	{
		if (x != y)
		 {
			Object temp = arr[x];
			arr[x] = arr[y];
			arr[y] = temp;
		}
	}
	public static void insert(Comparable[] arr, int n) 
	{					//n is the number of items we want to sort
		if (arr != null && n > 1)
		 {
			if (n > arr.length)
				n = arr.length;
		}
		for (int i = 1; i < n; i++) 
		{ //complexity is n in the best case, complexity is n squared in the worst case
			for (int j = i; j > 0 && arr[j].compareTo(arr[j-1]) < 0; j--) //complexity of 1 in the best case, complexity of i in the worst case
				swap(arr, j, j-1);	//complexity of 1
		}
	}
}
