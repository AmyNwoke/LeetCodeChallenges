package com.bptn.leetcodechallenge.challenge2;

import java.util.Arrays;


public class SolutionSortedSquares {
	
	//Array input 
	    public int[] sortedSquares(int[] nums) {
	    	//convert the array to stream to start the operation 
	        return Arrays.stream(nums)
	        		//using the mapping function with lambda to square each element in the list to return squared list
	                    .map((x) -> x*x)
	                    //sorting the squared list
	                    .sorted()
	                    //convert the list to an array 
	                    .toArray();
	    }
	
	    public static void main(String[] args) {

			// creating a new object
			SolutionSortedSquares solution = new SolutionSortedSquares();
			//testing with one of the example test on leetcode to confirm correctness of code
			 int[] nums = {-4, -1, 0, 3, 10};
			 //assign to output variable
			 int[] output = solution.sortedSquares(nums);

			//print the output
			 System.out.println(Arrays.toString(output));
		}




}


