# Definition for a binary tree node.
import unittest

# Read about enumerate in python

class EscapeTheGhosts(unittest.TestCase):

    def test_Normal(self):
        self.assertTrue(self.escapeGhosts([[1, 0], [0, 3]], [0, 1]))
        self.assertFalse(self.escapeGhosts([[1, 0]], [2, 0]))
        self.assertFalse(self.escapeGhosts([[2, 0]], [1, 0]))

    def test_ErrorCase(self):
        self.assertFalse(self.escapeGhosts([[1, 9], [2, -5], [3, 8], [9, 8], [-1, 3]], [8, -10]))

    def escapeGhosts(self, ghosts: list, target: list) -> bool:
        minPlayerToTarget = abs(target[0]) + abs(target[1])

        for ghost in ghosts:
            minGhostToTarget = abs(ghost[0] - target[0]) + abs(ghost[1] - target[1])
            if minGhostToTarget < minPlayerToTarget:
                return False

        return True

if __name__ == '__main__':
    unittest.main()