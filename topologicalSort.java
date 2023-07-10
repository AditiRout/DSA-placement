package com.company;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Stack;
public class topologicalSort {


    public static List<Integer> topo(graph s){
        List<Integer> L=new ArrayList<>();
        Stack <Integer>res=new Stack<>();
        for(int i=0;i<s.V;i++){
            if(s.indegree[i]==0){
                res.add(i);
            }
        }
        while(!res.isEmpty()){
            int i=res.pop();
            L.add(i);
            for(int m:s.adj_list.get(i)){
                s.indegree[m]--;
                if(s.indegree[m]==0){
                    res.add(m);
                }
            }
        }
        for(int i=0;i<s.V;i++){
            if(s.indegree[i]!=0){
                return null;
            }
        }
        return L;

    }

    public static void main(String[]args){
        graph g=new graph(8);
        g.addEdge(0,6);
        g.addEdge(1,2);
        g.addEdge(1,4);
        g.addEdge(1,6);
        g.addEdge(3,0);
        g.addEdge(3,4);
        g.addEdge(5,1);
        g.addEdge(7,0);
        g.addEdge(7,1);

        List<Integer>L=topo(g);
        for(int i=0;i<L.size();i++){
            System.out.println(L.get(i));
        }


    }
}
