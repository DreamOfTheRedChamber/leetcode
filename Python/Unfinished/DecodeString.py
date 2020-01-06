# Definition for a binary tree node.
import unittest

from collections import deque
# Read about enumerate in python

class DecodeString(unittest.TestCase):

    # Please look at HashMap solution here: https://leetcode.com/problems/decode-string/discuss/449085/Python3-Solution-Using-HashMap-greater99-Runtime-100-Memory
    def decodeString(self, s):
        from collections import defaultdict

        # Hashmap explained: key = current level, value = tuple with (multiplier, string)
        d = defaultdict(lambda: [0, ""])
        level = 1  # start at level 1 so level 0 is global chars not contained in brackets
        n = ""
        res = ""

        for i, ch in enumerate(s):
            # increment level
            if ch == "[":
                d[level] = [int(n), ""]
                n = ""
                level += 1

            # decrement level
            elif ch == "]":
                d[level - 2][1] += d[level - 1][0] * d[level - 1][1]
                d[level - 1] = [0, ""]
                level -= 1

            # write to current level, d[0] = global level
            elif ch.isalpha():
                d[level - 1][1] += ch

            # build current number
            else:
                n += ch

        return d[0][1]  # return d[0], result of global level string


    def decodeStringWrong(self, s: str) -> str:
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
                letterStack.append(word)
                word = ""
                chPos = chPos + 1
            elif s[chPos] == ']':
                temp = letterStack.pop()
                number = numberStack.pop()
                word = number * temp
                chPos += 1
            else:
                word = word + s[chPos]
                chPos += 1

        return word

    # stack based algorithm is so error prone
    def decodeStringStackErrorProne(self, s: str) -> str:
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

                if len(letterStack) == len(numberStack) + 1:
                    numberStack.append(1)
            elif s[chPos] == ']':
                number = numberStack.pop()
                letter = letterStack.pop()
                numberTemp = number * letter
                if len(letterStack) == 0:
                    letterStack.append(numberTemp)
                    numberStack.append(1)
                else:
                    stackTop = letterStack.pop()
                    letterStack.append(stackTop + numberTemp)

                chPos += 1
            else:
                raise ValueError("invalid cases")

        result = ""
        while len(letterStack) > 0:
            result = letterStack.pop() * numberStack.pop() + result

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
        self.assertEqual("zzzyypqjkjkefjkjkefjkjkefjkjkefyypqjkjkefjkjkefjkjkefjkjkefef", self.decodeString("3[z]2[2[y]pq4[2[jk]e1[f]]]ef"))

if __name__ == '__main__':
    unittest.main()