package com.company;

public class paintersPartitionProblem {
//consecutive min time to be allocated to complete painting
    public int minTimeToPaintBoards(int []arr,int n,int m){
        int result=0;
        int k=0;
        int sum=0;
        for(int i=0;i<arr.length;i++){
            k=Math.max(k,arr[i]);
            sum+=arr[i];
        }
        int low=k,high=sum;
        while(low<high){
            int mid=(low+high)/2;
          int painters=findFeasible(arr,mid,m);
          if(painters<=m){
              high=mid;
          }else{
              low=mid-1;
          }
        }
        return low;
    }

    public int findFeasible(int[]arr,int mid,int n){
        int sum=0,painters=1;
        for(int i=0;i<arr.length;i++){
            sum+=arr[i];
            if(sum>mid){
                sum=arr[i];
                painters++;

            }
        }
        return painters;

    }
}
