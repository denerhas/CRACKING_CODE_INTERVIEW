package DeleteMiddleNode;


public class Program {

	public static void main(String[] args) {
		LinkedListNode node = new LinkedListNode(5);
		node.next = new LinkedListNode(10);
		node.next.next = new LinkedListNode(20);
		node.next.next.next = new LinkedListNode(5);
		node.next.next.next.next = new LinkedListNode(18);
		node.next.next.next.next.next = new LinkedListNode(20);
		node.next.next.next.next.next.next = new LinkedListNode(25);
		
		DeleteMiddleNodeCustom(node.next.next);
		
		while(node != null)
		{
		    System.out.println(node.data);
			node = node.next;
		}
	}
	
	public static void DeleteMiddleNodeCustom(LinkedListNode node)
	{
		LinkedListNode previous = null;
		while(node.next != null)
		{
			node.data = node.next.data;
			previous = node;
			node = node.next;
		}
		
		previous.next = null;
	}
	
	public static void DeleteMiddleNode(LinkedListNode node)
	{
		LinkedListNode next = node.next;
		node.data = next.data;
		node.next = next.next;
	}
}
