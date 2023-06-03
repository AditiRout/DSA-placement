package com.company;

public class allocateMinPages {
    //n no. of pages in n different books
    //m -no.of students

    public int allocateMinimumPages(int arr[],int n,int m){
        //pages given in sorted order
        int sum=0;
        if(n<m) {
            return -1;
        }
        for(int i=0;i<n;i++){
            sum+=arr[i];
        }
        int start=0,end=sum,ans=Integer.MAX_VALUE;
        while(start<end){
            int mid=(start+end)/2;
            if(isPossible(arr,mid,n,m)){
                ans=Math.min(ans,mid);
                end=mid-1;

            }else {
                start=mid+1;
            }
        }
        return ans;
    }
    public boolean isPossible(int[]arr,int mid,int n,int m){
        int students=1,sum=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]>mid){
                return false;

            }
            if(sum+arr[i]>mid){
                sum=arr[i];
                students++;
                if(students>m){
                    return false;
                }
            }else{
                sum+=arr[i];
            }


        }
        return true;

    }
}
