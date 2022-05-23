package com.psk.leetcode.l704binarysearch;

public class BinarySearch {

  public int search(int[] nums, int target) {
    if (nums.length == 1) {
      return nums[0] == target ? 0 : -1;
    }

    return searchImpl(nums, target, 0, nums.length - 1);
  }

  private int searchImpl(int[] nums, int target, int lowIdx, int highIdx) {
    int differential = highIdx - lowIdx;
    if (differential < 0) {
      return -1;
    }

    int midIdx = lowIdx + differential / 2;
    if (midIdx > nums.length - 1) {
      return -1;
    }

    int midVal = nums[midIdx];

    if (midVal == target) {
      return midIdx;
    } else if (midVal < target) {
      return searchImpl(nums, target, midIdx + 1, highIdx);
    } else {
      return searchImpl(nums, target, lowIdx, midIdx - 1);
    }
  }
}
