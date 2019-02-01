package com.company;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        TreeNode node = new TreeNode(50);
        node.left = new TreeNode(20);
        node.right = new TreeNode(60);

        node.left.left = new TreeNode(10);
        node.left.left.left = new TreeNode(5);
        node.left.left.right = new TreeNode(15);

        node.left.right = new TreeNode(25);

        node.right.right = new TreeNode(70);
        node.right.right.left = new TreeNode(65);
        node.right.right.right = new TreeNode(80);

        ArrayList<LinkedList<Integer>> result = allSequences(node);
        return;

    }

    public static ArrayList<LinkedList<Integer>> allSequences (TreeNode node)
    {
        ArrayList<LinkedList<Integer>> result = new ArrayList<LinkedList<Integer>>();

        if(node == null)
            return result;

        ArrayList<LinkedList<Integer>> leftSequenceList = allSequences(node.left);
        ArrayList<LinkedList<Integer>> rightSequenceList = allSequences(node.right);

        for(LinkedList<Integer> left : leftSequenceList)
        {
            for(LinkedList<Integer> right : rightSequenceList) {
                LinkedList<Integer> prevList = new LinkedList<Integer>();
                prevList.add(node.data);
                result.addAll(weaveList(prevList, left, right));
            }
        }

        if(result.size() == 0) {
            LinkedList<Integer> list = new LinkedList<Integer>();
            list.add(node.data);
            result.add(list);
        }

        return result;
    }

    public static ArrayList<LinkedList<Integer>> weaveList(LinkedList<Integer> prevList, LinkedList<Integer> leftList, LinkedList<Integer> rightList)
    {
        ArrayList<LinkedList<Integer>> resultList = new ArrayList<LinkedList<Integer>>();

        if(leftList.size() == 0 || rightList.size() == 0)
        {
            LinkedList<Integer> prefix = (LinkedList<Integer>)prevList.clone();
            prefix.addAll(leftList);
            prefix.addAll(rightList);
            resultList.add(prefix);
        }
        else {
            Integer left = leftList.removeFirst();
            prevList.addLast(left);
            resultList.addAll(weaveList(prevList, leftList, rightList));
            leftList.addFirst(left);
            prevList.removeLast();

            Integer right = rightList.removeFirst();
            prevList.addLast(right);
            resultList.addAll(weaveList(prevList, leftList, rightList));
            rightList.addFirst(right);
            prevList.removeLast();
        }

        return resultList;
    }

}
