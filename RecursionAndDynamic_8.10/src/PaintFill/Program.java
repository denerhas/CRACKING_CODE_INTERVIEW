package PaintFill;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	boolean PaintFill(Color[][] screen, int r, int c, Color nColor)
	{
		if(screen[r][c] == nColor)
			return false;
		
		return PaintFill(screen, r, c, screen[r][c], nColor);
	}
	
	boolean PaintFill(Color[][] screen, int r, int c, Color oColor, Color nColor)
	{
		if(r < 0 || r >= screen.length || c < 0 || c >= screen[0].length)
			return false;
		
		if(screen[r][c] == oColor)
		{
			screen[r][c] = nColor;
			PaintFill(screen, r-1, c, oColor, nColor); //up
			PaintFill(screen, r+1, c, oColor, nColor); // down
			PaintFill(screen, r, c-1, oColor, nColor); // left
			PaintFill(screen, r, c+1, oColor, nColor); //right
		}
		
		return true;
	}

}
