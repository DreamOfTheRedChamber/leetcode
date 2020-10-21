# Definition for a binary tree node.

import unittest
from typing import List
from typing import Dict

try:
    # Python2
    import queue
except ImportError:
    # Python3
    import Queue as queue

class VerifyingAnAlienDictionary(unittest.TestCase):

    def isAlienSorted(self, words: List[str], order: str) -> bool:
        def inorder(word1: str, word2: str, orderDict: Dict) -> bool:
            for pos in range(min(len(word1), len(word2))):
                if orderDict[word1[pos]] > orderDict[word2[pos]]:
                    return False
                elif orderDict[word1[pos]] == orderDict[word2[pos]]:
                    continue
                else:
                    return True

            if len(word1) <= len(word2):
                return True
            else:
                return False

        orderDict = dict()
        for i in range(len(order)):
            orderDict[order[i]] = i

        if len(words) >= 2:
            for i in range(len(words) - 1):
                if not inorder(words[i], words[i + 1], orderDict):
                    return False

        return True

    def test_WrongAnswer(self):
        # ["apple", "app"]
        # "abcdefghijklmnopqrstuvwxyz"
        self.assertFalse(self.isAlienSorted(["apple", "app"], "abcdefghijklmnopqrstuvwxyz"))
        return

if __name__ == '__main__':
    unittest.main()