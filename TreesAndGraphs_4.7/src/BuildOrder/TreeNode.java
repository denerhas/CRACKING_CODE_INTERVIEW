/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BuildOrder;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Hasan
 */
public class TreeNode {
    
    String project;
    List<TreeNode> children;
    TreeNode parent;
    
    public TreeNode(String project)
    {
        this.project = project;
        children = new ArrayList<TreeNode>();
    }
    
    public TreeNode(List<TreeNode> children)
    {
        this.children = children;
    }
    
    public TreeNode(TreeNode parent)
    {
        this.parent = parent;
    }
}
