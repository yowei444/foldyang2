package com.foldyang.yowei.practice.linkedlist;

/**
 * @Author foldYang
 * @Description 双向链表实体类
 * @Date 2019/12/28
 * @Version 1.0
 */
public class Node {


    // 上一个节点
    Node previous;
    // 下一个节点
    Node next;
    // 元素数据
    Object element;

    public Node(Node previous, Node next, Object element) {
        this.previous = previous;
        this.next = next;
        this.element = element;
    }

    public Node(Object element) {
        this.element = element;
    }


}
