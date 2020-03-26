# Definition for a binary tree node.
import unittest

# Read about enumerate in python
from collections import defaultdict
from typing import List

class KillProcess(unittest.TestCase):

    def killProcess(self, pid: List[int], ppid: List[int], kill: int) -> List[int]:
        nodeToChildren = defaultdict(list)
        for idx, value in enumerate(ppid):
            nodeToChildren[value].append(pid[idx])

        result = []
        toKill = [kill]
        while (toKill):
            cur = toKill.pop()
            toKill += nodeToChildren[cur]
            result.append(cur)

        return result

    def test_Test1(self):
        print(self.killProcess([1, 3, 10, 5], [3, 0, 5, 3], 5))
        print(self.killProcess([1, 3, 10, 5], [3, 0, 5, 3], 10))
        print(self.killProcess([1, 3, 10, 5], [3, 0, 5, 3], 3))

if __name__ == '__main__':
    unittest.main()