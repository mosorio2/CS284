/**
* MyHeap creates a max heap
* @author Michael Osorio 
*/
public class MyHeap
{
        private Passenger[] heap;
        public int size = 0;

	/**
	*	default constructor with size of 0 and a capacity of 20
	*/
        public MyHeap()
        {
		heap = new Passenger[20];
                size = 0;
        }
	
	/**
	*  initializes a heap with a certain capacity
	*	@param cap  the capacity of the Heap
	*/
        public MyHeap(int cap)
        {
		if(cap <= 0)
			cap = 20;
                heap = new Passenger[cap];
                size = 0;
        }

	/** 
	* creates a heap with passengers
	*	@param arr 	 array for the heap
	*	@param n  	the ssize oet f the heap 
	*/
        public MyHeap(Passenger[] arr, int n)
        {
                if(arr == null)
                {
                        heap = new Passenger[20];
                        size = 0;
                }
                else
                {
                        if(n < 0)
                                n = 0;
                        else if(n > arr.length)
                                n = arr.length;
                        heap = arr;
                        size = n;
                        buildHeap();
                }
        }

	/**
	* gets the size of the heap
	*	@return size of the array
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
                        temp[i] = heap[i];
                heap = temp;
        }

	/**
	* adds passengers to the heap
	*@param i  	a comparable to add into the heap
	*@return false 	if comparable is null
	* 	@return true 	otherwise
	*/
        public boolean add(Passenger i)
        {
                if(i == null)
		{
                        return false;
		}
                if(size >= heap.length)
		{
                        expand();
		}
                heap[size++] = i;
                shiftUp(size - 1);
                return true;
        }

	/**
	*removes the max from the heap
	* @return	 max of the heap when it is removed
	*/
        public Passenger removeMax()
        {
                if(size <= 0)
                        return null;
                swap(0, --size);
                shiftDown(0);
                return heap[size];
        }

        private void shiftDown(int i)
        {
                int lc; //left child
                if(i < (size / 2))
                {
                        lc = (2 * i) + 1;
                        if(((lc + 1) < size) && (heap[lc + 1].compareTo(heap[lc]) > 0))
                                lc++;
                        //lc now means lowest child
                        if(heap[lc].compareTo(heap[i]) > 0)
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
			//System.out.println(heap[p].toString());
                        if(heap[i].compareTo(heap[p]) > 0)
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
                        Passenger tmp = heap[x];
                        heap[x] = heap[y];
                        heap[y] = tmp;
                }

        }

        private void buildHeap()
        {
                int i;
                for(i = (size / 2) - 1; i >= 0; i--)
                        shiftDown(i);
        }
	
	/**
	*prints out each member of the Heap in an easily readable way
	*/
        public void parse()
        {
                int i;
                for(i = 0; i < size; i++)
                        System.out.println(heap[i].toString() + "\n");
        }
	
	/**
	* gets the max element of the Heap
	* @return  	 max of the Heap
	*/
	public Passenger getMax()
	{
		if(size <= 0)
			return null;
		return heap[0];
	}
}
