"""
题目描述了一个模拟问题，关于一排房屋（或单元格）如何随时间变化。每个房屋在一天结束时都会根据它的邻居的状态来改变自己的状态。题目的具体要求如下：

有八个房屋，排成一直线。
每个房屋都有一个状态，1 代表活跃，0 代表非活跃。
每天每个房屋都会与它的邻居竞争。如果两个邻居的状态相同（都是 1 或都是 0），那么这个房屋第二天就会变成非活跃状态（0）。如果两个邻居的状态不同，
那么这个房屋第二天就会变成活跃状态（1）。
第一和最后的房屋只有一个邻居，可以假设另一个邻居的状态总是 0。
题目要求编写一个算法，输入当前每个房屋的状态和经过的天数，输出给定天数后每个房屋的状态。
输入：第一行是房屋的数量（总是 8）。
第二行包含 8 个空格分隔的整数，表示每个房屋当前的状态（1 或 0）。
第三行是经过的天数。输出：

输出 8 个空格分隔的整数，表示给定天数后每个房屋的状态。
示例：

输入：

8
1 0 0 0 0 1 0 0
1输出：

0 1 0 0 1 0 1 0
解释：

第一个房屋的状态是 1，它的邻居的状态是 0，所以它第二天的状态是 0。
第二个房屋的状态是 0，它的邻居的状态是 1 和 0，所以它第二天的状态是 1。
以此类推，所有房屋第二天的状态是 0 1 0 0 1 0 1 0。

"""


import bisect
import heapq
import unittest
from collections import defaultdict
from typing import List

from sortedcontainers import SortedList

class HousesInALine(unittest.TestCase):

    def test_Normal(self):
        houses = [1, 0, 0, 0, 0, 1, 0, 0]
        print(self.calculateAfterDay(houses, 2))

    def calculateAfterDay(self, initial:List[int], dayNum: int) -> List[int]:
        currDay = []
        nextDay = []
        for i in range(len(initial)):
            currDay.append(initial[i])
            nextDay.append(initial[i])

        for i in range(dayNum):
            for j in range(len(initial)):
                if j == 0:
                    if currDay[1] == 0:
                        nextDay[j] = 0
                    else:
                        nextDay[j] = 1
                elif j == 7:
                    if currDay[6] == 0:
                        nextDay[j] = 0
                    else:
                        nextDay[j] = 1
                else:
                    if currDay[j-1] == currDay[j+1]:
                        nextDay[j] = 0
                    else:
                        nextDay[j] = 1

            for j in range(len(initial)):
                currDay[j] = nextDay[j]

        return currDay

    @unittest.skip
    def test_MultiMatchWithSameDis(self):

        return