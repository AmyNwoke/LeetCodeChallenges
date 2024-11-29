# LeetCodeChallenges : Thought Process and Approach

## Challenge 1: Average salaries excluding max and min 
 [Average Salary Excluding the Minimum and Maximum Salary](https://leetcode.com/problems/average-salary-excluding-the-minimum-and-maximum-salary/description/)
### Problem
The task is to compute the average of salaries, excluding the minimum and maximum salaries from the array

### Approach 

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
* Step 1:
declare array of integers to store average salary
Initialize max and min to the first element in the salary array and initialize total to 0
* Step 2
validate that the length of salary is more 2 and <=100 otherwise return 0.0
* Step 3:
Loop through the array, if salary [i] <min, update min salary
else if salary[i] > max, update max salary
Add salary[i] to total
* Step 4
calculate the average excluding min and max
* Step 5
To test from the main app
create instance of the class
Initialize salary array with values {4000,3000,1000,2000}
call the method to calculate average and print the result

## Challenges 2: Squares of a Sorted Array
[Squares of a Sorted Array](https://leetcode.com/problems/squares-of-a-sorted-array/)

### Problem
Given an integer array nums sorted in non-decreasing/ascending order, return an array of the squares of each number sorted in non-decreasing/ascending order.
We are given an input which is an Integer array our job is to square each member of the array and sort in non-decreasing/ascending order.

### Approach
Our first thought was to use loops to iterate over the array and square while we iterate over it. After iterating and squaring we sort using an insertion sort algorithm. After this initial solution we iterated on it using functional programing since that will be a concise and fairly efficient way to find a solution. After this decision the next step was to figure out a method that could allow us to index our array and apply some operation to all the elements. This is where the two methods we need comes into play map and stream. Where map allows us to apply some operation to data that is given to it from a stream. 

Solution Steps.
* Step 1:
  Convert the array into a stream.
* Step 2:
  Use the .map method to get the data from the stream. In the map, get the element x and square x using lambda expressions, `.map(x -> x*x)`.
* Step 3:
  Use the .sorted method on the stream that is returned by the .map method.
## Challenges 4: Add Two Numbers.
[Add Two Numbers](https://leetcode.com/problems/add-two-numbers/description/)

### Problem
You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.
You may assume the two numbers do not contain any leading zero, except the number 0 itself.

### Approach
The approach that we chose with this problem had to consider the addition, carry-forwards, length of numbers and different length numbers. With this many factors to consider we decided that a recursive program that uses branches to deal with the various possible scenarios would be the best approach. Our solution involved using if-else-if branches to handle the type of recursive call we needed to make.
 


