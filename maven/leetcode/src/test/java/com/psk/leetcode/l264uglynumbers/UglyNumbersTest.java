package com.psk.leetcode.l264uglynumbers;

import junit.framework.TestCase;

public class UglyNumbersTest extends TestCase {

  public void testNthUglyNumber() {
    var ugly = new UglyNumbers();
    assertEquals(12, ugly.nthUglyNumber(10));
  }
}