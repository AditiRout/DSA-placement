package com.company;

import java.util.Arrays;

public class bipartite {
    public static int color[];
    //aleternate color nodes
    boolean bipartite;
    public void colorNodes(int u,int curr,graph g,boolean[]visited){
        if(color[u]!=-1 && color[u]!=curr){
            bipartite = false;
            return;
        }
        color[u]=curr;
        System.out.println(u);
        if(visited[u]){
            return;
        }
        visited[u]=true;
        for(int i:g.adj_list.get(u)){
            if(!visited[i]){

                colorNodes(i,curr^1,g,visited);
            }
        }

    }

    public static void main(String[]args){
        graph g=new graph(4);
        g.addEdge(3,3);
        g.addEdge(0,1);
        g.addEdge(1,2);
        g.addEdge(2,0);
        boolean[]visited=new boolean[4];
        color=new int[4];
        Arrays.fill(color,-1);
        bipartite b=new bipartite();
        b.colorNodes(0,0,g,visited);
        System.out.println(b.bipartite);

    }
}
