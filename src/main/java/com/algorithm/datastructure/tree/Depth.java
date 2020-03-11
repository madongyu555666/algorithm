package com.algorithm.datastructure.tree;


import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 二叉树最大深度和最小深度
 */
public class Depth {
    /**
     * 递归最大深度
     */
    public static int maxDepth(TreeNode root){
        if(root==null){
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return  Math.max(left,right)+1;
    }

    /**
     * 非递归最大深度
     * @param root
     * @return
     */
    public static int maxDepth2(TreeNode root){
        if(root==null){
            return 0;
        }
        Queue<TreeNode> queue=new ArrayDeque<>();
        queue.offer(root);
        int level=0;
        while (!queue.isEmpty()){
            level++;
            for (int i = 0; i < queue.size(); i++) {
                TreeNode poll = queue.poll();
                if(poll.left!=null){
                    queue.offer(poll.left);
                }
                if(poll.right!=null){
                    queue.offer(poll.right);
                }
            }
        }
        return level;
    }







    public  int mixDepth(TreeNode root){
        if(root==null){
            return 0;
        }
        if(root.left==null&&root.right==null){
            return 1;
        }
        if(root.left==null&&root.right!=null){
            return mixDepth(root.right);
        }
        if(root.left!=null&&root.right==null){
            return mixDepth(root.left);
        }
        int left = mixDepth(root.left);
        int right = mixDepth(root.right);
        return  Math.max(left,right)+1;
    }

    /**
     * 非递归最大深度
     * @param root
     * @return
     */
    public static int mixDepth2(TreeNode root){
        if(root==null){
            return 0;
        }
        Queue<TreeNode> queue=new ArrayDeque<>();
        queue.offer(root);
        int level=0;
        while (!queue.isEmpty()){
            level++;
            for (int i = 0; i < queue.size(); i++) {
                TreeNode poll = queue.poll();
                if(root.left==null&&root.right==null){
                    return level;
                }
                if(poll.left!=null){
                    queue.offer(poll.left);
                }
                if(poll.right!=null){
                    queue.offer(poll.right);
                }
            }
        }
        return 0;
    }


    public static void main(String[] args) {
        TreeNode A = new TreeNode("A");
        TreeNode B = new TreeNode("B");
        TreeNode C = new TreeNode("C");
        TreeNode D = new TreeNode("D");
        TreeNode E = new TreeNode("E");
        TreeNode F = new TreeNode("F");
        TreeNode G = new TreeNode("G");
        TreeNode H = new TreeNode("H");
        TreeNode I = new TreeNode("I");
        TreeNode J = new TreeNode("J");
        TreeNode K = new TreeNode("K");

        A.left=B;
        A.right=C;
        B.left=D;
        B.right=E;
        D.left=H;
        D.right=I;
        E.right=J;
        C.left=F;
        C.right=G;
        F.right=K;

        int i = maxDepth2(A);
        System.out.println(i);
    }

}
