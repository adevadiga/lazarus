package com.anoop.trees;

/*
Validate BST: Implement a function to check if a binary tree is a binary search tree.
*/

public class BSTCheckBinarySearchTree {

    boolean isBST(TreeNode root) {
        if (root.left == null && root.right == null) {
            return true;
        }

        if (root.left.data < root.data && root.data < root.right.data) {
            return isBST(root.left) && isBST(root.right);
        }
        return false;
    }
}