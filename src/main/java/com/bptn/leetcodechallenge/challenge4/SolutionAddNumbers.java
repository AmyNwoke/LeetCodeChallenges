package com.bptn.leetcodechallenge.challenge4;


class ListNode {

	// private static final ListNode ListNode = null;
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
public class SolutionAddNumbers {
	public static void main(String[] args) {
		ListNode l4 = new ListNode(4, null);
		ListNode l3 = new ListNode(3, l4);
		ListNode l2 = new ListNode(4, l3); // stuck here so moves to next only once why.
		ListNode l1 = new ListNode(3, l2);
		
		ListNode l23 = new ListNode(4, null);
		ListNode l22 = new ListNode(6, l23);
		ListNode l21 = new ListNode(5, l22);
		
		addTwoNumbers(l1,l21);
		
	}
		
	 public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
	        
	        ListNode returnList = new ListNode();
	        nodeNumGetter3(l1, l2, returnList, 0);
	        return returnList;
	 }
	    
	public static ListNode nodeNumGetter3(ListNode l1, ListNode l2, ListNode returnList, int remainder) {
		//Here we check if the current node exists or not.
		//If it does not exist we execute the else if branch.
		if (l1 != null && l2 != null) {

			int sum = l1.val + l2.val + remainder; //Calculates the sum at the current none empty node. Includes the remainder which is propagated as a parameter from old sums.
			if (sum >= 10) { //If the sum is greater than or equal to 10 then we have a carry forward of 1. Idea behind why carry forward is 1 is explained below.
				
				// 4+6 = 10 //Lowest number that creates a carry forward is 10. 
				// 9 + 9 + 1 = 19 //The largest number that creates a carry forward is 19.
				returnList.val = (sum - 10);

				l1 = l1.next; //Move the node forward to the next node this is done so that we can call l1, l2 as parameters in our recursive call. Because of object reference issues passing l1.next directly gets stuck at node 2.
				l2 = l2.next;
				
				//This set of branches repeat for when there is a remainder vs for when there is not a remainder.
				if (l1 != null && l2 != null) { //This checks that the new nodes are not null before making a new call to the methods this helps us avoid null pointer exceptions.
					returnList.next = new ListNode();
					returnList.next = nodeNumGetter3(l1, l2, returnList.next, 1); //recursive call with new node created on the step above, this new node links to the returnList parameter.
				} else if (l1 == null && l2 != null) {
					returnList.next = new ListNode();
					returnList.next = nodeNumGetter3(new ListNode(0), l2, returnList.next, 1); //This branch handles when l1 is fewer digits than l2. This creates new nodes in place of l1. These nodes hold 0.
				} else if (l1 != null && l2 == null) {
					returnList.next = new ListNode();
					returnList.next = nodeNumGetter3(l1, new ListNode(0), returnList.next, 1); //This branch handles when l2 is fewer digits than l1. This creates new nodes in place of l1. These nodes hold 0.
				} else {
					returnList.next = new ListNode();
					nodeNumGetter3(null, null, returnList.next, 1); //This handles the edge case where we there is still a carry forward but both LinkedList are now empty. With this I have one more recursive call with null parameters.
				}	//The null parameter call is handled in the else branch of the outer if-elseif statement.
			} else {
				returnList.val = sum;

				l1 = l1.next; //Move the node forward to the next node this is done so that we can call l1, l2 as parameters in our recursive call. Because of object reference issues passing l1.next directly gets stuck at node 2.
				l2 = l2.next;
				
				//These branches handle no remainder cases.
				if (l1 != null && l2 != null) {
					returnList.next = new ListNode();
					returnList.next = nodeNumGetter3(l1, l2, returnList.next, 0); //This branch handles when both l1 and l2 are non null and there are no remainders.
				} else if (l1 == null && l2 != null) {
					returnList.next = new ListNode();
					returnList.next = nodeNumGetter3(new ListNode(0), l2, returnList.next, 0); //No remainder but l2 has more digits than l1.
				} else if (l1 != null && l2 == null) {
					returnList.next = new ListNode();
					returnList.next = nodeNumGetter3(l1, new ListNode(0), returnList.next, 0); //No remainder l1 has more digits than l2.
				} // else {
					// returnList.next = new ListNode();
					// nodeNumGetter3(null, null, returnList.next, 0); //This branch is commented out because we do not need to handle this case because there are no remainders here.
					// }
			}
		} else if (l1 == null && l2 == null && remainder == 1) {//this else if branch executes only if the are no more nodes in the list but there is still a remainder here we create a new node and put the remainder.
			returnList.val = 1; //Put 1 at the last new node that is created when the nodes are empty for the input lists but there is a remainder. Edge Case where there is a remainder but both numbers have ended.
		}
		return returnList; //return the result.
	}
	
	
}
