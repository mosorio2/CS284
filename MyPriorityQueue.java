public class MyPriorityQueue extends MyMaxHeap
{
        private MyMaxHeap theQ;

	/*
		default constructor
	*/
        public MyPriorityQueue()
        {
		theQ = new MyMaxHeap();
        }

	public MyPriorityQueue(int cap)
	{
		//System.out.println("The cap is " + cap);
		theQ = new MyMaxHeap(cap);
	}
	
	/*
		@param arr: Array of Comparable to add to the Queue
		@param n: size of the Queue
	*/
        public MyPriorityQueue(Passenger[] arr, int n)
        {
                theQ = new MyMaxHeap(arr, n);
        }

	/*
		@param o: Comparable to enqueue to the queue
		@return MyMaxHeap.add(o)
	*/
        public boolean enqueue(Passenger o)
        {
		//theQ.parse();
                return theQ.add(o);
        }

	/*
		@return MyMaxHeap.removeMax()
	*/
        public Passenger dequeue()
        {
                return theQ.removeMax();
        }

	/*
		@return MyMaxHeap.getMax()
	*/
        public Passenger peek()
        {
                return theQ.getMax();
        }

	/*
		@return true if queue is empty, false otherwise
	*/
        public boolean empty()
        {
                if(theQ.size() <= 0)
                        return true;
                return false;
        }

	/*
		@return MyMaxHeap.parse()
	*/
	public void parse()
	{
		theQ.parse();
	}

	public int getSize()
	{
		return theQ.size();
	}

}
	