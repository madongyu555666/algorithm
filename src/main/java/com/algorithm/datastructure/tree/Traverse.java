package com.algorithm.datastructure.tree;






import java.util.*;

public class Traverse {
    /**
     * 前序遍历：先访问根节点，然后遍历左子树，最后遍历右子树
     * 中序遍历：先遍历左子树，然后遍历根节点，最后遍历右子树
     * 后序遍历：先遍历左子树，然后遍历右子树，最后遍历根节点
     * 层次遍历：从上到下逐层遍历，在同一层中，按从左到右的顺序遍历。
     */


    /**
     * 通过遍历构建二叉树
     * @param list
     * @return
     */
    public static TreeNode2 create(LinkedList<Integer> list){
        TreeNode2 treeNode=null;
        if(list.isEmpty()||list==null){
            return null;
        }
        Integer data = list.removeFirst();
        if(data!=null){
            treeNode=new TreeNode2(data);
            treeNode.left=create(list);
            treeNode.right=create(list);
        }
        return treeNode;
    }

    /**
     * 前序遍历(链表)
     *
     */
    public static  void preOrder2(TreeNode2 treeNode){
        if(treeNode==null){
            return;
        }
        System.out.print(treeNode.data+" ");
        preOrder2(treeNode.left);
        preOrder2(treeNode.right);

    }

    private static class TreeNode2{
        int data;
        TreeNode2 left;
        TreeNode2 right;

        public TreeNode2(int data) {
            this.data = data;
        }
    }


    /*public static void main(String[] args) {
        LinkedList<Integer> list=new LinkedList<>(Arrays.asList(new Integer[]{3,2,9,null,null,10,null,null,8,null,4}));
        TreeNode2 treeNode = create(list);
        preOrder2(treeNode);

    }*/




    /**
     * 非递归实现前序遍历
     *
     */
    public static void preOrder(TreeNode head){
        if(head!=null){
            Stack<TreeNode> stack =new Stack<>();
            stack.push(head);
            while (!stack.isEmpty()){
                TreeNode pop = stack.pop();
                System.out.print(pop.value+" ");
                if(pop.right!=null){
                    stack.push(pop.right);
                }
                if(pop.left!=null){
                    stack.push(pop.left);
                }
            }
        }
    }


    /**
     *
     * 非递归实现中序遍历---H D I B E J A F K C G
     */
    public static void  inOrder(TreeNode head){
        if(head !=null){
            Stack<TreeNode> stack =new Stack<>();
            while (!stack.isEmpty()||head !=null){
                if(head!=null){
                    stack.push(head);
                    head=head.left;
                }else {
                    head=stack.pop();
                    System.out.print(head.value+" ");
                    head = head.right;
                }
            }
        }
    }

    /**
     * 非递归后序遍历 H I D J E B K F G C A
     *
     */
    public static void  postOrder(TreeNode head){
        if(head!=null){
            Stack<TreeNode> stack1=new Stack<>();
            Stack<TreeNode> stack2=new Stack<>();
            stack1.push(head);
            while (!stack1.isEmpty()){
                TreeNode pop=stack1.pop();
                stack2.push(pop);
                if(pop.left!=null){
                    stack1.push(pop.left);
                }
                if(pop.right!=null){
                    stack1.push(pop.right);
                }
            }
            while (!stack2.isEmpty()){
                System.out.print(stack2.pop().value+" ");
            }
        }
    }

    /**
     *层次遍历 A B C D E F G H I J K
     */
    public static void levelOrder(TreeNode head){
        if(head!=null){
            Queue<TreeNode> queue=new ArrayDeque<>();
            queue.offer(head);
            while (!queue.isEmpty()){
                //获取当前层的结点数
                int levelNum=queue.size();
                for (int i = 0; i < levelNum; i++) {
                     TreeNode poll=queue.poll();
                    System.out.print(poll.value+" ");
                    if(poll.left!=null){
                        queue.offer(poll.left);
                    }
                    if (poll.right!=null){
                        queue.offer(poll.right);
                    }

                }
            }
        }
    }







   /* public static void main(String[] args) {
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

       // preOrder(A); //前
        // inOrder(A); //中
        //postOrder(A); //后
       levelOrder(A); //层次遍历
    }*/
}
