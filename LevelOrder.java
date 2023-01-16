package com.company;
import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LevelOrder {
    public List<List<Integer>> order (TreeNode root){
        List<List<Integer>>result=new ArrayList<>();
        List<Integer>values=new ArrayList<>();
        List<TreeNode>current=new LinkedList<TreeNode>();
        List<TreeNode>next=new LinkedList<TreeNode>();
        current.add(root);
        while(!current.isEmpty()){
            TreeNode t=current.get(0);
            current.remove(0);
            if(t.left!=null){
                next.add(t.left);

            }
            if(t.right!=null){
                next.add(t.right);
            }
            values.add(t.data);
          if(current.isEmpty()){
              current=next;
              next=new LinkedList<TreeNode>();
              result.add(values);
              values=new ArrayList<>();

          }

        }
        return result;
    }
    public int minDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        if(root.left == null && root.right==null){
            return 1;}
        if(root.left==null || root.right==null){
            return 1+Math.max(minDepth(root.left),minDepth(root.right));
        }
        return 1+Math.min(minDepth(root.left),minDepth(root.right));

    }
    public int countNodes(TreeNode root){
        if(root==null){
            return 0;
        }
        return countNodes(root.left)+countNodes(root.right)+1;
    }
    public int totalDataSum(TreeNode root){
        if(root==null){
            return 0;
        }
        return totalDataSum(root.left)+totalDataSum(root.right)+root.data;
    }
    public int maxDepth(TreeNode root) {
        if(root==null) return 0;
        else return 1+Math.max(maxDepth(root.left),maxDepth(root.right));

    }
    public int height(TreeNode root){
        if(root==null){
            return 0;
        }
        return Math.max(height(root.left),height(root.right))+1;
    }
    public int calDiameter(TreeNode root){
        if(root==null)return 0;
        int leftcal=height(root.left);
        int rightcal=height(root.right);
        int currDia=leftcal+rightcal;
        int lDiameter=calDiameter(root.left);
        int rDiameter=calDiameter(root.right);
        return Math.max(currDia,Math.max(lDiameter,rDiameter));
    }

    public TreeNode sumReplace(TreeNode root){
        if(root==null){
            return root;
        }
        root.left=sumReplace(root.left);
        root.right=sumReplace(root.right);
        if(root.left!=null){
            root.data+=root.left.data;
        }
        if(root.right!=null){
            root.data+=root.right.data;
        }
        return root;

    }
    public boolean isBalanced(TreeNode root) {
        if (root==null){
            return true;
        }
        if(isBalanced(root.left)==false){
            return false;
        }
        if(isBalanced(root.right)==false){
            return false;
        }
        int lh=height(root.left);
        int rh=height(root.right);
        if(Math.abs(lh-rh)<=1){
            return true;
        }
        return false;
    }
    //right view and left view
    public List<Integer>  rightView(TreeNode root){
        List<Integer> result = new ArrayList<>();
        if(root == null) return result;
        traverseThisNode(root, result, 1);
        return result;
    }
    public static void traverseThisNode(TreeNode root, List<Integer> result, int currentDepth){
        if (root==null)return;
        if(currentDepth>result.size()){
            result.add(root.data);
        }
        traverseThisNode(root.right, result, currentDepth+1);
        traverseThisNode(root.left, result, currentDepth+1);
    }
    public TreeNode LCA(TreeNode root,int n1,int n2){
        if(root==null){
            return null;
        }
        if(root.data==n1 || root.data==n2){
            return root;
        }
        TreeNode left=LCA(root.left,n1,n2);
        TreeNode right=LCA(root.right,n1,n2);
        if(left!=null && right!=null){
            return root;
        }
        if(left==null && right==null){
            return null;
        }
        if(left!=null){
            return LCA(root.left, n1, n2);
        }
        return LCA(root.right,n1,n2);

    }
    public int findDist(TreeNode root,int k,int dist){
        if(root==null){
            return -1;
        }
        if(root.data==k){
            return dist;
        }
        int left=findDist(root.left, k, dist+1);
        if(left!=-1){
            return left;
        }
        return findDist(root.right,k,dist+1);
    }
    int distbtwNodes(TreeNode root,int n1,int n2){
        TreeNode lca=LCA(root,n1,n2);

        int d1=findDist(lca,n1,0);
        int d2=findDist(lca,n2,0);
        return d1+d2;
    }

   

}
