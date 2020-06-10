# Definition for a binary tree node.
import unittest

class TrappingRainWater(unittest.TestCase):

    def trap(self, height: list) -> int:
        decStack = []
        result = 0
        i = 0
        while i < len(height):
            if decStack and height[decStack[-1]] < height[i]:
                top = decStack.pop()
                if decStack:
                    result += (min(height[decStack[-1]], height[i]) - height[top]) * (i - 1 - decStack[-1])
            else:
                decStack.append(i)
                i += 1

        return result

    def test_MonoContainer(self):
        self.assertEqual(0, self.trap([0, 1, 2, 3, 4, 5]))
        self.assertEqual(0, self.trap([5, 3, 1, 0]))

    def test_Normal(self):
        self.assertEqual(6, self.trap([0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1]))

    def test_EdgeCase(self):
        self.assertEqual(0, self.trap([]))
        self.assertEqual(0, self.trap([1, 2]))
        self.assertEqual(0, self.trap([1]))

    def test_WrongAnswer1(self):
        self.assertEqual(9, self.trap([4, 2, 0, 3, 2, 5]))

    def test_WrongAnswer2(self):
        self.assertEqual(7, self.trap([0, 1, 0, 2, 1, 1, 0, 1, 3, 2, 1, 2, 1]))

if __name__ == '__main__':
    unittest.main()