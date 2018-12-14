
public class Program {

	public static void main(String[] args) {
		
		MyQueue<Integer> queue = new MyQueue<Integer>();

		queue.add(10);
		queue.add(20);
		queue.add(30);
		queue.add(40);
		queue.add(50);
		
		System.out.println(queue.peek());
		System.out.println(queue.remove());
		System.out.println(queue.remove());
		queue.add(60);
		System.out.println(queue.remove());
		System.out.println(queue.remove());
		System.out.println(queue.remove());
		queue.add(70);
		System.out.println(queue.remove());
		System.out.println(queue.remove());
	}

}
