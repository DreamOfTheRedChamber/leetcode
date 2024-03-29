
class UnionFindInt(object):
    def __init__(self, n: int):
        self.parent = [i for i in range(n)]
        self.size = [1] * n

    def find(self, x: int) -> int:
        if x == self.parent[x]:
            return x
        else:
            return self.find(self.parent[x])

    def union(self, x: int, y: int):
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


class UnionFindStr(object):
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

