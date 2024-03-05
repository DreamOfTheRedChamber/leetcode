import unittest
from typing import List


class CombinationSum(unittest.TestCase):

    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:

        def dfs(candidates: List[int], target: int, start: int, currSum: int, path: List[int], result: List[List[int]]):

            # edge case
            if currSum > target:
                return

            if currSum == target:
                result.append(path.copy())
                return

            # recursion
            for i in range(start, len(candidates)):
                path.append(candidates[i])

                dfs(candidates, target, i, currSum + candidates[i], path, result)

                path.pop()

            return result

        result = []
        dfs(candidates, target, 0, 0, [], result)
        return result

    def test_normal(self):
        print(self.combinationSum([2, 3, 5], 8))
        print(self.combinationSum([2, 3, 6, 7], 7))

    def test_Edgecase(self):
        print(self.combinationSum([2, 4], 7))

if __name__ == '__main__':
    unittest.main()