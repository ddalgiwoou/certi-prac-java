class Node
{
	private Object data;
	private Node parent;
	
	public Node()
	{
		data = null;
		parent = null;
	}
	
	public Node(Object obj, Node node)
	{
		data = obj;
		parent = node;
	}
	
	public Node Clone()
	{
		return new Node(this.data, this.parent);
	}	
	
	
	public void Set(Object obj, Node node)
	{
		data = obj;
		parent = node;
	}
	
	public Object getData()
	{
		return data == null ? null : data;
	}
	
	public Node getParent()
	{
		return parent;
	}
}

class Stack<T>
{
	private Node currentNode;
	
	public Stack()
	{
		currentNode = null;
	}
	
	public void push(T item)
	{
		Node before = null;
		if (currentNode != null)
		{
			before = currentNode.Clone();
		}		
		currentNode = new Node(item, before);
	}
	
	@SuppressWarnings("unchecked")
	public T pop()
	{
		T result = null;
		
		if (currentNode != null)
		{
			result = (T) currentNode.getData();
			currentNode = currentNode.getParent();
		}
		
		return result;
	}
	
	public boolean isEmpty()
	{
		return (currentNode == null || currentNode.getData() == null);
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
