package com.company;

public class maxConsecutive {

    public int findMaxConsecutiveOnes(int[] nums) {
        int curCount = 0; int max = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 1){
                curCount++;
                max = max > curCount ? max : curCount;
            }else{
                curCount = 0;
            }
        }
        return max;

    }
}
