"""
6.	题目描述了一种叫做“最短作业优先”（Shortest Job First, SJF）的任务调度系统。在这个系统中，每个任务请求都有两个特点：一个是请求时间（也就是任务提交给系统的时间），另一个是任务的持续时间（完成任务所需要的时间）。

当SJF系统完成一个任务时，它会选择下一个要执行的任务。被选中的任务是所有当前等待的任务中持续时间最短的那个。如果有多个任务的持续时间相同，那么系统会选择请求时间最早的那个任务。

任务的等待时间是任务的请求时间与它实际开始执行的时间之间的差值。题目要求计算使用SJF调度算法时，任务的平均等待时间。输入：

第一行包含一个正整数，表示任务的数量。
第二行包含多个整数，表示每个任务的请求时间。
第三行也包含一个正整数，再次确认任务的数量。
第四行包含多个整数，表示每个任务的持续时间。输出：

输出一个实数，表示使用非抢占式SJF调度算法计算出的任务平均等待时间，结果保留两位小数。

约束条件：
任务的请求时间和持续时间都是按照请求时间的升序排序的。
0 ≤ 请求时间<1000
0 < 持续时间 < 100
0≤请求时间<1000,0<持续时间<100

"""

import bisect
import heapq
import unittest
from collections import defaultdict
from typing import List

from sortedcontainers import SortedList

class ShortestJobPath(unittest.TestCase):

    def test_Normal(self):
        jobList = [(3, 1), (3, 4), (1, 5)]
        print(self.calculateAverageWaitTime(jobList))

    @unittest.skip
    def test_MultiMatchWithSameDis(self):

        return

    def calculateAverageWaitTime(self, jobList: List) -> int:
        sortedJobList = sorted(jobList, key=lambda x: (x[0], x[1]))
        print(sortedJobList)

        heapq.heapify(sortedJobList)
        currTime = sortedJobList[0][0]

        totalWaitTime = 0
        while len(sortedJobList) > 0:
            heapTop = heapq.heappop(sortedJobList)

            waitTime = abs(heapTop[0] - currTime)
            totalWaitTime += waitTime

            currTime = currTime + heapTop[1]

        return totalWaitTime / len(jobList)

if __name__ == '__main__':
    unittest.main()