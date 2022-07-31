package com.hikaru.one.binarySearch;

import java.util.Iterator;

public class LinkedStack<Item> implements Iterable<Item> {
    private class Node {
        Item item;
        Node next;
    }

    private Node first;
    private int N;

    public void push(Item item) {
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
        N++;
    }

    public Item pop() {
        if(first == null)
            return null;
        Item item = first.item;
        first = first.next;
        N--;
        return item;
    }

    public int size() {
        return N;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    @Override
    public Iterator<Item> iterator() {
        return new LinkedStackIterator();
    }

    private class LinkedStackIterator implements Iterator<Item>{
        private int i = N;

        @Override
        public boolean hasNext() {
            return i > 0;
        }

        @Override
        public Item next() {
            Node temp = first;
            for(int j=0;j<i-1;j++)
                temp = temp.next;
            i--;
            return temp.item;
        }
    }
    // 测试
    public static void main(String[] args) {
        LinkedStack<Integer> stack = new LinkedStack<>();
        for (int i=0;i<10;i++)
            stack.push(i);
        System.out.println(stack.pop());

        for(int val : stack) {
            System.out.print(val);
        }
    }
}
