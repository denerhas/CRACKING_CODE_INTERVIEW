package StringArraySolution;

public class StringCompression {

	public static void main(String[] args) {
		
		System.out.println(compress("aabcccccaaa"));

	}
	
	public static String compress(String str)
	{
		StringBuilder compressed = new StringBuilder();
		int counter = 0;
		for(int i=0; i<str.length()-1; i++)
		{
			counter += 1;
			if(str.charAt(i) != str.charAt(i+1))
			{
				
				compressed.append(str.charAt(i)).append(counter); 
				counter = 0;
			}
		}
		
		counter++;
		compressed.append(str.charAt(str.length()-1)).append(counter); 
		
		if(compressed.length() < str.length())
			return compressed.toString();
		else
			return str;
	}
}
