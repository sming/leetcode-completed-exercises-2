package com.psk.leetcode.l113pathsumtwo;

import com.psk.leetcode.l113pathsumtwo.PathSumTwo.TreeNode;

class PathSumTwoTest {

  @org.junit.jupiter.api.Test
  void pathSum() {
    TreeNode root = new TreeNode(5,
        new TreeNode(4,
            new TreeNode(11,
                new TreeNode(7), new TreeNode(2)),
            null),
        new TreeNode(8,
            new TreeNode(13),
            new TreeNode(4, new TreeNode(5), new TreeNode(1))));

    var summer = new PathSumTwo();
    var res = summer.pathSum(root, 22);
    System.out.println(res);
  }
}