# Definition for a binary tree node.
import unittest
import math

# https://leetcode.com/problems/largest-component-size-by-common-factor/discuss/200643/Python-1112-ms-beats-100-Union-Find-and-Prime-factor-decomposition-with-Optimization
# Read about enumerate in python

class UnionFind(object):
    def uf(self, n):
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

class LargestCommonSizeByCommonFactor(unittest.TestCase):

    def largestComponentSize(self, A):
        """
        :type A: List[int]
        :rtype: int
        """

        def primeFactors(n):  # Prime factor decomposition
            out = set()
            while n % 2 == 0:
                out.add(2)
                n //= 2
            for i in range(3, int(math.sqrt(n)) + 1, 2):
                while n % i == 0:
                    out.add(i)
                    n //= i
            if n > 2:
                out.add(n)
            return out

        uf = UnionFind()
        uf.uf(len(A))

        primeToIndex = {}
        for i, a in enumerate(A):
            primes = primeFactors(a)
            for p in primes:
                if p in primeToIndex:
                    uf.union(i, primeToIndex[p])
                primeToIndex[p] = i
        return max(uf.size)

    def test_Components(self):
        self.assertEqual(4, self.largestComponentSize([4, 6, 15, 35]))
        self.assertEqual(2, self.largestComponentSize([20, 50, 9, 63]))
        self.assertEqual(8, self.largestComponentSize([2,3,6,7,4,12,21,39]))

if __name__ == '__main__':
    unittest.main()