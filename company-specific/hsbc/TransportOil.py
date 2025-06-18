"""
18.	Question
amount of oil that can be transported via the network at any given time.
Constraints
•	3≤num≤1053≤num≤105
•	1≤baseR≤1051≤baseR≤105
•	1≤rate≤1031≤rate≤103
•	numCon = num - 1
•	charCon = 3

Example
Input:
深色版本
6
4
5 3
4 2 10
4 6 20
4 1 30
1 3 50
1 5 80
Output:

Explanation:
Oil is transported in the network as shown below:
•	From pipe (4) -> (2): 10 units of oil is transported.
•	From pipe (4) -> (6): 20 units of oil is transported.
•	From pipes (4) -> (1) -> (3) & (4) -> (1) -> (5): only 30 units of oil can be transported, as the (4)-(1) pipe can transfer only 30 units of oil.
•	So, the maximum optimal flow through the network is 60(10+20+30).
"""


import bisect
import heapq
import sys
import unittest
from collections import defaultdict

class TransportOil(unittest.TestCase):

    def calcMaxFlow(self, start: int, upperLimit: int, directedGraph: defaultdict) -> int:

        if len(directedGraph[start]) == 0:
            return upperLimit

        totalFlow = 0
        for neighborEnd, pathWeight in directedGraph[start]:
            totalFlow += self.calcMaxFlow(neighborEnd, pathWeight, directedGraph)

        return min(upperLimit, totalFlow)

    def test_Normal(self):
        edges = [[4, 2, 10], [4, 6, 20], [4, 1, 30], [1, 3, 50], [1, 5, 80]]
        root = 4

        # build a directed graph with end and weight
        directedGraph = defaultdict(lambda: [])
        for edge in edges:
            start, end, weight = edge
            directedGraph[start].append((end, weight))

        result = self.calcMaxFlow(root, sys.maxsize, directedGraph)
        print(result)