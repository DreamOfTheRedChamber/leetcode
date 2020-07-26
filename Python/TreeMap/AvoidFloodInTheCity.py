# Definition for a binary tree node.
import heapq
import unittest

# Read about enumerate in python
from collections import defaultdict
from typing import List

class AvoidFloodInTheCity(unittest.TestCase):

    def avoidFlood(self, rains: List[int]) -> List[int]:
        # (urgency, city)
        urgencyHeap = []
        # city -> setOfRain represent uncleaned urgency
        cityToRains = dict()
        cityToUrgencyOccurDate = dict()

        # step1: build urgency heap and cityToRains
        for i in range(len(rains)):
            if rains[i] > 0:
                if rains[i] not in cityToRains:
                    cityToRains[rains[i]] = set()
                    cityToUrgencyOccurDate[rains[i]] = i
                else:
                    heapq.heappush(urgencyHeap, (i, cityToUrgencyOccurDate[rains[i]], rains[i]))
                    cityToRains[rains[i]].add(i)

        # step2: for each entry in rains, if rain then put -1; if sunny then pop out one element from urgency map
        # when will fail: city to uncleaned urgency contains
        # when will succeed: finished process the entire array
        result = []
        for i in range(len(rains)):
            if rains[i] > 0:
                if i in cityToRains[rains[i]]:
                    return []
                result.append(-1)
            else:
                if urgencyHeap:
                    urgency, cityToUrgencyOccurDate, city = heapq.heappop(urgencyHeap)
                    result.append(city)
                    if city in cityToRains and urgency in cityToRains[city]:
                        cityToRains[city].remove(urgency)
                else:
                    result.append(10 ** 9)

        if urgencyHeap:
            return []
        return result

    @unittest.skip
    def test_Leetcode(self):
        print(self.avoidFlood([1, 2, 3, 4]))
        print(self.avoidFlood([1, 2, 0, 0, 2, 1]))
        print(self.avoidFlood([1, 2, 0, 1, 2]))
        print(self.avoidFlood([69, 0, 0, 0, 69]))
        print(self.avoidFlood([10, 20, 20]))

    def test_WrongAnswer(self):
        print(self.avoidFlood([0,1,1]))


if __name__ == '__main__':
    unittest.main()