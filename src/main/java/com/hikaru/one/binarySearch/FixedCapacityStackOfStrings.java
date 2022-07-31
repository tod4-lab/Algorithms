package com.hikaru.one.binarySearch;

/**
 * 定容栈的实现
 *
 */
public class FixedCapacityStackOfStrings {
    private String[] a;
    private int N = 0;
    public FixedCapacityStackOfStrings(int capacity) {
        a = new String[capacity];
    }
    public int size() {
        return N;
    }
    public boolean isEmpty() {
        return N == 0;
    }
    public void push(String item) {
        a[N++] = item;
    }
    public String pop() {
        return a[--N];
    }
    // 测试
    public static void main(String[] args) {
        String str = "to be or not to - be - - that - - - is";
        String expect = "to be not that or be ";
        String result = "";
        FixedCapacityStackOfStrings s = new FixedCapacityStackOfStrings(100);

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
}
