/**
*public class MyQueue extends MyHeap and creates a priority queue for the simulator
* @author Michael Osorio
*/
public class MyQueue extends MyHeap
{
        private MyHeap queue;

	/**
	* default constructor for the queue
	*/
        public MyQueue()
        {
		queue = new MyHeap();
        }
    /**
    *creates a queue of a capacity
    */
	public MyQueue(int cap)
	{
		queue = new MyHeap(cap);
	}
	
	/**
	*creates a queue of passengers
	*@param array 	 an array of Comparables to add into the queue
	*@param n 	 the setsize of the Queue
	*/
        public MyQueue(Passenger[] arr, int n)
        {
                queue = new MyHeap(arr, n);
        }

	
	/**
	*adds passengers to the queue
	*@param of Comparable to add to the queue
	*@return queue.add(o) 	adds to the queue
	*/
        public boolean enqueue(Passenger o)
        {
                return queue.add(o);
        }

	/**
	* removes from the queue
	*@return queue.removeMax() 	removes the max from the queue
	*/
        public Passenger dequeue()
        {
                return queue.removeMax();
        }

	/**
	*peeks the max element of the queue
	*@return queue.getMax() 	gets the max of the queue
	*/
        public Passenger peek()
        {
                return queue.getMax();
        }

	/**
	*checks to see if the queue is empty
	*@return true 	 if queue is empty 
	*@return false	 if the queue is not empty
	*/
        public boolean empty()
        {
                if(queue.getSize() <= 0)
                        return true;
                return false;
        }

	/**
	*parses the queue in an easily readible way
	*@return queue.parse() 	the easily readbale way of reading the queue
	*/
	public void parse()
	{
		queue.parse();
	}

	/**
	*gets the size of the queue
	*@return queue.size() 	the size of the queue
	*/
	public int getSize()
	{
		return queue.getSize();
	}
}
	