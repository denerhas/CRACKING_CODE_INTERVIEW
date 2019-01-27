/**
 *
 * @author Hasan
 */
public class SuccessorOfNode {
    
    public static void main(String[] args)
    {
        TreeNode node = new TreeNode(8);
        node.left = new TreeNode(4);
        node.right = new TreeNode(10);
        node.left.left = new TreeNode(2);
        node.left.right = new TreeNode(6);
        node.right.right = new TreeNode(20);
        
        TreeNode result = findSuccessorCustom(node.right);
        
        if(result != null)
            System.out.println(result.data);
    }
    
    public static TreeNode findSuccessorCustom(TreeNode treeNode)
    {
        if(treeNode.right != null)
        {
            return getLeftMostNode(treeNode.right);
        }
        else
        {
            return getLeftChildParentNode(treeNode);
        }
    }
    
    public static TreeNode getLeftMostNode(TreeNode node)
    {
        while(node.left != null)
            node = node.left;
        
        return node;
    }
    
    public static TreeNode getLeftChildParentNode(TreeNode node)
    {
        while(node != null)
        {
            TreeNode parent = node.parent;
            if(parent.left == node)
                return parent;
            node = parent;
            
            return node;
        }
        
        return null;
    }
    
    
    TreeNode inOrderSucc(TreeNode n)
    {
        if(n == null)
            return null;
        
        if(n.right != null)
            return leftMostChild(n.right);
        else
        {
            TreeNode q = n;
            TreeNode x = q.parent;
            
            while(x != null && x.left != q)
            {
                q = x;
                x = x.parent;
            }
            
            return x;
        }
    }
    
    TreeNode leftMostChild(TreeNode n)
    {
        if(n == null)
            return null;
        while(n.left != null)
        {
            n = n.left;
        }
        
        return n;
    }
}
