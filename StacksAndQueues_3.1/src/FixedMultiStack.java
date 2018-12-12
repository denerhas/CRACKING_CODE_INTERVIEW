import java.util.EmptyStackException;


public class FixedMultiStack {

	private int numberOfStacks = 3;
	private int stackCapacity;
	private int[] values;
	private int[] sizes;
	
	public FixedMultiStack(int stackCapacity, int numOfStacks)
	{
		this.stackCapacity  = stackCapacity;
		numberOfStacks 		= numOfStacks;
		sizes  		   		= new int[numberOfStacks];
		values 		   		= new int[numberOfStacks*stackCapacity];
	}
	 
	public void push(int stackNo, int value)
	{
		int stackTopElementIndex = indexOfTop(stackNo);
		if(sizes[stackNo] >= stackCapacity)
			throw new StackOverflowError();
		
		values[++stackTopElementIndex] = value;
		sizes[stackNo] = sizes[stackNo]+1;
	}
	
	public int pop(int stackNo)
	{
		int value = peek(stackNo);
		sizes[stackNo]--;
		return value;
	}
	
	public int peek(int stackNo)
	{
		if(isEmpty(stackNo))
			throw new EmptyStackException();
		
		int stackTopElementIndex = indexOfTop(stackNo);
		return values[stackTopElementIndex];
	}
	
	public boolean isEmpty(int stackNo)
	{
		return sizes[stackNo] == 0;
	}
	
	public boolean isFull(int stackNo)
	{
		return sizes[stackNo] == stackCapacity;
	}
	
	public int indexOfTop(int stackNo)
	{
		return stackNo*stackCapacity + sizes[stackNo]-1;
	}
}
