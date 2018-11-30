package ZeroMatrix;

import java.util.Random;

public class Program {

	public static void main(String[] args) {
		
		int[][] multi = new int[10][8];
		
		Random rand = new Random();
		for(int row=0; row<multi.length; row++)
		{
			for(int column=0; column<multi[0].length; column++)
			{
				multi[row][column] = rand.nextInt(20);
			}
		}
		
		setZerosCustom(multi);
		
		for(int row=0; row<multi.length; row++)
		{
			for(int column=0; column<multi[0].length; column++)
			{
				System.out.print(multi[row][column] + "-");
			}
			System.out.println();
		}
	}

	public static void setZerosCustom(int[][] matrix)
	{
		for(int row=0; row<matrix.length; row++)
		{
			for(int column=0; column<matrix[row].length; column++)
			{
				if(matrix[row][column] == 0)
				{
					matrix[0][column] = 0;
					matrix[row][0] = 0;
				}
			}
		}
		
		for(int row=1; row<matrix.length; row++)
		{
			if(matrix[row][0] == 0)
			{
				for(int column=1; column < matrix[row].length; column++)
				{
					matrix[row][column] = 0;
				}
			}
		}
		
		for(int column=1; column<matrix[0].length; column++)
		{
			if(matrix[0][column] == 0)
			{
				for(int row=1; row < matrix.length; row++)
				{
					matrix[row][column] = 0;
				}
			}
		}
	}
	
	public static void setZeros(int[][] matrix)
	{
		boolean rowHasZero = false;
		boolean colHasZero = false;
		
		//Check if first row has zero
		for(int j=0; j<matrix[0].length; j++)
		{
			if(matrix[0][j] == 0)
			{
				rowHasZero = true;
				break;
			}
		}
		
		//Check if first column has zero
		for(int i=0; i<matrix.length; i++)
		{
			if(matrix[i][0] == 0)
			{
				colHasZero = true;
				break;
			}
		}
		
		//Check for zeros in the rest of the array
		for(int i=1; i<matrix.length; i++){
			for(int j=1; j<matrix[0].length; j++){
				if(matrix[i][j] == 0){
					matrix[i][0] = 0;
					matrix[0][j] = 0;
				}
			}
		}
		
		//Nullify rows based on values in first colum
		for(int i=1; i<matrix.length; i++){
			if(matrix[i][0] == 0){
				nullifyRow(matrix, i);
			}
		}
		
		for(int j=1; j<matrix[0].length; j++){
			if(matrix[0][j] == 0){
				nullifyColumn(matrix, j);
			}
		}
		
		if(rowHasZero){
			nullifyRow(matrix, 0);
		}
		
		if(colHasZero){
			nullifyColumn(matrix, 0);
		}
	}
	
	static void nullifyRow(int[][] matrix, int row)
	{
		for(int j=0; j<matrix[0].length; j++)
		{
			matrix[row][j] = 0;
		}
	}
	
	static void nullifyColumn(int[][] matrix, int col)
	{
		for(int i=0; i<matrix.length; i++)
		{
			matrix[i][col] = 0;
		}
	}
}
