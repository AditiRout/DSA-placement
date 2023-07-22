package com.company;

import java.util.List;
import java.util.ArrayList;

public class bellmanFord {
    public List<Edge> edges;

    static class Edge{
        int u;
        int v;
        int w;
        Edge(int s,int d,int w){
            u=s;
            v=d;
            this.w=w;
        }
        public int getU()
        {
            return u;
        }
        public void setU(int u)
        {
            this.u = u;
        }
        public int getV()
        {
            return v;
        }
        public void setV(int v)
        {
            this.v = v;
        }
        public int getW()
        {
            return w;
        }
        public void setW(int w)
        {
            this.w = w;
        }
    }

    public void bellman(int V){
        int distance[] = new int[V]; // The output array distance[i] holds the shortest distance from source s to j

// spSet[j] will be true if vertex j is included in the shortest
// path tree or the shortest distance from the source s to j is finalized
        Boolean spSet[] = new Boolean[V];

// Initializing all of the distances as INFINITE
// and spSet[] as false
        for (int j = 1; j < V; j++)
        {
            distance[j] = Integer.MAX_VALUE;
            spSet[j] = false;
        }
//        edges = new ArrayList<Edge>();
//        for(int i=0;i<graph.length;i++){
//            for(int j=0;j<graph.length;j++){
//                if(graph[i][j]!=0){
//                    edges.add(new Edge(i,j,graph[i][j]));
//                }
//            }
//
//            }


// Distance from the source vertex to itself is always 0
        distance[1] = 0;
        for(int i = 1; i < V; i++)
        {
//iterate over edges
            for(Edge e: edges)
            {
                int u = e.getU(), v = e.getV(), w = e.getW();
                if(distance[u] != Integer.MAX_VALUE && distance[v] > distance[u] + w)
                {
//calculates distance
                    distance[v] = distance[u] + w;
                }
            }
        }
        //checks if there exist negative cycles in graph G
        for(Edge e: edges)
        {
            int u = e.getU(), v = e.getV(), w = e.getW();
            if(distance[u] != Integer.MAX_VALUE && distance[v] > distance[u] + w)
            {
                System.out.println("yes it has negative cycle");
                return;
            }
        }
        System.out.println("No negative cycle");
        System.out.println("Vertex \t: Distance");
        for(int i = 1; i < distance.length; i++)
            System.out.println("\t"+i + " " + "\t\t"+(distance[i] == Integer.MAX_VALUE ? "-" : distance[i]));
    }
    public static void main(String[]args){
        bellmanFord b=new bellmanFord();
        b.edges=new ArrayList<>(7);
        Edge e=new Edge(1,2,4);
        b.edges.add(e);
        e=new Edge(1,4,9);
        b.edges.add(e);
        e=new Edge(2,3,-1);
        b.edges.add(e);
        e=new Edge(3,6,3);
        b.edges.add(e);
        e=new Edge(4,3,2);
        b.edges.add(e);
        e=new Edge(4,5,-5);
        b.edges.add(e);
        e=new Edge(5,6,0);
        b.edges.add(e);
        b.bellman(7);

    }




}
