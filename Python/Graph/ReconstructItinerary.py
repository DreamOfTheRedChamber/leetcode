# Definition for a binary tree node.
import unittest
import collections

# Read about enumerate in python

class ReconstructItinerary(unittest.TestCase):

    def findItinerary(self, tickets: list):
        """
        :type tickets: List[List[str]]
        :rtype: List[str]
        """

        def dfs(start: str, graph: dict, path: list) -> list:
            if len(path) == len(tickets) + 1:
                return path

            sortedNeighbors = sorted(graph[start])
            for neighbor in sortedNeighbors:
                graph[start].remove(neighbor)
                path.append(neighbor)

                result = dfs(neighbor, graph, path)
                if len(result) > 0:
                    return result

                path.remove(neighbor)
                graph[start].append(neighbor)

            return []

        graph = collections.defaultdict(list)
        for start, end in tickets:
            graph[start].append(end)

        return dfs("JFK", graph, ["JFK"])

    def test_singleLine(self):
        tickets = [["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]]
        print(self.findItinerary(tickets))

    def test_cycle(self):
        tickets = [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
        print(self.findItinerary(tickets))

if __name__ == '__main__':
    unittest.main()