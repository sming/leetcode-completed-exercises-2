package com.psk.leetcode.l704binarysearch;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class BinarySearchTest {

  @Test
  public void search1() {
    var bs = new BinarySearch();
    int[] nums = {-1, 0, 3, 5, 9, 12};
    assertEquals(4, bs.search(nums, 9));
  }

  @Test
  public void search2() {
    var bs = new BinarySearch();
    int[] nums = {-1, 0, 3, 5, 9, 12};
    assertEquals(-1, bs.search(nums, 2));
  }
}