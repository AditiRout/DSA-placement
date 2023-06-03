package com.company;

public class redundantBraces {
    public static boolean check(String str,Stack s){
        boolean ans=false;
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)=='+' || str.charAt(i)=='-' || str.charAt(i)=='*' || str.charAt(i)=='/'){
                s.push(str.charAt(i));
            }
            else if(str.charAt(i)=='('){
                s.push(str.charAt(i));
            }
            else if(str.charAt(i)==')'){
                if(s.top()=='('){
                    ans=true;
                }
                while(s.top()=='+' || s.top()=='-'||s.top()=='/'||s.top()=='*'){
                    s.pop();
                }
                s.pop();
            }
        }
        return ans;

    }
    public static void main (String[]args){
        String s="((a+b))";
        Stack str=new Stack();
        System.out.println(check(s,str));
    }
}
