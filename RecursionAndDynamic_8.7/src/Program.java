import java.util.ArrayList;

public class Program {

	ArrayList<String> getPerms(String str)
	{
		if(str == null)
			return null;
		
		ArrayList<String> permutations = new ArrayList<String>();
		if(str.length() == 0)
		{
			permutations.add("");
			return permutations;
		}
		
		char first = str.charAt(0);
		String remainder = str.substring(1); //remove the first char
		
		ArrayList<String> words = getPerms(remainder);
		
		for(String word : words)
		{
			for(int j=0; j<=word.length(); j++)
			{
				String s = insertCharAt(word, first, j);
			}
		}
		
		return permutations;
	}
	
	String insertCharAt(String word, char c, int i)
	{
		String start = word.substring(0, i);
		String end = word.substring(i);
		
		return start + c + end;
	}
}
