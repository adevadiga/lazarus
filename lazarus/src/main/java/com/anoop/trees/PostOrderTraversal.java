package com.anoop.trees;

/*
*Assume binary tree - left, right, parent
*/
public class PostOrderTraversal {

    void traverse(TreeNode root) {
        if (root == null) {
            return;
        }

        traverse(root.left);
        traverse(root.right);
        visit(root);
    }

    void visit(TreeNode node) {
        System.out.println(node.data);
    }
}