package com.anoop.trees;

/*
*Assume binary tree - parent, left, right
*/
public class PreOrderTraversal {

    void traverse(TreeNode root) {
        if (root == null) {
            return;
        }

        visit(root);
        traverse(root.left);
        traverse(root.right);
    }

    void visit(TreeNode node) {
        System.out.println(node.data);
    }
}