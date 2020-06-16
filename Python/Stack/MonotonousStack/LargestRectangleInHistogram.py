# Definition for a binary tree node.
import unittest

class LargestRectangleInHistogram(unittest.TestCase):

    def test_MonoIncreasing(self):
        self.assertEqual(12, self.largestRectangleArea([1, 2, 3, 4, 5, 6]))

    def test_MonoDecreasing(self):
        self.assertEqual(16, self.largestRectangleArea([7, 6, 5, 4, 3, 2, 1]))

    def test_Normal(self):
        self.assertEqual(10, self.largestRectangleArea([2, 1, 5, 6, 2, 3]))

    def test_WrongAnswer1(self):
        self.assertEqual(3, self.largestRectangleArea([2, 1, 2]))

    def test_WrongAnswer2(self):
        self.assertEqual(6, self.largestRectangleArea([4, 2, 0, 3, 2, 5]))

    def test_SameHeight(self):
        self.assertEqual(20, self.largestRectangleArea([1, 5, 5, 5, 7]))

    def test_Edgecase(self):
        self.assertEqual(0, self.largestRectangleArea([]))

    def largestRectangleArea(self, heights: list) -> int:
        incStack = []
        heights.append(0)

        result = 0
        for i in range(len(heights)):
            while incStack and heights[incStack[-1]] > heights[i]:
                head = incStack.pop()
                if not incStack:
                    result = max(result, i * heights[head])
                else:
                    result = max(result, (i - 1 - incStack[-1]) * heights[head])
            incStack.append(i)

        return result

if __name__ == '__main__':
    unittest.main()