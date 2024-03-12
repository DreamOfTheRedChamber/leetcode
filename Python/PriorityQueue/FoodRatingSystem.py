import heapq
import unittest
from collections import defaultdict
from typing import List

class FoodRatings:

    def __init__(self, foods: List[str], cuisines: List[str], ratings: List[int]):
        self.foodsToRating = {}
        self.cuisineToFoods = defaultdict(list)
        self.foodToCusine = {}

        for i in range(len(foods)):
            self.foodsToRating[foods[i]] = ratings[i]

            self.foodToCusine[foods[i]] = cuisines[i]

            maxHeap = self.cuisineToFoods[cuisines[i]]
            heapq.heappush(maxHeap, (-ratings[i], foods[i]))

        return

    def changeRating(self, food: str, newRating: int) -> None:
        self.foodsToRating[food] = newRating
        cuisine = self.foodToCusine[food]
        maxHeap = self.cuisineToFoods[cuisine]
        heapq.heappush(maxHeap, (-newRating, food))

        return

    def highestRated(self, cuisine: str) -> str:
        maxHeap = self.cuisineToFoods[cuisine]
        while maxHeap:
            negRating, food = maxHeap[0]
            if negRating != -self.foodsToRating[food]:
                heapq.heappop(maxHeap)
            else:
                return food

        return ""

class FoodRatingsTest(unittest.TestCase):

    def test_example1(self):
        foods = ["kimchi", "miso", "sushi", "moussaka", "ramen", "bulgogi"]
        cuisines = ["korean", "japanese", "japanese", "greek", "japanese", "korean"]
        ratings = [9, 12, 8, 15, 14, 7]
        system = FoodRatings(foods, cuisines, ratings)

        self.assertEqual(system.highestRated("korean"), "kimchi")
        self.assertEqual(system.highestRated("japanese"), "ramen")
        system.changeRating("sushi", 16)
        self.assertEqual(system.highestRated("japanese"), "sushi")
        system.changeRating("ramen", 16)
        self.assertEqual(system.highestRated("japanese"), "ramen")

if __name__ == '__main__':
    unittest.main()