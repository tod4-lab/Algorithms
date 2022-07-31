package com.hikaru.three;

import sun.reflect.generics.tree.Tree;

import java.util.Queue;

public class BinaryTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public void levelOrderPrint(TreeNode root) {
        TreeNode[] queue = new TreeNode[5001];
        int front = 0;
        int rear = 0;
        TreeNode p = root;
        queue[rear++] = p;
        while(rear != front) {
            TreeNode temp = queue[front++];
            System.out.println(temp.val);
            if(temp.left!=null) {
                queue[rear++] = temp.left;
            }
            if(temp.right!=null) {
                queue[rear++] = temp.right;
            }
        }
    }

    // 根据前序和中序序列构造二叉树
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length == 0)
            return null;
        TreeNode root = new TreeNode(preorder[0]);
        int rootIndex = 0;
        while (inorder[rootIndex] != preorder[0]) {
            rootIndex++;
        }
        int len1 = rootIndex;
        int len2 = preorder.length - len1 - 1;

        TreeNode leftTree = null;
        TreeNode rightTree  = null;

        int[] leftPreOrder = new int[len1];
        int[] leftInOrder = new int[len1];
        int[] rightPreOrder = new int[len2];
        int[] rightInOrder = new int[len2];

        if(len1!=0) {
            for (int i = 0; i < len1;i++) {
                leftInOrder[i] = inorder[i];
                leftPreOrder[i] = preorder[i+1];
            }
            leftTree = buildTree(leftPreOrder, leftInOrder);
        }
        if(len2!=0) {
            for (int i = 0; i < len2; i++) {
                rightInOrder[i] = inorder[i + rootIndex + 1];
                rightPreOrder[i] = preorder[i + rootIndex + 1];
            }
            rightTree = buildTree(rightPreOrder, rightInOrder);
        }
        root.left = leftTree;
        root.right = rightTree;
        return root;
    }

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        int[] preOrder = {3,9,20,15,7};
        int[] inOrder = {9,3,15,20,7};
        TreeNode root = binaryTree.buildTree(preOrder, inOrder);
        binaryTree.levelOrderPrint(root);
    }
}
