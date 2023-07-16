package com.company;

import static com.company.Arrays.*;
import static java.util.Arrays.sort;

public class kruskal {
    class Edge implements Comparable<Edge> {
        int src, dest, weight;
        Edge(int src,int dest,int weight){
            this.src=src;
            this.dest=dest;
            this.weight=weight;
        }

        public int compareTo(Edge compareEdge) {
            return this.weight - compareEdge.weight;
        }
    };
    int[]parent,rank;

    public int KruskalAlgo(int n, int[][] edge) {
        Edge[] edges=new Edge[edge.length];
        for (int i = 0; i < edges.length; i++) {
            int vertex1 = edge[i][0];
            int vertex2 = edge[i][1];
            int weight = edge[i][2];
            edges[i] = new Edge(vertex1, vertex2, weight);
        }
        sort(edges);
        parent = new int[n + 1];
        rank = new int[n + 1];

        // assigning each element as a unique group and assigning rank 1 to them.
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
        int ans=0;
        for (int i = 0; i < edges.length; i++) {
            int vertex1 = edges[i].src;
            int vertex2 = edges[i].dest;
            int weight = edges[i].weight;

            //checking if the vertices belong to same group or not.
            boolean flag = union(vertex1, vertex2);

            //if vertices are from unique groups that implies , if both vertices would be connected, it won't create a loop.
            if (flag == false) {
                System.out.println(vertex1+"  "+vertex2+"  "+weight);
                ans += weight;
            }
        }
        return  ans;

    }
    public  int find(int component) {

        // if the component which is a leader already is returned.
        if (parent[component] == component) {
            return component;
        }

        //finding the parent  or group leader of that  element
        int temp = find(parent[component]);
        parent[component] = temp;
        return temp;
    }

    public  boolean union(int vertex1, int vertex2) {

        // finding the parent or group leader of both of these vertices.
        int parentOfVertex1 = find(vertex1);
        int parentOfVertex2 = find(vertex2);

        //if parent or leader of both vertices is same, this implies, that if they get connected, it would create a loop
        if (parentOfVertex1 == parentOfVertex2) {
            return true;
        }

        //deciding the parent of vertex according to their ranks.
        if (rank[parentOfVertex1] > rank[parentOfVertex2]) {
            parent[parentOfVertex2] = parentOfVertex1;
        } else if (rank[parentOfVertex1] < rank[parentOfVertex2]) {
            parent[parentOfVertex1] = parentOfVertex2;
        } else {
            parent[parentOfVertex1] = parentOfVertex2;
            rank[parentOfVertex2]++;
        }

        return false;
    }
    public static void main(String[] args) {

        int[][] edges = new int[5][3];

        edges[0][0] = 0;
        edges[0][1] = 1;
        edges[0][2] = 10;

        edges[1][0] = 1;
        edges[1][1] = 2;
        edges[1][2] = 9;

        edges[2][0] = 2;
        edges[2][1] = 4;
        edges[2][2] = 2;

        edges[3][0] = 4;
        edges[3][1] = 3;
        edges[3][2] = 5;

        edges[4][0] = 3;
        edges[4][1] = 2;
        edges[4][2] = 3;
        kruskal k=new kruskal();
        int ans = k.KruskalAlgo(5, edges);
        System.out.println("The min cost is");
        System.out.println(ans);

    }
}

