import heapq
import unittest
from typing import List, Tuple


class Node:
    def __init__(self, char: str):
        self.char = char
        self.time = 0
        self.sentence = ""
        self.children = dict()
        return

    def __lt__(self, other):
        if self.time < other.time:
            return True
        elif self.time > other.time:
            return False
        else:
            return self.sentence > other.sentence

class Trie:

    def __init__(self):
        self.root = Node("0")
        self.prev = self.root

    def insert(self, word: str, time: int) -> None:
        curr = self.root
        for i in range(len(word)):
            char = word[i]
            if char in curr.children:
                curr = curr.children[char]
            else:
                newNode = Node(char)
                curr.children[char] = newNode
                curr = newNode

        curr.sentence = word
        curr.time = time
        return


class AutocompleteSystem:

    def __init__(self, sentences: List[str], times: List[int]):
        self.trie = Trie()
        for sentence, time in zip(sentences, times):
            self.trie.insert(sentence, time)

    def input(self, c: str) -> list:
        def getLeaves(node: Node, pq: List[Node]):
            if node is None:
                return
            if node.time != 0:
                heapq.heappush(pq, node)
                if len(pq) > 3:
                    heapq.heappop(pq)

            for value in node.children.values():
                getLeaves(value, pq)

            return

        if c == "#":
            self.trie.prev = self.trie.root
            return []

        pq = []  # Node
        if c in self.trie.prev.children:
            getLeaves(self.trie.prev.children[c], pq)
            self.trie.prev = self.trie.prev.children[c]

        result = []
        while pq:
            result.append(heapq.heappop(pq).sentence)
        result.reverse()
        return result

class DesignSearchAutoComplete(unittest.TestCase):

    def test_basicCase(self):
        autocomp = AutocompleteSystem(["i love you","island","iroman","i love leetcode"], [5,3,2,2])
        resultI = autocomp.input("i")
        resultSpace = autocomp.input(" ")
        resultA = autocomp.input("a")
        resultSharp = autocomp.input("#")

    @unittest.skip
    def test_priority(self):
        sentences = ["i love you", "island", "iroman", "i love leetcode"]
        times = [5, 3, 2, 2]
        pq = []
        for s, t in zip(sentences, times):
            heapq.heappush(pq, (-t, s))

        result = []
        while pq:
            top = heapq.heappop(pq)
            result.append(top[1])
        print(result)