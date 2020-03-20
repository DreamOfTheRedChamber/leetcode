# Definition for a binary tree node.
import unittest

# Read about enumerate in python

class SentenceSimilarity(unittest.TestCase):

    def areSentencesSimilarTwo(self, words1, words2, pairs):
        """
        :type words1: List[str]
        :type words2: List[str]
        :type pairs: List[List[str]]
        :rtype: bool
        """

        def findRoot(w, parents):
            if w not in parents:
                parents[w] = w
            while w in parents and parents[w] != w:
                w = parents[w]
            return w

        parents = {}
        for a, b in pairs:
            aRoot = findRoot(a, parents)
            bRoot = findRoot(b, parents)
            parents[aRoot] = bRoot

        l1, l2 = len(words1), len(words2)
        if l1 != l2:
            return False

        for i in range(l1):
            rootWord1, rootWord2 = findRoot(words1[i], parents), findRoot(words2[i], parents)
            if rootWord1 != rootWord2:
                return False

        return True

    def test_Components(self):
        self.assertTrue(self.areSentencesSimilarTwo(
                                ["great", "acting", "skills"],
                                ["fine", "drama", "talent"],
                                [["great", "good"], ["fine", "good"], ["acting", "drama"], ["skills", "talent"]]))

if __name__ == '__main__':
    unittest.main()