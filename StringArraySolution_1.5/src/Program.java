
public class Program {

	public static void main(String[] args) {
		
		if(oneEditAway("pale", "bae"))
			System.out.print("Strings are one edit away");
		else
			System.out.print("Strings are not one edit away");
	}
	
	public static boolean oneEditAway(String str1, String str2)
	{
		if(Math.abs(str1.length()-str2.length()) == 1)
			return oneInsertorRemoveAway(str1, str2);
		else
			return oneReplaceAway(str1, str2);
	}
	
	public static boolean oneInsertorRemoveAway(String str1, String str2)
	{
		char[] smallArray;
		char[] bigArray;
		
		if(str1.length() > str2.length())
		{
			smallArray = str2.toCharArray();
			bigArray   = str1.toCharArray();
		}
		else
		{
			smallArray = str1.toCharArray();
			bigArray   = str2.toCharArray();
		}
		
		boolean oneInsert = false;
		for(int i=0; i<smallArray.length; i++)
		{
			if(!oneInsert && smallArray[i] != bigArray[i])
				oneInsert = true;
			else if(oneInsert & smallArray[i] != bigArray[i+1])
				return false;
		}
		
		return true;
	}
	
	public static boolean oneReplaceAway(String str1, String str2)
	{
		boolean oneReplaceDone = false;
		for(int i=0; i<str1.length(); i++)
		{
			if(str1.charAt(i) != str2.charAt(i))
			{
				if(oneReplaceDone)
				{
					return false;
				}
				oneReplaceDone = true;
			}
		}
		
		return true;
	}
}
