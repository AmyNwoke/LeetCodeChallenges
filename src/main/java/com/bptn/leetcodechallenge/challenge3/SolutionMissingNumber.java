package com.bptn.leetcodechallenge.challenge3;

import java.util.Arrays;

public class SolutionMissingNumber {
	public int missingNumber(int[] nums) {
        
        //Solution 3
        Arrays.sort(nums); //Sorts the array in ascending order.
        if(nums[0] != 0){ // This acts as some kind of base case for short circuiting because we know that in a sorted array that has numbers from 0 to length of array 0 will be first.
            return 0; //So we return 0 and stop running the program.
        }
		for(int i=0; i<nums.length; i++) {
			//Try catch block to catch and index out of bounds since we compare the numbers in the array to the number that comes after them. When we get to arr.length+1 an exception will be thrown.
			try {
                if(nums[i+1] != nums[i] +1) {
					return nums[i]+1; //Here we return the number that would have been at nums[i+1] but since it is missing nums[i+1] != nums[i] + 1
				} 
			} catch (ArrayIndexOutOfBoundsException e) {
				return nums[i]+1; //Here if the exception is caught it means we have reached the end of the array and the missing number is the last number in that array so return the current last number +1
			}
		}
		return -1; //This return statement will never be reached if the program works correctly. It is placed here because java does not like us returning from if branches or try/catch.
    }
	
	public static void main(String[] args) {
		//Creating an instance of SolutionMissingNumber for testing.
		SolutionMissingNumber test = new SolutionMissingNumber();
		
		 System.out.println(test.missingNumber(new int[] {9,6,4,2,3,5,7,0,1})); 
		
		
	}
}
