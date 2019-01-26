
import java.util.LinkedList;
import java.util.Stack;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Hasan
 */
public class ValidateBinarySearchTree {
    
    public static void main(String[] args)
    {
        TreeNode node = new TreeNode(8);
        node.left = new TreeNode(4);
        node.right = new TreeNode(10);
        node.left.left = new TreeNode(2);
        node.left.right = new TreeNode(6);
        node.right.right = new TreeNode(20);
        
        if(checkBST(node))
            System.out.println("Tree is binary");
        else
            System.out.println("Tree is not binary");
    }
    
    static boolean checkIfBinarySearchTreeCustom(TreeNode root)
    {
        Stack<TreeNode> nodeList = new Stack<TreeNode>();
        
        nodeList.add(root);
        LinkedList<TreeNode> list = new LinkedList<TreeNode>();
        list.add(root);
        while(!nodeList.isEmpty())
        {
            TreeNode processItem = nodeList.pop();
            if(processItem.right != null)
                list.add(list.indexOf(processItem)+1, processItem.right);
            
            if(processItem.left != null)
                list.add(list.indexOf(processItem), processItem.left);
            
            if(processItem.right != null)
                nodeList.push(processItem.right);
            
            if(processItem.left != null)
                nodeList.push(processItem.left);
        }
        
        for(int i=0; i<list.size()-1; i++)
        {
            if(list.get(i+1).data < list.get(i).data)
                return false;
        }
        
        return true;
    }
    
    static boolean checkBST(TreeNode n)
    {
        return checkBST(n, null, null);
    }
    
    static boolean checkBST(TreeNode n, Integer min, Integer max)
    {
        if(n == null)
        {
            return true;
        }
        
        if((min != null && n.data <= min) || ((max != null) && n.data > max))
            return false;
        
        if(!checkBST(n.left, min, n.data) || !checkBST(n.right, n.data, max))
            return false;
        
        return true;
    }
}
