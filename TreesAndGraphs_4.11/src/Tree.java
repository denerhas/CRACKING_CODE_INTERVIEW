
import java.util.Random;

    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Hasan
 */
public class Tree {
    TreeNode root = null;
    
    public int size()
    {
        return root == null ? 0 : root.size();
    }
    
    public TreeNode getRandomNode()
    {
        if(root == null)
            return null;
        
        Random random = new Random();
        int i = random.nextInt(size());
        return root.getIthNode(i);
    }
    
    public void insertInOrder(int value)
    {
        if(root == null)
            root = new TreeNode(value);
        else
            root.InsertInOrder(value);
    }
}
