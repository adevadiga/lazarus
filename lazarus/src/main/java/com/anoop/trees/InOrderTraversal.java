package com.anoop.trees;

/*
*Assume binary tree - left, parent, right
*/
public class InOrderTraversal {

    void traverse(TreeNode root) {
        if (root == null) {
            return;
        }

        traverse(root.left);
        visit(root);
        traverse(root.right);
    }

    void visit(TreeNode node) {
        System.out.println(node.data);
    }
}