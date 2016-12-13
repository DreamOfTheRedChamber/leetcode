package linkedIn;

/*
Given two arrays sorted in ascending order, find the absolute minimum difference between any pair of elements |a-b| such that a is from one array and b is from another array.

For example consider the following two arrays.

array1 = [3, 27, 45, 68, 70, 81, 99]
array2 = [9, 16, 25, 35, 70, 84]

The minimum difference is 2 (27-25).

This can be calculated using the following algorithm.
1. Take two indices i, j which point to the beginning of the two arrays (i.e 0)
2. Take variable MinDiff and assign it the maximum possible value
3. If array1[i] and array2[j] are equal return 0 
4. Otherwise update MinDiff if abs( array1[i] - array2[j] ) is the new minimum.
5. If array1[i] > array2[j] move second index(j) forward otherwise move first index (i) forward.
6. Repeat the above procedure until we reach the end of any of the two arrays.
7. Finally process the remaining part of left-over array to update MinDiff. 
This algorithm takes linear time - O(n) and constant space O(1). Here is the Java implementation of the above algorithm.
  
 * */

public class MinimumDifferenceBetweenTwoSortedArrays {

}
