import java.util.Stack;


public class StackWithMin extends Stack<Integer>{

	Stack<Integer> sMin;
	
	public StackWithMin()
	{
		sMin   = new Stack<Integer>();
	}
	
	public void push(int value)
	{
		if(sMin.isEmpty() || value <= sMin.peek())
		{
			sMin.push(value);
		}
		
		super.push(value);
	}
	
	public Integer pop()
	{
		int value = super.pop();
		
		if(value <= super.peek())
		{
			sMin.pop();
		}
		
		return (Integer)value;
	}
	
	public Integer min()
	{
		return sMin.peek();
	}
	
}
