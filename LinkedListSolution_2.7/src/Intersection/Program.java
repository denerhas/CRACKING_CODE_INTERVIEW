package Intersection;

public class Program {

	public static void main(String[] args) {
		LinkedListNode head1 = new LinkedListNode(5);
		head1.next = new LinkedListNode(10);
		head1.next.next = new LinkedListNode(20);
		head1.next.next.next = new LinkedListNode(25);
		head1.next.next.next.next = new LinkedListNode(21);
		head1.next.next.next.next.next = new LinkedListNode(10);
		head1.next.next.next.next.next.next = new LinkedListNode(5);
		
		LinkedListNode head2 = new LinkedListNode(5);
	    head2.next = new LinkedListNode(8);
	    head2.next.next = new LinkedListNode(13);
	    
	    head2.next.next.next = head1.next.next.next.next;
	    
	    LinkedListNode intersectionNode = getIntersectionNode(head1, head2);
	    if(intersectionNode != null)
	    {
	    	System.out.println("Intersection Point: " + intersectionNode.data);
	    }
	}
	
	public static LinkedListNode getIntersectionNode(LinkedListNode node1, LinkedListNode node2)
	{
		int lengthList1 = 0;
		LinkedListNode headNode1 = node1;
		while(node1 != null)
		{
			lengthList1++;
			node1 = node1.next;
		}
		
		int lengthList2 = 0;
		LinkedListNode headNode2 = node2;
		while(node2 != null)
		{
			lengthList2++;
			node2 = node2.next;
		}
		
		int diff = 0;
		LinkedListNode tallerList = null;
		LinkedListNode shorterList = null;
		if(lengthList1 > lengthList2)
		{
			diff = lengthList1 - lengthList2;
			tallerList =  headNode1;
			shorterList = headNode2;
		}
		else
		{
			diff = lengthList2 - lengthList1;
			tallerList = headNode2;
			shorterList = headNode1;
		}
		
		for(int i=0; i<diff; i++)
		{
			tallerList = tallerList.next;
		}
		
		while(tallerList != null && shorterList != null)
		{
			if(tallerList == shorterList)
				return tallerList;
			
			tallerList = tallerList.next;
			shorterList = shorterList.next;
		}
		
		return null;
	}

}
