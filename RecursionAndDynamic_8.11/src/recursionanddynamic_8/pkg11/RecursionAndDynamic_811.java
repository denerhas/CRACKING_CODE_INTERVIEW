/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recursionanddynamic_8.pkg11;

/**
 *
 * @author Hasan
 */
public class RecursionAndDynamic_811 {

    public static void main(String[] args) {
        // TODO code application logic here
    }
    
    public static int makeChange(int n)
    {
        int[] denoms = {25, 10, 5, 1};
        int[][] map = new int[n + 1][denoms.length]; //precomputed values
        return makeChange(n, denoms, 0, map);
    }
    
    public static int makeChange(int amount, int[] denoms, int index, int[][] map)
    {
        if(map[amount][index] > 0) //retrieve value
        {
            return map[amount][index];
        }
        if(index >= denoms.length -1)
            return 1; //one denom remaining
        
        int denomAmount = denoms[index];
        int ways = 0;
        
        for(int i=0; i*denomAmount <= amount; i++)
        {
            //go to next denom, assuming i coins of denomAmount
            int amountRemaining = amount - i*denomAmount;
            ways += makeChange(amountRemaining, denoms, index+1, map);
        }
        
        map[amount][index] = ways;
        return ways;
    }
}
