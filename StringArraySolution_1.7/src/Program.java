
public class Program {

	public static void main(String[] args) {
	
		
		
	}
	
	
	public static void rotateMatrix(int[][] matrix, int dimension){
		
		if(matrix.length != dimension && matrix[0].length != dimension)
		{
			throw new IllegalArgumentException("Matrix is not in suitable dimension!");
		}
		
		for(int layer= 0; layer<dimension/2; layer++)
		{
			int first = layer;
			int last = dimension-layer-1;
			
			
			for(int i = first; i<last; i++)
			{
				int offset = i-first;
				
				//save top
				int top = matrix[first][i];
				//left -> top
				matrix[first][i] = matrix[last-offset][first];
				//bottom -> left
				matrix[last-offset][first] = matrix[last][last-offset];
				//right -> bottom
				matrix[last][last-offset] = matrix[i][last];
				//top -> right
				matrix[i][last] = top; 
			}
		}
	
	}
}
