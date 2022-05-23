package com.psk.leetcode.l22generateparen;

import java.util.stream.Stream;
import junit.framework.TestCase;

public class GenerateParenSolutionTest extends TestCase {

  public void testGenerateParenthesis() {
    var s = new GenerateParenSolution();
    System.out.println(s.generateParenthesis(5));
  }

  public void testStreams() {
    var foo = Stream.of(1, 2, 3, 4, 5).filter(x -> x > 2);

    foo.forEach(System.out::println);
  }
}