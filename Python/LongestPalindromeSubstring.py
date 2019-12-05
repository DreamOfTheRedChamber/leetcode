import unittest

class LongestPalindromeSubstring(unittest.TestCase):

    def longestPalindrome(self, s: str) -> str:
        if len(s) == 0:
            return s

        isPalindrome = [[False for x in range(len(s))] for y in range(len(s))]

        for index in range(len(s)):
            isPalindrome[index][index] = True

        begin = 0
        end = 0
        for index in range(len(s) - 1):
            isPalindrome[index][index + 1] = s[index] == s[index + 1]
            if isPalindrome[index][index + 1] is True:
                begin = index
                end = index + 1

        for distance in range(2, len(s)):
            for row in range(len(s) - distance):
                col = row + distance
                isPalindrome[row][col] = s[row] == s[col] and isPalindrome[row + 1][col - 1]
                if isPalindrome[row][col] and col - row > end - begin:
                    begin = row
                    end = col

        result = s[begin:end + 1]

        return result

    def test_empty(self):
        self.assertTrue(self.longestPalindrome("") in {""})

    def test_multiple(self):
        self.assertTrue(self.longestPalindrome("babad") in {"bab", "aba"})

    def test_twoInTheMiddle(self):
        self.assertTrue(self.longestPalindrome("cbbd") in {"bb"})

    def test_oneInTheMiddle(self):
        self.assertTrue(self.longestPalindrome("abc") in {"a", "b", "c"})

    def test_longestAtTheMiddle(self):
        self.assertTrue(self.longestPalindrome("abcacba") in {"abcacba"})

if __name__ == '__main__':
    unittest.main()