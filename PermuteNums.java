package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.*;

public class PermuteNums {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>>r=new ArrayList<>();
        boolean[]visited=new boolean[nums.length];
        if(nums.length==0 ||nums==null){
            r.add((List<Integer>) new LinkedList());
        }
        List<Integer>k= (List<Integer>) new LinkedList();
        perm(r,visited,nums,k);
        return r;
    }
    public void perm(List<List<Integer>>l,boolean[]visited,int[]nums,List<Integer>k){
        if(k.size()==nums.length){
            l.add(new LinkedList<>(k));
        }
        for(int i=0;i<nums.length;i++){
            if(visited[i])continue;
            visited[i]=true;
            k.add(nums[i]);
            perm(l,visited,nums,k);
            k.remove(k.size()-1);
            visited[i]=false;
        }

    }





}
