import unittest

class ContainerWithMostWater(unittest.TestCase):

    def maxArea(self, height: list) -> int:
        start = 0
        end = len(height) - 1
        maxArea = 0

        while start < end:
            currentArea = min(height[start], height[end]) * (end - start)
            if currentArea > maxArea:
                maxArea = currentArea
            if height[start] < height[end]:
                start += 1
            else:
                end -= 1

        return maxArea

if __name__ == '__main__':
    unittest.main()