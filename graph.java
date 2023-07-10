package com.company;

import java.util.ArrayList;


    public class graph{
        public int V;
        public ArrayList<ArrayList<Integer>>adj_list;
        public int[]indegree;

        graph(int v){
            V=v;
            indegree=new int[V];
            adj_list=new ArrayList<ArrayList<Integer>>(v);
            for(int i=0;i<v;i++){
                adj_list.add(new ArrayList<Integer>());
            }
        }

        public void addEdge(int u,int v){
            adj_list.get(u).add(v);
            indegree[v]++;
        }

    }

