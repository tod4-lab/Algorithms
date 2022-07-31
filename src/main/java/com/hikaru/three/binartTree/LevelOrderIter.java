package com.hikaru.three.binartTree;

public class LevelOrderIter {
    public static void levelOrderPrint(BinaryTree.TreeNode root) {
        BinaryTree.TreeNode[] queue = new BinaryTree.TreeNode[5001];
        int front = 0;
        int rear = 0;
        BinaryTree.TreeNode p = root;
        queue[rear++] = p;
        while(rear != front) {
            BinaryTree.TreeNode temp = queue[front++];
            System.out.println(temp.val);
            if(temp.left!=null) {
                queue[rear++] = temp.left;
            }
            if(temp.right!=null) {
                queue[rear++] = temp.right;
            }
        }
    }
}
