package com.hikaru.three.binartTree;

import java.util.Stack;

public class PreOrderIter {
    public static void preOrderIterPrint(BinaryTree.TreeNode root) {
        if(root == null)
            return;
        Stack<BinaryTree.TreeNode> s = new Stack<>();
        s.push(root);
        while(!s.empty()) {
            BinaryTree.TreeNode temp = s.pop();
            System.out.println(temp.val);
            if(temp.right!=null) {
                s.push(temp.right);
            }
            if(temp.left!=null) {
                s.push(temp.left);
            }
        }
    }
}
