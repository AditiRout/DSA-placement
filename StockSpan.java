package com.company;

public class StockSpan {
    public static void stockspan(int[] arr){
        int []span=new int[arr.length];
        span[0]=1;

        for(int i=1;i<arr.length;i++){
            int j=i-1;
            int ans=1;
            while(j>=0 && arr[j]<=arr[i]){
                ans++;
                j--;

            }
            span[i]=ans;

        }
        for(int k=0;k<span.length;k++){
            System.out.println(span[k]);
        }

    }
    public static void main(String[] args){
        int price[] = { 10, 4, 5, 90, 120, 80 };
        stockspan(price);

        // print the calculated span values

    }
}
