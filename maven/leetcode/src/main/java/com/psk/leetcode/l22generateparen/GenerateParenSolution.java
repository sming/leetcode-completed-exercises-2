package com.psk.leetcode.l22generateparen;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * so what is a valid output? one where there are no "unmatched" parens left over can we just
 * randomly try shit? are there some rules that we can use to help us? so we're given n pairs. do we
 * treat the pair as an object/entity? or just go with LHS and RHS parens?
 */
public class GenerateParenSolution {

  public List<String> generateParenthesis(int nPairs) {
    var resultSet = new HashSet<String>();

    generateAllCombinations(resultSet, new StringBuilder(nPairs * 2), 0, nPairs * 2);
    return new ArrayList<>(resultSet);
  }

  private void generateAllCombinations(HashSet<String> resultSet, StringBuilder current, int idx,
      int len) {
    if (idx == len) {
      if (isValid(current.toString())) {
        resultSet.add(current.toString());
      }
      return;
    }

    var lcurrent = new StringBuilder(current);
    var rcurrent = new StringBuilder(current);
    lcurrent.append('(');
    generateAllCombinations(resultSet, lcurrent, idx + 1, len);
    rcurrent.append(')');
    generateAllCombinations(resultSet, rcurrent, idx + 1, len);
  }

  private boolean isValid(String current) {
    int lrBal = 0;
    for (int i = 0; i < current.length(); i++) {
      if (lrBal < 0) {
        return false;
      }

      if (current.charAt(i) == '(') {
        lrBal++;
      } else {
        lrBal--;
      }
    }

    return lrBal == 0;
  }

}
