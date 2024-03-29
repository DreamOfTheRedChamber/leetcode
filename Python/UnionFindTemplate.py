import unittest

class UnionFind(object):
    def __init__(self, n: int):
        self.uf = [i for i in range(n)]
        self.size = [1] * n

    def find(self, x):
        while x != self.uf[x]:
            self.uf[x] = self.uf[self.uf[x]]
            x = self.uf[x]
        return self.uf[x]

    def union(self, x, y):
        x_root = self.find(x)
        y_root = self.find(y)
        if x_root == y_root:
            return
        self.uf[x_root] = y_root
        self.size[y_root] += self.size[x_root]
        self.size[x_root] = 0

class Template(unittest.TestCase):

    def test_Leetcode(self):
        print([1])

if __name__ == '__main__':
    unittest.main()