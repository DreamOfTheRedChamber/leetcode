# Definition for a binary tree node.
import unittest

# Read about enumerate in python

class PalindromicSubstrings(unittest.TestCase):

    def countSubstrings(self, s: str) -> int:
        length = len(s)
        result = 0

        isPalindrome = [[False for x in range(len(s))] for y in range(len(s))]
        for length in range(1, len(s) + 1):
            for start in range(0, len(s) - length + 1):
                end = start + length - 1
                if length == 1:
                    isPalindrome[start][end] = True
                elif length == 2:
                    isPalindrome[start][end] = s[start] == s[end]
                else:
                    isPalindrome[start][end] = isPalindrome[start + 1][end - 1] and s[start] == s[end]

                if isPalindrome[start][end]:
                    result += 1

        return result

    def test_leetcode(self):
        self.assertEqual(3, self.countSubstrings("abc"))
        # self.assertEqual(6, self.countSubstrings("aaa"))

if __name__ == '__main__':
    unittest.main()