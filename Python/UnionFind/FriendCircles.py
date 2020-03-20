# Definition for a binary tree node.
import unittest

# Read about enumerate in python

class FriendCircles(unittest.TestCase):

    def findCircleNum(self, M: list) -> int:

        def findRoot(node, circles):
            root = circles[node]
            while root != circles[root]:
                root = circles[root]
            return root

        n = len(M)
        circles = {x: x for x in range(n)}
        for i in range(n):
            for j in range(i, n):
                if i != j and M[i][j] == 1 and findRoot(i, circles) != findRoot(j, circles):
                    circles[findRoot(i, circles)] = findRoot(j, circles)

        return sum([1 for k, v in circles.items() if k == v])

    def test_Components(self):
        array2D_one = [[1, 1, 0], [1, 1, 0], [0, 0, 1]]
        self.assertEqual(2, self.findCircleNum(array2D_one))

        array2D_two = [[1, 1, 0], [1, 1, 1], [0, 1, 1]]
        self.assertEqual(1, self.findCircleNum(array2D_two))

if __name__ == '__main__':
    unittest.main()