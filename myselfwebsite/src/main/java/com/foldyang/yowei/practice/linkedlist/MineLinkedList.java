package com.foldyang.yowei.practice.linkedlist;

/**
 * @Author foldYang
 * @Description 自定义链表
 * @Date 2019/12/28
 * @Version 1.0
 */
public class MineLinkedList {

    private Node first;
    private Node last;
    private int size;

    public void add(int index, Object obj) {
        Node newNode = new Node(obj);
        Node temp = getNode(index);

        if (temp != null) {
            Node up = temp.previous;
            if (up == null) {
                first = newNode;
                newNode.next = temp;
            }
        }
    }

    /**
     * @Author: foldYang
     * @Description: 根据下标获取节点(代码重用)
     * @Date: 15:41 2019/12/28
     */
    public Node getNode(int index) {
        Node temp = null;
        // size >> 1 相当于除以2
        if (index <= (size >> 1)) {
            temp = first;
            for (int i = 0; i < index; i++) {
                temp = temp.next;
            }
        } else {
            temp = last;
            for (int i = size - 1; i > index; i--) {
                temp = temp.previous;
            }
        }
        return temp;
    }

}
