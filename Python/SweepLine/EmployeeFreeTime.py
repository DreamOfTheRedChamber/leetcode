import unittest


# Definition for an Interval.
class Interval:
    def __init__(self, start: int = None, end: int = None):
        self.start = start
        self.end = end

from itertools import chain

class EmployeeFreeTime(unittest.TestCase):

    def employeeFreeTime(self, schedule: '[[Interval]]') -> '[Interval]':
        def isOverlapping(inter1: Interval, inter2: Interval) -> bool:
            if inter1.end < inter2.start or inter2.end < inter1.start:
                return False
            else:
                return True

        flattened = list(chain.from_iterable(schedule))
        flattened = sorted(flattened, key=lambda x: x.start)
        if len(flattened) <= 1:
            return []

        result = []
        current = flattened[0]
        for i in range(1, len(flattened)):
            if isOverlapping(flattened[i], current):
                current = Interval(min(flattened[i].start, current.start), max(flattened[i].end, current.end))
            else:
                result.append(Interval(current.end, flattened[i].start))
                current = flattened[i]

        return result

    def test_testCase1(self):
        # Input: schedule = [[[1, 2], [5, 6]], [[1, 3]], [[4, 10]]]
        # Output: [[3, 4]]

        interval1 = Interval(1,2)
        interval2 = Interval(5, 6)
        interval3 = Interval(1, 3)
        interval4 = Interval(4, 10)
        result = self.employeeFreeTime([[interval1, interval2], [interval3, interval4]])

        return