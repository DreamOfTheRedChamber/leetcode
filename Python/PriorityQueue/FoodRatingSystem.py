import unittest
from typing import List

class FoodRatings:
    def __init__(self, foods: List[str], cuisines: List[str], ratings: List[int]):
        
        return

    def changeRating(self, food: str, newRating: int) -> None:

        return

    def highestRated(self, cuisine: str) -> str:

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