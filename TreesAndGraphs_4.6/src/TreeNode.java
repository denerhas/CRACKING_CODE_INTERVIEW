/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Hasan
 */
public class TreeNode {
    
    int data;
    TreeNode left, right, parent;
    
    public TreeNode(int data)
    {
        this.data = data;
    }
    
    public TreeNode(int data, TreeNode left, TreeNode right)
    {
        this.data = data;
        this.left = left;
        this.right = right;
    }
    
    public TreeNode(int data, TreeNode left, TreeNode right, TreeNode parent)
    {
        this.data = data;
        this.left = left;
        this.right = right;
        this.parent = parent;
    }
}
