"""
A car travels from a starting position to a destination which is target miles east of the starting position.

There are gas stations along the way. The gas stations are represented as an array stations where stations[i] = [position_i, fuel_i]
indicates that the ith gas station is position i miles east of the starting position and has fuel_i liters of gas.

The car starts with an infinite tank of gas, which initially has start Fuel liters of fuel in it. It uses one liter of gas per one mile that it drives.
When the car reaches a gas station, it may stop and refuel, transferring all the gas from the station into the car.

Return the minimum number of refueling stops the car must make in order to reach its destination. If it cannot reach the destination, return -1.xx
"""
import sys
import unittest
from collections import defaultdict
from typing import List
from functools import lru_cache

stations = []

class MinRefuelNumber(unittest.TestCase):

    @lru_cache
    def calcMinRefuelNumTopDown(self, currPos: int, remainingFuel: int) -> int:
        if currPos == 0:
            return 0

        minRefuelNum = sys.maxsize
        for i in range(len(stations)):
            fuelPos, fuelAmount = stations[i]
            if fuelPos > currPos:
                break
            else:
                newFuel = fuelAmount - (currPos - fuelPos) + remainingFuel
                if newFuel >= 0:
                    singleResult = self.calcMinRefuelNumTopDown(fuelPos, newFuel) + 1
                    minRefuelNum = min(minRefuelNum, singleResult)

        return minRefuelNum

    def calcMinRefuelNumBottomUp(self, startFuel: int, targetDis: int, stations: List[List[int]]) -> int:
        disToEntryList = defaultdict(lambda: [])
        disToEntryList[0].append([startFuel, 0])
        for i in range(len(stations)):
            currPos, refuelAmount = stations[i]
            for position, value in sorted(disToEntryList.items()):
                if position < currPos:
                    for remainingFuel, minRefuel in value:
                        newRemainingFuel = remainingFuel - (currPos - position)
                        if newRemainingFuel > 0:
                            disToEntryList[currPos].append([newRemainingFuel + refuelAmount, minRefuel + 1])
                            disToEntryList[currPos].append([newRemainingFuel, minRefuel])

        biggestKey = max(sorted(disToEntryList.keys()))
        resultMinRefuel = sys.maxsize
        for remainingFuel, minRefuel in disToEntryList[biggestKey]:
            newRemainingFuel = remainingFuel - (targetDis - biggestKey)
            if newRemainingFuel > 0:
                resultMinRefuel = min(resultMinRefuel, minRefuel)

        if resultMinRefuel == sys.maxsize:
            return -1
        else:
            return resultMinRefuel

    def test_Normal(self):
        stations = [[3, 16], [15, 4], [35, 15]]

        minRefuel = self.calcMinRefuelNumBottomUp(23, 56, stations)

        print(minRefuel)
        return

    def test_Accident(self):


        return