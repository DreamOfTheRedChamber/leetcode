import unittest
import collections

class BeforeAndAfterPuzzle(unittest.TestCase):
    def beforeAndAfterPuzzles(self, phrases):
        """
        :type phrases: List[str]
        :rtype: List[str]
        """

        dic = collections.defaultdict(list)
        for i, p in enumerate(phrases):
            p = p.split()
            head, rest = p[0], p[1:]
            dic[head].append([i] + rest)

        res = []
        for i, p in enumerate(phrases):
            p = p.split()
            rest, tail = p[:-1], p[-1]
            if tail in dic:
                res += [' '.join(p + i_words[1:]) for i_words in dic[tail] if i_words[0] != i]

        return sorted(set(res))

    @unittest.skip
    def testCase(self):
        self.assertEqual(["a"], self.beforeAndAfterPuzzles(["a", "b", "a"]))
        self.assertEqual(["a man a", "man a man"], self.beforeAndAfterPuzzles(["a man", "man a"]))
        self.assertEqual(["a man on a mission impossible", "a man on a mission statement"], self.beforeAndAfterPuzzles(["mission statement", "mission impossible", "a man on a mission"]))

    def testInvalidInput(self):
        firstSplit = "a  ".split()
        secondSplit = " b ".split()
        self.beforeAndAfterPuzzles(["a  ", " b "])

if __name__ == '__main__':
    unittest.main()