/** 
*DLClist makes a Double-linked circular node for patients sorting in Java.
*@author Michael Osorio
*/
public class DLClist
{

	/* instance of a node that's the first node in the list
	*/
	private DLNode head;
	/* variable containing the size of the list
	*/
	private int size;
	
	/* private inner class DLNode creates a node object
	*/
	private class DLNode 
	{

		/* data in the node, the next node, and the previous node
		*/
		public Object data;
		public DLNode next;
		public DLNode prev;	

		/* DLNode creates a node holding o
		*@param o 	object in the node
		*/
		public DLNode(Object o) 
		{
			data = o;
			next = this;
			prev = this;
		}

		/* DLNode creates a node holding o, with n as the next and p as the previous
		*@param o 	object in the node
		*@param n 	the next node in the list
		*@param p 	the previous node in the list			
		*/
		public DLNode(Object o, DLNode n, DLNode p) 
		{
			data = o;
			next = n;
			prev = p;
		}
	}

	/* DLClist creates an empty list
	*/
	public DLClist()
	 {
		size = 0;
	}

	/* add adds o at position i (counting from wherever head is)
	*@param o 	object being added
	*param i 	position in list represented by an integer
	@return 	false if o is null
	@return 	true if o is not null
	*/ 
	public boolean add(int i, Object o) 
	{
		if (o ==null)
			return false;
		if (i == 0)
			return add(o);
		DLNode curr = head;
		if (i>0)
		{
			if(i >= size)
				i = i % size;
			for(curr=head; i>1; i--)
				curr=curr.next;
			curr.next=new DLNode(o, curr.next, curr);
			curr.next.next.prev = curr.next;
			size++;
		}
		if (i<0)
		{
			for(curr=head; i< -1; i++)
				curr=curr.prev;
			curr.prev = new DLNode(o,curr, curr.prev);
			curr.prev.prev.next = curr.prev;
			size++;
		}
		return true;
	}

	/* add 	adds o at the head
	*@param o 	the object beng added to the head of the list
	*@return 	false if o == null
	*@return 	true when o is not null
	*/
	public boolean add(Object o)
	{
		if (o == null)
			return false;
		if (size <= 0)
		{
			head = new DLNode(o);
			size++;
			return true;
		}
		head = new DLNode(o, head, head.prev);
		head.next.prev = head;
		size++;
		return true;
	}

	/* append 	adds o before the head
	*@param 	object being added before the head of the list
	*@return 	false if o == null
	@return 	add(o) adds o to the head if the head is null
	@return 	true when o is not null
	*/
	public boolean append(Object o) 
	{
		if (o == null)
			return false;
		if (head == null)
			return add(o);
		DLNode curr = new DLNode(o, head, head.prev);
		head.prev = curr;
		curr.prev.next = curr;
		size++;
		return true;
	}

	/* get returns the object at the head
	*@return 	the object at the head of the list
	*/
	public Object get() 
	{
		return get(0);
	}

	/*get returns the object at position i from the head
	*@param i 	the position from the head where the object is
	*@return 	null if size <=0
	*@return 	ret when size > 0. ret is the object at position i
	*/
	public Object get(int i) 
	{
		DLNode curr;
		Object ret = null;
		if (size <= 0)
			return null;
		if (i >= 0)
		{
			for (curr = head; i > 0; i--)
				curr = curr.next;
			ret = curr.data;
		}
		if (i < 0)
		{
			for (curr = head; i < 0; i++)
				curr = curr.prev;
			ret = curr.data;
		}
		return ret;
	}

	/* getLast returns the object at the tail
	*@return 	null if head == null
	*@return 	the object at the tail of the list
	*/
	public Object getLast() 
	{
		return get(-1);
	}

	/* size returns the list size
	*@returns size of the list
	*/
	public int size() 
	{
		return size;
	}

	/* remove removes and returns the element at the head
	*@return 	the removed element from the head
	*/
	public Object remove() 
	{
		return remove(0);
	}

	/* removeLast removes and returns the element at the tail
	*@return 	the removed element from the tail
	*/
	public Object removeLast() 
	{
		return remove(-1);
	}

