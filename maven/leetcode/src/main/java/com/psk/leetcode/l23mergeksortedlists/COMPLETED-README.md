# 23. Merge k Sorted Lists

You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.

Merge all the linked-lists into one sorted linked-list and return it.



Example 1:

Input: lists = [[1,4,5],[1,3,4],[2,6]]

Output: [1,1,2,3,4,4,5,6]

Explanation: The linked-lists are:
[
1->4->5,
1->3->4,
2->6
]

merging them into one sorted list:

1->1->2->3->4->4->5->6


Example 2:

what if we had 
[
1   2   3
2   3   4
1   2   3
]

so find the smallest one(s) to start with
then we know that either the next value is in the smallest chain, or in another so we could just store the "current value" of each chain