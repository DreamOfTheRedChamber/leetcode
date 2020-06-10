# Definition for a binary tree node.
import unittest

# 20 min

class TwoSum(unittest.TestCase):

    def isValid(self, s: str) -> bool:
        stack = []
        dict = {
            '(': ')',
            '[': ']',
            '{': '}',
        }

        for ch in s:
            if ch in dict:
                stack.append(ch)
            else:
                if len(stack) == 0 or dict[stack.pop()] != ch:
                    return False

        return len(stack) == 0

    def test_Normal(self):
        self.assertFalse(self.isValid("}"))
        self.assertFalse(self.isValid("("))
        self.assertTrue(self.isValid("()"))
        self.assertTrue(self.isValid("()[]{}"))
        self.assertFalse(self.isValid("(]"))
        self.assertFalse(self.isValid("([)]"))

if __name__ == '__main__':
    unittest.main()