	/* remove removes and returns the ELT at index i
	*@param i 	the position of the required node
	*@return 	null if head == null
	*@return 	ret is the data being looked for at index i
	*/
	public Object remove(int i)
	 {
		if (head == null) 
		{
			return null;
		}

		Object ret = null;
		if (size > 0)
		{

		DLNode curr = head;
		if (size ==1)
		{
			ret = curr.data;
			head = null;
		}
		if (i == 0)
		{
			ret = curr.data;
			curr.next.prev = curr.prev;
			curr.prev.next = curr.next;
			head = curr.next;
		}
		else 
		{
			if ( i > 0)
			{
				for(curr = head; i >=1; i--)
					curr = curr.next;
			}
			if (i < 0)
			{
				for (curr = head; i <= -1; i++)
					curr= curr.prev;
			}
			ret = curr.data;
			curr.prev.next = curr.next;
			curr.next.prev = curr.prev;
		}
		size--;
		}
		return ret;
	}


	/* remove removes the first iteration of o in the list and returns true. Returns false 
	*if if o is not in the list
	*@param o 	object being removed from the list
	@return 	false if head is null
	@return 	true if o is found and removed from the list
	@return 	false if o was not in the list and was therefore not removed
	*/
	public Object remove(Object o) 
	{
		if (head == null)
		{
			return false;
		}

		DLNode curr;
		int i = 0;
		for (curr = head; i <= size -1; i++)
		{
			if (o.equals(curr.data))
			{
				remove(i);
				return true;
			}
			curr = curr.next;
		}
		return false;
	}

	/*  showList prints all the elements in the list in an easily understood way using toString()
	*/
	public void showList() 
	{
		if (head == null)
			System.out.println("List is empty");
		DLNode curr;
		int i = 0;
		for (curr = head; i <= size - 1; i++) 
		{
			System.out.println("Element " + i + ": " + curr.data.toString());
			curr = curr.next;
		}
	}
	/* main function for testing
	*/
	public static void main(String[] args)
	{
		DLClist lst = new DLClist();
		System.out.println("Empty list: ");
		lst.showList();
		System.out.println("Creating a new head with int 20");
		lst.add(20);
		System.out.println("Expected: element 0: 20");
		lst.showList();
		System.out.println("Appending 3, 4, 60, 23, 7, and 12 to the list");
		lst.append(3);
		lst.append(4);
		lst.append(60);
		lst.append(23);
		lst.append("7");
		lst.append(12);
		System.out.println("Result is: ");
		lst.showList();
		System.out.println("Getting first element of the list");
		System.out.println(lst.get());
		System.out.println("Getting element at index 2");
		System.out.println(lst.get(2));
		System.out.println("Getting last element of the list");
		System.out.println(lst.getLast());
		System.out.println("Size of list: ");
		System.out.println(lst.size());
		System.out.println("Removing element at the head");
		System.out.println(lst.remove());
		System.out.println("Result is: ");
		lst.showList();
		System.out.println("Appending with tom");
		lst.append("tom");
		System.out.println("Appending with 5. New tail is 5. ");
		lst.append(5);
		System.out.println("Removing element at the tail");
		System.out.println(lst.removeLast());
		System.out.println("Removing object at index 3");
		System.out.println(lst.remove(3));
		System.out.println("Removing 7 from list");
		System.out.println(lst.remove("7"));
		System.out.println("Result is: ");
		lst.showList();
		System.out.println("Adds 123456 at index 2 ");
		lst.add(2, 123456);
		lst.showList();
		System.out.println("Remove object at index 2 and tom ");
		System.out.println(lst.remove(2));
		System.out.println(lst.remove("tom"));
		lst.showList();
		System.out.println("Exected: false ");
		System.out.println(lst.remove("Leroy"));
		System.out.println("Add -55 at index 1 and 32 at index 2 from the last");
		lst.add(1, -55);
		lst.add(-2, 32);
		System.out.println("Result is: ");
		lst.showList();
		System.out.println("Add Henry as new head ");
		lst.add("Henry");
		System.out.println("Result is: ");
		lst.showList();
		System.out.println("Add 120 to index 0 ");
		lst.add(0,120);
		lst.showList();
		System.out.println("Remove the last element and get final size of list ");
		lst.removeLast();
		lst.showList();
		System.out.println(lst.size());
		lst.add(-513405);
		lst.add(293);
		lst.showList();
		lst.removeLast();
	}
}