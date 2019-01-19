
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


/**
 *
 * @author Hasan
 */
public class BinarySearchTreeLevelList {
    
    public static void main(String[] args)
    {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(9);
        root.left.right = new TreeNode(11);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(15);
        
        createBinarySearchTreeLevelList(root);
    }
    
    public static List<LinkedList<TreeNode>> createBinarySearchTreeLevelList(TreeNode root)
    {
        List<LinkedList<TreeNode>> list = new ArrayList<LinkedList<TreeNode>>();
        createBinarySearchTreeLevelList(list, root, 0);
        
        return list;
    }
    
    public static void createBinarySearchTreeLevelList(List<LinkedList<TreeNode>> list, TreeNode node, int level)
    {
        if(node == null)
            return;
        
        if(list != null && list.size() <= level)
        {
            list.add(new LinkedList<TreeNode>());
        }
        
        LinkedList<TreeNode> correspondingLevelList = list.get(level);
        correspondingLevelList.add(node);
        
        createBinarySearchTreeLevelList(list, node.left, level+1);
        createBinarySearchTreeLevelList(list, node.right, level+1);
    }
}
