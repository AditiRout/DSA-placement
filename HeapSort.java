package com.company;

public class HeapSort {

    public void heapify(int[]arr,int n,int i){
        int largest=i;
        int left=2*i +1;
        int right =2*i +2;
        if(left<n && arr[left]>arr[largest]){
            largest=left;
        }
        if(right<n && arr[right]>arr[largest]){
            largest=right;
        }
        if(largest !=i){
            int temp=arr[i];
            arr[i]=arr[largest];
            arr[largest]=arr[i];
            heapify(arr,n,largest);
        }
    }

    public void heapSort(int arr[],int n){
        for(int i=n/2 -1;i>=0;i--){
            heapify(arr,n,i);
        }
        for(int i=n-1;i>=0;i--){
            int temp=arr[0];
            arr[0]=arr[i];
            arr[i]=temp;
            heapify(arr,i,0);
        }
    }
}
