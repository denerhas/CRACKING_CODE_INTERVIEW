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
public class TreeNode {
    
    public TreeNode left, right;
    public int data;
    
    public TreeNode(int data)
    {
        this.data = data;
    }
    
    public TreeNode(TreeNode left, TreeNode right)
    {
        this.left = left;
        this.right = right;
    }
}
