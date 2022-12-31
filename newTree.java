package com.company;

import com.sun.source.tree.Tree;

public class newTree {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0) return null;
        return buildTree(preorder, inorder, 0, 0, inorder.length - 1);
    }

    private TreeNode buildTree(int[] preorder, int[] inorder, int preorderIndex, int start, int end) {
        if (start > end) return null;
        TreeNode node = new TreeNode(preorder[preorderIndex]);
        int inorderIndex = findInorderIndex(inorder, start, end, preorder[preorderIndex]);
        int leftTreeSize = inorderIndex - start;
        int rightTreeSize = end - inorderIndex;
        node.left = buildTree(preorder, inorder, preorderIndex + 1, start, inorderIndex - 1);
        node.right = buildTree(preorder, inorder, preorderIndex + leftTreeSize + 1, inorderIndex + 1, end);
        return node;
    }

    private int findInorderIndex(int[] inorder, int start, int end, int key) {
        for (int i = start; i <= end; i++) {
            if (inorder[i] == key) return i;
        }
        return -1;
    }
    public TreeNode buildTreefrompost(int[] inorder, int[] postorder)
    {
        return buildTree(0, inorder.length - 1, postorder.length - 1, inorder, postorder);
    }

    private TreeNode buildTree(int inStart, int inEnd, int postEnd, int[] inorder, int[] postorder)
    {
        if (inStart > inEnd || postEnd < 0) return null;
        TreeNode root = new TreeNode(postorder[postEnd]);
        int inIndex = 0;
        for (int i = inStart; i <= inEnd; i++)
        {
            if (inorder[i] == root.data)
            {
                inIndex = i;
                break;
            }
        }
        root.left = buildTree(inStart, inIndex - 1, postEnd - (inEnd - inIndex) - 1, inorder, postorder);
        root.right = buildTree(inIndex + 1, inEnd, postEnd - 1, inorder, postorder);
        return root;
    }
    //given preorder and inorder
    public static void main(String[]args){
        int[]pre={1,2,4,3,5};
        int[]inorder={4,2,1,5,3};
        TreeNode root=new TreeNode();
        newTree t=new newTree();
        root=t.buildTree(pre,inorder);

    }
}
