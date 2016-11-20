public class merge
{
	 public static void merge(int[] arr, int n)
	 {
	 	//EC
	 	int[] tmp=new int[n];
	 	merge(arr,O,n-1,tmp);
	 }
	 private static void merge(int[] arr, int l, int r, int[] tmp)
	 {
	 	int m;
	 	if(r-l < min)
	 		InsertionSort(arr,r+1,l,1);
	 	else
	 	{
	 		m=l+(r-l)/2;
	 		merge(arr,l,m,tmp);
	 		merge(arr,n+1,r,tmp);
	 		for(i=l;i<=m;i++)
	 			tmp[i]=arr[i];
	 		for(j=r; j>m; j--,i++)
	 			tmp[i]=arr[j];
	 		for(i=l;j=r;k=l; k<=r;k++)
	 			if(tmp[i] <= tmp[j])
	 				arr[k]=tmp[i++];
	 			else
	 				arr[k]=tmp[j--];
	 	}
	 }
}