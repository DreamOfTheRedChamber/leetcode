import unittest
from collections import defaultdict

class Node:
    def __init__(self):
        self.children = defaultdict(Node)
        self.content = None

class FileSystem:

    def __init__(self):
        self.root = Node()

    def ls(self, path: str) -> list:
        segments = path.split("/")[1:]
        resultNode = self.root
        for segment in segments:
            if segment is not "":
                resultNode = resultNode.children[segment]

        if resultNode.content is not None:
            return [segments[-1]]
        else:
            result = []
            for key in sorted(resultNode.children.keys()):
                result.append(key)
            return result

    def mkdir(self, path: str) -> None:
        segments = path.split("/")[1:]
        currentNode = self.root
        for segment in segments:
            currentNode = currentNode.children[segment]

    def addContentToFile(self, filePath: str, content: str) -> None:
        segments = filePath.split("/")[1:]
        currentNode = self.root
        if len(segments) >= 2:
            for segment in segments[:-1]:
                currentNode = currentNode.children[segment]

        if currentNode.children[segments[-1]].content is None:
            currentNode.children[segments[-1]].content = content
        else:
            currentNode.children[segments[-1]].content += content

    def readContentFromFile(self, filePath: str) -> str:
        segments = filePath.split("/")[1:]
        currentNode = self.root
        if len(segments) >= 2:
            for segment in segments[:-1]:
                currentNode = currentNode.children[segment]
        return currentNode.children[segments[-1]].content

class TestDataStructuresPriorityQueue(unittest.TestCase):

    @unittest.skip
    def test_InMemoryFileSystem(self):
        fs = FileSystem()
        print(fs.ls("/"))
        fs.mkdir("/a/b/c")
        fs.addContentToFile("/a/b/c/d", "hello")
        print(fs.ls("/"))
        print(fs.readContentFromFile("/a/b/c/d"))

    @unittest.skip
    def test_WrongAnswer(self):
        # input
        # ["FileSystem","mkdir","ls","ls","mkdir","ls","ls","addContentToFile","ls","ls","ls"]
        # [[],["/goowmfn"],["/goowmfn"],["/"],["/z"],["/"],["/"],["/goowmfn/c","shetopcy"],["/z"],["/goowmfn/c"],["/goowmfn"]]

        # output
        # [null, null, [], ["goowmfn"], null, ["goowmfn", "z"], ["goowmfn", "z"], null, [],
        # ["s", "h", "e", "t", "o", "p", "c", "y"], ["c"]]

        # expected
        # [null, null, [], ["goowmfn"], null, ["goowmfn", "z"], ["goowmfn", "z"], null, [], ["c"], ["c"]]
        fs = FileSystem()
        fs.mkdir("/goowmfn")
        fs.ls("/goowmfn")
        fs.ls("/")
        fs.mkdir("/z")
        fs.ls("/")
        fs.ls("/")
        fs.addContentToFile("/goowmfn/c","shetopcy")
        fs.ls("/z")
        print(fs.ls("/goowmfn/c"))
        print(fs.ls("/goowmfn"))
        return

    def test_WrongAnswer2(self):
        # ["FileSystem", "mkdir", "ls", "mkdir", "ls", "ls", "ls", "addContentToFile", "ls", "ls", "ls"]
        # [[], ["/m"], ["/m"], ["/w"], ["/"], ["/w"], ["/"], ["/dycete", "emer"], ["/w"], ["/"], ["/dycete"]]

        # input
        # [null, null, [], null, ["m", "w"], [], ["m", "w"], null, [], ["dycete", "m", "w"],
        # ["d", "y", "c", "e", "t", "e"]]

        # output
        # [null, null, [], null, ["m", "w"], [], ["m", "w"], null, [], ["dycete", "m", "w"], ["dycete"]]
        fs = FileSystem()
        fs.mkdir()

        return

# Your FileSystem object will be instantiated and called as such:
# obj = FileSystem()
# param_1 = obj.ls(path)
# obj.mkdir(path)
# obj.addContentToFile(filePath,content)
# param_4 = obj.readContentFromFile(filePath)