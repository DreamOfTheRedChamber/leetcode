# Definition for a binary tree node.
import heapq
import unittest

class DivideTwoIntegers(unittest.TestCase):

    def divide(self, dividend: int, divisor: int) -> int:
        sign = 1 if (dividend > 0) == (divisor > 0) else -1
        if dividend == -2**31 and divisor == -1:
            return 2**31 - 1

        dividend = abs(dividend)
        divisor = abs(divisor)

        highestShift = 0
        while (divisor << highestShift) <= dividend:
            highestShift += 1

        quotient = 0
        for i in reversed(range(0, highestShift)):
            if dividend >= (divisor << i):
                quotient += (1 << i)
                dividend -= (divisor << i)

        return quotient * sign

    def test_Leetcode(self):
        self.assertEqual(3, self.divide(10, 3))
        self.assertEqual(-2, self.divide(7, -3))

    def test_Edgecase(self):
        self.assertEqual(0, self.divide(0, -2))
        self.assertEqual(2**31 - 1, self.divide(-2**31, -1))

    ## < > <= >= signs are the place which really error-prone
    def test_WrongAnswer(self):
        self.assertEqual(1, self.divide(1, 1))

if __name__ == '__main__':
    unittest.main()