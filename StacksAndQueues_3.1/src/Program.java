
public class Program {

	public static void main(String[] args) 
	{
		FixedMultiStack multiStack = new FixedMultiStack(10,3);
		
		multiStack.push(0, 1);
		multiStack.push(0, 2);
		multiStack.push(0, 3);
		multiStack.push(0, 4);
		
		multiStack.push(1, 11);
		multiStack.push(1, 12);
		multiStack.push(1, 13);
		
		multiStack.push(2, 21);
		multiStack.push(2, 22);
		multiStack.push(2, 23);
		multiStack.push(2, 24);
		multiStack.push(2, 25);
		multiStack.push(2, 26);
		
		System.out.println(multiStack.pop(2));
		System.out.println(multiStack.pop(2));
		System.out.println(multiStack.pop(2));
		
		System.out.println(multiStack.pop(0));
		System.out.println(multiStack.pop(0));
		
		System.out.println(multiStack.pop(1));
	}
}
