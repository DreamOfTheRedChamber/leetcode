# Definition for a binary tree node.
import heapq
import unittest

# Read about enumerate in python
from collections import defaultdict, deque
from typing import List

class WordLadderII(unittest.TestCase):

    def findLadders(self, beginWord: str, endWord: str, wordList: List[str]) -> List[List[str]]:

        def dfs(prevMap: dict, allResults: List[List[str]], oneResult: List[str], currWord: str, endWord: str):
            if currWord == endWord:
                copiedList = oneResult.copy()
                copiedList.reverse()
                allResults.append(copiedList)
                return

            for neighbor in prevMap[currWord]:
                oneResult.append(neighbor)
                dfs(prevMap, allResults, oneResult, neighbor, endWord)
                oneResult.remove(neighbor)

            return

        wordSet = set(wordList)
        if endWord not in wordSet:
            return []
        wordSet.add(beginWord)
        wordSet.add(endWord)

        # build neighbor map
        neighborMap = defaultdict(set)
        for word in wordSet:
            for i in range(len(word)):
                for j in range(26):
                    changedChar = chr(ord('a') + j)
                    newWord = word[:i] + changedChar + word[i+1:]
                    if newWord in wordSet and newWord != word:
                        neighborMap[word].add(newWord)

        prevMap = defaultdict(set)
        bfsQueue = deque()
        bfsQueue.append(beginWord)
        currentLevelSet = {beginWord}
        endFlag = False
        while bfsQueue:
            levelSize = len(bfsQueue)
            nextLevelSet = set()
            for i in range(levelSize):
                head = bfsQueue.popleft()
                for neighbor in neighborMap[head]:
                    if neighbor not in currentLevelSet:
                        bfsQueue.append(neighbor)
                        nextLevelSet.add(neighbor)
                        prevMap[neighbor].add(head)
                        if neighbor == endWord:
                            endFlag = True
            if endFlag:
                break

            for element in nextLevelSet:
                currentLevelSet.add(element)

        allResults = []
        dfs(prevMap, allResults, [endWord], endWord, beginWord)
        return allResults

    def test_Leetcode(self):
        print(self.findLadders("hit", "cog", ["hot","dot","dog","lot","log","cog"]))
        print(self.findLadders("hit", "cog", ["hot","dot","dog","lot","log"]))

if __name__ == '__main__':
    unittest.main()