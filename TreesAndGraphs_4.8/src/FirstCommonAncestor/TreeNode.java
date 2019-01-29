/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FirstCommonAncestor;

public class TreeNode {
 
    TreeNode left, right;
    int data;
    
    public TreeNode(TreeNode left, TreeNode right)
    {
        this.left = left;
        this.right = right;
    }
    
    public TreeNode(int data)
    {
        this.data = data;
    }
}
