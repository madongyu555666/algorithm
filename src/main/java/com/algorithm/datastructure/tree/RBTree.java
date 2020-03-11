package com.algorithm.datastructure.tree;

import javax.crypto.spec.RC2ParameterSpec;

/**
 * 红黑树
 */
public class RBTree<K extends Comparable<K>,V> {

    //红色
    private static  final  boolean RED=true;
    //黑色
    private static  final  boolean BLACK=true;

    /**
     * 树根的引用
     */
    private RBNode root;

    public RBNode getRoot() {
        return root;
    }

    /**
     * 获取当前的父节点
     */
    private RBNode parentOf(RBNode node ){
        if(node!=null){
            return  node.parent;
        }
        return  null;
    }

    /**
     * 节点是否为红色
     */
    private boolean isRed(RBNode node ){
        if(node!=null){
            return  node.color==RED;
        }
        return  false;
    }


    /**
     * 节点是否为黑色
     */
    private boolean isBlack(RBNode node ){
        if(node!=null){
            return  node.color==BLACK;
        }
        return  false;
    }

    /**
     * 设置节点为红色
     */
    private void setRed(RBNode node ){
        if(node!=null){
            node.color=RED;
        }
    }

    /**
     * 设置节点为黑色
     */
    private void setBlack(RBNode node ){
        if(node!=null){
            node.color=BLACK;
        }
    }


    /**
     *中序打印二叉树
     */
    public void inOrderPrint(){
        inOrderPrint(this.root);
    }


    public void inOrderPrint(RBNode node){
       if(node!=null){
           inOrderPrint(node.left);
           System.out.println("key:"+node.key+"value:"+node.value);
           inOrderPrint(node.right);
       }
    }


    /**
     *左旋方法
     * 左旋示意图：左旋x节点
     *    p                  p
     *    |                  |
     *    X                  y
     *   / \      ------>   /\
     *  lx  y              x  ry
     *     /\             /\
     *    ly ry          lx ly
     * 1.并将x的右子节点指向y的左子节点（ly）,将y的左子节点的父节点更新为x
     * 2.当x的父节点（不为空时），更新y的父节点为x的父节点，并将x的父节点指定子树
     * （当前x的子树位置）指定为y
     * 3.将x的父节点更新为y，将y的左子节点更新为x
     */
    private void leftRotate(RBNode x){//传入x节点
        RBNode y=x.right;
       // 1.并将x的右子节点指向y的左子节点（ly）,将y的左子节点的父节点更新为x
        x.right=y.left;
        if(y.left!=null){
            y.left.parent=x;
        }

        //2.当x的父节点（不为空时），更新y的父节点为x的父节点，并将x的父节点指定子树
        //     * （当前x的子树位置）指定为y
        if(x.parent!=null){
            y.parent=x.parent;
            if(x==x.parent.left){
                x.parent.left=y;
            }else {
                x.parent.right=y;
            }
        }else {//说明x为根节点，此时需要更新y为根节点引用
            this.root=y;
            this.root.parent=null;
        }

        //3.将x的父节点更新为y，将y的左子节点更新为x
        x.parent=y;
        y.left=x;
    }


    /**
     * 右旋方法
     * 右旋示意图：右旋y节点
     *    p                  p
     *    |                  |
     *    y                  x
     *   / \      ------>   /\
     *  x  ry              lx y
     * /\                     /\
     *lx ly                  ly ry
     * 1.将y的左子节点指向x的右子节点，并且更新x的右子节点的父节点为y
     * 2.当y的父节点不为空时，更新x的父节点为y的父节点，更新y的父节点的指定子节点（y当前的位置）为x
     * 3.更新y的父节点为x，更新x的右子节点为y
     */
    private void rightRotate(RBNode y){
        RBNode x = y.left;
        y.left = x.right;
       if(x.right!=null){
           x.right.parent=y;
       }


       //2.当y的父节点不为空时，更新x的父节点为y的父节点，更新y的父节点的指定子节点（y当前的位置）为x
       if(y.parent!=null){
           x.parent=y.parent;
           if(y==y.parent.left){
                y.parent.left=x;
           }else {
               y.parent.right = x;
           }
       }else {
           this.root=x;
           this.root.parent=null;
       }

       //3.更新y的父节点为x，更新x的右子节点为y
        y.parent=x;
       x.right=y;
    }


    /**
     * 公开的插入方法
     * @param key
     * @param value
     */
    public void insert(K key,V value){
       RBNode node=new RBNode();
       node.setKey(key);
       node.setValue(value);
       //新加入的结点一定是红色
       node.setColor(RED);
        insert(node);
    }




    private void insert(RBNode node){
        //第一步查找当前node的父节点
        RBNode parent=null;
        RBNode x=this.root;
        while (x!=null){
            parent=x;

            //cmp>0 说明node.key大于x.key 需要到x的右子树查找
            //cmp==0 说明node.key等于x.key说明需要进行替换操作
            //cmp<0 说明node.key小于x.key需要到x的左子树查找
            int cmp = node.key.compareTo(x.key);
            if(cmp>0){
                x=x.right;
            }else if(cmp==0){
                x.setValue(node.getValue());
                return;
            }else {
                x=x.left;
            }
        }
        //上面是一直往下查找
        //下面开始赋值
        node.parent=parent;//该parent就是最后下面的节点
        if(parent!=null){
            //判断node与parent的key谁大
            int cmp = node.key.compareTo(parent.key);
            if(cmp >0){
                //当前node的key比parent的key大，需要把node放入parent的右子节点
                parent.right=node;
            }else {
                //当前node的key比parent的key小，需要把node放入parent的左子节点
                parent.left=node;
            }
        }else {
            this.root=node;
        }
        //需要调用修复红黑树的平衡的方法
        insertFixup(node);

    }


