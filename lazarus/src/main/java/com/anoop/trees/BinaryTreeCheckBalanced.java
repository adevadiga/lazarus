package com.anoop.trees;

/*
Implement a function to check if a binary tree is balanced. For the purposes of
this question, a balanced tree is defined to be a tree such that the heights of the two subtrees of any
node never differ by more than one.
*/
public class BinaryTreeCheckBalanced {

    boolean isBalanced(TreeNode root) {
        if (root == null)
            return false;
        int heightDiff = getHeight(root.left) - getHeight(root.right);
        if (Math.abs(heightDiff) > 1) {
            return false;
        } else {
            return isBalanced(root.left) && isBalanced(root.right);
        }
    }

    int getHeight(TreeNode root) {
        if (root == null)
            return -1;

        return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
    }
}