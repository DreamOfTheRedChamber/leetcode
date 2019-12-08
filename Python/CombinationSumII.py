import unittest
from typing import List


class CombinationSumII(unittest.TestCase):

    def combinationSum2(self, candidates: List[int], target: int) -> List[List[int]]:
        allResults = []
        sortedCandidates = candidates.copy()
        sortedCandidates.sort()
        self.combinationSumReverse(allResults, [], sortedCandidates, 0, target)
        return allResults

    def combinationSumReverse(self, allResults: List[List[int]], oneResult: List[int], candidates: List[int], startPos: int, target: int):
        if target == 0:
            allResults.append(oneResult.copy())
            return

        for i in range(startPos, len(candidates)):
            # if i == 0 or candidates[i] != candidates[i-1]:
            if i > startPos and candidates[i] == candidates[i - 1]:
                continue

            if candidates[i] <= target:
                oneResult.append(candidates[i])
                self.combinationSumReverse(allResults, oneResult, candidates, i + 1, target - candidates[i])
                oneResult.pop()

    def test_normal(self):
        result = self.combinationSum2([10, 1, 2, 7, 6, 1, 5], 8)
        print(result)

if __name__ == '__main__':
    unittest.main()