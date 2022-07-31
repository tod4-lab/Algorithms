package com.hikaru.three.binartTree;

import sun.reflect.generics.tree.Tree;

import java.util.Stack;

public class InorderIter {
    public static void inorderIterPrint(BinaryTree.TreeNode root) {
        Stack<BinaryTree.TreeNode> s = new Stack<>();
        while(root!=null) {
            s.push(root);
            root = root.left;
        }
        while(!s.empty()) {
            BinaryTree.TreeNode node = s.pop();
            System.out.println(node.val);
            BinaryTree.TreeNode temp = node.right;
            while(temp!=null) {
                s.push(temp);
                temp = temp.left;
            }
        }
    }
}
