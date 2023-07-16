package com.company;

public class maxCircularSubArray {
    public int maxSubarraySumCircular(int[] arr) {
        int n=arr.length;
        int maxsum1=maxsum(arr);
        if(maxsum1<0)
            return maxsum1;
        int total=0;
        for(int i=0;i<n;i++){
            total+=arr[i];
            arr[i]=-arr[i];
        }
        int maxsum2=total+maxsum(arr);
        return Math.max(maxsum1,maxsum2);
    }
    static int maxsum(int arr[]){
        int n=arr.length;
        int count=arr[0];
        int maxending=arr[0];
        for(int i=1;i<n;i++){
            maxending=Math.max(maxending+arr[i],arr[i]);
            count=Math.max(count,maxending);
        }
        return count;
    }

}
