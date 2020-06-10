# Definition for a binary tree node.
import unittest

class LargestRectangleInHistogram(unittest.TestCase):

    def test_MonoIncreasing(self):
        self.assertEqual(12, self.largestRectangleArea([1, 2, 3, 4, 5, 6]))

    def test_MonoDecreasing(self):
        self.assertEqual(16, self.largestRectangleArea([7, 6, 5, 4, 3, 2, 1]))

    def test_Normal(self):
        self.assertEqual(10, self.largestRectangleArea([2, 1, 5, 6, 2, 3]))

    def test_WrongAnswer(self):
        self.assertEqual(3, self.largestRectangleArea([2, 1, 2]))

    def largestRectangleArea(self, heights: list) -> int:
        monoIncreasingStack = []
        largestRectangle = 0
        for i in range(len(heights)):
            while len(monoIncreasingStack) > 0 and heights[monoIncreasingStack[-1]] > heights[i]:
                height = heights[monoIncreasingStack.pop()]
                if len(monoIncreasingStack) == 0:
                    width = i
                else:
                    width = i - 1 - monoIncreasingStack[-1]
                largestRectangle = max(largestRectangle, height * width)

            monoIncreasingStack.append(i)

        while len(monoIncreasingStack) > 0:
            xPos = monoIncreasingStack.pop()
            height = heights[xPos]
            if len(monoIncreasingStack) == 0:
                width = i + 1
            else:
                width = i + 1 - monoIncreasingStack[-1] - 1

            largestRectangle = max(largestRectangle, height * width)

        return largestRectangle

if __name__ == '__main__':
    unittest.main()