
package stringarraysolution_1.pkg3;

/**
 *
 * @author Hasan
 */
public class StringArraySolution_13 {

    public static void main(String[] args) {
        char[] arg = "Mr John Smith     ".toCharArray();
        replaceSpaces(arg,13);
        System.out.print(arg);
    }
    
    public static void replaceSpaces(char[] str, int trueLength)
    {
        int counter = str.length-1;
        int index = trueLength;
        boolean check = false;
        while(index >= 0)
        {
            
            if(str[index] == ' ' && check)
            {
                str[counter] = '0';
                str[counter-1] = '2';
                str[counter-2] = '%';
                
                counter = counter-3;
            }
            else
            {
                str[counter] = str[index];
                counter--;
                check = true;
            }
            index--;
        }
    }
}
