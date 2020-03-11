package com.algorithm.datastructure.tree;


/**
 * 简单的红黑树
 */
public class RedBlackBST {


    private final  int R=0; //红
    private final  int B=1; //黑
    private  final  Node nil=new Node(-1);
    private Node root = nil;

    private class Node{
        int key =-1;
        int color=B;
        Node left=nil;
        Node right=nil;
        Node p=nil;//父
        public Node(int key) {
            this.key = key;
        }
    }



    /**
     * 中序输出
     */
    public void printTree(Node node){
        if(node==nil){
            return;
        }
        printTree(node.left);
        System.out.print(((node.color==R)?"R":"B")+"Key:"+node.key+"Parent:"+node.p.key);
        printTree(node.right);
    }


    /**
     * 前序输出
     */
    public void printTreePre(Node node){
        if(node==nil){
            return;
        }
        printTree(node.left);
        System.out.print(((node.color==R)?"R":"B")+"Key:"+node.key+"Parent:"+node.p.key);
        printTree(node.right);
    }

    /**
     * 查找节点
     * @param findNode
     * @param node
     * @return
     */
    private Node findNode(Node findNode,Node node){
        if(node==nil){
            return null;
        }
        if(findNode.key<node.key){
            if(node.left!=nil){
                return findNode(findNode,node.left);
            }
        }else if(findNode.key>node.key){
            if(node.right!=nil){
                return findNode(findNode,node.right);
            }
        }else if(findNode.key==node.key){
             return node;
        }
        return null;
    }

    /**
     * 插入节点
     */
    public void insert(Node node){
        Node temp=root;
        if(root==nil){
            root=node;
            node.color=B;
            node.p=nil;
        }else {
            node.color=R;
            while (true){
                if(node.key<temp.key){
                    //左
                    if(temp.left==nil){
                        temp.left =node;
                        node.p=temp;
                        break;
                    }else {
                       temp = temp.left;
                    }
                }else if(node.key>=temp.key){
                    if(temp.right==nil){
                        temp.right=node;
                        node.p=temp;
                        break;
                    }else {
                        temp=temp.right;
                    }
                }
            }
            fixTree(node);
        }
    }

    /**
     * 修理红黑树
     * @param node
     */
    private void fixTree(Node node) {
        while (node.p.color==R){
            Node y=nil;
            if(node.p==node.p.p.left){
                y=node.p.p.right;

                if(y!=nil && y.color==R){
                    node.p.color=B;
                    y.color=B;
                    node.p.p.color=R;
                    node = node.p.p;
                    continue;
                }

                if(node==node.p.right){
                    node=node.p;
                    rotateLeft(node);
                }
                node.p.color=B;
                node.p.p.color=R;
                rotateRight(node.p.p);
                
            }else {
                y=node.p.p.left;
                if(y!=nil&& y.color==R){
                    node.p.color=B;
                    y.color=B;
                    node.p.p.color=R;
                    node=node.p.p;
                    continue;
                }
                if(node==node.p.left){
                  node=node.p;
                  rotateRight(node);
                }
                node.p.color=B;
                node.p.p.color=R;
                rotateLeft(node.p.p);
            }
        }
        root.color=B;
    }

    /**
     * 右旋
     * @param node
     */
    private void rotateRight(Node node) {
        if(node.p!=null) {
            if (node == node.p.left) {
                node.p.left = node.left;
            } else {
                node.p.right = node.left;
            }

            node.left.p = node.p;
            node.p = node.left;
            if (node.left.right != nil) {
                node.left.right.p = node;
            }
            node.left = node.left.right;
            node.p.right = node;
        }else {
            Node left=root.left;
            root.left=root.left.right;
            left.right.p=root;
            root.p=left;
            left.right=root;
            left.p=nil;
            root=left;
        }
    }


    /**
     * 左旋
     * @param node
     */
    private void rotateLeft(Node node) {
        if(node.p!=nil){
            if(node==node.p.left){
                node.p.left = node.right;
            }else {
                node.p.right=node.right;
            }
            node.right.p=node.p;
            node.p=node.right;
            if(node.right.left!=nil){
                node.right.left.p=node;
            }
            node.right=node.right.left;
            node.p.left=node;
        }else {
            Node right=root.right;
            root.right=right.left;
            right.left.p=root;
            root.p=right;
            right.left=root;
            right.p=nil;
            root=right;
        }

    }





}
