package com.psk.leetcode.l7reverseint;

import junit.framework.TestCase;

public class ReverseIntSolutionTest extends TestCase {

  public void testReverse() {
    var s = new ReverseIntSolution();
    assertEquals(123, s.reverse(321));
  }
}