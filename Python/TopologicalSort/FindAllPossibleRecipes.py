# Definition for a binary tree node.
import heapq
import unittest

# Read about enumerate in python
from collections import defaultdict, deque
from typing import List

class BalanceABinarySearchTree(unittest.TestCase):

    def findAllRecipes(self, recipes: List[str], ingredients: List[List[str]], supplies: List[str]) -> List[str]:

        # indegree map
        ingredToRecipes = defaultdict(set)
        recipeToCount = defaultdict(lambda: 0)

        for i in range(len(recipes)):
            recipeToCount[recipes[i]] = len(ingredients[i])
            for ingred in ingredients[i]:
                ingredToRecipes[ingred].add(recipes[i])

        result = []
        bfsQueue = deque(supplies)
        while bfsQueue:
            head = bfsQueue.popleft()
            if head in ingredToRecipes:
                usedRecipes = ingredToRecipes[head]
                for item in usedRecipes:
                    recipeToCount[item] -= 1
                    if recipeToCount[item] == 0:
                        del recipeToCount[item]
                        result.append(item)
                        bfsQueue.append(item)

        return result

    @unittest.skip
    def test_example1(self):
        recipes = ["bread"]
        ingredients = [["yeast", "flour"]]
        supplies = ["yeast", "flour", "corn"]
        print(self.findAllRecipes(recipes, ingredients, supplies))

    def test_example2(self):
        recipes = ["bread","sandwich"]
        ingredients = [["yeast","flour"],["bread","meat"]]
        supplies = ["yeast","flour","meat"]
        print(self.findAllRecipes(recipes, ingredients, supplies))

    def test_example3(self):
        recipes = ["bread","sandwich","burger"]
        ingredients = [["yeast","flour"],["bread","meat"],["sandwich","meat","bread"]]
        supplies = ["yeast","flour","meat"]
        print(self.findAllRecipes(recipes, ingredients, supplies))

if __name__ == '__main__':
    unittest.main()