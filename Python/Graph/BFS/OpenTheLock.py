# Definition for a binary tree node.
import heapq
import unittest

# Read about enumerate in python
from collections import defaultdict, deque
from typing import List


class OpenTheLock(unittest.TestCase):

    def openLock(self, deadends: List[str], target: str) -> int:
        def successors(src):
            res = []
            for i, ch in enumerate(src):
                num = int(ch)
                res.append(src[:i] + str((num - 1) % 10) + src[i + 1:])
                res.append(src[:i] + str((num + 1) % 10) + src[i + 1:])
            return res

        bfsQueue = deque(["0000"])
        discovered = set(deadends)
        depth = 0
        while bfsQueue:
            for i in range(len(bfsQueue)):
                queueTop = bfsQueue.popleft()
                if queueTop == target:
                    return depth
                if queueTop in discovered:
                    continue
                bfsQueue.extend(successors(queueTop))
                discovered.add(queueTop)
            depth += 1

        return -1

    def test_Leetcode(self):
        self.assertEqual(6, self.openLock(["0201", "0101", "0102", "1212", "2002"], "0202"))
        self.assertEqual(1, self.openLock(["8888"], "0009"))
        self.assertEqual(-1, self.openLock(["8887", "8889","8878","8898","8788","8988","7888","9888"], "8888"))
        self.assertEqual(-1, self.openLock(["0000"], "8888"))

if __name__ == '__main__':
    unittest.main()