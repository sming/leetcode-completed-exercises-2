package com.psk.leetcode.l23mergeksortedlists;

import java.util.List;
import junit.framework.TestCase;

public class MergeKSortedListsSolutionTest extends TestCase {

  public void testMergeKLists() {
    var chainList = new ListNode(1, new ListNode(2, new ListNode(3)));
    var chainList2 = new ListNode(2, new ListNode(3, new ListNode(4)));
    var chainList3 = new ListNode(1, new ListNode(2, new ListNode(3)));

    var doop = List.of(chainList, chainList2, chainList3);
    var res = new MergeKSortedListsSolution().mergeKLists(doop.toArray(ListNode[]::new));
    while (res != null) {
      System.out.println(res.val + ",");
      res = res.next;
    }
  }
}