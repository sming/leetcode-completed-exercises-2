package com.psk.leetcode.l110balancedbinarytree;

import com.psk.leetcode.l110balancedbinarytree.BalancedBinaryTree.TreeNode;
import org.junit.Test;

public class BalancedBinaryTreeTest {

  /**
   * [3,9,20,null,null,15,7]
   */
  @Test
  public void isBalanced1() {
    var root = new TreeNode(3, new TreeNode(9, null, null),
        new TreeNode(20, new TreeNode(15), new TreeNode(7)));

    var balancer = new BalancedBinaryTree();
    org.junit.Assert.assertTrue(balancer.isBalanced(root));
  }
}