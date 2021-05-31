class Node<T>
{
	public T Data;
	public Node<T> Next;
	
	public Node(T data)
	{
		this.Data = data;
		this.Next = null;
	}
	
	public void Clear()
	{
		this.Data = null;
		this.Next = null;
	}
}

class Queue<T>
{
	private Node<T> front;
	private Node<T> rear;
	private int size;
	
	public Queue()
	{
		front = null;
		rear = null;
		size = 0;
	}
	
	public void Enqueue(T item)
	{
		Node<T> newNode = new Node<T>(item);

		if (size == 0)
		{
			front = rear = newNode;
		}
		else
		{
			rear.Next = newNode;
			rear = newNode;
		}
		
		size++;
	}
	
	public T Dequeue()
	{
		T result = null;
		
		if (size > 0)
		{
			result = front.Data;
			Node<T> nextNode = front.Next;
			
			front.Clear();
			front = null;
			
			front = nextNode;
			size--;
		}
		
		return result;
	}
	
	public boolean isEmpty()
	{
		return (size == 0);
	}
}


//	= TEST CODE =
//
//	int[] arr = {6, 5, 3, 1, 9, 8, 7, 2, 4};
//		
//	Queue<Integer> queue = new Queue<>();
//		
//	for(int i = 0 ; i < arr.length; i++)
//	{
//		queue.Enqueue(arr[i]);
//	}
//		
//	while(st.isEmpty() != true)
//	{
//		System.out.print(queue.Dequeue() + " ");
//	}
//
//
//	= OUTPUT =
//	6 5 3 1 9 8 7 2 4 
