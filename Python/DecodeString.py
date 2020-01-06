# Definition for a binary tree node.
import unittest

from collections import deque
# Read about enumerate in python

class DecodeString(unittest.TestCase):

    def decodeString(self, s: str) -> str:
        if len(s) == 0:
            return s

        numberStack = deque()
        letterStack = deque()

        chPos = 0
        word = ""
        while chPos < len(s):
            if '0' <= s[chPos] <= '9':
                number = 0
                while chPos < len(s) and '0' <= s[chPos] <= '9':
                    number = number * 10 + int(s[chPos])
                    chPos += 1
                numberStack.append(number)
            elif s[chPos] == '[':
                chPos = chPos + 1
            elif 'a' <= s[chPos] <= 'z' or 'A' <= s[chPos] <= 'Z':
                word = word + s[chPos]
                chPos = chPos + 1
            elif s[chPos] == ']':
                number = numberStack.pop()
                wordTemp = number * word
                if len(letterStack) == 0:
                    letterStack.append(wordTemp)
                else:
                    stackTop = letterStack.pop()
                    letterStack.append(stackTop + wordTemp)
                chPos += 1
            else:
                raise ValueError("invalid cases")

        result = letterStack.pop()
        while len(letterStack) > 0:
            result = letterStack.pop() + result

        return result

    # recursion two stack always push not working for case self.assertEqual("aaabFFFFcbFFFFc", self.decodeString("3[a]2[b4[F]c]"))
    def decodeStringAlwaysPush(self, s: str) -> str:
        if len(s) == 0:
            return s

        numberStack = deque()
        letterStack = deque()

        chPos = 0
        while chPos < len(s):
            if '0' <= s[chPos] <= '9':
                number = 0
                while chPos < len(s) and '0' <= s[chPos] <= '9':
                    number = number * 10 + int(s[chPos])
                    chPos += 1
                numberStack.append(number)
            elif s[chPos] == '[':
                chPos = chPos + 1
            elif 'a' <= s[chPos] <= 'z' or 'A' <= s[chPos] <= 'Z':
                letters = ""
                while chPos < len(s) and ('a' <= s[chPos] <= 'z' or 'A' <= s[chPos] <= 'Z'):
                    letters = letters + s[chPos]
                    chPos = chPos + 1
                letterStack.append(letters)
            elif s[chPos] == ']':
                number = numberStack.pop()
                letter = letterStack.pop()
                numberTemp = number * letter
                if len(letterStack) == 0:
                    letterStack.append(numberTemp)
                else:
                    stackTop = letterStack.pop()
                    letterStack.append(stackTop + numberTemp)
                chPos += 1
            else:
                raise ValueError("invalid cases")

        result = letterStack.pop()
        while len(letterStack) > 0:
            result = letterStack.pop() + result

        return result

    # recursion not working
    def decodeStringDFS(self, s: str) -> str:
        if s is None or len(s) == 0:
            return s
        return self.decodeStringRecursive(s, 0, len(s) - 1)

    def decodeStringRecursive(self, s: str, start: int, end: int) -> str:
        originalStart = start
        originalEnd = end
        while start < end and s[start] is not "[":
            start += 1
        while start < end and s[end] is not "]":
            end -= 1
        if start == end:
            return s[originalStart: originalEnd]
        else:
            return int(s[originalStart:start-1]) * self.decodeString(s, start+1, end-1)

    def test_Normal(self):
        self.assertEqual("", self.decodeString(""))
        self.assertEqual("ab", self.decodeString("1[a]1[b]"))
        self.assertEqual("aaabcbc", self.decodeString("3[a]2[bc]"))
        self.assertEqual("accaccacc", self.decodeString("3[a2[c]]"))
        self.assertEqual("abcabccdcdcdef", self.decodeString("2[abc]3[cd]ef"))
        self.assertEqual("aaabFFFFcbFFFFc", self.decodeString("3[a]2[b4[F]c]"))

if __name__ == '__main__':
    unittest.main()