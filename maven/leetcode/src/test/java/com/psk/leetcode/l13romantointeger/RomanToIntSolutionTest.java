package com.psk.leetcode.l13romantointeger;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class RomanToIntSolutionTest {

  @Test
  public void shouldAnswerWithTrue() {
    RomanToIntSolution foo = new RomanToIntSolution();
    //assertEquals(1, foo.romanToInt("I"));
    //assertEquals(3, foo.romanToInt("III"));
    //assertEquals(4, foo.romanToInt("IV"));
    //assertEquals(1994, foo.romanToInt("MCMXCIV"));
    // MM=2000
    // CD= 400
    // XXV= 25
    // But I am getting 2430
    assertEquals(2425, foo.romanToInt("MMCDXXV"));
    assertEquals(3045, foo.romanToInt("MMMXLV"));
  }
}
