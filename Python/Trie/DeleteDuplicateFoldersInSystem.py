import unittest
from collections import defaultdict
from typing import List

class TrieNode:

    def __init__(self, val: str):
        self.val = val
        self.isDuplicated = False
        self.children = dict()

class DeleteDuplicateFolderInSystems(unittest.TestCase):

    def deleteDuplicateFolder(self, paths: List[List[str]]) -> List[List[str]]:

        def buildTrie(paths: List[List[int]]):
            root = TrieNode("/")
            currNode = root

            for path in paths:
                for segment in path:
                    if segment not in currNode.children:
                        currNode.children[segment] = TrieNode(segment)
                    currNode = currNode.children[segment]

            return root

        def categorizeByKey(node: TrieNode, keyToNodeList: defaultdict):
            if node is None:
                return

            currKey = ""
            for key, trieNode in node.children.items():
                childKey = categorizeByKey(trieNode, keyToNodeList)
                currKey = currKey + "#" + trieNode.val + "#" + childKey

            keyToNodeList[currKey].append(node)
            return currKey

        def traverseAndDelete(trieNode: TrieNode):
            for key, nextTrieNode in trieNode.children.items():
                if nextTrieNode.isDuplicated:
                    del trieNode.children[key]
                else:
                    traverseAndDelete(nextTrieNode)

            return None

        def listPaths(root: TrieNode, currPath: List[str], allPaths: List[List[str]]):
            if root is None:
                return

            if root.val != "/":
                currPath.append(root.val)

            if len(root.children) == 0:
                allPaths.append(currPath.copy())
            else:
                for child in root.children.values():
                    listPaths(child, currPath, allPaths)

            if root.val != "/":
                currPath.pop()
            return

        root = buildTrie(paths)
        keyToList = defaultdict(list)
        categorizeByKey(root, keyToList)

        # mark duplicate
        for nodeList in keyToList.values():
            if len(nodeList) >= 2:
                for node in nodeList:
                    node.isDuplicated = True

                    # traverse trie to delete node
        traverseAndDelete(root)

        # print path
        allPaths = []
        listPaths(root, [], allPaths)
        return allPaths

    def test_CreateString(self):
        input = [["a"],["c"],["d"],["a","b"],["c","b"],["d","a"]]
        result = self.deleteDuplicateFolder(input)
        print(result)

if __name__ == '__main__':
    unittest.main()