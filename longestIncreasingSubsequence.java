package com.company;
import java.util.Arrays;
public class longestIncreasingSubsequence {

    public int lengthOfLIS(int[] nums) {
        int []dp=new int[nums.length+1];
        Arrays.fill(dp,1);
        int n=nums.length;
        int ans=dp[0];
        for(int i=1;i<n;i++){

            for(int j=0;j<i;j++){
                if(nums[i]>nums[j]){

                    dp[i]=Math.max(dp[i],1+dp[j]);
                }
            }
            ans=Math.max(ans,dp[i]);
        }
        return ans;

    }
}
