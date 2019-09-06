import queue
import unittest

class CourseSchedule(unittest.TestCase):
    def canFinishDFS(self, numCourses, prerequisites):
        """
        :type numCourses: int
        :type prerequisites: List[List[int]]
        :rtype: bool
        """

        # build graph
        graph = dict()
        for course in range(numCourses):
            graph[course] = set()
        for prerequisite in prerequisites:
            graph[prerequisite[0]].add(prerequisite[1])

        # depth first search
        discovered = set()
        visited = set()

        for node in graph.keys():
            if not discovered.__contains__(node):
                if not self.canFinishRecurse(node, discovered, visited, graph):
                    return False

        return True

    def canFinishRecurse(self, startNode, discovered, visited, graph):
        if visited.__contains__(startNode):
            return True
        elif discovered.__contains__(startNode) and not visited.__contains__(startNode):
            return False
        else:
            discovered.add(startNode)
            for neighbor in graph[startNode]:
                if not self.canFinishRecurse(neighbor, discovered, visited, graph):
                    return False
            visited.add(startNode)
            return True

    def canFinishBFS(self, numCourses, prerequisites):
        """
        :type numCourses: int
        :type prerequisites: List[List[int]]
        :rtype: bool
        """

        # build graph
        indegreeMap = dict()
        outdegreeMap = dict()
        for course in range(numCourses):
            indegreeMap[course] = 0
            outdegreeMap[course] = set()
        for prerequisite in prerequisites:
            indegreeMap[prerequisite[1]] += 1
            outdegreeMap[prerequisite[0]].add(prerequisite[1])

        searchQueue = queue.Queue()
        for key,value in indegreeMap.items():
            if value == 0:
                searchQueue.put(key)


        while not searchQueue.empty():
            poppedOut = searchQueue.get()
            del indegreeMap[poppedOut]
            for outgoingNode in outdegreeMap[poppedOut]:
                indegreeMap[outgoingNode] -= 1
                if indegreeMap[outgoingNode] == 0:
                    searchQueue.put(outgoingNode)

        return len(indegreeMap) == 0

    @unittest.skip
    def test_circleBFS(self):
        self.assertEqual(self.canFinishBFS(2, [[1, 0], [0, 1]]), False)

    @unittest.skip
    def test_singleBFS(self):
        self.assertEqual(self.canFinishBFS(0, []), True)

    def test_multiComponentBFS(self):
        self.assertEqual(self.canFinishBFS(5, [[0, 1], [0, 4], [1, 2], [1, 3], [2, 3], [4, 2]]), True)

    def test_circleDFS(self):
        self.assertEqual(self.canFinishDFS(2, [[1, 0], [0, 1]]), False)

    def test_singleDFS(self):
        self.assertEqual(self.canFinishDFS(0, []), True)

    def test_multiComponentDFS(self):
        self.assertEqual(self.canFinishDFS(5, [[0, 1], [0, 4], [1, 2], [1, 3], [2, 3], [4, 2]]), True)



if __name__ == '__main__':
    unittest.main()