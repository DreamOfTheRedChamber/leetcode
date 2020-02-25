# Definition for a binary tree node.
import unittest

class TrappingRainWater(unittest.TestCase):

    def trap(self, height: list) -> int:
        monoDecStack = []
        maxTrappedWater = 0

        for i in range(len(height)):
            while len(monoDecStack) > 0 and height[monoDecStack[-1]] < height[i]:
                stackTop = monoDecStack.pop()
                trappedHeighth = min(0 if len(monoDecStack) == 0 else height[monoDecStack[-1]], height[i]) - height[stackTop]
                trappedWidth = 0 if len(monoDecStack) == 0 else i - 1 - monoDecStack[-1]
                maxTrappedWater += trappedHeighth * trappedWidth

            monoDecStack.append(i)

        return maxTrappedWater

    def test_MonoContainer(self):
        self.assertEqual(0, self.trap([0, 1, 2, 3, 4, 5]))
        self.assertEqual(0, self.trap([5, 3, 1, 0]))

    def test_Normal(self):
        self.assertEqual(6, self.trap([0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1]))
        self.assertEqual(7, self.trap([0, 1, 0, 2, 1, 1, 0, 1, 3, 2, 1, 2, 1]))

    def test_EdgeCase(self):
        self.assertEqual(0, self.trap([]))
        self.assertEqual(0, self.trap([1, 2]))
        self.assertEqual(0, self.trap([1]))

if __name__ == '__main__':
    unittest.main()