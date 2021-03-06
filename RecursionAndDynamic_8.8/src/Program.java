import java.util.ArrayList;
import java.util.HashMap;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static ArrayList<String> printPerms(String s)
	{
		ArrayList<String> result = new ArrayList<String>();
		HashMap<Character, Integer> map = buildFreqTable(s);
		printPerms(map, "", s.length(), result);
		return result;
	}
	
	static HashMap<Character, Integer> buildFreqTable(String s)
	{
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		for(char c : s.toCharArray())
		{
			if(!map.containsKey(c))
				map.put(c, 0);
			
			map.put(c, map.get(c) + 1);
		}
		
		return map;
	}
	
	static void printPerms(HashMap<Character, Integer> map, String prefix, int remaining, ArrayList<String> result)
	{
		/*Base case. Permutation has been completed */
		if(remaining == 0)
		{
			result.add(prefix);
			return;
		}
		
		/* Try remaining letters for next char, and generate remaining permutation */
		for(Character c : map.keySet())
		{
			int count = map.get(c);
			if(count > 0)
			{
				map.put(c, count-1);
				printPerms(map, prefix+c, remaining-1, result);
				map.put(c, count);
			}
		}
	}

}
