
public class Program {

	public static void main(String[] args) {
		
		SetOfStacks setOfStacks = new SetOfStacks(3);
		setOfStacks.push(10);
		setOfStacks.push(20);
		setOfStacks.push(30);
		
		setOfStacks.push(40);
		setOfStacks.push(50);
		System.out.println(setOfStacks.pop());
		
		setOfStacks.push(60);
		setOfStacks.push(70);
		System.out.println(setOfStacks.pop());
		System.out.println(setOfStacks.pop());
		System.out.println(setOfStacks.pop());
	}

}
       