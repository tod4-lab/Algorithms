package com.hikaru.three.binartTree;
import sun.reflect.generics.tree.Tree;

import java.util.Stack;

public class PostOrderIter {
    public static void postOrderIterPrint(BinaryTree.TreeNode root) {
        if(root==null)
            return;
        Stack<BinaryTree.TreeNode> s1 = new Stack();
        Stack<BinaryTree.TreeNode> s2 = new Stack();
        s1.push(root);
        while(!s1.empty()) {
            BinaryTree.TreeNode temp = s1.pop();
            s2.push(temp);
            if(temp.left!=null)
                s1.push(temp.left);
            if(temp.right!=null)
                s1.push(temp.right);
        }
        while(!s2.empty()) {
            System.out.println(s2.pop().val);
        }
    }
}
