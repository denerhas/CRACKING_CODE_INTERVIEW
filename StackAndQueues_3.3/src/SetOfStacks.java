import java.util.ArrayList;
import java.util.Stack;


public class SetOfStacks {

	ArrayList<Stack<Integer>> stacks;
	int capacity;
	
	public SetOfStacks(int pCapacity)
	{
		stacks = new ArrayList<Stack<Integer>>();
		stacks.add(new Stack<Integer>());
		capacity = pCapacity;
	}
	
	public void push(int v)
	{
		Stack<Integer> lastStack = getLastStack();
		if(lastStack.size() == capacity)
		{
			stacks.add(new Stack<Integer>());
		}
		
		getLastStack().push(v);
	}
	
	public int pop()
	{
		Stack<Integer> lastStack = getLastStack();
		int value = (int)getLastStack().pop();
		
		if(getLastStack().size() == 0)
			stacks.remove(stacks.size()-1);
		
		return value;
	}
	
	private Stack getLastStack()
	{
		return stacks.get(stacks.size()-1);
	}
}
