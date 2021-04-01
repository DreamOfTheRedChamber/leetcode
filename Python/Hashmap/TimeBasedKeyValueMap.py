import heapq
import unittest
from collections import defaultdict

class TimeMap:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.valueToTimeKeyEntry = defaultdict(lambda: [])

    def set(self, key: str, value: str, timestamp: int) -> None:
        heapq.heappush(self.valueToTimeKeyEntry[key], (-timestamp, value))

    def get(self, key: str, timestamp: int) -> str:
        tempList = []
        maxHeap = self.valueToTimeKeyEntry[key]

        result = ""
        while maxHeap:
            topTime, topValue = heapq.heappop(maxHeap)
            tempList.append((topTime, topValue))
            if -topTime <= timestamp:
                result = topValue
                break

        for item in tempList:
            heapq.heappush(maxHeap, item)

        return result

class TestFailure(unittest.TestCase):

    def test_failure(self):
    #        Input: inputs = ["TimeMap", "set", "get", "get", "set", "get", "get"], inputs = [[], ["foo", "bar", 1],
    #                                                                                         ["foo", 1], ["foo", 3],
    #                                                                                         ["foo", "bar2", 4], ["foo", 4],
    #                                                                                         ["foo", 5]]
    #        Output: [null, null, "bar", "bar", null, "bar2", "bar2"]
        timeMap = TimeMap()
        timeMap.set("foo", "bar", 1)
        print(timeMap.get("foo", 1))
        print(timeMap.get("foo", 3))
        timeMap.set("foo", "bar2", 4)
        print(timeMap.get("foo", 4))
        print(timeMap.get("foo", 5))

