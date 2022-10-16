package com.company;

public class LargestRectangle {
    public static int  findmaxArea(Stack s,int arr[]){
        int area=0;
        s.push(-1);
        for(int i=0;i<arr.length;i++){
            while((s.top()!=-1) && arr[s.top()]>=arr[i]){
                int currentHeight=arr[s.pop()];
                int width=i-s.top()-1;
                area=Math.max(area,currentHeight*width);

            }
            s.push(i);


        }
        while(s.top()!=-1){
            int currentHeight=arr[s.pop()];
            int width=arr.length-s.top()-1;
            area=Math.max(area,currentHeight*width);

        }
        return area;

    }
    public static void main (String[]args){
        int arr[]={2,1,5,6,2,7};
        Stack s=new Stack();
        System.out.println(findmaxArea(s,arr));

    }
}
