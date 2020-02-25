import unittest

class Trie:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.root = TrieNode()
        self.root.isLeaf = True

    def insert(self, word: str) -> None:
        """
        Inserts a word into the trie.
        """
        curNode = self.root
        for ch in word:
            if ch in curNode.next:
                curNode = curNode.next[ch]
            else:
                newNode = TrieNode()
                newNode.isLeaf = False
                curNode.next[ch] = newNode
                curNode = newNode

        curNode.isLeaf = True

    def search(self, word: str) -> bool:
        """
        Returns if the word is in the trie.
        """
        curNode = self.root
        for ch in word:
            if ch in curNode.next:
                curNode = curNode.next[ch]
            else:
                return False

        return curNode.isLeaf

    def startsWith(self, prefix: str) -> bool:
        """
        Returns if there is any word in the trie that starts with the given prefix.
        """
        curNode = self.root
        for ch in prefix:
            if ch in curNode.next:
                curNode = curNode.next[ch]
            else:
                return False

        return True

class TrieNode:

    def __init__(self):
        self.next = dict()
        self.isLeaf = True

# Your Trie object will be instantiated and called as such:
# obj = Trie()
# obj.insert(word)
# param_2 = obj.search(word)
# param_3 = obj.startsWith(prefix)

class ImplementTrie(unittest.TestCase):

    def test_Normal(self):
        trie = Trie()
        trie.insert("apple")
        self.assertTrue(trie.search("apple"))
        self.assertFalse(trie.search("app"))
        self.assertTrue(trie.startsWith("app"))
        trie.insert("app")
        self.assertTrue(trie.search("app"))

    def test_Edge(self):
        trie = Trie()
        trie.insert("")
        self.assertTrue(trie.search(""))
        self.assertFalse(trie.search("abc"))

if __name__ == '__main__':
    unittest.main()