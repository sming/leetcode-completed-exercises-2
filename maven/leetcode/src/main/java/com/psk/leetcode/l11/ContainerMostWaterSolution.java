package com.psk.leetcode.l11;

import java.util.ArrayList;

/*
https://leetcode.com/problems/container-with-most-water/
11. Container With Most Water
Medium

16425

930

Add to List

Share
You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).

Find two lines that together with the x-axis form a container, such that the container contains the most water.

Return the maximum amount of water a container can store.

Notice that you may not slant the container.


Input: height = [1,8,6,2,5,4,8,3,7]
Output: 49
Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.




                            |              |
                            |              |
                            |              |
    |-----------------------|----------|   |
    |                       |          |   |
    |           |           |          |   |
    |           |           |          |   |
|   |           |           |          |   |
------------------------------------------------------

Constraints:

n == length
2 <= n <= 105
0 <= height[i] <= 104
 */
public class ContainerMostWaterSolution {

  public int maxArea(int[] height) {
    if (height == null || height.length == 0) {
      return 0;
    }

    int length = height.length;

    if (length == 2) {
      return Math.min(height[0], height[1]);
    }

    int maxVol = -1;
    int maxLhs = -1;
    int maxRhs = -1;
    var maxLhsIdxs = new ArrayList<Integer>();
    var maxRhsIdxs = new ArrayList<Integer>();

    for (int i = 0; i < length; i++) {
      int lhsHeight = height[i];

      if (lhsHeight > maxLhs) {
        maxLhsIdxs.add(i);
        maxLhs = lhsHeight;
      }
    }

    for (int j = length - 1; j >= 0; j--) {
      int rhsHeight = height[j];

      if (rhsHeight > maxRhs) {
        maxRhsIdxs.add(j);
        maxRhs = rhsHeight;
      }
    }

    for (Integer lIdx : maxLhsIdxs) {
      int lhsHeight = height[lIdx];

      for (Integer rIdx : maxRhsIdxs) {
        int rhsHeight = height[rIdx];

        int vol = Math.min(lhsHeight, rhsHeight) * (rIdx - lIdx);
        if (vol > maxVol) {
          maxVol = vol;
        }
      }
    }

    return maxVol;
  }
}

/*
  public int maxAreav2(int[] height) {
    if (height == null || length == 0) {
      return 0;
    }

    if (length == 2) {
      return Math.min(height[0], height[1]);
    }

    int maxVol = -1;
    int maxLhs = -1;
    int maxRhs = -1;
    var maxLhsIdxs = new ArrayList<Integer>();
    var maxRhsIdxs = new ArrayList<Integer>();

    var halfway = length / 2;
    for (int i = 0; i <= halfway; i++) {
      int lhsHeight = height[i];

      if (lhsHeight > maxLhs) {
        maxLhsIdxs.add(i);
        maxLhs = lhsHeight;
      }
    }

    for (int j = length - 1; j > halfway; j--) {
      int rhsHeight = height[j];

      if (rhsHeight > maxRhs) {
        maxRhsIdxs.add(j);
        maxRhs = rhsHeight;
      }
    }

    for (Integer lIdx : maxLhsIdxs) {
      int lhsHeight = height[lIdx];

      for (Integer rIdx : maxRhsIdxs) {
        int rhsHeight = height[rIdx];

        int vol = Math.min(lhsHeight, rhsHeight) * (rIdx - lIdx);
        if (vol > maxVol) {
          maxVol = vol;
        }
      }
    }

    return maxVol;
  }
}
 */
/*

  public int maxAreaV1(int[] height) {
    if (height == null || length == 0) {
      return 0;
    }
    int maxPoolVolume = -1;
    for (int i = 0; i < length; i++) {
      int lhsHeight = height[i];
      for (int j = i + 1; j < length; j++) {
        int rhsHeight = height[j];

        int poolHeight = Math.min(lhsHeight, rhsHeight);
        int poolLength = j - i;
        int poolVolume = poolHeight * poolLength;
        if (poolVolume > maxPoolVolume) {
          maxPoolVolume = poolVolume;
        }
      }
    }

    return maxPoolVolume;
  }
 */