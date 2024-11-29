# LeetCodeChallenges : Thought Process and Approach

Challenge 1: Average salaries excluding max and min 
 [Average Salary Excluding the Minimum and Maximum Salary](https://leetcode.com/problems/average-salary-excluding-the-minimum-and-maximum-salary/description/)
## Problem
The task is to compute the average of salaries, excluding the minimum and maximum salaries from the array

## Approach 

The first thing we did but diving into a solution was to understand the problem. Things we understood and considered before arriving at a solution were;

* The salary is an array
* The average should exclude the smallest and largest elements in the array
* If we are excuding min and max the next thing to consider is that the length of the list muse be more than 2

Based on the above the next thing we did was to decompose the problem and arrived at smaller parts to solve the issue ;
* Confirm the array length , if the array length is less than 3, 0 will be returned 
*  Find the minimum and maximum values in the array.
* Compute the total sum of the array.
* Subtract the minimum and maximum values from the total sum.
* Divide the resulting sum by the number of elements remaining (length - 2).

Method leveraged: We applied the if else and for loop for traversing the array to find the min and max salary. 
The solution was so easy and relatable to us from what we have done in class.

Solution Steps 
Step 1:
declare array of integers to store average salary
Initialize max and min to the first element in the salary array and initialize total to 0
Step 2
validate that the length of salary is more 2 and <=100 otherwise return 0.0
Step 3:
Loop through the array, if salary [i] <min, update min salary
else if salary[i] > max, update max salary
Add salary[i] to total
Step 4
calculate the average excluding min and max
Step 5
To test from the main app
create instance of the class
Initialize salary array with values {4000,3000,1000,2000}
call the method to calculate average and print the result


