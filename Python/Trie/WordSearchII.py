import unittest
from typing import List


class TrieNode:
    def __init__(self, value: str):
        self.value = value
        self.children = dict()
        self.isLeaf = False


class Trie:
    def __init__(self):
        self.root = TrieNode(0)

    def add(self, memberStr: str):
        currNode = self.root

        for i in range(len(memberStr)):
            if memberStr[i] in currNode.children:
                currNode = currNode.children[memberStr[i]]
            else:
                newNode = TrieNode(memberStr[i])
                currNode.children[memberStr[i]] = newNode
                currNode = newNode

            if i == len(memberStr) - 1:
                currNode.isLeaf = True
        return

    def search(self, memberStr: str) -> bool:
        currNode = self.root

        for i in range(len(memberStr)):
            if memberStr[i] in currNode.children:
                currNode = currNode.children[memberStr[i]]
            else:
                return False

            if i == len(memberStr) - 1 and currNode.isLeaf:
                return True

        return False


class Solution:
    def findWords(self, board: List[List[str]], words: List[str]) -> List[str]:
        def dfs(xCor: int, yCor: int, path: str, node: TrieNode):
            if path[-1] not in node.children:
                return
            if node.children[path[-1]].isLeaf:

            # if node.isLeaf:
                result.append(path)

            direcs = [[0, 1], [1, 0], [-1, 0], [0, -1]]
            for direc in direcs:
                xNeigh = xCor + direc[0]
                yNeigh = yCor + direc[1]
                if 0 <= xNeigh < height and 0 <= yNeigh < width:
                    if visited[xNeigh][yNeigh]:
                        continue

                    visited[xNeigh][yNeigh] = True
                    dfs(xNeigh, yNeigh, path + board[xNeigh][yNeigh], node.children[path[-1]])
                    visited[xNeigh][yNeigh] = False
            return

        trie = Trie()
        for word in words:
            trie.add(word)

        result = []
        height, width = len(board), len(board[0])
        visited = [[False for j in range(width)] for i in range(height)]
        for i in range(height):
            for j in range(width):
                visited[i][j] = True
                dfs(i, j, board[i][j], trie.root)
                visited[i][j] = False
        return result

# Your Trie object will be instantiated and called as such:
# obj = Trie()
# obj.insert(word)
# param_2 = obj.search(word)
# param_3 = obj.startsWith(prefix)

class WordSearchII(unittest.TestCase):
   # [["o", "a", "a", "n"], ["e", "t", "a", "e"], ["i", "h", "k", "r"], ["i", "f", "l", "v"]]

    def test_Normal(self):
        board = [["o","a","a","n"],["e","t","a","e"],["i","h","k","r"],["i","f","l","v"]]
        words = ["oath", "pea", "eat", "rain"]
        solution = Solution()
        print(solution.findWords(board, words))

if __name__ == '__main__':
    unittest.main()