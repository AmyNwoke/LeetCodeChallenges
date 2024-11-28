package com.bptn.leetcodechallenge.challenge3;

import java.util.Arrays;

public class SolutionMissingNumber {
	public int missingNumber(int[] nums) {
        
        //Solution 3
        Arrays.sort(nums);
        if(nums[0] != 0){
            return 0;
        }
		for(int i=0; i<nums.length; i++) {
			try {
                if(nums[i+1] != nums[i] +1) {
					return nums[i]+1; 
				} 
			} catch (ArrayIndexOutOfBoundsException e) {
				return nums[i]+1;
			}
		}
		return -1;
    }
	
	public static void main(String[] args) {
		SolutionMissingNumber test = new SolutionMissingNumber();
		
		 System.out.println(test.missingNumber(new int[] {9,6,4,2,3,5,7,0,1})); 
		
		
	}
}
