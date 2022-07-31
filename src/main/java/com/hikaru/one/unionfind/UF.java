package com.hikaru.one.unionfind;

import java.util.Iterator;
import java.util.Scanner;
import java.util.function.Consumer;

public class UF implements Iterable<Integer>{
    // 以触点作为索引的分量id
    private int[] id;
    // 记录连通分量的个数
    private int count;

    UF(int N) {
        // 初始化分量数组
        count = N;
        id = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
        }
    }

    // 查找触点所属的分量
    public int find(int p) {
        return id[p];
    }

    // 将两个触点连接
    public void union(int p, int q) {
        int pId = find(p);
        int qId = find(q);
        // 已经属于同一个连通分量则不需要连接
        if (pId == qId) return;
        // 否则将每一个和触点p属于同一个连通分量的触点，并入连通分量q
        for (int i = 0; i < id.length; i++) {
            if (find(i) == pId) {
                id[i] = qId;
                count--;
            }
        }
    }

    public int getCount() {
        return count;
    }

    // 判断两个触点是否属于同一个分量
    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    @Override
    public Iterator<Integer> iterator() {
        return new UFIterator();
    }

    private class UFIterator implements Iterator<Integer> {
        private int i = 0;
        @Override
        public boolean hasNext() {
            return i != id.length;
        }

        @Override
        public Integer next() {
            return id[i++];
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N;
        while (sc.hasNextInt()) {
            N = sc.nextInt();
            UF union = new UF(N);
            for (int i = 0; i < N; i++) {
                int p, q;
                p = sc.nextInt();
                q = sc.nextInt();
                union.union(p, q);
            }
            for(int id : union) {
                System.out.print(id + " ");
            }
        }
    }
}
