/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CheckSubTree;

/**
 *
 * @author Hasan
 */
public class CheckSubTree {
    
    public static void main(String[] args)
    {
        TreeNode node1 = new TreeNode(1);
        node1.left = new TreeNode(2);
        node1.right = new TreeNode(3);
        node1.left.left = new TreeNode(4);
        node1.left.right = new TreeNode(5);
        node1.right.left = new TreeNode(6);
        node1.right.right = new TreeNode(7);
        
        if(containsTree(node1.right, node1.left.right))
            System.out.println("Node1 contains node2");
        else
            System.out.println("Node1 does not contain node2");
    }
    
    public static boolean containsTree(TreeNode node1, TreeNode node2)
    {
        if(node1 == null || node2 == null)
            return false;
        if(node1.data == node2.data)
        {
            if(isIdentical(node1, node2))
                return true;
        }
        
        return containsTree(node1.left, node2) || containsTree(node1.right, node2);   
    }
    
    public static boolean isIdentical(TreeNode node1, TreeNode node2)
    {
        if(node1 == null && node2 == null)
            return true;
        if(node1 == null && node2 != null)
            return false;
        if(node1 != null && node2 == null)
            return false;
        if(node1.data != node2.data)
            return false;
        else 
            return isIdentical(node1.left, node2.left) && isIdentical(node1.right, node2.right);
    }
}
