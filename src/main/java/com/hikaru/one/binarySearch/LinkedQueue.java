package com.hikaru.one.binarySearch;

import java.util.Iterator;

public class LinkedQueue<Item> implements Iterable<Item> {
    private class Node {
        Item item;
        Node next;
    }
    private int N;
    private Node first;
    private Node tail;

    // 表尾入队
    public void enQueue(Item item) {
        Node oldTail = tail;
        tail = new Node();
        tail.item = item;
        if(N == 0)
            first = tail;
        else
            oldTail.next = tail;
        N++;
    }

    // 表首出队
    public Item deQueue() {
        if(first == null)
            return null;

        Item item = first.item;
        first = first.next;
        if(isEmpty()) tail=null;
        N--;
        return item;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    private void printAll() {
        Node temp = first;
        while(first!=null) {
            System.out.println(first.item);
            first = first.next;
        }
    }

    @Override
    public Iterator<Item> iterator() {
        return new LinkedQueueIterator();
    }

    private class LinkedQueueIterator implements Iterator<Item> {
        private int i = 0;
        @Override
        public boolean hasNext() {

            return i<N;
        }

        @Override
        public Item next() {
            Node temp = first;
            for(int j=0;j<i;j++)
                temp = temp.next;
            i++;
            return temp.item;
        }
    }

    public static void main(String[] args) {
        LinkedQueue<Integer> queue = new LinkedQueue<>();
        for(int i=0;i<10;i++)
            queue.enQueue(i);
        for(int var:queue) {
            System.out.print(var);
        }
    }
}
