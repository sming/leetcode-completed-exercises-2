package com.psk.leetcode.l113pathsumtwo;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/path-sum-ii/
 * <p>
 * void pathSums(TreeNode root, List<List<Integer>> validPaths, List<Integer> currPath)
 */
public class PathSumTwo {

  public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
    var validPaths = new ArrayList<List<Integer>>();
    pathSums(root, targetSum, validPaths, new ArrayList<>());
    return validPaths;
  }

  /**
   * So the difficulty is going to be disentangling the different paths?
   *
   * @param root
   * @param targetSum
   * @param validPaths
   * @param currPath
   */
  private void pathSums(TreeNode root, int targetSum, List<List<Integer>> validPaths,
      List<Integer> currPath) {
    // So if root == null then that means that the above
    if (root == null) {
      return;
    }

    currPath.add(root.val);
    boolean hasAChild = false;
    if (root.left != null) {
      pathSums(root.left, targetSum, validPaths, currPath);
      hasAChild = true;
    }
    if (root.right != null) {
      pathSums(root.right, targetSum, validPaths, currPath);
      hasAChild = true;
    }

    if (!hasAChild) {
      // now we know that root is a leaf node
      if (sumPath(currPath) == targetSum) {
        validPaths.add(new ArrayList<>(currPath));
      }
    }

    currPath.remove(currPath.size() - 1);
  }

  private Integer sumPath(List<Integer> currPath) {
    return currPath.stream().mapToInt(x -> x).sum();
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
