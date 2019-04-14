/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sortandsearch_10.pkg4;

/**
 *
 * @author Hasan
 */
public class Listy {
    
    int[] array;
    
    public Listy(int[] arr)
    {
        array = arr.clone();
    }
    
    public int elementAt(int index)
    {
        if(index > array.length)
            return -1;
        
        return array[index];
    }
}
