package com.psk.leetcode.l322coinchange;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

class CoinChangeTest {

  @Test
  void coinChange() {
    var coins = new int[]{1, 3, 4, 5};
    assertEquals(2, new CoinChange().coinChange(coins, 7));
  }
}