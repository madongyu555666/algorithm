package com.jikeshijian.tanchao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @author madongyu
 * @projectName algorithm
 * @description: 590
 * @date 2020/5/199:55
 */
public class N叉树的后序遍历 {

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

    /*public List<Integer> postorder(Node root) {
        ArrayList<Node> stack = new ArrayList<Node> ();
        ArrayList<Integer> out = new ArrayList<Integer> ();

        if(root == null){
            return out;
        }
        Node temp=root;
        stack.add(temp);
        while (!stack.isEmpty()){
            temp= stack.remove(stack.size() -1);
            out.add(temp.val);
            for (Node child : temp.children) {
               if(child!=null){
                   stack.add(child);
               }
            }
        }
        Collections.reverse(out);
        return out;
    }*/
    public List<Integer> postorder(Node root) {
        LinkedList<Node> stack = new LinkedList<Node> ();
        LinkedList<Integer> out = new LinkedList<Integer> ();
        if(root == null){
            return out;
        }
        stack.add(root);
        while (!stack.isEmpty()){
            Node node= stack.pollLast();
            out.addFirst(node.val);
            for (Node child : node.children) {
                if(child!=null){
                    stack.add(child);
                }
            }
        }
        return out;
    }
}
