# Definition for a binary tree node.
import heapq
import unittest

# Read about enumerate in python
from collections import defaultdict
from typing import List

class UnionFind(object):
    def __init__(self, words: set):
        self.parent = dict()
        self.size = dict()

        for word in words:
            self.parent[word] = word
            self.size[word] = 1

    def find(self, x: str) -> str:
        if x == self.parent[x]:
            return x
        else:
            return self.find(self.parent[x])

    def union(self, x: str, y: str):
        xRoot = self.find(x)
        yRoot = self.find(y)
        if xRoot == yRoot:
            return
        elif self.size[xRoot] > self.size[yRoot]:
            self.parent[yRoot] = xRoot
            self.size[xRoot] += self.size[yRoot]
        else:
            self.parent[xRoot] = yRoot
            self.size[yRoot] += self.size[xRoot]

class SynonymousSentences(unittest.TestCase):

    def dfs(self, currPos: int, textItems: List[str], rootToWords: dict, words: set, uf: UnionFind, oneResult: List[str], allResult: List[str]):
        if currPos == len(textItems):
            allResult.append(' '.join(oneResult))
            return

        if textItems[currPos] not in words:
            oneResult.append(textItems[currPos])
            self.dfs(currPos + 1, textItems, rootToWords, words, uf, oneResult, allResult)
        else:
            root = uf.find(textItems[currPos])
            for poss in rootToWords[root]:
                oneResult.append(poss)
                self.dfs(currPos + 1, textItems, rootToWords, words, uf, oneResult, allResult)
                oneResult.pop()

    def generateSentences(self, synonyms: List[List[str]], text: str) -> List[str]:
        words = set()
        for word1, word2 in synonyms:
            words.add(word1)
            words.add(word2)

        uf = UnionFind(words)
        for word1, word2 in synonyms:
            uf.union(word1, word2)

        rootToWords = defaultdict(list)
        for word in words:
            root = uf.find(word)
            rootToWords[root].append(word)

        textItems = text.split(' ')
        allResults = []
        self.dfs(0, textItems, rootToWords, words, uf, [], allResults)
        return allResults

    def test_example1(self):
        synonyms = [["happy", "joy"], ["sad", "sorrow"],["joy", "cheerful"]]
        text = "I am happy today but was sad yesterday"
        result = self.generateSentences(synonyms, text)
        print(result)

    def test_example2(self):
        synonyms = [["happy", "joy"], ["cheerful", "glad"]]
        text = "I am happy today but was sad yesterday"
        result = self.generateSentences(synonyms, text)
        print(result)

if __name__ == '__main__':
    unittest.main()