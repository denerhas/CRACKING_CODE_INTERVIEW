/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stringarraysolution_1.pkg9;

/**
 *
 * @author Hasan
 */
public class StringArraySolution_19 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        if(isRotation("waterbottle", "erbottlewat"))
            System.out.println("Strings are rotations of each other");
        else
            System.out.println("Strins are not rotations of each other");
    }
    
    public static boolean isRotation(String s1, String s2)
    {
        String s2s2 = s2 + s2;
        return s2s2.contains((CharSequence)s1);
    }
}
