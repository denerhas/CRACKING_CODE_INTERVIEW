package Palindrome;


public class Program {

	public static void main(String[] args) {
		
		LinkedListNode node = new LinkedListNode(5);
		node.next = new LinkedListNode(10);
		node.next.next = new LinkedListNode(20);
		node.next.next.next = new LinkedListNode(25);
		node.next.next.next.next = new LinkedListNode(20);
		node.next.next.next.next.next = new LinkedListNode(10);
		node.next.next.next.next.next.next = new LinkedListNode(5);
		
		if(isPalindrome(node))
			System.out.println("List is palindrome");
		else
			System.out.println("List is not palindrome");
		
	}
	
	public static boolean isPalindromeCustom(LinkedListNode node)
	{
		LinkedListNode reverseHead = reverseLinkedList(node);
		
		boolean isPalindrome = true;
		while(node != null)
		{
			if(!(node.data == reverseHead.data))
			{
				isPalindrome=false;
			}
				
			node = node.next;
			reverseHead = reverseHead.next;
		}
		
		return isPalindrome;
	}
	
	public static LinkedListNode reverseLinkedList(LinkedListNode node)
	{
		LinkedListNode head = new LinkedListNode(node.data);
		node = node.next;
		
		while(node != null)
		{
			head = addBefore(node, head);
			node = node.next;
		}
		
		return head;
	}
	
	public static LinkedListNode addBefore(LinkedListNode node, LinkedListNode head)
	{
		LinkedListNode newNode = new LinkedListNode(node.data);
		newNode.next = head;
		
		return newNode;
	}
	
	public static boolean isPalindrome(LinkedListNode head)
	{
		int length = lengthOfList(head);
		Result p = isPalindromeRecurse(head, length);
		
		return p.result;
	}
	
	public static Result isPalindromeRecurse(LinkedListNode head, int length)
	{
		if(head == null || length <= 0) //Even number of nodes
			return new Result(head, true);
		else if(length == 1) //Odd number of nodes
			return new Result(head.next, true);
		
		Result res = isPalindromeRecurse(head.next, length-2);
		
		// If child calls are not a palindrome, pass back up a failure
		if(!res.result || res.node == null)
		{
			return res;
		}
		
		//Check if matches corrensponding node on other side
		res.result = (head.data == res.node.data);
		
		//Return corresponding node
		
		return res;
	}
	
	public static int lengthOfList(LinkedListNode n)
	{
		int size = 0;
		while(n != null)
		{
			size++;
			n = n.next;
		}
		
		return size;
	}
}
