package com.psk.leetcode.l5longestpalindromicstring;

public class LongestPalindromicStringSolution {

  /**
   * so, what is a palindrom? - a word that reads the same forwards as backwards. how can that fact
   * help us? we could look for mirror points, before which the string reads 'backwards' and
   * afterwhich the same string reads forwards can we do a binary search? just plump down and try to
   * improve? remember that in a long string, there may be many palindromes could it be that we
   * "build up", accruing letters, and at the same time "build down", and see if that's a
   * palindrome? actually, as we build up, we can nip ahead and check to see if it's a palindrome
   * <p>
   * <p>
   * hmm. however, just cos it isn't, doesn't mean that it's not part of a bigger palindrome,
   * right?
   * <p>
   * <p>
   * wait. we know a palindrome must have double letters, right? so if we've seen abc and there's no
   * 'other' abc in the string, then we know we can skip abc, right?
   * <p>
   * <p>
   * how about we creep down the string, looking forwards and backwards, for both an even-length'd
   * and an odd-length'd palindrome centered on the current char?
   * <p>
   * OK so how do we define an odd palindrome for index i of string s, len n? i = 0 lp = s[i] while
   * i < n maxPotLen = max(i - 0, n -i) while j < maxPotLen if s[i-j] == s[i+j] lp = s[i-j] + lp +
   * s[i-j]
   * <p>
   * abcba abccba
   * <p>
   * OK, how about an even pally? we identify those by the next char being the same as this char i =
   * 0 lp = s[i] while i < n maxPotLen = max(i - 0, n -i) while j < maxPotLen if s[i-j] == s[i+j+1]
   * lp = s[i-j] + lp + s[i-j]
   */
  public String longestPalindrome(String s) {
    var longest = "";

    var currStr = "";
    for (int i = 0; i < s.length(); i++) {
      var curr = new StringBuilder();
      currStr = s.substring(i);
      for (var b : currStr.getBytes()) {
        char c = (char) b;

        curr.append(c);
        if (isPally(curr) && curr.length() > longest.length()) {
          longest = curr.toString();
        }
      }
    }

    return longest;

  }

  /**
   * so if len = 5, mid = 2 and we basically ignore char 3 and compare lhs and rhs if len = 6, mid =
   * 3 and we include char 3 in the lhs
   */
  private boolean isPally(StringBuilder s) {
    if (s.length() < 2) {
      return true;
    }

    var str = s.toString();
    int midIdx = (s.length() / 2);

    var rhs = "";

    if (str.length() % 2 == 0) { // even
      rhs = s.substring(midIdx);
    } else { // odd
      rhs = s.substring(midIdx + 1);
    }
    var lhs = new StringBuilder(s.substring(0, midIdx)).reverse().toString();

    return lhs.equals(rhs);
  }

  //public String longestPalindrome(String s) {
  //
  //  int maxPallyLen = -1;
  //  String result = "";
  //  int len = s.length();
  //  for (int i = 0; i < len; i++) {
  //    int maxPotentialPallyLen = Math.min(i, len - i);
  //    if (maxPotentialPallyLen <= maxPallyLen) {
  //      continue;
  //    }
  //
  //    var sb = new StringBuilder(s.charAt(i));
  //    for (int j = 0; j < maxPotentialPallyLen; j++) {
  //      if (s.charAt(i - j) == s.charAt(i + j)) {
  //        sb.insert(0, s.charAt(i - j));
  //        sb.append(s.charAt(i - j));
  //      }
  //    }
  //
  //    if (sb.length() > maxPallyLen) {
  //      result = sb.toString();
  //    }
  //  }
  //
  //  if (result == "") {
  //    result = s;
  //  }
  //
  //  return result;
  //}

}
