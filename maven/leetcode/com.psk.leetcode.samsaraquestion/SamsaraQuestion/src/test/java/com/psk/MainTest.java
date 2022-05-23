package com.psk;

import junit.framework.TestCase;

public class MainTest extends TestCase {

  public void testMain() {
    String input = "This is a paragraph with a soft\n"
        + "line break.\n\n"
        + "This is another paragraph that has\n";

    Main.main(input);
  }
}