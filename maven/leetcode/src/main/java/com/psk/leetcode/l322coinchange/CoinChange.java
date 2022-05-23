package com.psk.leetcode.l322coinchange;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * So, inspired by "Coin Change - Dynamic Programming Bottom Up - Leetcode 322"
 * (https://www.youtube.com/watch?v=H9bfqozjoqs), am going to try bottom-up DP.
 */
public class CoinChange {

  /**
   * Here we'll try the solution from https://leetcode.com/problems/coin-change/solution/ itself
   */
  public int coinChange(int[] coins, int amount) {
    if (amount < 1) {
      return 0;
    }
    var dp = new int[amount];
    return coinChangeImpl(coins, amount, dp);
  }

  private int coinChangeImpl(int[] coins, int amount, int[] dp) {
    if (amount < 0) {
      return -1;
    }
    if (amount == 0) {
      return 0;
    }
    int preCalculated = dp[amount - 1];
    if (preCalculated != 0) {
      return preCalculated;
    }

    int min = Integer.MAX_VALUE;
    for (int coin : coins) {
      int result = coinChangeImpl(coins, amount - coin, dp);
      if (result >= 0 && result < min) {
        min = 1 + result;
      }
    }

    dp[amount - 1] = min == Integer.MAX_VALUE ? -1 : min;
    return dp[amount - 1];
  }

  @Deprecated
  public int coinChangeFromYouTubeFails(int[] coins, int amount) {
    if (coins == null || coins.length == 0) {
      return -1;
    }

    // This will hold the DP value for range 0...amount.
    var dp = IntStream.range(0, amount + 1).map(i -> amount + 1).toArray();

    dp[0] = 0;

    var sortedCoins = Arrays.stream(coins).sorted().toArray();

    // Calc DP for each value up to amount
    for (int i = 1; i <= amount; i++) {
      for (int coin : sortedCoins) {
        int remainder = amount - coin;
        if (remainder >= 0) {
          dp[i] = Math.min(dp[i], 1 + dp[remainder]);
        }

      }
    }

    return dp[amount] != amount + 1 ? dp[amount] : -1;
  }
}
