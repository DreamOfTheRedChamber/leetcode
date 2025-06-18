"""
"""

import bisect
import heapq
import sys
import unittest
from collections import defaultdict
from typing import List
from functools import lru_cache

from sortedcontainers import SortedList

class MinApplePrices(unittest.TestCase):

    def test_Normal(self):
        shop1Price = 10
        shop1BundleSize = 3
        shop2Price = 15
        shop2BundleSize = 4

        resultExist, minPrice = self.getMinPrice(19, shop1BundleSize, shop2BundleSize, shop1Price, shop2Price)

        print(minPrice)

    @lru_cache
    def getMinPrice(self, remainingAmount: int, shop1BundleSize: int, shop2BundleSize: int, shop1Price: int, shop2Price: int ) -> (bool, int):
        if remainingAmount == 0:
            return True, 0
        elif remainingAmount < 0:
            return False, -1
        else:
            recurse1Exist, recurse1MinPrice = self.getMinPrice(remainingAmount - shop1BundleSize, shop1BundleSize, shop2BundleSize, shop1Price, shop2Price)
            if recurse1Exist:
                recursePrice1 = shop1Price + recurse1MinPrice

            recurse2Exist, recurse2MinPrice = self.getMinPrice(remainingAmount - shop2BundleSize, shop1BundleSize, shop2BundleSize, shop1Price, shop2Price)
            if recurse2Exist:
                recursePrice2 = shop2Price + recurse2MinPrice

            if recurse1Exist and recurse2Exist:
                return True, min(recursePrice1, recursePrice2)
            elif recurse1Exist:
                return True, recursePrice1
            elif recurse2Exist:
                return True, recursePrice2
            else:
                return False, -1