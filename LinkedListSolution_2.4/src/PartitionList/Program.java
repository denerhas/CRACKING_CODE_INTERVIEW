package PartitionList;

public class Program {

	public static void main(String[] args) {
		LinkedListNode node = new LinkedListNode(5);
		node.next = new LinkedListNode(10);
		node.next.next = new LinkedListNode(20);
		node.next.next.next = new LinkedListNode(5);
		node.next.next.next.next = new LinkedListNode(18);
		node.next.next.next.next.next = new LinkedListNode(20);
		node.next.next.next.next.next.next = new LinkedListNode(25);
		
		LinkedListNode list = partition(node, 18);
		
		while(list != null)
		{
		    System.out.println(list.data);
		    list = list.next;
		}
	}

	public static LinkedListNode partitionCustom(LinkedListNode node, int x)
	{
		LinkedListNode beforeStart = null;
		LinkedListNode beforeEnd = null;
		LinkedListNode afterStart = null;
		LinkedListNode afterEnd = null;
		
		while(node != null)
		{
			if(node.data < x)
			{
				if(beforeStart == null)
					beforeStart = new LinkedListNode(node.data);
				else if(beforeEnd == null)
				{
					beforeEnd = new LinkedListNode(node.data);
					beforeStart.next = beforeEnd;
				}
				else
				{
					beforeEnd.next = new LinkedListNode(node.data);
					beforeEnd = beforeEnd.next;
				}
			}
			else
			{
				if(afterStart == null)
					afterStart = new LinkedListNode(node.data);
				else if(afterEnd == null)
				{
					afterEnd = new LinkedListNode(node.data);
					afterStart.next = afterEnd;
				}
				else
				{
					afterEnd.next = new LinkedListNode(node.data);
					afterEnd = afterEnd.next;
				}
			}
			
			node = node.next;
		}
		
		
		if(beforeEnd != null)
			beforeEnd.next = afterStart;
		else
			beforeStart.next = afterStart;
		
		return beforeStart;
	}
	
	public static LinkedListNode partition(LinkedListNode node, int x)
	{
		LinkedListNode beforeStart = null;
		LinkedListNode beforeEnd = null;
		LinkedListNode afterStart = null;
		LinkedListNode afterEnd = null;
		
		while(node != null)
		{
			LinkedListNode next = node.next;
			node.next = null;
			
			//Insert node into end of before list
			if(node.data < x)
			{
				if(beforeStart == null)
				{
					beforeStart = node;
					beforeEnd = beforeStart;
				}
				else
				{
					beforeEnd.next = node;
					beforeEnd = node;
				}
			}
			else
			{
				//Insert node into end of after list
				if(afterStart == null)
				{
					afterStart = node;
					afterEnd = afterStart;
				}
				else
				{
					afterEnd.next = node;
					afterEnd = node;
				}
			}
			node = next;
		}
		
		if(beforeStart == null)
		{
			return afterStart;
		}
		
		beforeEnd.next = afterStart;
		return beforeStart;
	}

	
}
