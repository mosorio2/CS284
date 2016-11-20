/** 
*Sort makes three different methods of sortin data in a list
*@author Michael Osorio
*I pledge my honor that I have abided by the Stevens Honor System
*/
public class MySorts
{
	private void compareTo(String str)
	{
		this.compareTo(str);
	}
	private static void parse(String[] arr)
	{
		for(int i =0; i< arr.length;i++)
			System.out.println(arr[i]);
	}
	private static void parse(int[] arr)
	{
		for(int i=0; i<arr.length;i++)
			System.out.println(arr[i]);
	}
	private static void swap(int[] arr, int x, int y)
	{
		if (x!= y)
		{
			int temp =arr[x];
			arr[x]=arr[y];
			arr[y]=temp;
		}
	}
	private static void swap(String[] arr, int x, int y)
	{
		if (x!= y)
		{
			String temp =arr[x];
			arr[x]=arr[y];
			arr[y]=temp;
		}
	}
	private static int findPivot(String [] arr, int l, int r)
	{
		return l+ (r-l)/2;
	}
	private static int partition(String[] arr, int l, int r)
	{
		int i, j;
		for(i=l, j= r-1;i<j; )
		{
			for(; arr[i].compareTo(arr[r])<0;i++)
				;
			for(; j>l && arr[j].compareTo(arr[r]) >= 0; j--)
				;
			if (i <j)
				swap(arr, i++, j--);
		}
		return i;
	}
	/* method for insert sorting
	*@param arr 	array of strings being sorted
	*@param n 	number of items being sorted
	*/
	public static void insert(String[] arr, int n)
	{
		if(arr != null && n>1)
		{
			if(n>arr.length)
				n=arr.length;
		}
		for(int i =1; i<n; i++)
		{
			for(int j=i;j>0 &&arr[j].compareTo(arr[j-1])<0;j--)
				swap(arr,j,j-1);
		}
	}
	private static void insert(int[] arr, int n, int s, int incr)
	{
		int i, j;
		for(i=s+incr;i<n;i+=incr)
		{
			for(j=i;(j>s)&&arr[j]<arr[j-incr];j-= incr)
				swap(arr,j,j-incr);
		}
	}
	private static void insert(String[] arr, int n, int s, int incr)
	{
		int i, j;
		for(i=s+incr;i<n;i+=incr)
		{
			for(j=i;(j>s)&&arr[j].compareTo(arr[j-incr]) < 0;j-= incr)
				swap(arr,j,j-incr);
		}
	}
	/*method for shell sort
	*@param arr 	array of integers being sorted
	*@param n 	number of items beng sorted
	*/
	public static void shell(int[] arr, int n)
	{
		int s, incr;
		if(arr != null && n>1)
		{
			if (n > arr.length)
				n = arr.length;
			for(incr = n/2;incr<n; incr++)
			{
				for (s=0; s<incr; s++)
					insert(arr, n, s, incr);
			}
			insert(arr, n, 0, 1);
		}
	}
	/* method for quick sort
	*@param arr 	list of strings being sorted
	*@param n 	number of items being sorted
	*/
	public static void quick(String[] arr, int n)
	{
		if(arr != null && n>1)
		{
			if(n>arr.length)
				n=arr.length;
			quick(arr, 0, n-1);
		}
	}
	private static void quick(String[] arr, int l, int r)
	{
		int p;
		if(r-l <10)
			insert(arr,r+1,l,1);
		else
		{
			p = findPivot(arr, l, r);
			swap(arr,p,r);
			p= partition(arr, l, r);
			swap(arr, p, r);
			quick(arr, l, p-1);
			quick(arr, p+1, r);
		}
	}
	/* main mehtod for testing
	*/
	public static void main(String[] args)
	{
		System.out.println("insert (Insertion Sort): ");
		String[] arr = {"python", "java", "Humphrey", "jacket", "walrus", "laptop"};
		insert(arr, 6);
		parse(arr);
		System.out.println("shell(Shell sort): ");
		int [] narr = {63, 42, 7, 10, 23, -14, 0, 9};
		shell(narr, 8);
		parse(narr);
		System.out.println("quick (quick sort): ");
		String[] tarr = {"Darth", "vader", "sail", "city", "cards", "mirror"};
		quick(tarr, 6);
		parse(tarr);		
	}
}