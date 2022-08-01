package com.hikaru.four;

import org.junit.Test;

import java.util.Iterator;

public class Bag<T> implements Iterable<T> {
    private node head = null;

    @Override
    public Iterator iterator() {
        return new bagIterator();
    }

    private class node {
        private T val;
        private node next;

        node(T val) {
            this.val = val;
            this.next = null;
        }
    }

    public void add(T val) {
        node p = new node(val);
        if (head != null) {
            p.next = head;
        }
        head = p;
    }

    private class bagIterator implements Iterator<T> {
        private node p = head;

        @Override
        public boolean hasNext() {
            return p != null;
        }

        @Override
        public T next() {
            T result = p.val;
            p = p.next;
            return result;
        }
    }

    public static void main(String[] args) {
        Bag<Integer> b = new Bag<>();
        for (int i = 0; i < 1; i++)
            b.add(i);
        for (int v : b) {
            System.out.println(v);
        }
    }
}
