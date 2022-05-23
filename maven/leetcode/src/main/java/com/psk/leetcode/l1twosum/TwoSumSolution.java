package com.psk.leetcode.l1twosum;

public class TwoSumSolution {

  public int[] twoSum(int[] nums, int target) {

    return findPair(nums, 0, 1, target);
  }

  private int[] findPair(int[] nums, int i, int j, int target) {
    if (nums[i] + nums[j] == target) {
      return new int[]{i, j};
    }

    if (j + 1 < nums.length && nums[i] < target) {
      var res = findPair(nums, i, j + 1, target);
      if (res != null) {
        return res;
      }

    }

    if (i + i < nums.length && nums[j] < target) {
      return findPair(nums, i + 1, j, target);
    }

    return null;
  }
}
