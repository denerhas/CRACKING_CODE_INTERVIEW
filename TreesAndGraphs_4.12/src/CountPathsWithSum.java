
import com.sun.org.apache.xalan.internal.xsltc.runtime.Hashtable;
import java.util.HashMap;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Hasan
 */
public class CountPathsWithSum {
    
    public static void main(String[] args)
    {
        
    }
    
    public static int countPathsWithSum(TreeNode node, int targetSum)
    {
        return countPathsWithSum(node, targetSum, 0, new HashMap<Integer, Integer>());
    }
    
    public static int countPathsWithSum(TreeNode node, int targetSum, int runningSum, HashMap<Integer, Integer> pathCount)
    {
        if(node == null)
            return 0;
        
        runningSum += node.data;
        int sum = runningSum - targetSum;
        int totalPathCount = runningSum - pathCount.getOrDefault(sum, 0);
        
        if(runningSum == targetSum)
            totalPathCount++;
        
        incrementHashTable(pathCount, runningSum, 1);
        totalPathCount += countPathsWithSum(node.left, targetSum, runningSum, pathCount);
        totalPathCount += countPathsWithSum(node.right, targetSum, runningSum, pathCount);
        incrementHashTable(pathCount, runningSum, -1);
        
        return totalPathCount;
    }
    
    public static void incrementHashTable(HashMap<Integer, Integer> hashTable, int key, int delta)
    {
        int value = hashTable.getOrDefault(key, 0);
        if(value == 0)
            hashTable.remove(key);
        else
            hashTable.put(key, value++);
        
    }
}
