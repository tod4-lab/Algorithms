package com.hikaru.one.binarySearch;

import java.util.Iterator;

/**
 *  泛型定容栈
 */
public class FixedCapacityStack<Item> implements Iterable{
    private Item[] a;
    private int N = 0;
    public FixedCapacityStack(int capacity) {
        // 不能使用泛型数组
        a = (Item[]) new Object[capacity];

    }

    public boolean isEmpty() {
        return N == 0;
    }

    public Item pop() {
        return a[--N];
    }

    public void push(Item item) {
        a[N++] = item;
    }

    public int size() {
        return N;
    }
    // 测试
    public static void main(String[] args) {
        String str = "to be or not to - be - - that - - - is";
        String expect = "to be not that or be ";
        String result = "";
        FixedCapacityStack<String> s = new FixedCapacityStack<>(100);

        for(String item : str.split(" ")) {
            if(!"-".equals(item)) {
                s.push(item);
            }
            else if(!s.isEmpty()) {
                result += s.pop() + " ";
            }
        }
        System.out.println(expect.equals(result));
    }

    @Override
    public Iterator iterator() {
        return null;
    }
}
