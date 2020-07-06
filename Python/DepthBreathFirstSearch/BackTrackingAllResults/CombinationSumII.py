import unittest
from typing import List


class CombinationSumII(unittest.TestCase):

    def combinationSum2(self, candidates: List[int], target: int) -> List[List[int]]:
        def dfs(candidates: List[int], target: int, curSum: int, start: int, path: List[int], result: List[List[int]]):
            # edge case
            if curSum > target:
                return
            if curSum == target:
                result.append(path.copy())
                return
            if start >= len(candidates):
                return

            # recursion
            uniqueNum = set()
            for i in range(start, len(candidates)):
                if candidates[i] in uniqueNum:
                    continue
                uniqueNum.add(candidates[i])

                path.append(candidates[i])
                dfs(candidates, target, curSum + candidates[i], i + 1, path, result)
                path.pop()

            return

        candidates = sorted(candidates)
        result = []
        dfs(candidates, target, 0, 0, [], result)
        return result

    def test_Leetcode(self):
        print(self.combinationSum2([10, 1, 2, 7, 6, 1, 5], 8))
        print(self.combinationSum2([2, 5, 2, 1, 2], 5))

    def test_Edgecase(self):
        print(self.combinationSum2([1, 1], 9))
        print(self.combinationSum2([], 8))

if __name__ == '__main__':
    unittest.main()