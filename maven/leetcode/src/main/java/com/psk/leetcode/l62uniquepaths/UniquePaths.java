package com.psk.leetcode.l62uniquepaths;

public class UniquePaths {


  /**
   * what we need is a backtracking solution that counts the successful visits to T. So, how do we
   * track a "run". Well, we just recurse, adding to a stack? but that's what the recursion is for.
   * <p>
   * So we're gonna need (x,y) construct? Maybe not.
   * <p>
   * Let's solve for the easiest case
   */
  public int uniquePaths(int m, int n) {

    int numRoutes = tryRouteWorksButTimesOut(0, 0, m, n);
    return numRoutes;
  }

  private int tryRouteWorksButTimesOut(int currX, int currY, int maxX, int maxY) {
    if (currX == maxX - 1 && currY == maxY - 1) {
      return 1;
    }

    if (currX == maxX || currY == maxY) {
      return 0;
    }

    int resX = tryRouteWorksButTimesOut(currX + 1, currY, maxX, maxY);
    int resY = tryRouteWorksButTimesOut(currX, currY + 1, maxX, maxY);

    return resX + resY;
  }

  private int tryRoute(int currX, int currY, int maxX, int maxY) {
    if (currX == maxX - 1 && currY == maxY - 1) {
      return 1;
    }

    if (currX == maxX || currY == maxY) {
      return 0;
    }

    int resX = tryRoute(currX + 1, currY, maxX, maxY);
    int resY = tryRoute(currX, currY + 1, maxX, maxY);

    return resX + resY;
  }
}
