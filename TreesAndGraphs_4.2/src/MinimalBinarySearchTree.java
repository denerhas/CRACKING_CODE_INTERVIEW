/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Hasan
 */
public class MinimalBinarySearchTree {
    
    public static void main(String[] args)
    {
        int[] array = new int[]{3, 5, 7, 9, 11, 13, 15};
        TreeNode r = createMinimalBST(0, array.length-1, array);
        
        String s = "";
        return;
    }
    
    public static TreeNode createMinimalBST(int[] args)
    {
        TreeNode root = createMinimalBST(0, args.length, args);
        
        return root;
    }
    
    public static TreeNode createMinimalBST(int start, int end, int[] args)
    {
        int middle = (start+end)/2;
        
        TreeNode root = new TreeNode(args[middle]);
        if(middle == 0)
            return root;
        if(middle == end)
            return root;
        
        root.leftNode = createMinimalBST(start, middle-1, args);
        root.rightNode = createMinimalBST(middle+1, end, args);
        
        return root;
    }
}
