package RemoveDuplicates;

import java.util.HashSet;

public class Program {

	public static void main(String[] args) {
		
		LinkedListNode node = new LinkedListNode(5);
		node.next = new LinkedListNode(10);
		node.next.next = new LinkedListNode(20);
		node.next.next.next = new LinkedListNode(5);
		node.next.next.next.next = new LinkedListNode(18);
		node.next.next.next.next.next = new LinkedListNode(20);
		node.next.next.next.next.next.next = new LinkedListNode(25);
		
		DeleteDups(node);
		while(node != null)
		{
		    System.out.println(node.data);
			node = node.next;
		}
	}
	
	public static void DeleteDupsCustom(LinkedListNode node)
	{
		HashSet<Integer> dups = new HashSet<Integer>();
		LinkedListNode previous = null;
		
		while(node != null)
		{
			if(dups.contains((node.data)))
			{
				previous.next = node.next;
			}
			else
			{
				dups.add(node.data);
				previous = node;
			}
			
			node = node.next;
		}
	}
	
	public static void DeleteDups(LinkedListNode node)
	{
		LinkedListNode current = node;
		LinkedListNode runner  = node.next;
		
		while(current != null)
		{
			LinkedListNode previous = current;
			runner = current.next;
			
			while(runner != null)
			{
				if(current.data == runner.data)
				{
					previous.next = runner.next;
				}
				else
				{
					previous = runner;
				}
				
				runner = runner.next;
			}
			
			current = current.next;
		}
	}

}
