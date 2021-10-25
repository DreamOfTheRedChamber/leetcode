'''
DoorDash obtains restaurant data from various sources which have varying quality. 
These sources often have duplicate merchants with minor typos in their names. 
The assignment is to create a list of unique restaurants across various sources ignoring the errors before onboarding them.

Definition: Similar restaurants

Two restaurants R1 and R2 are similar if we can swap a maximum of two letters (in different positions) of R1, so that it equals R2.

For example, source one may have a restaurant named "omega grill" while another source may have the same restaurant as "omgea grill".

For example, "biryani" and "briyani" are similar (swapping at positions 1 and 2). "biryani" is not similar to following, "biryeni" (no e to swap with), "briynai"(Needs 2 swap)

For a given restaurant name, find and return all the similar restaurant names in the list.

Implement the function below:

public List<String> findSimilarRestaurants(String name, String[] list) {}
Test cases
1
Input: "tars", ["rats", "star", "tars"]
Output: ["rats", "tars"]
2
Input: "abcdef", ["aecdbf", "aexdbf"]
Output: ["aecdbf"]
3
Input: "hotpot", ["hottop", "hotopt", "hotpit", "httoop", "hptoot", "hotozt"]
Output: ["hottop", "hotopt", "hptoot"]
4
Input: "biryani", ["biryani", "biryeni", "biriyani", "biriany", "briynai"]
Output: ["biryani", "biriany"]
5
Input: "omega grill", ["omeag grill", "omeea grill", "omega gril", "omegla gril"]
Output: ["omeag grill"]
6
Input: "omega", ["omega", "moega", "mogea", "xxgea", "mmega"]
Output: ["omega", "moega"]

straightforward; 
length of str: M, length list N
M*N

O(1)+O(M)



Given a restaurant name, find other restaurants in the list that are k-anagrams with each other. A name is a k-anagram with another name if both the conditions below are true:

The names contain the same number of characters.
The names can be turned into anagrams by changing at most k characters in the string
For example:

name = "grammar", k = 3 and list = ["anagram"], "grammar" is k-anagram with "anagram" since they contain the same number of characters and you can change 'r' to 'n' and 'm' to 'a'.
name = "omega grill", k = 2 and list = ["jmega frill"], "omega grill" is k-anagram with "jmega frill" since they contain same number of characters and you can change 'o' to 'j' and 'g' to 'f'
public List<String> findKAnagrams(String name, String[] list, int K) {}

Test cases:
1
Input: "anagram", ["grammar", "grammer", "unagram", "anagram", "frammer"], K = 3
Output: ["grammar", "grammer", "unagram", "anagram"]
2
Input: "anagram", ["grammar", "grammer", "unagram", "anagram", "frammer"], K = 2
Output: ["grammar", "unagram", "anagram"]
3
Input: "anagram", ["grammar", "grammer", "unagram", "anagram", "frammer"], K = 1
Output: ["unagram", "anagram"]
4
Input: "anagram", ["grammar", "grammer", "unagram", "anagram", "frammer"], K = 0
Output: ["anagram"]
5
Input: "anagram", ["grammar", "grammer", "unagram", "frammer"], K = 0
Output: []
6
Input: "omexyb grillg", ["omgxca grille", "omgxca grille"], K = 2
Output: ["omgxca grille", "omgxca grille"]

T.C. O(M*N)
S.C. O(M)
'''

import unittest

import collections
from collections import deque
from collections import defaultdict
#from sortedcontainers import SortedList, SortedSet, SortedDict

import heapq
import re

class OnlineHackerRankCodePair(unittest.TestCase):


    def test_Test8(self):
        print(self.findKAnagrams("anagram", ["grammar", "grammer", "unagram", "anagram", "frammer"], 3))
        # ["grammar", "grammer", "unagram", "anagram"]

    def test_Test9(self):
        print(self.findKAnagrams("anagram", ["grammar", "grammer", "unagram", "anagram", "frammer"], 2))
        # ["grammar", "grammer", "unagram", "anagram"]

    def test_Test90(self):
        print(self.findKAnagrams("anagram", ["grammar", "grammer", "unagram", "anagram", "frammer"], 1))
        # ["grammar", "grammer", "unagram", "anagram"]

    def test_Test91(self):
        print(self.findKAnagrams("anagram", ["grammar", "grammer", "unagram", "anagram", "frammer"], 0))
        # ["grammar", "grammer", "unagram", "anagram"]

    def test_Test92(self):
        print(self.findKAnagrams("anagram", ["grammar", "grammer", "unagram", "frammer"], 0))
        # ["grammar", "grammer", "unagram", "anagram"]
 
    def test_Test93(self):
        print(self.findKAnagrams("omexyb grillg", ["omgxca grille", "omgxca grille"], 2))
        # ["grammar", "grammer", "unagram", "anagram"]
         
        
    def findSimilarRestaurants(self, name, inputList):
        
        result = []
        for index, toCompare in enumerate(inputList):
            
            if len(toCompare) != len(name):
                continue
            
            firstMismatch = False
            firstMismatchIndex = 0
            secondMismatch = False
            isOpposite = False
            for strPos in range(len(name)):
                if name[strPos] != toCompare[strPos]:
                    if secondMismatch:
                        isOpposite = False
                        break
                    elif not firstMismatch:
                        firstMismatchIndex = strPos
                        firstMismatch = True
                    else:
                        isOpposite = name[strPos] == toCompare[firstMismatchIndex] and name[firstMismatchIndex] == toCompare[strPos]
                        secondMismatch = True
            
            if not firstMismatch or isOpposite:
                result.append(toCompare)
            
        return result
    
# public List<String> findKAnagrams(String name, String[] list, int K) {} 
    def findKAnagrams(self, name, inputList, k):
        result = []
        for index, toCompare in enumerate(inputList):
            
            if len(toCompare) != len(name):
                continue
            
            count = 0
            nameDict = collections.Counter(name)
            for i in range(len(toCompare)):
                if toCompare[i] in nameDict:
                    if nameDict[toCompare[i]] > 0:
                        nameDict[toCompare[i]] -= 1
                    else:
                        count += 1
                else:
                    count += 1
            
            if count <= k:
                result.append(toCompare)
                    
        return result

        
if __name__ == '__main__':
    unittest.main()



