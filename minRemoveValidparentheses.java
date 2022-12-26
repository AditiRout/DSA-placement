package com.company;

public class minRemoveValidparentheses {
    public String minRemoveToMakeValid(String s) {
        StringBuffer sb=new StringBuffer(s);
        Stack right=new Stack();
        Stack left=new Stack();
        //left to right
        for(int i=0;i<sb.length() ;i++){
            char c= sb.charAt(i);
            if(c!='(' && c!=')'){
                continue;
            }
            if(c=='('){
                right.push(')');
            }
            else{
                if(c==')'){
                    if (right.isEmpty()){
                        sb.deleteCharAt(i);
                        i--;


                    }
                    else{
                        right.pop();
                    }
                }
            }
        }

        //right to left
        for(int i=sb.length()-1;i>=0;i--){
            char c=sb.charAt(i);
            if(c!='(' && c!=')'){
                continue;
            }
            if(c==')'){
                left.push('(');
            }
            else{
                if(c=='('){
                    if (left.isEmpty()){
                        sb.deleteCharAt(i);
                    }
                    else{
                        left.pop();
                    }
                }
            }
        }
        return sb.toString();

    }
}
