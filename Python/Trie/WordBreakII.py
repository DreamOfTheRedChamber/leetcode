# Definition for a binary tree node.
import heapq
import unittest

# Read about enumerate in python
from collections import defaultdict
from typing import List

class TrieNode:

    def __init__(self, val: str, isEnd: bool):
        self.val = val
        self.children = dict()
        self.isEnd = isEnd

class Trie:

    def __init__(self):
        self.root = TrieNode(" ", False)

    def insert(self, word: str):
        currNode = self.root
        for i in range(len(word)):
            if word[i] not in currNode.children:
                newNode = TrieNode(word[i], False)
                currNode.children[word[i]] = newNode

            currNode = currNode.children[word[i]]
            if i == len(word) - 1:
                currNode.isEnd = True

        return

    def search(self, word: str, start: int) -> List[str]:
        result = []
        currNode = self.root
        pos = start
        while pos < len(word) and word[pos] in currNode.children:
            currNode = currNode.children[word[pos]]
            if currNode.isEnd:
                result.append(word[start: pos + 1])
            pos += 1

        return result

class WordBreakII(unittest.TestCase):

    def wordBreakWithTrie(self, s: str, pos: int, trie: Trie, currPath: List[str], allPaths: List[List[str]]):
        if pos == len(s):
            allPaths.append(" ".join(currPath.copy()))
            return

        nextWords = trie.search(s, pos)
        for word in nextWords:
            currPath.append(word)
            self.wordBreakWithTrie(s, pos + len(word), trie, currPath, allPaths)
            currPath.pop()

        return

    def wordBreak(self, s: str, wordDict: List[str]) -> List[str]:
        trie = Trie()
        for word in wordDict:
            trie.insert(word)

        result = []
        self.wordBreakWithTrie(s, 0, trie, [], result)
        return result

    def test_example1(self):
        s = "catsanddog"
        wordDict = ["cat", "cats", "and", "sand", "dog"]
        # expect ["cats and dog","cat sand dog"]
        print(self.wordBreak(s, wordDict))

    def test_example2(self):
        s = "pineapplepenapple"
        wordDict = ["apple", "pen", "applepen", "pine", "pineapple"]
        # expect ["pine apple pen apple","pineapple pen apple","pine applepen apple"]
        print(self.wordBreak(s, wordDict))

    def test_example3(self):
        s = "catsandog"
        wordDict = ["cats", "dog", "sand", "and", "cat"]
        # expect []
        print(self.wordBreak(s, wordDict))

if __name__ == '__main__':
    unittest.main()