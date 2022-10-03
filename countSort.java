package com.company;

public class countSort {
    public static void count(int arr[],int n){
        int k=arr[0];
        for (int i=0;i<n;i++){
            k=Math.max(k,arr[i]);
        }
        int []ct=new int[10];
        for(int i=0;i<n;i++){
            ct[arr[i]]++;
        }
        for(int i=1;i<=k;i++){
            ct[i]+=ct[i-1];
        }
        int []output=new int[n];
        for(int i=n-1;i>=0;i--){
            output[--ct[arr[i]]]=arr[i];
        }
        for(int i=0;i<n;i++){
            System.out.println(output[i]);
        }

    }

    public static void main(String[] args){
        int arr[]={1,3,2,3,4,1,6,4,3};
        count(arr,arr.length);
    }
}
