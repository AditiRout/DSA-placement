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
    public int maxValue(int n, int index, int maxSum) {
        int left = 0, right = maxSum-n;

        while (left < right) {
            int middle = (left + right + 1) / 2;
            if (check(middle,index,n)<=maxSum-n){
                left = middle;}
            else{
                right = middle - 1;}
        }
        return left+1;
  //to find maximised value at particular index in given no.of elements and max sum

    }

    public long check(int mid,int index,int n){
        long leftIndex=Math.max(mid-index,0);
        long rightIndex=Math.max(mid-((n-1)-index),0);

        long leftSum=(mid+leftIndex)*(mid-leftIndex +1)/2;
        long rightSum=(mid+rightIndex)*(mid-rightIndex +1)/2;

        return leftSum+rightSum-mid;

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
