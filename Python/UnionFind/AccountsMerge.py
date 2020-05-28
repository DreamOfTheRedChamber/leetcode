# Definition for a binary tree node.
import unittest

# Read about enumerate in python
from collections import defaultdict
from typing import List


class AccountsMerge(unittest.TestCase):

    def accountsMerge(self, accounts: List[List[str]]) -> List[List[str]]:
        def find(a: str) -> str:
            if a not in ancestors:
                ancestors[a] = a
            if a != ancestors[a]:
                ancestors[a] = find(ancestors[a])
            return ancestors[a]

        def union(a: str, b: str):
            aRoot, bRoot = find(a), find(b)
            if aRoot != bRoot:
                ancestors[aRoot] = ancestors[bRoot]

        ancestors = {}
        emailRootToOwner = {}
        for account in accounts:
            name, emailList = account[0], account[1:]
            if len(emailList) == 0:
                continue
            for email in emailList[1:]:
                union(emailList[0], email)
            emailRootToOwner[find(emailList[0])] = account[0]

        rootToDescendants = defaultdict(set)
        for key in ancestors.keys():
            rootToDescendants[find(key)].add(key)

        return [[emailRootToOwner[k]] + sorted(v) for k, v in rootToDescendants.items()]

    def test_Leetcode(self):
        print(self.accountsMerge([["John", "johnsmith@mail.com", "john00@mail.com"], ["John", "johnnybravo@mail.com"], ["John", "johnsmith@mail.com", "john_newyork@mail.com"], ["Mary", "mary@mail.com"]]))

    @unittest.skip
    def test_Edgecase(self):
        print(self.accountsMerge([["John", "A@mail.com", "B@mail.com"], ["John", "C@mail.com", "D@mail.com"], ["John", "A@mail.com", "C@mail.com"], ["Mary", "mary@mail.com"]]))

if __name__ == '__main__':
    unittest.main()