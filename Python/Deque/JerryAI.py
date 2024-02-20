# Definition for a binary tree node.
import heapq
import unittest

"""
应该算是一道easy-medium，给定一个数组，只有一个初始数字1，对这个数组的每个数字k，做k*2+1和k*3+1，然后加入数组，要求这个数组是sorted并且没有重复元素，返回第N个
这个数组应该是[1,3,4,7,9,10,13,....]
算法
3(1*2+1), 4(1*3+1)
7(3*2+1), 10(3*3+1)
9(4*2+1), 13(4*3+1)

## 解法分析
因为出现了3算出来的比4还大，所以单纯用queue不行，要用heap，然后用set去重

这个题需要处理的点是对于两个相邻的elements - a(k) 和 a(k+1)，a(k) * 3 + 1 有可能大于 a(k+1) * 2 + 1，所以要排序。
解法一：用一个heap，每次从里面拿最小值。复杂度 O(n logn)
解法二：观察到 k*2 + 1 和 k*3 + 1两个数组是独立递增的，所以可以维护两个deque，每次从两个deque的头去最小值，然后把新的element放到相应的队列里。复杂度 O(n)
我给出的是第二个解法，这轮pass
"""

# Read about enumerate in python
from collections import defaultdict, deque
from typing import List

class JerryAI(unittest.TestCase):

    def calcNth(self, num: int) -> List[int]:
        twoSeries = deque()
        threeSeries = deque()

        result = [1]
        twoSeries.append(1*2 + 1)
        threeSeries.append(1*3 + 1)
        existing = {1}

        for i in range(1, num):
            while twoSeries[0] in existing:
                twoSeries.popleft()
            while threeSeries[0] in existing:
                threeSeries.popleft()

            if twoSeries[0] < threeSeries[0]:
                result.append(twoSeries[0])
                twoSeries.append(2*twoSeries[0] + 1)
                threeSeries.append(3*twoSeries[0] + 1)
                twoSeries.popleft()
            else:
                result.append(threeSeries[0])
                twoSeries.append(2*threeSeries[0] + 1)
                threeSeries.append(3*threeSeries[0] + 1)
                threeSeries.popleft()

        return result

    def test_Leetcode(self):
        print(self.calcNth(7))
        print(self.calcNth(19))

if __name__ == '__main__':
    unittest.main()