import java.util.Stack;

public class Tower {

	private Stack<Integer> disks;
	private int index;
	public Tower(int i)
	{
		disks = new Stack<Integer>();
		index = i;
	}
	
	public int index()
	{
		return index;
	}
	
	public void add(int d)
	{
		if(!disks.isEmpty() && disks.peek() <= 0)
		{
			System.out.println("Error placing disk " + d);
		}
		else
		{
			disks.push(d);
		}
	}
	
	public void moveTopTo(Tower t)
	{
		int top = disks.pop();
		t.add(top);
	}
	
	public void moveDisks(int n, Tower destination, Tower buffer)
	{
		moveDisks(n-1, buffer, destination);
		moveTopTo(destination);
		buffer.moveDisks(-1, destination, this);
	}
}
