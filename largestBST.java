package com.company;

public class largestBST {
public BSTInfor largestBSTinBT(TreeNode root){
    if(root==null){
        BSTInfor z=new BSTInfor(0,Integer.MAX_VALUE,Integer.MIN_VALUE,0,true);
        return z;
    }
    if(root.left==null && root.right==null){
        BSTInfor z=new BSTInfor(1,root.data,root.data,1,true);
        return z;
    }
    BSTInfor left=largestBSTinBT(root.left);
    BSTInfor right=largestBSTinBT(root.right);
    BSTInfor curr=new BSTInfor();
    curr.size=(1+left.size+right.size);
    if(left.isBST && right.isBST && left.max<root.data && right.min>root.data){
        curr.min=Math.min(left.min,Math.min(right.min, root.data));
        curr.max=Math.max(right.max,Math.max(root.data,left.max));
        curr.ans=curr.size;
        curr.isBST=true;
        return curr;
    }
    curr.ans=Math.max(left.ans, right.ans);
    curr.isBST=false;
    return curr;
}
}
