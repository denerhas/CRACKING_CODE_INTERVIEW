
public class Program {

	public static void main(String[] args) {
		
	}

	public static void merge(int[] a, int[] b, int lastA, int lastB)
	{
		int indexA = lastA - 1; //index of last element in array A
		int indexB = lastB - 1; //index of last element in array B
		int indexMerged = lastB + lastA -1; //end of the merged array
		
		// Merge a and b, starting from the last element each
		while(indexB >= 0)
		{
			//end of a is > than end of b
			if(indexA >= 0 && a[indexA] > b[indexB])
			{
				a[indexMerged] = a[indexA]; //copy the element
				indexA--;
			}
			else
			{
				a[indexMerged] = b[indexB];
				indexB--;
			}
			indexMerged--; // move indices
		}
	}
}
