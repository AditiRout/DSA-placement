package com.company;

import java.net.Inet4Address;
import java.util.HashMap;

public class SlideWindowExamples {

    void computeNumberFromArray(int []arr,int k){
        //divisible by 3;
        int sum=0;
        HashMap<Integer, Integer>h=new HashMap<>();
        for(int i=0;i<k;i++){
            sum+=arr[i];
        }
        boolean found=false;
        if(sum%3==0){
            h.put(0,k-1);
            found=true;
        }
        for(int j=k;j<arr.length;j++){
            if(found){
                break;
            }
            sum=sum+arr[j] -arr[j-k];
            if(sum%3 ==0){
                h.put(j-k+1,j);
                found=true;
            }
        }
    }

    boolean isPalindrome(int num){
        int temp=num,number=0;
        while(temp>0){
            number=number*10 +temp%10;
            temp=temp/10;

        }
        if(num==number){
            return true;
        }
        return false;
    }
    int findPalindromicSubArray(int[]arr,int k){
        int num=0;
        for(int i=0;i<k;i++){
            num=num*10 +arr[i];
        }
        if(isPalindrome(num)){
            return 0;
        }
        for(int j=k;j<arr.length;j++){
            num=(num % (int)Math.pow(10,k-1))*10 +arr[j];
            if(isPalindrome(num)){
                return j-k+1;
            }
        }
        return -1;
    }

    public boolean isPerfectNumber(int n){
        int sum=1;
        for(int i=2;i<Math.pow(n,0.5);i++){
            if(n%i ==0){
                if(i == n/i){
                    sum+=i;
                }else {
                    sum+=i +n/i;
                }
            }
        }
        if(sum ==n && n!=1){
            return true;
        }
        return false;
    }
}
