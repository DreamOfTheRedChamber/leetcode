import unittest
from typing import List


class CombinationSum(unittest.TestCase):

    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        allResults = []
        self.combinationSumReverse(allResults, [], candidates, 0, target)
        return allResults

    def combinationSumReverse(self, allResults: List[List[int]], oneResult: List[int], candidates: List[int], startPos: int, target: int):
        if target == 0:
            allResults.append(oneResult.copy())
            return

        for i in range(startPos, len(candidates)):
            candidate = candidates[i]
            if candidate <= target:
                oneResult.append(candidate)
                self.combinationSumReverse(allResults, oneResult, candidates, i, target - candidate)
                oneResult.pop()

    def test_normal(self):
        result = self.combinationSum([2, 3, 5], 8)
        print(result)

if __name__ == '__main__':
    unittest.main()