class Node<T>
{
	public T Data;
	public Node<T> Parent;
	
	public Node(T data, Node<T> parent)
	{
		this.Data = data;
		this.Parent = parent;
	}
	
	public void Clear()
	{
		this.Data = null;
		this.Parent = null;
	}
}

class Stack<T>
{
	private Node<T> current;
	
	public Stack()
	{
		current = null;
	}
	
	public void push(T item)
	{
		Node<T> newNode = new Node<T>(item, current);
		current = newNode;
	}
	
	public T pop()
	{
		T result = null;
		
		if (current != null)
		{
			result = current.Data;
			
			Node<T> parent = current.Parent;
			
			current.Clear();
			current = null;
			
			current = parent;
		}
		
		return result;
	}
	
	public boolean isEmpty()
	{
		return (current == null);
	}
}

//	= TEST CODE =
//
//	int[] arr = {6, 5, 3, 1, 9, 8, 7, 2, 4};
//		
//	Stack<Integer> st = new Stack<>();
//		
//	for(int i = 0 ; i < arr.length; i++)
//	{
//		st.push(arr[i]);
//	}
//		
//	while(st.isEmpty() != true)
//	{
//		System.out.print(st.pop() + " ");
//	}
//
//
//	= OUTPUT =
//	4 2 7 8 9 1 3 5 6 
