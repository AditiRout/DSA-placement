package com.company;


public class SubArray {
    public static void sum(int[]n,int target){
        int st=-1,en=-1,i=0,j=0,sum=0;
        while(j<n.length && sum+n[j]>=target){
            sum+=n[j];
            j++;
        }
        if(sum==target) {
            System.out.println("start: " + i + "end: " + j);
        }
        while(j<n.length){
            sum+=n[j];
            if(sum==target){
                st=i+1;
                en=j+1;
                break;
            }
            if(sum>target){
                sum-=n[i];
                i++;
            }
            j++;
        }
        System.out.println("start:"+st+"end:"+en);}

    public static void main(String[] args){
    int []n={1,2,3,4,5,6,7};
    int t=6;
    sum(n,t);



    }

    public static class MaxArray {
        public int maxProduct(int[] nums) {

            if (nums.length == 0) return 0;

            int res = nums[0];

            for (int i = 0; i < nums.length; i++)
            {

                int product = 1;

                for (int j = i; j < nums.length; j++)
                {
                    product *= nums[j];
                    res = Math.max(res, product);
                }
            }
            return res;


        }
        public int maxSum(int []nums){
            int ans=nums[0];
            int res=nums[0];
            for(int i=0;i<nums.length;i++){
                ans=Math.max(nums[i],ans+nums[i]);
                res=Math.max(res,ans);
            }
            return res;
        }
        public static void main(String[] args){

            MaxArray m=new MaxArray();
            int[] h={1,6,3,4,5,8};
            System.out.println(m.maxSum(h));
            int []k={-1,2,5,7};
            System.out.println(m.maxProduct(k));

    }}
}
