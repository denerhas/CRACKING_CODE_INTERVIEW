package ReturnKthToLast;

public class Program {

	public static void main(String[] args) {
		LinkedListNode node = new LinkedListNode(5);
		node.next = new LinkedListNode(10);
		node.next.next = new LinkedListNode(20);
		node.next.next.next = new LinkedListNode(5);
		node.next.next.next.next = new LinkedListNode(18);
		node.next.next.next.next.next = new LinkedListNode(20);
		node.next.next.next.next.next.next = new LinkedListNode(25);
		
		printKthToLast(node, 4);
		
	}
	
	public static void printKthTolastCustom(LinkedListNode head, int k)
	{
		LinkedListNode runner = head;
		while(k > 0)
		{
			runner = runner.next;
			k--;
		}
		
		LinkedListNode current = head;
		while(runner != null)
		{
			runner = runner.next;
			current = current.next;
		}
		
		System.out.println("K th element of the list: " + current.data);
	}
	
	public static void printKthToLast(LinkedListNode head, int k)
	{
		Index order = new Index();
		printKthToLast(head, k, order);
	}
	
	public static void printKthToLast(LinkedListNode head, int k, Index order)
	{
		if(head.next == null)
			return;
		
		printKthToLast(head.next, k, order);
		order.value++;
		
		if(order.value == k)
		{
			System.out.println("K th element of the linkedlist:" + head.data);
		}
	}
}
