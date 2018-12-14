import java.util.Stack;


public class MyQueue<T> {

	Stack<T> stackOldest;
	Stack<T> stackNewest;
	
	public MyQueue()
	{
		stackOldest = new Stack<T>();
		stackNewest = new Stack<T>();
	}
	
	public void add(T value)
	{
		stackOldest.push(value);
	}
	
	public T peek()
	{
		if(stackNewest.isEmpty())
		{
			shiftData();
		}
		
		if(!stackNewest.isEmpty())
			return stackNewest.peek();
		else 
			return null;
	}
	
	public T remove()
	{
		if(stackNewest.isEmpty())
		{
			shiftData();
		}
		
		if(!stackNewest.isEmpty())
			return stackNewest.pop();
		else
			return null;
	}
	
	public void shiftData()
	{
		while(!stackOldest.isEmpty())
		{
			stackNewest.push(stackOldest.pop());
		}
	}
	
	public int size()
	{
		return stackNewest.size() + stackOldest.size();
	}
}
