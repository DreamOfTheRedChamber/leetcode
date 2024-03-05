import unittest
from typing import List

class CombinationSumIII(unittest.TestCase):

    def combinationSum3(self, k: int, n: int) -> List[List[int]]:
        def dfs(start: int, end: int, currSum: int, target: int, path: List[int], result: List[List[int]]):
            # edge case
            if currSum > target:
                return
            if currSum == target and len(path) == k:
                result.append(path.copy())
                return
            if len(path) >= k:
                return

            # recursion
            for i in range(start, end + 1):
                path.append(i)
                dfs(i + 1, 9, currSum + i, target, path, result)
                path.pop()

            return

        result = []
        dfs(1, 9, 0, n, [], result)
        return result

    def test_Leetcode(self):
        print(self.combinationSum3(3, 7))
        print(self.combinationSum3(3, 9))

    def test_Edgecase(self):
        print(self.combinationSum3(3, 5))

if __name__ == '__main__':
    unittest.main()