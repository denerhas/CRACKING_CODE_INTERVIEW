/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BuildOrder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author Hasan
 */
public class BuildOrder {
    
    public static void main(String[] args)
    {
        String[] projects = new  String[]{"a", "b", "c", "d", "e", "f"};
        String[][] dependencies  = new String[][]{{"a", "d"}, {"f", "b"}, {"b", "d"}, {"f", "a"}, {"d", "c"}};
        List<String> orderList = new ArrayList<String>();
        
        HashMap<String, TreeNode> hashMap = createBuildOrder(projects, dependencies);
        int counter = 0;
        while(counter < projects.length)
        {
            for(TreeNode key : hashMap.values())
            {
                if(key.children == null || key.children.isEmpty() && !orderList.contains(key.project))
                {
                    orderList.add(key.project);

                    for(TreeNode value : hashMap.values())
                    {
                        if(value.children.contains(key))
                            value.children.remove(key);
                    }
                    
                    break;
                }
                
            }
            
            counter++;
        }
        
        System.out.println(orderList);
    }
    
    public static HashMap createBuildOrder(String[] projects, String[][] dependencies)
    {
        HashMap<String, TreeNode> projectList = new HashMap<>();
        for(String project : projects)
        {
            projectList.put(project, new TreeNode(project));
        }
        
        for(String[] dependency : dependencies)
        {
            projectList.get(dependency[1]).children.add(projectList.get(dependency[0]));
        }
        
        return projectList;
    }
}
