import unittest

class LongestSubstringWithoutRepeatingCharacters(unittest.TestCase):

    def lengthOfLongestSubstring(self, s: str) -> int:
        uniqueChars = set()
        start = 0
        longest = 0

        for end in range(0, len(s)):
            while s[end] in uniqueChars:
                uniqueChars.remove(s[start])
                start += 1
            uniqueChars.add(s[end])
            longest = max(longest, end - start + 1)

        return longest

    def test_empty(self):
        self.assertEqual(0, self.lengthOfLongestSubstring(""))

    def test_repeatingSingleCharacter(self):
        self.assertEqual(1, self.lengthOfLongestSubstring("bbbbbb"))

    def test_longestAtTheEnd(self):
        self.assertEqual(3, self.lengthOfLongestSubstring("pwwkew"))

    def test_longestAtTheMiddle(self):
        self.assertEqual(3, self.lengthOfLongestSubstring("abcabcbb"))

if __name__ == '__main__':
    unittest.main()