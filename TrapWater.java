package com.company;

public class TrapWater {

    public static int rain_water(Stack s,int[]a){
        int n=a.length;
        int ans=0;
        for(int i=0;i<n;i++){
            while(!s.isEmpty() && (a[s.top()]<a[i])){
                int cur=s.top();
                s.pop();
                if(s.isEmpty()){
                    break;
                }
                int diff=i-s.top()-1;
                ans+=(Math.min(a[s.top()],a[i])-a[cur])*diff;

            }
            s.push(i);
        }
        return ans;
    }
    public static void main(String[]args){
        Stack s=new Stack();
        int[]arr={0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(rain_water(s,arr));

    }
}
