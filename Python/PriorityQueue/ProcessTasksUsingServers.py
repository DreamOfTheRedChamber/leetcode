# Definition for a binary tree node.
import heapq
import unittest

# Read about enumerate in python
from collections import defaultdict
from typing import List

class ProcessTasksUsingServers(unittest.TestCase):

    def assignTasks(self, servers: List[int], tasks: List[int]) -> List[int]:


        return []

    def test_example1(self):
        servers = [3, 3, 2]
        tasks = [1, 2, 3, 2, 1, 2]

        # [2,2,0,2,1,2]
        print(self.assignTasks(servers, tasks))

    def test_example2(self):
        servers = [5, 1, 4, 3, 2]
        tasks = [2, 1, 2, 4, 5, 2, 1]

        # [1,4,1,4,1,3,2]
        print(self.assignTasks(servers, tasks))

if __name__ == '__main__':
    unittest.main()