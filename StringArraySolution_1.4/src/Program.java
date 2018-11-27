import java.util.HashMap;


public class Program {

	static int template = 0;
	
	public static void main(String[] args) {
		
		if(isPermutationOfPalindrom("Tact Coa"))
			System.out.print("String is a permutation of a palindrome.");
		else
			System.out.print("String isn't a permutation of a palindrome.");
		
	}
	
	
	public static boolean isPermutationOfPalindrom(String phrase)
	{

		for(char c : phrase.toLowerCase().toCharArray())
		{
			if(c == ' ')
				continue;
			toggleCharacter(c);
		}
		
		int result = (template) & (template-1);
		if(result == 0)
			return true;
		
		return false;
	}
	
	public static int toggleCharacter(char c)
	{
		int index = c - 'a';
		int mask = 1 << index;
		
		if((template & mask) == 0)
			template |= mask;
		else
			template &= ~mask;
		
		return template;
	}
	
	public static boolean isPermutationOfPalindromeCustom(String phrase)
	{
		HashMap<Character, Integer> charMap = new HashMap<Character, Integer>();
		for(char c : phrase.toLowerCase().toCharArray())
		{
			if(c == ' ')
				continue;
			if(!charMap.containsKey(c))
				charMap.put(c, 1);
			else
				charMap.put(c, charMap.get(c)+1);
		}
		
		boolean oneOddValue = false;
		for(Integer i : charMap.values())
		{
			if(i%2 == 0)
				continue;
			else if(!oneOddValue)
				oneOddValue = true;
			else
				return false;
		}
		
		return true;
	}

}
