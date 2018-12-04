package SumList;

public class Program {

	public static void main(String[] args) {
		
		LinkedListNode num1 = new LinkedListNode(7);
		num1.next = new LinkedListNode(1);
		num1.next.next = new LinkedListNode(6);
		
		LinkedListNode num2 = new LinkedListNode(5);
		num2.next = new LinkedListNode(9);
		num2.next.next = new LinkedListNode(2);
		
		System.out.println(addLists(num1, num2));

	}

	public static int addListCustom(LinkedListNode node1, LinkedListNode node2)
	{
		LinkedListNode head = null;
		LinkedListNode tail = null;
		int carry = 0;
		int value = 0;
		while(node1 != null || node2 != null || carry != 0)
		{
			value = 0;
			
			if(node1 != null)
				value += node1.data;
		    if(node2 != null)
				value += node2.data;
		    if(carry != 0)
				value += carry;
				
			int digitValue = value%10;
			
			if(head == null)
			{
				head = new LinkedListNode(digitValue);
				tail = head;
			}
			else
			{
				tail.next = new LinkedListNode(digitValue);
				tail = tail.next;
			}
			
			carry = value/10;
			
			if(node1 != null)
				node1 = node1.next;
			if(node2 != null)
				node2 = node2.next;
		}
		
		StringBuilder num = new StringBuilder();
		while(head != null)
		{
			num.insert(0, head.data); 
			head = head.next;
		}
		
		return Integer.parseInt(num.toString());
	}
	
	public static LinkedListNode addLists(LinkedListNode l1, LinkedListNode l2)
	{
		int len1 = getLengthOfLinkedList(l1);
		int len2 = getLengthOfLinkedList(l2);
				
		if(len1 < len2){
			l1 = padList(l1, len2-len1);
		}
		else{
			l2 = padList(l2, len1-len2);
		}
		
		PartialSum sum = addListHelper(l1, l2);
		
		if(sum.carry == 0)
		{
			return sum.sum;
		}
		else
		{
			LinkedListNode result = insertBefore(sum.sum, sum.carry);
			return result;
		}
	}
	
	public static PartialSum addListHelper(LinkedListNode l1, LinkedListNode l2)
	{
		if(l1 == null && l2 == null)
		{
			PartialSum sum = new PartialSum();
			return sum;
		}
		
		PartialSum sum = addListHelper(l1.next, l2.next);
		int val = sum.carry + l1.data + l2.data;
		
		LinkedListNode full_result = insertBefore(sum.sum, val%10);
		
		sum.sum = full_result;
		sum.carry = val/10;
		return sum;
	}
	
	public static int getLengthOfLinkedList(LinkedListNode n)
	{
		int length = 0;
		while(n != null)
		{
			length++;
			n = n.next;
		}
		
		return length;
	}
	
	public static LinkedListNode padList(LinkedListNode l, int padding)
	{
		LinkedListNode head = l;
		for(int i=0; i<padding; i++)
		{
			head = insertBefore(head, 0);
		}
		
		return head;
	}
	
	public static LinkedListNode insertBefore(LinkedListNode list, int data)
	{
		LinkedListNode node = new LinkedListNode(data);
		if(list != null)
		{
			node.next = list;
		}
		
		return node;
	}
}
