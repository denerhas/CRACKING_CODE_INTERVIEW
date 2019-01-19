
/**
 *
 * @author Hasan
 */
public class TreeNode {
    public int data;
    public TreeNode leftNode;
    public TreeNode rightNode;
    
    public TreeNode(int data)
    {
        this.data = data;
    }
    
    public TreeNode(int data, TreeNode leftNode, TreeNode rightNode)
    {
        this.data = data;
        this.leftNode = leftNode;
        this.rightNode = rightNode;
    }
}
