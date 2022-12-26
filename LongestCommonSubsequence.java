package com.company;

public class LongestCommonSubsequence {
    public static int len(char[] s,char [] b,int m,int n){
        if(m==0 || n==0){
            return 0;
        }
        else if(s[m]==b[n]){
            return 1+len(s,b,m-1,n-1);
        }
        else{
            return Math.max(len(s,b,m-1,n),len(s,b,m,n-1));
        }}

       /* public int longestCommonSubsequence(String text1, String text2) {
            char[] chars1 = text1.toCharArray();
            char[] chars2 = text2.toCharArray();
            int[][] dp = new int[chars1.length + 1][chars2.length + 1];
            for (int i = 0; i < chars1.length; i++) {
                for (int j = 0; j < chars2.length; j++)
                    dp[i+1][j+1] = chars1[i] == chars2[j]? dp[i][j] + 1 : Math.max(dp[i][j+1], dp[i+1][j]);
            }
            return dp[chars1.length][chars2.length];
        }*/

    public static void main(String[]args){
        String s1 = "abc";
        String s2 = "def";

        char[] X=s1.toCharArray();
        char[] Y=s2.toCharArray();
        int m = X.length;
        int n = Y.length;


        System.out.println(len( X, Y, m-1, n-1 )) ;
    }
}
