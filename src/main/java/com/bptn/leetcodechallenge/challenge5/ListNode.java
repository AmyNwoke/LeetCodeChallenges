package com.bptn.leetcodechallenge.challenge5;

 class ListNode {
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



	package com.bptn.leetcodechallenge.challenge5;

	public class Main {
	    public  void main(String[] args) {
	        // Create first linked list: 1 -> 2 -> 4
	        ListNode l3 = new ListNode(4, null);
	        ListNode l2 = new ListNode(2, l3);
	        ListNode l1 = new ListNode(1, l2);

	        // Create second linked list: 1 -> 3 -> 4
	        ListNode l23 = new ListNode(4, null);
	        ListNode l22 = new ListNode(3, l23);
	        ListNode l21 = new ListNode(1, l22);

	        // Merge the two linked lists
	        Solution solution = new Solution();
	        ListNode mergedList = solution.mergeTwoLists(l1, l21);

	        // Print the merged linked list values step by step
	        ListNode current = mergedList;
	        while (current != null) {
	            System.out.println(current.val);
	            current = current.next; // Move to the next node
	        }
	    }
	}






