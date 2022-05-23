package com.psk.leetcode.l13romantointeger;

import java.util.HashMap;
import java.util.Map;

class RomanToIntSolution {

  private static final Map<Character, Integer> numeralToDecimal = new HashMap<>();

  public RomanToIntSolution() {
    numeralToDecimal.put('I', 1);
    numeralToDecimal.put('V', 5);
    numeralToDecimal.put('X', 10);
    numeralToDecimal.put('L', 50);
    numeralToDecimal.put('C', 100);
    numeralToDecimal.put('D', 500);
    numeralToDecimal.put('M', 1000);
  }

  public int romanToInt(String s) {
    int runningTotal = 0;
    for (int i = 0; i < s.length(); i++) {
      char currNumeral = s.charAt(i);

      switch (currNumeral) {
        case 'V':
        case 'L':
        case 'D':
        case 'M':
          runningTotal += numeralToDecimal.get(currNumeral);
          break;
        default:
          // so we know it's one of I,X,C. We need to look at the next
          // char
          if (i + 1 <= s.length() - 1) {
            char nextNumeral = s.charAt(i + 1);

            if (currNumeral == 'I') {
              if (nextNumeral == 'V') {
                runningTotal += 4;
                i++;
              } else if (nextNumeral == 'X') {
                runningTotal += 9;
                i++;
              } else {
                runningTotal += 1;
              }
            } else if (currNumeral == 'X') {
              if (nextNumeral == 'L') {
                runningTotal += 40;
                i++;
              } else if (nextNumeral == 'C') {
                runningTotal += 90;
                i++;
              } else {
                runningTotal += 10;
              }
            } else if (currNumeral == 'C') {
              if (nextNumeral == 'D') {
                runningTotal += 400;
                i++;
              } else if (nextNumeral == 'M') {
                runningTotal += 900;
                i++;
              } else {
                runningTotal += 100;
              }
            }
          } else {
            runningTotal += numeralToDecimal.get(currNumeral);
          }
      }

    }
    return runningTotal;
  }
}

