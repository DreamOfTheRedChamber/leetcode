# Definition for a binary tree node.
import unittest
from typing import List

class LetterCombinationOfAPhoneNumber(unittest.TestCase):

    def letterCombinations(self, digits: str) -> List[int]:
        digitToLetters = {'2': {'a', 'b', 'c'},
                          '3': {'d', 'e', 'f'},
                          '4': {'g', 'h', 'i'},
                          '5': {'j', 'k', 'l'},
                          '6': {'m', 'n', 'o'},
                          '7': {'p', 'q', 'r', 's'},
                          '8': {'t', 'u', 'v'},
                          '9': {'w', 'x', 'y', 'z'}}

        allPerms = []
        for digit in digits:
            letters = digitToLetters[digit]
            newAllPerm = []
            if len(allPerms) == 0:
                for letter in letters:
                    newAllPerm.append(letter)
            else:
                for letter in letters:
                    for onePerm in allPerms:
                        newAllPerm.append(onePerm + letter)
            allPerms = newAllPerm

        return allPerms

    def test_letterCombinations(self):
        result = self.letterCombinations("23")
        self.assertTrue("ab" in result)

if __name__ == '__main__':
    unittest.main()