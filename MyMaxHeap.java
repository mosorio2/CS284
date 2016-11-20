public class MyMaxHeap
{
        private Passenger[] theHeap;
        public int size = 0;

	/*
		default constructor with size = 0 and capacity of 20
	*/
        public MyMaxHeap()
        {
		theHeap = new Passenger[20];
                size = 0;
        }
	
	/* 
		@param cap: capacity of the MaxHeap
	*/
        public MyMaxHeap(int cap)
        {
		if(cap <= 0)
			cap = 20;
		//System.out.println(cap);
                theHeap = new Passenger[cap];
                size = 0;
		//System.out.println("The length of the array is " + theHeap.length);
        }

	/* 
		@param arr array to put into the heap
		@param n size of the heap 
	*/
        public MyMaxHeap(Passenger[] arr, int n)
        {
                if(arr == null)
                {
                        theHeap = new Passenger[20];
                        size = 0;
                }
                else
                {
                        if(n < 0)
                                n = 0;
                        else if(n > arr.length)
                                n = arr.length;
                        theHeap = arr;
                        size = n;
                        buildHeap();
                }
        }

	/*
		@return size of the array
	*/
        public int size()
        {
                return size;
        }

        private void expand()
        {
                Passenger[] temp = new Passenger[size + 20];
                int i;
                for(i = 0; i < size - 1; i++)
                        temp[i] = theHeap[i];
                theHeap = temp;
        }

	/*
		@param i Comparable to add to the heap
		@return false if comparable is null, true otherwise
	*/
        public boolean add(Passenger i)
        {
		//parse();
		//System.out.println(i.toString());
		//System.out.println("here is what you want: " + size);
                if(i == null)
		{
		//	System.out.println("cock");
                        return false;
		}
                if(size >= theHeap.length)
		{
		//	System.out.println(theHeap.length);
		//	System.out.println("vagina");
                        expand();
		}
                theHeap[size++] = i;
		//parse();
                shiftUp(size - 1);
		//parse();
		//System.out.println("is this the size: " + size);
                return true;
        }

	/*
		@return the max of the heap that is removed
	*/
        public Passenger removeMax()
        {
                if(size <= 0)
                        return null;
                swap(0, --size);
                shiftDown(0);
                return theHeap[size];
        }

        private void shiftDown(int i)
        {
                int lc; //left child
                if(i < (size / 2))
                {
                        lc = (2 * i) + 1;
                        if(((lc + 1) < size) && (theHeap[lc + 1].compareTo(theHeap[lc]) > 0))
                                lc++;
                        //lc now means lowest child
                        if(theHeap[lc].compareTo(theHeap[i]) > 0)
                                swap(lc,i);
                                shiftDown(lc);
                }
        }

        private int shiftUp(int i)
        {
                int p; //parent
                if((i > 0) && i < size)
                {
			p = (i - 1) / 2;
			//System.out.println(p);
			//System.out.println(theHeap[p].toString());
                        if(theHeap[i].compareTo(theHeap[p]) > 0)
                        {
                                swap(i,p);
                                return shiftUp(p);
                        }
                }
                return i;
        }

        private void swap(int x, int y)
        {
                if(x != y)
                {
                        Passenger tmp = theHeap[x];
                        theHeap[x] = theHeap[y];
                        theHeap[y] = tmp;
                }

        }

        private void buildHeap()
        {
                int i;
                for(i = (size / 2) - 1; i >= 0; i--)
                        shiftDown(i);
        }
	
	/*
		prints out each member of the MaxHeap
	*/
        public void parse()
        {
                int i;
                for(i = 0; i < size; i++)
                        System.out.println(theHeap[i].toString() + "\n");
        }
	
	/*
		@return the max of the Heap
	*/
	public Passenger getMax()
	{
		if(size <= 0)
			return null;
		return theHeap[0];
	}

}
