
public class Solution2 {

	public static Coordinate findElement(int[][] matrix, Coordinate origin, Coordinate dest, int x)
	{
		if(!origin.inbounds(matrix) || !dest.inbounds(matrix))
			return null;
		
		if(matrix[origin.row][origin.column] == x)
			return origin;
		else if(!origin.isBefore(dest))
			return null;
		
		Coordinate start = (Coordinate)origin.clone();
		int diagDist = Math.min(dest.row - origin.row, dest.column-origin.column);
		
		Coordinate end = new Coordinate(start.row + diagDist, start.column+diagDist);
		Coordinate p = new Coordinate(0,0);
		
		while(start.isBefore(end))
		{
			p.setToAverage(start, end);
			if(x > matrix[p.row][p.column])
			{
				start.row = p.row + 1;
				start.column = p.column + 1;
			}
			else
			{
				end.row = p.row-1;
				end.column = p.column-1;
			}
		}
		
		return partitionAndSearch(matrix, origin, dest, start, x);
	}
	
	static Coordinate partitionAndSearch(int[][] matrix, Coordinate origin, Coordinate dest, Coordinate pivot, int x)
	{
		Coordinate lowerLeftOrigin = new Coordinate(pivot.row, origin.column);
		Coordinate lowerLeftDest = new Coordinate(dest.row, pivot.column - 1);
		
		Coordinate upperRightOrigin = new Coordinate(origin.row, pivot.column);
		Coordinate upperRightDest = new Coordinate(pivot.row - 1, dest.column);
		
		Coordinate lowerLeft = findElement(matrix, lowerLeftOrigin, lowerLeftDest, x);
		if (lowerLeft == null) {
			return findElement(matrix, upperRightOrigin, upperRightDest, x);
		}
		
		return lowerLeft;
	}
}
