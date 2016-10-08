package interview.airbnb;

/**
Given a list of strings, find all the palindromic pairs of the string and output the concatenated palindrome.

e.g. [abc, cba], output is abccba, cbaabc.
e.g. [aabc, cb], output is cbaabc

1. Check if two strings are palindromes.
2. Make a function that does this for lists of strings
3. Implement a hash function for this instead of brute force.  

Understand the problem:
The brute-force solution to this problem is very simple. For each word, we search all the others and see if it can form a palindrome. Assume that the ave. length of each word is m and there are totally n words in the list, the time complexity would be O(n^2 * m). 
 */

public class PalindromePair
{

}
