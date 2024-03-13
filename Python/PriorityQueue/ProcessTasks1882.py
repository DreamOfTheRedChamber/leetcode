# Definition for a binary tree node.
import heapq
import unittest

# Read about enumerate in python
from collections import defaultdict
from typing import List

class ProcessTasks1882(unittest.TestCase):

    def assignTasks(self, servers: List[int], tasks: List[int]) -> List[int]:
        available = []
        for i in range(len(servers)):
            heapq.heappush(available, (servers[i], i))

        unavailable = []
        result = []
        for ts in range(len(tasks)):

            while unavailable and unavailable[0][0] <= ts:
                freeTs, weight, index = heapq.heappop(unavailable)
                heapq.heappush(available, (servers[index], index))

            if available:
                weight, index = heapq.heappop(available)
                heapq.heappush(unavailable, (ts + tasks[ts], servers[index], index))
                result.append(index)
            else:
                freeTs, weight, index = heapq.heappop(unavailable)
                heapq.heappush(unavailable, (freeTs + tasks[ts], servers[index], index))
                result.append(index)

        return result

    def test_example1(self):
        servers = [3, 3, 2]
        tasks = [1, 2, 3, 2, 1, 2]

        # [2,2,0,2,1,2]
        print(self.assignTasks(servers, tasks))

    def test_example2(self):
        servers = [5, 1, 4, 3, 2]
        tasks = [2, 1, 2, 4, 5, 2, 1]

        # [1, 4, 1, 4, 1, 3, 2]
        print(self.assignTasks(servers, tasks))

    def test_example3(self):
        servers = [0, 1]
        tasks = [10, 5, 5]

        # [0, 1, 1]
        print(self.assignTasks(servers, tasks))

if __name__ == '__main__':
    unittest.main()