package com.psk.leetcode.l23mergeksortedlists;

import java.util.HashMap;

public class MergeKSortedListsSolution {

  /**
   * length of lists is K So the obvious way is to iterate all the linked lists in one go but how?
   * We'd need to maintain a list of indices, that's all
   * <p>
   * <p>1  2  3
   * <p>2  3  4
   * <p>1  1  3
   * <p>
   * <p>--> 1,1,1,2,2,3,3,3,4
   * <p>
   */
  public ListNode mergeKLists(ListNode[] chains) {
    if (chains == null || chains.length == 0) {
      return null;
    }

    // Step 1: store the current val of each chain
    var chainIdxToCurrVal = new HashMap<Integer, Integer>();
    var chainIdxToCurrLink = new HashMap<Integer, ListNode>();
    for (int i = 0; i < chains.length; i++) {
      var chain = chains[i];
      if (chain == null) {
        continue;
      }

      chainIdxToCurrVal.put(i, chain.val);
      chainIdxToCurrLink.put(i, chain);
    }

    ListNode result = null;
    ListNode firstResult = null;
    boolean allDone = false;
    while (!chainIdxToCurrLink.isEmpty()) {

      int smallestIdx = -1;
      int smallest = Integer.MAX_VALUE;
      ListNode smallestLink = null;
      boolean noLinksLeft = false;
      for (var entry : chainIdxToCurrVal.entrySet()) {
        if (entry != null && entry.getValue() <= smallest) {
          smallest = entry.getValue();
          smallestLink = chainIdxToCurrLink.get(entry.getKey());
          smallestIdx = entry.getKey();
        }
      }

      if (result == null) {
        firstResult = result = smallestLink;
      } else {
        result.next = smallestLink;
        result = result.next;
      }

      if (smallestLink.next != null) {
        chainIdxToCurrLink.put(smallestIdx, smallestLink.next);
        chainIdxToCurrVal.put(smallestIdx, smallestLink.next.val);
      } else {
        chainIdxToCurrLink.remove(smallestIdx);
        chainIdxToCurrVal.remove(smallestIdx);
      }
    }
    return firstResult;
  }
}
