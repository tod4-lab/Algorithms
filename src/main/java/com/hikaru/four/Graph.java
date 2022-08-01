package com.hikaru.four;

import java.util.Scanner;
import java.util.Stack;

public class Graph {
    private final int V;
    private int E;
    private Bag<Integer>[] adj;

    Graph(int V, int E) {
        this.V = V;
        this.E = E;
        adj = (Bag<Integer>[]) new Bag[V];
        for (int i = 0; i < V; i++)
            adj[i] = new Bag<Integer>();
    }

    public void addEdge(int u, int v) {
        adj[u].add(v);
    }

    public int V() {
        return this.V;
    }

    public int E() {
        return this.E;
    }

    public Iterable<Integer> adj(int v) {
        return adj[v];
    }

    public String toString() {
        String s = V + " vertices, " + E + " edges.\n";
        for (int i = 0; i < V; i++) {
            s += i + " : ";
            for(int w : this.adj(i))
                s += w + " ";
            s += "\n";
        }

        return s;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int V = sc.nextInt();
        int E = sc.nextInt();
        Graph g = new Graph(V, E);
        for (int i = 0; i < E; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            g.addEdge(u, v);
            g.addEdge(v, u);
        }
        BreadthFirstPaths bfp = new BreadthFirstPaths(g, 0);
        Stack<Integer> integers = bfp.pathTo(4);
//        while(!integers.empty()) {
//            System.out.print(integers.pop() + " ");
//        }
        for(int i : integers) {
            System.out.print(i + " ");
        }
    }
}
