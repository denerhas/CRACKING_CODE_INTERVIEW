import java.awt.List;
import java.util.ArrayList;
import java.util.HashSet;

public class RobotInAGrid {

	public static void main(String[] args)
	{
		
	}
	
	public static ArrayList<Point> getPath(boolean[][] maze)
	{
		ArrayList<Point> result = new ArrayList<Point>();
		
		if(maze == null)
			return result;
		
		HashSet<Point> failedPaths = new HashSet<Point>();
		ArrayList<Point> path = new ArrayList<Point>();
		
		getPath(maze, maze.length-1, maze[0].length-1, path, failedPaths);
		
		return path;
	}
	
	public static boolean getPath(boolean[][] maze, int row, int column, ArrayList<Point> path, HashSet<Point> failedPoints)
	{
		if(row < 0 || column < 0 || !maze[row][column])
			return false;
		
		Point p = new Point(row, column);
		
		if(failedPoints.contains(p))
			return false;
		
		boolean isAtOrigin = (row == 0 && column == 0);
		
		if(isAtOrigin || getPath(maze, row-1, column, path, failedPoints) || getPath(maze, row, column-1, path, failedPoints))
		{
			path.add(new Point(row, column));
			return true;
		}
		
		failedPoints.add(new Point(row, column));
		return false;
	}
}
