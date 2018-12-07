
public class Program {

	public static void main(String[] args) {
		
		LinkedListNode head = new LinkedListNode('a');
		head.next = new LinkedListNode('b');
		head.next.next = new LinkedListNode('c');
		head.next.next.next = new LinkedListNode('d');
		head.next.next.next.next = new LinkedListNode('e');
		head.next.next.next.next.next = new LinkedListNode('f');
		head.next.next.next.next.next.next = new LinkedListNode('g');
		head.next.next.next.next.next.next.next = new LinkedListNode('h');
		head.next.next.next.next.next.next.next.next = head.next.next.next.next;
		
		LinkedListNode intersectionPoint = FindBeginning(head);
		if(intersectionPoint != null)
		{
			System.out.println(intersectionPoint.data);
		}

	}
	
	public static LinkedListNode FindBeginning(LinkedListNode head)
	{
		LinkedListNode slow = head;
		LinkedListNode fast = head;
		boolean firstLoop = true;
		
		while((slow != fast && fast != null) || firstLoop)
		{
			slow = slow.next;
			fast = fast.next.next;
			firstLoop = false;
		}
		
		if(fast != null)
		{
			slow = head;
			while(slow != fast)
			{
				slow = slow.next;
				fast = fast.next;
			}
			
			return fast;
		}
		else
		{
			return null;
		}
	}

}
