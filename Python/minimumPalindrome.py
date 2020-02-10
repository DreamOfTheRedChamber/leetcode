# Definition for a binary tree node.
import unittest

# Read about enumerate in python

class MinimumPalindrome(unittest.TestCase):

    def removePalindromeSub(self, s: str) -> int:
        numRemoval = 0

        while len(s) > 0:
            s = self.removeLongest(s)
            numRemoval += 1

        if numRemoval > 2:
            return 2

        return numRemoval

    def removeLongest(self, s: str) -> str:
        oddCentered = 0
        oddPalindromeLength = 0
        for pos in range(len(s)):
            palindromeLength = 0
            while pos - palindromeLength - 1 >= 0 and pos + palindromeLength + 1 < len(s) and s[pos - palindromeLength - 1] == s[pos + palindromeLength + 1]:
                palindromeLength += 1
            if palindromeLength > oddPalindromeLength:
                oddPalindromeLength = palindromeLength
                oddCentered = pos
        firstPart = s[0:oddCentered-oddPalindromeLength]
        secondPart = s[oddCentered+oddPalindromeLength+1:len(s)]
        oddPalindrome = firstPart + secondPart

        evenCentered = 0
        evenPalindromeLength = 0
        for pos in range(len(s) - 1):
            palindromeLength = 0
            if s[pos] != s[pos+1]:
                continue
            while pos - palindromeLength - 1 >= 0 and pos + 2 + palindromeLength < len(s) and s[pos - palindromeLength] == s[pos + 1 + palindromeLength]:
                palindromeLength += 1
            if palindromeLength > evenPalindromeLength:
                evenCentered = pos
                evenPalindromeLength = palindromeLength
        firstPart = s[0:evenCentered-evenPalindromeLength]
        secondPart = s[evenCentered+evenPalindromeLength+2:len(s)]
        evenPalindrome = firstPart + secondPart

        if len(oddPalindrome) > len(evenPalindrome):
            return evenPalindrome
        else:
            return oddPalindrome

    def test_Test1(self):
        # self.assertEqual(1, self.removePalindromeSub("ababa"))

        # self.assertEqual(2, self.removePalindromeSub("abb"))

        # self.assertEqual(2, self.removePalindromeSub("baabb"))

        self.assertEqual(2, self.removePalindromeSub("abaabbbabb"))

if __name__ == '__main__':
    unittest.main()