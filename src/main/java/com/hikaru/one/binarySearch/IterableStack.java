package com.hikaru.one.binarySearch;

import java.util.Iterator;

public class IterableStack<Item> implements Iterable<Item>{
    private Item[] a;
    //默认初始化为0
    private int N;

    public void resize(int max) {
        Item[] temp = (Item[]) new Object[max];
        for(int i=0;i<N;i++) {
            temp[i] = a[i];
        }
        a = temp;
    }

    public IterableStack(int capacity) {
        a = (Item[]) new Object[capacity];
    }

    public void push(Item item) {
        if(N == a.length)
            resize(a.length * 2);
        a[N++] = item;
    }

    public Item pop() {
        Item item = a[--N];
        // 防止对象游离
        a[N] = null;
        // N=0不必再进行长度缩减
        if(N > 0 && N <= a.length/4)
            resize(a.length / 2);
        return item;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    @Override
    public Iterator iterator() {
        return new ReverseArrayIterator();
    }

    private class ReverseArrayIterator implements Iterator<Item> {
        private int i = N;
        @Override
        public boolean hasNext() {
            return i > 0;
        }

        @Override
        public Item next() {
            return a[--i];
        }

        @Override
        public void remove() {

        }
    }

    public static void main(String[] args) {
        String str = "to be or not to - be - - that - - - is";
        String expect = "to be not that or be ";
        String result = "";
        IterableStack<String> s = new IterableStack<>(100);

        for(String item : str.split(" ")) {
            if(!"-".equals(item)) {
                s.push(item);
            }
            else if(!s.isEmpty()) {
                result += s.pop() + " ";
            }
        }
        System.out.println(expect.equals(result));

        Iterator iterator = s.iterator();
        while(iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        for (String str2 : s) {
            System.out.println(str2);
        }
    }
}
