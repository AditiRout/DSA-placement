package com.company;

import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class ZigZag {
    public static List<List<Integer>> Zig(TreeNode root){

        List<List<Integer>>result=new ArrayList<>();
        List<Integer>values=new ArrayList<>();
        List<TreeNode>current=new LinkedList<TreeNode>();
        List<TreeNode>next=new LinkedList<TreeNode>();
        current.add(root);
        int flag=0;
        while(!current.isEmpty()){
            TreeNode z=current.get(0);
            current.remove(0);
            if(z.left!=null){
                next.add(z.left);
            }
            if(z.right!=null){
                next.add(z.right);
            }
            values.add(z.data);
            if(current.isEmpty()){
                current=next;
                if(flag==0){
                    result.add(values);
                    next=new ArrayList<TreeNode>();
                    values=new ArrayList<>();
                    flag=1;

                }else{
                    Collections.reverse(values);
                    result.add(values);
                    next=new ArrayList<TreeNode>();
                    values=new ArrayList<>();
                    flag=0;
                }
            }

        }
        return result;

    }

    public static boolean isIdentical(TreeNode root1,TreeNode root2){
        if(root1==null && root2==null){
            return true;
        }
        if(root1 ==null || root2==null){
            return false;
        }
        boolean equal=(root1.data== root2.data);
        boolean left=isIdentical(root1.left,root2.left);
        boolean right=isIdentical(root1.right,root2.right);
        return left && right && equal;
    }
    public static void main(String[]args){
        TreeNode root=new TreeNode(7);
        root.left=new TreeNode(9);
        root.right=new TreeNode(2);
        TreeNode z=new TreeNode(5);
        TreeNode y=new TreeNode(8);
        root.left.left=z;
        root.left.right=y;
        List<List<Integer>> res=Zig(root);
        for( int i=0;i<res.size();i++){
            for(int j=0;j<res.get(i).size();j++){
                System.out.print(res.get(i).get(j));
            }
            System.out.println();
        }

    }

}
