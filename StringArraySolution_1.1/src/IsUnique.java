import java.util.HashMap;


public class IsUnique {

	public static void main(String[] args) {
		
		if(isUniqueChars("qwe"))
			System.out.println("System hasn't dublicate characters");
		else
			System.out.println("System has dublicate character");
	}
	
	static boolean isUniqueCharsScratch(String str)
	{
		if(str == null || str.isEmpty())
		{
			return true;
		}
		
		HashMap<Character, Integer> charList = new HashMap<Character, Integer>();
		for(char c : str.toCharArray())
		{
			if(charList.containsKey(c))
			{
				charList.put(c, charList.get(c)+1);
				return false;
			}
			else
			{
				charList.put(c, 0);
			}
		}
		
		return true;
	}
	
	static boolean isUniqueChars(String s)
	{
		if(s == null || s.isEmpty())
		{
			return true;
		}
		if(s.length() > 128)
		{
			return false;
		}
		
		int check = 0;
		for(char c : s.toCharArray())
		{
			int charOrder = c-'a';
			
			if((check & (1 << charOrder)) > 0)
				return false;
			
			check = check | (1 << charOrder);
		}
		
		return true;
	}
}
