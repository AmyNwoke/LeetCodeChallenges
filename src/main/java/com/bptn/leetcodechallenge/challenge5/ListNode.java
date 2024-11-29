package com.bptn.leetcodechallenge.challenge5;

public class ListNode {
	int val;
	ListNode next;

	ListNode() {
	}

	ListNode(int val) {
		this.val = val;
	}

	ListNode(int val, ListNode next) {
		this.val = val;
		this.next = next;
	}
}

class Solution {
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

		if (l1 == null) { // If first list null, return list 2
			return l2;
		}

		if (l2 == null) { // If second list null, return list 1
			return l1;
		}

		ListNode mergedList; // New ListNode to merge list

		if (l1.val <= l2.val) {

			mergedList = new ListNode(l1.val); // If list 1 value less <= list 2, mergedList value become list 1 value
			mergedList.next = mergeTwoLists(l1.next, l2); // Merge rest of list 1 with list 2

		} else {

			mergedList = new ListNode(l2.val); // if list 2 value less than list 1 value, mergedList value becomes list 2 value 
			mergedList.next = mergeTwoLists(l1, l2.next); // Merge list 1 with the rest of list 2

		}

		return mergedList; // Returns the head of the merged list
	}
}