# Definition for a binary tree node.
import bisect
import unittest
from collections import defaultdict
from typing import List

from sortedcontainers import SortedList


class NearestCity(unittest.TestCase):

    def test_NoMatch(self):
        return

    def test_MultiMatchWithSameDis(self):
        return

    def GetClosestCity(cityNames: List[str], cityX: List[int], cityY: List[int], queriedCityX: List[int], queriedCityY: List[int]) -> List[str]:

        # Preprocess
        # Map x => List((Y)) and ..: used for binary search queried city
        xToYList = defaultdict(lambda: [])
        for index, xValue in enumerate(cityX):
            bisect.insort(xToYList[xValue], cityY[index])
            # xToYList[xValue].append(cityY[index])

        yToXList = defaultdict(lambda: [])
        for index, yValue in enumerate(cityY):
            bisect.insort(yToXList[yValue], cityX[index])
            # yToXList[yValue].append(cityX[index])

        # Map (x,y) => city: used for map (x,y) to result
        coorToName = dict()
        # nameToCoor = dict()
        for index, cityName in enumerate(cityNames):
            # nameToCoor[cityName] = (cityX[index], cityY[index])
            coorToName[(cityX[index], cityY[index])] = cityName

        # Process
        # For each queried city, find its closest city by binary search x and y list
        result = []
        for queryX, queryY in zip(queriedCityX, queriedCityY):
            priorityQueue = SortedList(key=lambda x: (x[0], len(x[1])))

            # TODO: Refactor to remove duplicates inside code
            if len(xToYList[queryX]) > 0:
                searchIndex = bisect.bisect_left(xToYList[queryX], queryY)
                if searchIndex < len(xToYList[queryX]):
                    closetY = xToYList[queryX][searchIndex]
                    priorityQueue.add((abs(queryY - closetY), coorToName[(queryX, closetY)]))
                if searchIndex - 1 >= 0:
                    closetY = xToYList[queryX][searchIndex-1]
                    priorityQueue.add((abs(queryY - closetY), coorToName[(queryX, closetY)]))

            if len(yToXList[queryY]) > 0:
                searchIndex = bisect.bisect_left(yToXList[queryY], queryX)
                if searchIndex < len(yToXList[queryY]):
                    closetX = yToXList[queryY][searchIndex]
                    priorityQueue.add((abs(queryX - closetX), coorToName[(closetX, queryY)]))
                if searchIndex - 1 >= 0:
                    closetX = yToXList[queryY][searchIndex-1]
                    priorityQueue.add((abs(queryX - closetX), coorToName[(closetX, queryY)]))

            if len(priorityQueue) == 0:
                result.append(None)
            else:
                minDis, city = priorityQueue.pop(0)
                result.append(city)
        return result

if __name__ == '__main__':
    unittest.main()