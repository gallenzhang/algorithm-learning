package com.gallenzhang.algorithm.tree;
/**
 * @author : zhangxq
 * @date : 2019/3/19
 * @description :二叉树节点
 */
public class Node<T> {
    T data;
    Node left;
    Node right;

    public Node(T data){
        this.data = data;
    }
}
