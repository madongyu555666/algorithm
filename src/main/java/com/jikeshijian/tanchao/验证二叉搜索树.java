package com.jikeshijian.tanchao;

import java.util.Stack;

/**
 * @author madongyu
 * @title: 验证二叉搜索树
 * @projectName algorithm
 * @description: 98 *
 * @date 2020/5/1822:17
 */
public class 验证二叉搜索树 {

    public class TreeNode {
      int val;
      TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
  }
    long pre = Long.MIN_VALUE;
    public boolean isValidBST(TreeNode root) {
       if(root==null){
           return true;
       }
       //左
        if(!isValidBST(root.left)){
            return false;
        }
        //访问当前节点：如果当前节点小于等于中序遍历的前一个节点，说明不满足BST，返回 false；否则继续遍历。
        if(root.val<=pre){
            return false;
        }
        pre=root.val;
        //右
        return isValidBST(root.right);

    }
}
