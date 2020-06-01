package com.jikeshijian.tanchao;

import java.util.*;

/**
 * @author madongyu
 * @title: N叉树的前序遍历
 * @projectName algorithm
 * @description: 589
 * @date 2020/5/1523:26
 */
public class N叉树的前序遍历 {
    /**
     * 给定一个 N 叉树，返回其节点值的前序遍历。
     */

    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    };

    public List<Integer> preorder(Node root) {
        LinkedList<Node> stack = new LinkedList<>();
        LinkedList<Integer> out=new LinkedList<>();
        if(root==null){
            return out;
        }
        stack.add(root);
        while (!stack.isEmpty()){
             Node node=stack.pollLast();
             out.add(node.val);
             //反转数据
            Collections.reverse(node.children);
            for (Node child : node.children) {
                stack.add(child);
            }
        }
        return out;
    }

    public List<Integer> preorder2(Node root) {
        LinkedList<Node> stack = new LinkedList<Node> ();
        LinkedList<Integer> out = new LinkedList<Integer> ();
        if(root == null){
            return out;
        }
        stack.add(root);
        while (!stack.isEmpty()){
            Node node= (Node) stack.pollLast();
            out.add(node.val);
            //反转数据
            Collections.reverse(node.children);
            for (Node child : node.children) {
                stack.add(child);
            }
        }
        return out;
    }



/*[1,null,3,2,4,null,5,6]*/

    /*class Solution {
    List<Integer> res = new ArrayList<Integer>();
    public List<Integer> preorder(Node root) {
        //递归版

        if(root == null)
            return res;
        res.add(root.val);
        for(Node child:root.children)
        {
            preorder(child);
        }

        return res;
    }
}*/
}
