# Definition for a binary tree node.
import heapq
import unittest

"""
## 描述
coding只有15分钟到20分钟，题目是给一个int，输出最小的，大于这个数的回文串：比如说：12300 -> 12321。

## 分析
解答：分情况讨论，基本思路是从中间劈开，‍构建回文串，如果需要在中间+1的话就+1，比如12385 -> 12421。但是这个有好多edge case，比如999，个位数一类的，我没有cover所有的edge case
"""

class NextBiggerPalindrome(unittest.TestCase):

    def nextBigger(self, palindrome: int) -> int:
        palinStr = str(palindrome)
        if palindrome < 9 :
            return palindrome + 1

        for i in reversed(range(len(palinStr))):
### assume that bits bigger than i does not need to change
            newPalinStr = list(palinStr)
            biggestNumStr = list(palinStr)
            for j in range(i, len(palinStr)):
                newPalinStr[j] = newPalinStr[len(palinStr) - 1 - j]
                biggestNumStr[j] = '9'
            newPalinInt = int(''.join(newPalinStr))
            biggestNumInt = int(''.join(biggestNumStr))

            while newPalinInt <= biggestNumInt:
                if self.isPalindrome(str(newPalinInt)) and newPalinInt > palindrome:
                    return newPalinInt
                newPalinInt += 1

        palindrome += 1
        while not self.isPalindrome(str(palindrome)):
            palindrome += 1
        return palindrome

    def isPalindrome(self, value: str):
        for i in range(len(value)):
            if value[i] != value[len(value) - i - 1]:
                return False
        return True

    def test_Leetcode(self):
        self.assertEqual(15751, self.nextBigger(15679))
        self.assertEqual(149941, self.nextBigger(149083))
        self.assertEqual(13631, self.nextBigger(13591))
        self.assertEqual(1, self.nextBigger(0))
        self.assertEqual(101, self.nextBigger(99))


if __name__ == '__main__':
    unittest.main()