# Definition for a binary tree node.
import bisect
import heapq
import unittest

# Read about enumerate in python
from collections import defaultdict
from typing import List


class OnlineElection(unittest.TestCase):
    class TopVotedCandidate:

        def __init__(self, persons: List[int], times: List[int]):
            self.leads, self.votes, lead = [], defaultdict(lambda: 0), -1
            self.times = times
            for person in persons:
                self.votes[person] += 1
                if self.votes[person] >= self.votes[lead]:
                    lead = person
                self.leads.append(lead)

        def q(self, t: int) -> int:
            insertPos = bisect.bisect_right(self.times, t)
            return self.leads[insertPos-1]

if __name__ == '__main__':
    unittest.main()