package com.company;

import java.util.Arrays;

public class maxMinDist {


    boolean isFeasible(int mid,int arr[],int n,int k){
        int pos=arr[0],elements=1;
        for(int i=1;i<n;i++){
            if(arr[i]-pos>=mid){
                pos=arr[i];
                elements++;
                if(elements==k){
                    return true;
                }
            }
        }
        return false;
    }
    public int largestMinDistance(int arr[],int n,int k){
        Arrays.sort(arr);
        int res=-1;
        int left=1,right=arr[n-1];
        while(left<right){
            int mid=(left+right)/2;
            if(isFeasible(mid,arr,n,k)){
                res=Math.max(res,mid);
                left=mid+1;
            }else{
                right=mid;
            }
        }
        return res;
    }
}
