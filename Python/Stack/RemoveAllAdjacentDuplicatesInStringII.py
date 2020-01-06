import unittest
from collections import deque

class RemoveAllDuplicatesInStringII(unittest.TestCase):

    def removeDuplicates(self, s: str, k: int) -> str:

        # use stack to dedupe string
        stack = deque()
        for char in s:
            if len(stack) == 0 or stack[-1][0] != char:
                stack.append((char, 1))
            else:
                top = stack.pop()
                if top[1] + 1 == k:
                    continue
                else:
                    stack.append((top[0], top[1] + 1))

        # reconstruct string
        result = ""
        while len(stack) != 0:
            char, frequency = stack.pop()
            result = char * frequency + result

        return result

    def test_RemovedToEmptyString(self):
        self.assertEqual("", self.removeDuplicates("aabbcc", 2))
        self.assertEqual("", self.removeDuplicates("aa", 2))
        self.assertEqual("", self.removeDuplicates("", 2))

    def test_OnlyRemoveBiggerCount(self):
        self.assertEqual("aaa", self.removeDuplicates("aaabbbb", 4))
        self.assertEqual("a", self.removeDuplicates("aaaaa", 2))

    def test_LeetcodeCases(self):
        self.assertEqual("aa", self.removeDuplicates("deeedbbcccbdaa", 3))
        self.assertEqual("ps", self.removeDuplicates("pbbcggttciiippooaais", 2))

if __name__ == '__main__':
    unittest.main()