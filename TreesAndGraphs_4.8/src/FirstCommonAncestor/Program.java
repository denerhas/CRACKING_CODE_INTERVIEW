/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FirstCommonAncestor;

/**
 *
 * @author Hasan
 */
public class Program {
    
    public static void main(String[] args) 
    {
        TreeNode node1 = new TreeNode(1);
        node1.left = new TreeNode(2);
        node1.right = new TreeNode(3);
        node1.left.left = new TreeNode(4);
        node1.left.right = new TreeNode(5);
        node1.right.left = new TreeNode(6);
        node1.right.right = new TreeNode(7);
        
        TreeNode node = commonAncestor(node1, node1.right.left, node1.right.right);
        if(node != null)
            System.out.println(node.data);
    }
    
    public static boolean cover(TreeNode root, TreeNode node)
    {
        if(root == null)
            return false;
        if(root == node)
            return true;
        return cover(root.left, node) || cover(root.right, node);
    }
    
    public static TreeNode commonAncestor(TreeNode root, TreeNode node1, TreeNode node2)
    {
        if(root == null)
            return null;
        
        boolean isNode1LeftSide = cover(root.left, node1);
        boolean isNode1RightSide = cover(root.right, node1);
        boolean isNode2LeftSide = cover(root.left, node2);
        boolean isNode2RightSide = cover(root.right, node2);
        
        if(isNode1LeftSide && isNode2RightSide)
            return root;
        if(isNode1RightSide && isNode2LeftSide)
            return root;
        if(isNode1LeftSide && root == node2)
            return root;
        if(isNode2LeftSide && root == node1)
            return root;
        
        if(isNode1LeftSide && isNode2LeftSide)
            return commonAncestor(root.left, node1, node2);
        else
            return commonAncestor(root.right, node1, node2);
    }
}
