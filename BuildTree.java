package com.company;

import com.sun.source.tree.Tree;

public class BuildTree {
    public TreeNode build(int[]arr,int l,int h,TreeNode n){
        if(l<h){
            TreeNode nw=new TreeNode(arr[l]);
            n=nw;
            n.left=build(arr,2*l+1,h,n.left);
            n.right=build(arr,2*l+2,h,n.right);
        }
        return n;
    }
    public void inorder(TreeNode n){
        if(n==null){
            return ;
        }
        inorder(n.left);
        System.out.println(n.data);
        inorder(n.right);
    }

    public void preorder(TreeNode n){
        if(n==null){
            return ;
        }
        System.out.println(n.data);
        preorder(n.left);
        preorder(n.right);
    }

    public void postorder(TreeNode n){
        if(n==null){
            return ;
        }
        postorder(n.left);
        postorder(n.right);
        System.out.println(n.data);
    }

    public static void main(String[] args){
        TreeNode root=new TreeNode();
        int[]arr={1,2,3,4,5,6,7,8,9,10};
        BuildTree t=new BuildTree();
        root=t.build(arr,0,9,root);
        System.out.println("Tree is: ");

        System.out.println("Inorder is:");
        t.inorder(root);


    }
}
