# Definition for a binary tree node.
import bisect
import unittest
from collections import defaultdict, deque
from typing import List

from sortedcontainers import SortedList

class ResourceAccess(unittest.TestCase):

    def highestNumAccessPerResourceIn5Minutes(self, input: List[List[str]]):
        resourceToAccessTs = defaultdict(lambda: [])
        for entry in input:
            resourceToAccessTs[entry[2]].append(int(entry[0]))
        for key, value in resourceToAccessTs.items():
            resourceToAccessTs[key] = sorted(value)

        result = 0
        resultResource = ""
        for key, value in resourceToAccessTs.items():
            queue = deque()
            for i in value:
                while queue and queue[0] + 60 * 5 < i:
                    queue.popleft()
                queue.append(i)
                if len(queue) > result:
                    result = max(result, len(queue))
                    resultResource = key

        return resultResource + "," + str(result)

    @unittest.skip
    def test_minMaxAccess(self):
        log1 = ([["58523", "user_1", "resource_1"],
        ["62314", "user_2", "resource_2"],
        ["54001", "user_1", "resource_3"],
        ["200", "user_6", "resource_5"],
        ["215", "user_6", "resource_4"],
        ["54060", "user_2", "resource_3"],
        ["53760", "user_3", "resource_3"],
        ["58522", "user_22", "resource_1"],
        ["53651", "user_5", "resource_3"],
        ["2", "user_6", "resource_1"],
        ["100", "user_6", "resource_6"],
        ["400", "user_7", "resource_2"],
        ["100", "user_8", "resource_6"],
        ["54359", "user_1", "resource_3"]])

        return

    def test_accessWindow(self):
        log2 = ( [
["300", "user_1", "resource_3"],
["599", "user_1", "resource_3"],
["900", "user_1", "resource_3"],
["1199", "user_1", "resource_3"],
["1200", "user_1", "resource_3"],
["1201", "user_1", "resource_3"],
["1202", "user_1", "resource_3"]
])

        log1 = ([["58523", "user_1", "resource_1"],
        ["62314", "user_2", "resource_2"],
        ["54001", "user_1", "resource_3"],
        ["200", "user_6", "resource_5"],
        ["215", "user_6", "resource_4"],
        ["54060", "user_2", "resource_3"],
        ["53760", "user_3", "resource_3"],
        ["58522", "user_22", "resource_1"],
        ["53651", "user_5", "resource_3"],
        ["2", "user_6", "resource_1"],
        ["100", "user_6", "resource_6"],
        ["400", "user_7", "resource_2"],
        ["100", "user_8", "resource_6"],
        ["54359", "user_1", "resource_3"]])

        print(self.highestNumAccessPerResourceIn5Minutes(log1))



if __name__ == '__main__':
    unittest.main()