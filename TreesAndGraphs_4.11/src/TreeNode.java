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
    
    private int data;
    public TreeNode left;
    public TreeNode right;
    private int size = 0;
    
    public TreeNode(int d)
    {
        data = d;
        size = 1;
    }
    
    public int size()
    {
        return size;
    }
    
    public int data()
    {
        return data;
    }
    
    public TreeNode find(int d)
    {
        if(d == data)
            return this;
        else if(d <= data)
            return left != null ? left.find(d) : null;
        else if(d > data)
            return right != null ? right.find(d) : null;
        
        return null;
    }
    
    public void InsertInOrder(int d)
    {
        if(d <= data)
        {
            if(left == null)
                left = new TreeNode(d);
            else
                left.InsertInOrder(d);
        }
        else
        {
            if(right == null)
                right = new TreeNode(d);
            else
                right.InsertInOrder(d);
        }
    }
    
    public TreeNode getIthNode(int i)
    {
        int leftSize = left == null ? 0 : left.size();
        
        if(i < leftSize)
            return left.getIthNode(i);
        else if(i == leftSize)
            return this;
        else
        {
            return right.getIthNode(i - (leftSize + 1));
        }
    }
}
