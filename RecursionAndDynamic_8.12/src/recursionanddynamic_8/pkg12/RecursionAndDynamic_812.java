/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recursionanddynamic_8.pkg12;

import java.util.ArrayList;

/**
 *
 * @author Hasan
 */
public class RecursionAndDynamic_812 {

    static int GRID_SIZE = 8;
    
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
    public static void placeQueens(int row, Integer[] columns, ArrayList<Integer[]> results)
    {
        if(row == GRID_SIZE) //Found valid placement
        {
            results.add(columns.clone());
        }
        else
        {
            for(int col=0; col < GRID_SIZE; col++)
            {
                if(checkValid(columns, row, col))
                {
                    columns[row] = col; //place queen
                    placeQueens(row + 1, columns, results);
                }
            }
        }
    }
    
    public static boolean checkValid(Integer[] columns, int row1, int column1)
    {
        for(int row2=0; row2<row1; row2++)
        {
            int column2 = columns[row2];
            
            //Check if (row2, column2) invalidates (row1, column1) as a queen spot
            
            if(column1 == column2)
                return false;
            
            /* Check diagonals: if the distance between the columns equals the distance between 
            the rows, then they are in the same diagonal
            */
            
            int columnDistance = Math.abs(column2-column1);
            int rowDistance = row1 - row2;
            
            if(columnDistance == rowDistance)
                return false;
        }
        
        return true;
    }
}
