# Definition for a binary tree node.
import heapq
import unittest

# Read about enumerate in python
from collections import defaultdict, deque
from typing import List


class LongestContinuousSubarrayWithAbsoluteDiffLessThanOrEqualToLimit(unittest.TestCase):

    def longestSubarray(self, nums: List[int], limit: int) -> int:
        minDeque = deque()
        maxDeque = deque()
        l = r = 0
        longest = 0

        while r < len(nums):

            # ending with this right position, what's the left most valid position it could maintain
            # assumption: if the previous left boundary of sliding window is known, then the next left boundary mu
            while minDeque and nums[r] < nums[minDeque[-1]]:
                minDeque.pop()
            while maxDeque and nums[r] > nums[maxDeque[-1]]:
                maxDeque.pop()

            # reason for only enqueuing index:
            maxDeque.append(r)
            minDeque.append(r)

            # how to guarantee the maxQueue and minQueue are not empty? r index is appended above
            while nums[maxDeque[0]] - nums[minDeque[0]] > limit:
                l += 1
                if l > minDeque[0]:
                    minDeque.popleft()
                if l > maxDeque[0]:
                    maxDeque.popleft()

            longest = max(longest, r - l + 1)
            r += 1

        return longest

    def longestSubarrayOld(self, nums: List[int], limit: int) -> int:
        freqMap = defaultdict(int)
        minQueue = []
        maxQueue = []

        start = 0
        end = 0
        currentLimit = 0
        longest = 0
        while start <= end and end < len(nums):
            while end < len(nums):
                heapq.heappush(minQueue, nums[end])
                heapq.heappush(maxQueue, -nums[end])
                freqMap[nums[end]] += 1
                end += 1
                currentLimit = (-maxQueue[0]) - minQueue[0]
                if currentLimit <= limit:

                    longest = max(longest, end - start)
                else:
                    break

            while start < end:
                freqMap[nums[start]] -= 1
                if minQueue[0] == nums[start]:
                    heapq.heappop(minQueue)
                if maxQueue[0] == nums[start]:
                    heapq.heappop(maxQueue)
                while len(minQueue) > 0 and freqMap[minQueue[0]] == 0:
                    heapq.heappop(minQueue)
                while len(maxQueue) > 0 and freqMap[-maxQueue[0]] == 0:
                    heapq.heappop(maxQueue)
                if len(maxQueue) > 0 and len(minQueue) > 0:
                    currentLimit = (-maxQueue[0]) - minQueue[0]
                start += 1
                if currentLimit <= limit or len(maxQueue) == 0 or len(minQueue) == 0:
                    break

        return longest

    def test_Leetcode(self):
        self.assertEqual(2, self.longestSubarray([8, 2, 4, 7], 4))
        self.assertEqual(4, self.longestSubarray([10, 1, 2, 4, 7, 2], 5))
        self.assertEqual(3, self.longestSubarray([4, 2, 2, 2, 4, 4, 2, 2], 10))

if __name__ == '__main__':
    unittest.main()