    /**
     * 插入后修复红黑树平衡的方法
     * 情景1：红黑树为空树，将根节点染为黑色
     * 情景2：插入节点的key已经存在，不需要处理（x.setValue(node.getValue());）已经处理了
     * 情景3：插入节点的父节点为黑色，因为你所插入的路径，黑色节点没有变化，所以红黑树依然平衡，所以不需要处理
     *
     * 情景4：插入节点的父节点为红色
     *      情景4.1：叔叔节点存在，并且为红色（父-叔 双红），将爸爸和叔叔染为黑色，将爷爷染为红色，并且在以爷爷节点为当前节点，进行下一轮处理
     *      情景4.2：叔叔节点不存在，或者为黑色，父节点为爷爷节点的左子树
     *             情景4.2.1:插入节点为其父节点的左子节点（LL情况），将爸爸染为黑色，将爷爷染为红色，然后以爷爷节点右旋，就完成了
     *             情景4.2.2:插入节点为其父节点的右子节点（LR情况）,以爸爸节点进行一次左旋，得到LL双红的情景（4.2.1），然后指定爸爸节点为当前节点进行下一轮处理
     *      情景4.3：叔叔节点不存在，或者为黑色，父节点为爷爷节点的右子树
     *             情景4.3.1:插入节点为其父节点的右子节点（RR情况），将爸爸染为黑色，将爷爷染为红色，然后以爷爷节点左旋，就完成了
     *      *      情景4.3.2:插入节点为其父节点的左子节点（RL情况）,以爸爸节点进行一次右旋，得到RR双红的情景（4.3.1），然后指定爸爸节点为当前节点进行下一轮处理
     */
     private void insertFixup(RBNode node){
         this.root.setColor(BLACK);

         RBNode parent = parentOf(node);
         RBNode gparent = parentOf(parent);

         //情景4：插入节点的父节点为红色
         if(parent!=null && isRed(parent)){
            //如果父节点是红色，那么一定存在爷爷节点，因为跟节点不可能是红色。

             RBNode uncle=null;
             //父节点为爷爷节点的左子树
             if(parent==gparent.left){
                 uncle=gparent.right;
                 //情景4.1叔叔节点存在，并且为红色（父-叔 双红）
                 if(uncle!=null&&isRed(uncle)){
                    //将爸爸和叔叔染为黑色，将爷爷染为红色，并且在以爷爷节点为当前节点，进行下一轮处理
                     setBlack(parent);
                     setBlack(uncle);
                     setRed(gparent);
                     insertFixup(gparent);
                     return;
                 }
                 //情景4.2：叔叔节点不存在，或者为黑色，父节点为爷爷节点的左子树
                 if(uncle==null || isBlack(uncle)){
                       //情景4.2.1:插入节点为其父节点的左子节点（LL情况），将爸爸染为黑色，将爷爷染为红色，然后以爷爷节点右旋，就完成了
                      if(node==parent.left){
                          setBlack(parent);
                          setRed(gparent);
                          rightRotate(gparent);
                          return;
                      }

                     //情景4.2.2:插入节点为其父节点的右子节点（LR情况）,
                     // 以爸爸节点进行一次左旋，得到LL双红的情景（4.2.1），然后指定爸爸节点为当前节点进行下一轮处理
                      if(node==parent.right){
                          leftRotate(parent);
                          insertFixup(parent);
                          return;
                      }
                 }
             }else {
                 //父节点为爷爷节点的右子树
                 uncle=gparent.left;

                 //情景4.1叔叔节点存在，并且为红色（父-叔 双红）
                 if(uncle!=null&&isRed(uncle)){
                     //将爸爸和叔叔染为黑色，将爷爷染为红色，并且在以爷爷节点为当前节点，进行下一轮处理
                     setBlack(parent);
                     setBlack(uncle);
                     setRed(gparent);
                     insertFixup(gparent);
                     return;
                 }
                 //情景4.3：叔叔节点不存在，或者为黑色，父节点为爷爷节点的右子树
                 if(uncle==null || isBlack(uncle)){
                    // 情景4.3.1:插入节点为其父节点的右子节点（RR情况），将爸爸染为黑色，将爷爷染为红色，然后以爷爷节点左旋，就完成了
                    if(node==parent.right){
                        setBlack(parent);
                        setRed(gparent);
                        leftRotate(gparent);
                        return;
                    }
                    // 情景4.3.2:插入节点为其父节点的左子节点（RL情况）,
                     if(node==parent.left){
                        // 以爸爸节点进行一次右旋，得到RR双红的情景（4.3.1），然后指定爸爸节点为当前节点进行下一轮处理
                         rightRotate(parent);
                         insertFixup(parent);
                         return;
                     }
                 }

             }
         }
     }






    //定义节点
    static  class  RBNode<K extends Comparable<K>,V>{
        private RBNode parent;
        private RBNode left;
        private RBNode right;
        private boolean color;
        private K key;
        private V value;

        public RBNode() {
        }

        public RBNode(RBNode parent, RBNode left, RBNode right, boolean color, K key, V value) {
            this.parent = parent;
            this.left = left;
            this.right = right;
            this.color = color;
            this.key = key;
            this.value = value;
        }

        public RBNode getParent() {
            return parent;
        }

        public void setParent(RBNode parent) {
            this.parent = parent;
        }

        public RBNode getLeft() {
            return left;
        }

        public void setLeft(RBNode left) {
            this.left = left;
        }

        public RBNode getRight() {
            return right;
        }

        public void setRight(RBNode right) {
            this.right = right;
        }

        public boolean isColor() {
            return color;
        }

        public void setColor(boolean color) {
            this.color = color;
        }

        public K getKey() {
            return key;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }
    }
}
