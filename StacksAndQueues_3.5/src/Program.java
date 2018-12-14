import java.util.Stack;


public class Program {

	public static void main(String args[])
	{
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(10);
		stack.push(20);
		stack.push(30);
		stack.push(25);
		stack.push(15);
		
		
		sort(stack);
		int order  = 0;
		while(!stack.isEmpty())
		{
			order++;
			System.out.println(order + ". element value: " + stack.pop());
		}
	}
	
	public static void sort(Stack<Integer> stack)
	{
		Stack<Integer> tempStack = new Stack<Integer>();
		
		while(!stack.isEmpty())
		{
			Integer tempValue = stack.pop();
			
			if(tempStack.isEmpty())
			{
				tempStack.push(tempValue);
			}
			else if(tempValue > tempStack.peek())
			{
				tempStack.push(tempValue);
			}
			else
			{
				shiftData(stack, tempStack, tempValue);
				tempStack.push(tempValue);
			}
		}
		
		shiftData(stack, tempStack, Integer.MIN_VALUE);
	}
	
	public  static void shiftData(Stack<Integer> originalStack, Stack<Integer> tempStack, int tempValue)
	{
		while(!tempStack.isEmpty() && tempStack.peek() > tempValue)
		{
			originalStack.push(tempStack.pop());
		}
	}
}
