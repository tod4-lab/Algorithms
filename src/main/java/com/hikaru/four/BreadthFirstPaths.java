package com.hikaru.four;

import java.util.Iterator;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.LinkedBlockingQueue;

public class BreadthFirstPaths {
    private boolean[] marked;
    private int[] edgeTo;
    private int s;

    BreadthFirstPaths(Graph g, int s) {
        marked = new boolean[g.V()];
        edgeTo = new int[g.V()];
        this.s = s;

        bfs(g, s);
    }

    public void bfs(Graph g, int v) {
        Queue<Integer> q = new LinkedBlockingQueue<>();
        q.add(v);
        marked[v] = true;

        while (!q.isEmpty()) {
            int x = q.poll();
            for (int w : g.adj(x)) {
                if (!marked[w]) {
                    edgeTo[w] = x;
                    q.add(w);
                    marked[w] = true;
                }
            }
        }
    }

    public Stack<Integer> pathTo(int v) {
        Stack<Integer> s = new Stack<>();
        while (v != this.s) {
            s.push(v);
            v = edgeTo[v];
        }
        s.push(v);
        return s;
    }
}
