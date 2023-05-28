package com.company;

public class BST {
    //O(logn) search time complexity
    public  TreeNode createBST(TreeNode root,int val){
        if(root==null){
            return new TreeNode(val);
        }
        if(val<= root.data){
            root.left=createBST(root.left,val);
        }
        else{
            root.right=createBST(root.right,val);
        }
        return root;

    }
    public TreeNode searchBst(TreeNode root,int val){
        if(root.data==val){
            return root;
        }
        else if(root.data>=val){
            return searchBst(root.left,val);
        }
        return searchBst(root.right,val);

    }
    public TreeNode inorderSucc(TreeNode root){
        TreeNode curr=root;
        while(curr!=null && curr.left!=null){
            curr=curr.left;
        }
        return curr;
    }
    public TreeNode deleteBst(TreeNode root,int val){
        if(val<root.data){
            root.left= deleteBst(root.left,val);
        }
        else if (val>root.data){
            root.right=deleteBst(root.right,val);
        }
        else{
            if(root.left==null){
                TreeNode temp=root.right;
                return temp;

            }
            else if(root.right==null){
                TreeNode temp=root.left;
                return temp;
            }
            TreeNode temp=inorderSucc(root.right);
            root.data=temp.data;
            root.right=deleteBst(root.right,temp.data);

        }
        return root;
    }
     public TreeNode BSTfromPre(int[]preOrder,int preIndex,int max,int min,int key,int n){
        TreeNode root=new TreeNode();
        if(preIndex>=n){
            return null;
        }
        if(key>min && key<max){
            root.data=key;
            preIndex++;
            if(preIndex<n){
                root.left=BSTfromPre(preOrder,preIndex,key,min,preOrder[preIndex],n);

            }
            if(preIndex<n){
                root.right=BSTfromPre(preOrder,preIndex,max,key,preOrder[preIndex],n);
            }
        }

    return root;
    }

    public boolean checkBST(TreeNode root,TreeNode min,TreeNode max){
        if(root==null){
            return true;
        }
        if(min!=null && root.data<=min.data){
            return false;
        }
        if(max!=null && root.data>=max.data){
            return false;
        }
        boolean leftValid=checkBST(root.left,min,root);
        boolean rightValid=checkBST(root.right,root,max);
        return leftValid && rightValid;
    }

    public TreeNode buildFromSortedArray(int start,int end,int[]arr){
        if(start>=end){
            return null;
        }
        int mid=(start+end)/2;
        TreeNode root=new TreeNode(mid);
        root.left=buildFromSortedArray(start,mid-1,arr);
        root.right=buildFromSortedArray(mid+1,end,arr);
        return root;
    }
    public static void main(String[]args){}

}


