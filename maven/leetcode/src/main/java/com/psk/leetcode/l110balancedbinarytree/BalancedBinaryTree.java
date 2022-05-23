package com.psk.leetcode.l110balancedbinarytree;

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode
 * right; TreeNode() {} TreeNode(int val) { this.val = val; } TreeNode(int val, TreeNode left,
 * TreeNode right) { this.val = val; this.left = left; this.right = right; } }
 */
class BalancedBinaryTree {

  public boolean isBalanced(TreeNode root) {
    if (root == null) {
      return true;
    }

    int lhsHeight = 0;
    if (root.left != null) {
      lhsHeight = getHeight(root.left);
    }
    int rhsHeight = 0;
    if (root.right != null) {
      rhsHeight = getHeight(root.right);
    }

    if (Math.abs(lhsHeight - rhsHeight) > 1) {
      return false;
    }

    if (!isBalanced(root.left)) {
      return false;
    }
    return isBalanced(root.right);
  }

  private int getHeight(TreeNode node) {
    if (node == null) {
      return 0;
    }

    int lhsHeight = 0;
    if (node.left != null) {
      lhsHeight++;
      lhsHeight += getHeight(node.left);
    }
    int rhsHeight = 0;
    if (node.right != null) {
      rhsHeight++;
      rhsHeight += getHeight(node.right);
    }
    return Math.max(1, Math.max(lhsHeight, rhsHeight));
  }

  public static class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
      this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
      this.val = val;
      this.left = left;
      this.right = right;
    }
  }
}
