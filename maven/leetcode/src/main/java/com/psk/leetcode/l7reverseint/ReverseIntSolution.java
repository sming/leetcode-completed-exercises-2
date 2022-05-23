package com.psk.leetcode.l7reverseint;

public class ReverseIntSolution {

  /**
   * TODO this doesn't work with negative numbers and it's kind of cheating
   */
  public int reverseUsingString(int x) {
    var sb = new StringBuilder(String.valueOf(x));
    var res = sb.reverse().toString();
    try {
      return Integer.parseInt(res);
    } catch (NumberFormatException e) {
      return 0;
    }
  }

  /**
   * OK so how might we do this. Examples.
   * <p>100 1
   * <p>6 6
   * <p>102 201
   * <p>123 321
   * <p>123456789 987654321
   * <p>
   * - drop any leading zeroes - store isNegative - count numDigits (by % with increasing number of
   * exponent?)
   */
  public int reverse(int x) {
    return x;
  }

  public int reverseFucked(int x) {
    if ((-10 < x && x < 0) || x < 10) {
      return x;
    }

    boolean isNeg = x < 0;
    int num = x;
    if (isNeg) {
      num = Math.abs(num);
    }

    var numStr = String.valueOf(num);
    int actualLen = numStr.length();
    int i;
    for (i = actualLen - 1; i >= 0; i--) {
      if (numStr.charAt(i) != '0') {
        break;
      }
    }
    actualLen = i + 1;

    int res = 0;

    /*
    147 -> 741
    deal with 700 first
    need to get 7 first
    that means you % 140. so how do we do that
    OR

    741 - 147
    deal with the 1 first. how to get 1.
    1 == num % 10 * pow(10, len-1)

    deal with 40 next. how to get 40.


    741 -> 147
    OK, so try dealing with 100 first

     */
    //int derp = 0;
    //int remainder = 0;
    //int digit1, digit0 = 0;
    //for (int power = 0; power < actualLen; power++) {
    //  //remainder = (num % (int) (Math.pow(10, power))) - remainder;
    //  //derp += remainder * Math.pow(10, actualLen - power);
    //  //remainder = (int) (num % Math.pow(10, power + 1));
    //  //derp += (int) (remainder * Math.pow(10, actualLen - i - 1)) % Math.pow(10, actualLen - i);
    //  digit1 = (int) (num - (num
    //  derp += digit1;
    //  digit0 = digit1;
    //}
    //
    //if (isNeg) {
    //  derp *= -1;
    //}
    //
    //return derp;
    return res;
  }
}

