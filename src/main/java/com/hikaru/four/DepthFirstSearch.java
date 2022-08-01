package com.hikaru.four;

import java.util.Stack;

public class DepthFirstSearch {
    boolean[] marked;
    private int count;

    DepthFirstSearch(Graph g, int s) {
        marked = new boolean[g.V()];
//        dfs(g, s);
        dfs2(g, s);
    }

    void dfs2(Graph g, int v) {
        Stack<Integer> s = new Stack<>();
        s.push(v);
        visit(v);
        marked[v] = true;
        while(!s.empty()) {
            int x = s.peek();

            boolean flag = false;
            // 每次访问第一个未被访问的相邻节点
            for(int w : g.adj(x)) {
                if(!marked[w]) {
                    s.push(w);
                    marked[w] = true;
                    flag = true;
                    break;
                }
            }
            // 如果不存在相邻顶点则将栈顶顶点出栈
            if(!flag)
                s.pop();
        }
    }

    void visit(int v) {
        System.out.print(v + " ");
    }
    void dfs(Graph g, int v) {
        marked[v] = true;
        visit(v);
        for(int w : g.adj(v)) {
            if(!marked[w]) {
                dfs(g, w);
            }
        }
    }
}
