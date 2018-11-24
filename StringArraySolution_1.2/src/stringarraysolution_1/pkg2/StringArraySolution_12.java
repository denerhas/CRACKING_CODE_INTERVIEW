package stringarraysolution_1.pkg2;

import java.util.HashMap;

/**
 *
 * @author Hasan
 */
public class StringArraySolution_12 {

    public static void main(String[] args) {
        if(checkPermutation("hasan", "nasah"))
            System.out.println("They are permutation srings");
        else
            System.out.println("They are not permutation of each other");
    }
    
    public static boolean checkPermutation(String str1, String str2)
    {
        if(str1.length() != str2.length())
            return false;
        
        int[] letters = new int[128];
        char[] charList = str1.toCharArray();
        
        for(char c : charList)
        {
            letters[c]++;
        }
        
        for(char c : str2.toCharArray())
        {
            if(letters[c] > 0)
                letters[c]--;
            else
                return false;
        }
        
        return true;
    }
    
    public static boolean customCheckPermutation(String str1, String str2)
    {
        if(str1.length() != str2.length())
            return false;
        
        HashMap<Character, Integer> charMap = new HashMap();
        for(char c : str1.toCharArray())
        {
            if(charMap.containsKey(c))
               charMap.put(c, (charMap.get(c)+1));
            else
                charMap.put(c, 1);
        }
        for(char c : str2.toCharArray())
        {
            if(charMap.containsKey(c))
            {
                int value = charMap.get(c);
                if(value < 1)
                    return false;
                else
                    charMap.put(c, charMap.get(c)-1);
            }
            else
                return false;
            
        }
        
        return true;
    }
}
