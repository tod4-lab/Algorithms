package com.hikaru.one.binarySearch;

public class LinkedList<Item> {
    private Node first;
    private class Node {
        Item item;
        Node next;
    }
    /**
     * 在表头插入节点
     * @param item
     */
    public void addOnHead(Item item) {
        Node temp = new Node();
        temp.item = item;
        temp.next = first.next;
        first = temp;
    }

    /**
     * 在表头删除节点
     * @return
     */
    public boolean deleteAtHead() {
        // 没有节点删除失败
        if(first == null)
            return false;
        // 有一个节点，将链表置空
        if(first.next == null)
            first = null;
        // 两个以上节点的情况
        else
            first.next = first.next.next;
        return true;
    }

    /**
     * 尾插法
     * @param item
     */
    public void insertOnTail(Item item) {
       Node temp = new Node();
       temp.item = item;
       Node tail = first;
       if(tail==null) {
            tail = temp;
       }
       while(tail.next!=null) {
           tail = tail.next;
       }
       tail.next = temp;
    }
}
