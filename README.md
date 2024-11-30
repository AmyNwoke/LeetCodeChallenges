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

##### Solution Steps 
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

#### Solution Steps.
* Step 1:
  Convert the array into a stream.
* Step 2:
  Use the .map method to get the data from the stream. In the map, get the element x and square x using lambda expressions, `.map(x -> x*x)`.
* Step 3:
  Use the .sorted method on the stream that is returned by the .map method.

## Challenges 3: Missing Number
[Missing Number](https://leetcode.com/problems/missing-number/)

### Problem
Given an array nums containing n distinct numbers in the range [0, n], return the only number in the range that is missing from the array.
An unstated constraint is that there can be only one missing number. Our approach acknowledges this and assumes that there is only one.

### Approach
Our decision on how to approach this problem was to use a map where we go from 0 to the length of the input array. We did this because the problem says the numbers will go from 0 to length of the array. This approach was fine but not quite as efficient as we would have liked. It required a for loop to create and add to the numbers to the Map this simply put nothing as the keys, another for loop for put the String "exists" as the keys for all the values in the map that were also in the key, we did this by indexing the array, and a third loop to convert the Map into and entrySet that I could iterate over and find out if a key still had a null value then I would return that key. This solution was fairly efficient with the 3 loops but figured there must be a better approach to it. So brainstormed for a bit and decided that we could simply sort the array, after sorting we would just check if the values are incrementing by one if there is just a case where it is not we found our missing number.

#### Solution Steps.
* Step 1: Sort the input array. It is sorted in ascending order.
* Step 2: `This is a short circuit branch` If the first index; `array[0] != 0` then `return 0` since every array must start from 0.
* Step 3: We start a for loop here that goes up to the end of the array.
* Step 4: Start a try catch block.
* Step 5: In the try block use and if statement, it says
```Java
if(nums[i+1] != nums[i] +1) {
return nums[i]+1; //Here we return the number that would have been at nums[i+1] but since it is missing nums[i+1] != nums[i] + 1
} 
```
It returns the value arr[i]+1 when arr[i+1] != arr[i]+1, it returns the current value + 1 if the next value that is the value to the right of the current value is not the current value + 1
* Step 6: In the catch block we catch an `ArrayIndexOutOfBoundsException`, this exception would mean we have reached the end of the list and did not find a missig number. This simply means that the missing number is the `arr.length` or `arr[i]+1` since `i == arr.length`, if that is the case we just return the current last element + 1 to get the missing number.
  

## Challenges 4: Add Two Numbers.
[Add Two Numbers](https://leetcode.com/problems/add-two-numbers/description/)

### Problem
You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.
You may assume the two numbers do not contain any leading zero, except the number 0 itself.

### Approach
The approach that we chose with this problem had to consider the addition, carry-forwards, length of numbers and different length numbers. With this many factors to consider we decided that a recursive program that uses branches to deal with the various possible scenarios would be the best approach. Our solution involved using if-else-if branches to handle the type of recursive call we needed to make.

#### Solution Steps.
* Step 0: Create a new method that will take parameters for remainder, two ListNodes and a return ListNode.
* Step 1: Call the method created in step 0 in your main method.
* Step 2: `The steps from here describe what the method created in step 0 does` First we check to make sure that the two current input nodes are not null, if they are not null then we access their value using `ListNode.val` syntax.
* Step 3: Inside the branch from step 3 we first find the `sum`, our `sum` is always `ListNode.val + ListNode.val + remainder`. This way we always make sure our remainder that we passed as parameter to our method is propagated.
* Step 4: After finding the sum. We simply reset `l1` and `l2` which are our input `ListNodes`, we set them to their next node by running `l1 = l1.next` and `l2 = l2.next`. With this we are almost setup for our first recursive call we just need to create a new node in our returnList that will hold new values.
* Step 5: Before we make the recursive call we need to find out if there was a remainder from our `sum` variable. If there was a remainder we simply subtract 10 to give us the number that must be at this current `ListNode.val`. This also affects the type of recursive call that we make. This is because we want the remainder to be propagated.
* Step 6: This is the step where we decide what the recursive call we make based on whether there is a remainder or not. If there is a remainder our recursive call will look like `nodeNumGetter(ListNode, ListNode, returnList, 1)` where one is the remainder we propagate. We do not neccessarily need it to be a 1 it could be a boolean letting us know there was a remainder, using just means we can add 1 directly to the `sum` which eliminates one more possible if-else branch if we used a boolean. If there is no remainder the recursive call looks like `nodeNumGetter(ListNode, ListNode, returnList, 0)` here zero added to the `sum` will obviously have no effect.
* Step 7: This is another step where we need to make several decisions before the recursive call can be finalized. First we need to account for different length ListNodes. So in our program we check that;
```Java
if(l1 != null && l2 != null) /*we simply do our regular recursive call*/ nodeNumGetter(ListNode, ListNode, returnList, remainder)
else if(l1 == null && l2 != null) /*we do a modified recursive call*/ nodeNumGetter3(new ListNode(0), ListNode, returnList.next, remainder) //this just creates a new node with 0 at l1 so that the addition can continue.
else if(l1 != null && l2 == null) /*we do a modified recursive call*/ nodeNumGetter3( ListNode, new ListNode(0), returnList.next, remainder) //here we do the mirrored version if l2 is null but l1 is not.
```
  This is repeated in the branch of the program that handles remainders too.
* Step 8: Make the recursive call with the right parameters. The recursive call will continue being made until both l1 and l2 are null.
* Step 9: `This step is only for when there is a remainder and but all the nodes are null`. Here I use an else branch in the if statment that handles the remainders. In the else branch I call a unique recursive statement where l1 is null, l2 is null but remainder is 1 `nodeNumGetter3(null, null, returnList.next, 1)`. This triggers an else branch to handle it pseudocode description below.
```Java
//This is where I handle the recursive call
else if(l1 == null && l2 == null & remainder == 1){
   returnList.val = 1; //Set the last node created by giving param returnList.next to 1 so that the remainder is added.
}
```
### Challenge 5: Merge Two Sorted Lists
[Merge Two Sorted Lists](https://leetcode.com/problems/merge-two-sorted-lists/description/)

### Problem
The task is to merge two sorted linked lists into one sorted list by joining their nodes, and then return the head of the merged linked list.

### Approach
We decided to use recursion to compare the nodes, which was similar to what we did in the 4th challenge. We were given two sorted linked lists and had to merge them into a single sorted linked list in non-decreasing order. Additionally, if one of the lists is empty, the non-empty list would be the result. Knowing this, we originally created two different methods to handle this problem (one as the main entry point to merge the lists, and the other to recursively merge the nodes of the lists). Later, we simplified this into one method.
The main steps we took were:
Checking if a list is null, and if so, returning the other list.
Comparing the values at the current nodes of both lists.
Using the lesser (smaller) value as the next node in the merged list.
Recursively merging the remaining nodes of the lists.
Finally, returning the head of the merged linked list.


### Solution Steps.
Step 1: Create a method (mergeTwoLists) that takes the two sorted linked lists and returns a merged sorted list.
Step 2: If l1 is null, return l2 because there’s nothing to merge. The same applies if l2 is null: return l1.
Step 3: Compare the current values in l1 and l2. If l1.val is smaller or equal, use l1.val as the next node in the merged list and move to the next node in l1. If l2.val is smaller, do the same with l2.val and move to the next node in l2.
Step 4: Recursively call the mergeTwoLists method for the remaining nodes and attach the result to the next pointer of the merged list.
Step 5: Repeat until one of the lists is empty, at which point attach the rest of the non-empty list to the merged list. Then, return the head of the merged list.


  
  


