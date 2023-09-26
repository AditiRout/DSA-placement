package com.company;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class longestConsecutivbe {
    public int longestConsecutive(List<Integer>nums) {
        HashSet<Integer> h = new HashSet<>();
        int max=0,longest=0,ans=0;
        for(Integer i:nums) h.add(i);
        for(int i:h){
            if(!h.contains(i-1)){
                max=1;
                longest=i;
                while(h.contains(longest+1)){
                    max+=1; longest+=1;
                }
            }
            ans=Math.max(ans,max);
        }
        return ans;



    }
}
