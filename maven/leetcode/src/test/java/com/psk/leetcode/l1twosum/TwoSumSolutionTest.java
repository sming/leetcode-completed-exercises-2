package com.psk.leetcode.l1twosum;

import java.util.Arrays;
import junit.framework.TestCase;

public class TwoSumSolutionTest extends TestCase {

  public void testFuckMyLife() {
    var s = new TwoSumSolution();
    var res = s.twoSum(new int[]{2, 7, 11, 15}, 9);
    System.out.println("Res:" + Arrays.toString(res));

    assertEquals(0, res[0]);
    assertEquals(1, res[1]);
    res = s.twoSum(new int[]{3, 2, 4,}, 6);
    System.out.println("Res:" + Arrays.toString(res));

    assertEquals(1, res[0]);
    assertEquals(2, res[1]);
  }
}