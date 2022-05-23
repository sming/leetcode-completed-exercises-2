package com.psk.leetcode.l983mincostfortickets;

import java.util.Arrays;
import java.util.HashMap;

/**
 * See <a href="https://leetcode.com/problems/minimum-cost-for-tickets/">Min Cost For Tickets</a>
 * <p>
 * <ul>
 * <li>a 1-day pass is sold for costs[0] dollars,</li>
 * <li>a 7-day pass is sold for costs[1] dollars, and a</li>
 * <li>30-day pass is sold for costs[2] dollars.</li>
 * </ul>
 * <p></p>
 * The passes allow that many days of consecutive travel.
 * <p></p>
 * For example, if we get a 7-day pass on day 2, then we can travel for 7 days: 2, 3, 4, 5, 6, 7,
 * and 8. Return the minimum number of dollars you need to travel every day in the given list of
 * days.
 */
public class MinCostForTickets {

  /**
   * Return the minimum number of dollars you need to travel every day in the given list of days.
   */
  public int mincostTickets(int[] days, int[] costs) {
    if (days == null || days.length == 0 || costs == null || costs.length == 0) {
      return -1;
    }

    var d = new HashMap<Integer, Boolean>();
    for (var day : days) {
      d.put(day, false);
    }

    var sortedCosts = Arrays.stream(costs).sorted().toArray();
    var sortedDays = Arrays.stream(days).sorted().toArray();

    int maxDay = sortedDays[sortedDays.length - 1];
    int minDay = sortedDays[0];
    int span = maxDay - minDay;

    /* How do we get the recurrence relation?
    Bottom-up ———————
    So, if it's 1 day, then we know that it must be costs[0] (1 day).

    Top-down ———————
    To know the min cost for travelling day T, we'd need to know the previous 6 days
    and the next 6 days (to consider a 7 day pass).
    So we need to look 6 days ahead and behind.
    Let's try to look 1 day behind/ahead.
    Wait, do we need to consider ahead AND behind? Surely we just want to look ahead, right?
    So if T+1 is a travelling day,
    */
  }

}
