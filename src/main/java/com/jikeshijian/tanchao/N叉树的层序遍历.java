package com.jikeshijian.tanchao;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author madongyu
 * @projectName algorithm
 * @description: 429，广度优先遍历
 * @date 2020/5/199:56
 */
public class N叉树的层序遍历 {
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


    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> list=new ArrayList<>();
        if(root==null){
            return list;
        }
        Queue<Node> queue=new LinkedList<Node>();
        queue.add(root);
        while (!queue.isEmpty()){
            List<Integer> list1=new ArrayList<>();
            int size = queue.size();
            for (int i=0;i<size;i++){
                Node poll = queue.poll();
                list1.add(poll.val);
                queue.addAll(poll.children);
            }
            list.add(list1);
        }
        return list;
    }

}
