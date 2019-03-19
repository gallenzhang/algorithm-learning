package com.gallenzhang.algorithm.tree;
/**
 * @author : zhangxq
 * @date : 2019/3/19
 * @description :二叉搜索树
 */
public class BinarySearchTree<T extends Comparable> {

    private Node<T> root;

    public BinarySearchTree(){}

    public BinarySearchTree(Node<T> root){
        this.root = root;
    }

    public Node<T> getRoot(){
        return root;
    }

    /**
     * 查找最小节点
     * @return
     */
    public Node<T> findMin(){
        if(root == null){
            return null;
        }
        Node<T> p = root;
        while (p.left != null){
            p = p.left;
        }
        return p;
    }

    /**
     * 查找最大节点
     * @return
     */
    public Node<T> findMax(){
        if(root == null){
            return null;
        }
        Node<T> p = root;
        while (p.right != null){
            p = p.right;
        }
        return p;
    }

    /**
     * 树的高度
     * @param root
     * @return
     */
    public int height(Node<T> root){
        if(root == null){
            return 0;
        }

        int leftTree = height(root.left) + 1;
        int rightTree = height(root.right) + 1;
        return Math.max(leftTree,rightTree);
    }

    /**
     * 查找节点
     * @param data
     * @return
     */
    public Node<T> find(T data){
        Node<T> p = root;
        while (p != null){
            if(data.compareTo(p.data) < 0){
                p = p.left;
            }else if(data.compareTo(p.data) > 0){
                p = p.right;
            }else {
                return p;
            }
        }
        return null;
    }

    /**
     * 二叉搜索树中插入节点
     * @param data
     */
    public void insert(T data){
        if(root == null){
            root = new Node<T>(data);
            return;
        }

        Node<T> p = root;
        while (p != null){
            if(data.compareTo(p.data) < 0){
                if(p.left == null){
                    p.left = new Node(data);
                    return;
                }
                p = p.left;
            }else {
                if(p.right == null){
                    p.right = new Node(data);
                    return;
                }
                p = p.right;
            }
        }
    }

    /**
     * 二叉搜索树删除节点
     * @param data
     */
    public void delete(T data){
        Node<T> p = root;
        Node<T> pp = null;

        //查找要删除的节点
        while (p != null && p.data.compareTo(data) != 0){
            pp = p;
            if(data.compareTo(p.data) < 0){
                p = p.left;
            }else {
                p = p.right;
            }
        }

        //没找到要删除的节点
        if(p == null){
            return;
        }

        //要删除节点有左右子节点,将右子树最小节点赋值给要删除节点，然后删除最小节点（p）
        if(p.left != null && p.right != null){
            Node<T> minP = p.right;
            Node<T> minPP = p;
            while (minP.left!= null){
                minPP = minP;
                minP = minP.left;
            }
            p.data = minP.data;

            p = minP;
            pp = minPP;
        }

        //保存待删除节点的子节点
        Node<T> child = null;
        if(p.left != null){
            child = p.left;
        }else if(p.right != null){
            child = p.right;
        }else {
            child = null;
        }

        if(pp == null){
            root = child;
        }else {
            if(pp.right == p){
                pp.right = child;
            }else if(pp.left == p){
                pp.left = child;
            }
        }
    }
}
