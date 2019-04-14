/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sortandsearch_10.pkg4;

import java.util.Arrays;

/**
 *
 * @author Hasan
 */
public class SortAndSearch_104 {

    public static void main(String[] args) {
        // TODO code application logic here
    }
    
    int search(Listy list, int value)
    {
        int index = 1;
        while(list.elementAt(index) != -1 && list.elementAt(index) < value)
        {
            index *= 2;
        }
        
        return binarySearch(list, value, index/2, index);
    }
    
    int binarySearch(Listy list, int value, int low, int high)
    {
        int mid;
        
        while(low <= high)
        {
            mid = (low + high)/2;
            int middle = list.elementAt(mid);
            if(middle > value || middle == -1)
            {
                high = mid -1;
            }
            else if(middle < value)
            {
                low = mid + 1;
            }
            else
            {
                return mid;
            }
        }
        
        return -1;
    }
}
