package com.psk.leetcode.l264uglynumbers;

import java.util.ArrayList;

public class UglyNumbers {

  /**
   * - we'd like to know all the prime numbers for checking whether a number has one as a prime
   * factor - we can divide the number by two as ... there can't be a prime factor that's more than
   * half the number (?) - we need a getFactors() - we need a isPrime() how to do isPrime()?
   * <p>
   * 5 is prime 6 is not for i=2 to N/2 (2 for 5 and 2,3 for 6) if N % i == 0 // N is not prime
   * <p>
   * getFactors() for i=2 to N (2 for 5 and 2,3 for 6) if N % i == 0 // i is a factor
   **/

  public int nthUglyNumber(int n) {
    return doop(1, n);
  }

  private int doop(int currNum, int remainingUglies) {
    int res = -1;
    if (currNum == 1) {
      res = doop(2, remainingUglies - 1);
    } else if (currNum == 2) {
      res = doop(3, remainingUglies - 1);
    } else if (currNum == 3) {
      res = doop(4, remainingUglies - 1);
    } else {
      var factors = new ArrayList<Integer>();
      for (int i = 2; i < currNum; i++) {
        if (currNum % i == 0 && i != 2 && i != 3 && i != 5) {
          factors.add(i);
        }
      }

      boolean noGood = false;
      for (int i = 0; i < factors.size(); i++) {
        int factor = factors.get(i);
        if (isPrime(factor)) {
          noGood = true;
          break;
        }
      }

      res = doop(++currNum, noGood ? remainingUglies : remainingUglies - 1);
    }

    if (remainingUglies == 0) {
      return res;
    } else {
      return -1;
    }
  }

  private void doop2(int currNum, int remainingUglies, Integer result) {
    if (currNum == 1) {
      result = doop(2, remainingUglies - 1);
    } else if (currNum == 2) {
      result = doop(3, remainingUglies - 1);
    } else if (currNum == 3) {
      result = doop(4, remainingUglies - 1);
    } else {
      var factors = new ArrayList<Integer>();
      for (int i = 2; i < currNum; i++) {
        if (currNum % i == 0 && i != 2 && i != 3 && i != 5) {
          factors.add(i);
        }
      }

      boolean noGood = false;
      for (int i = 0; i < factors.size(); i++) {
        int factor = factors.get(i);
        if (isPrime(factor)) {
          noGood = true;
          break;
        }
      }

      result = doop(++currNum, noGood ? remainingUglies : remainingUglies - 1);
    }

  }

  private boolean isPrime(int n) {
    for (int i = 2; i < n / 2; i++) {
      if (n % i == 0) {
        return false;
      }
    }

    return true;
  }
}
