
public class Point implements Comparable<Point>{

	protected int row;
	protected int column;
	
	public Point(int pRow, int pColumn)
	{
		this.row = pRow;
		this.column = pColumn;
	}

	@Override
	public boolean equals(Object o)
	{
		if(this == o)
			return true;
		if(o == null || getClass() != o.getClass())
			return false;
		
		Point point = (Point)o;
		
		return (row == point.row) && (column == point.column);
	}
	
	@Override
	public int compareTo(Point p)
	{
		return 0;
	}
}
