
public class Program {

	public static void main(String[] args) {
		
		StackWithMin stack = new StackWithMin();
		stack.push(5);
		stack.push(10);
		stack.push(3);
		stack.push(10);
		stack.push(20);
		
		System.out.println(stack.min());
		stack.pop();
		stack.pop();
		System.out.println(stack.min());
		stack.pop();
		System.out.println(stack.min());
		stack.pop();
		System.out.println(stack.min());
	}

}
