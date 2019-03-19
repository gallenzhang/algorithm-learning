package com.gallenzhang.algorithm.tree;
/**
 * @author : zhangxq
 * @date : 2019/3/19
 * @description :二叉树
 */
public class BinaryTree<T extends Comparable> {

    private Node root;

    public BinaryTree(){}

    public BinaryTree(Node root){
        this.root = root;
    }

    public Node getRoot(){
        return this.root;
    }

    /**
     * 前序遍历
     * @param root
     */
    public void preOrder(Node<T> root){
        if(root == null){
            return;
        }

        System.out.println(root.data);
        preOrder(root.left);
        preOrder(root.right);
    }

    /**
     * 中序遍历
     * @param root
     */
    public void inOrder(Node<T> root){
        if(root == null){
            return;
        }

        preOrder(root.left);
        System.out.println(root.data);
        preOrder(root.right);
    }

    /**
     * 后序遍历
     * @param root
     */
    public void postOrder(Node<T> root){
        if(root == null){
            return;
        }

        preOrder(root.left);
        preOrder(root.right);
        System.out.println(root.data);
    }
}
