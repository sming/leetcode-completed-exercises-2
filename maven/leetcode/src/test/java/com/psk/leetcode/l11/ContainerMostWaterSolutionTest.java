package com.psk.leetcode.l11;

import org.junit.Assert;
import org.junit.Test;

public class ContainerMostWaterSolutionTest {

  @Test
  public void shouldAnswerWithTrue() {
    var sol = new ContainerMostWaterSolution();
    //Assert.assertEquals(49, sol.maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
    //Assert.assertEquals(1, sol.maxArea(new int[]{1, 1}));
    /*
        |
        ||
        ||
        ||
        ||
        |||
       ||||
      |||||
     ||||||
    |||||||
    |||||||
    -----------------------------------------------
     */
    Assert.assertEquals(17, sol.maxArea(new int[]{2, 3, 4, 5, 18, 17, 6}));
  }
}