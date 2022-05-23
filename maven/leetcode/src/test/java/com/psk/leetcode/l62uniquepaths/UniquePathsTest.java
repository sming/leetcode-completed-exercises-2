package com.psk.leetcode.l62uniquepaths;

import org.junit.Test;

public class UniquePathsTest {

  @Test
  public void uniquePaths() {
    var up = new UniquePaths();
    org.junit.Assert.assertEquals(3, up.uniquePaths(3, 2));
  }
}