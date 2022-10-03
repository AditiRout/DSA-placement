package com.company;

public class longestCommonPrefix {
    public static String common(String[] strs){
        String prefix=strs[0];
        int n=strs.length;
        for(int i=0;i<n;i++){
            while(!strs[i].startsWith(prefix)){
                prefix=prefix.substring(0,prefix.length()-1);
                if(prefix.length()==0) return "";

            }
        }
        return prefix;
    }
    public static void main(String[]args){

    }
}
