# Definition for a binary tree node.
import heapq
import unittest

# Read about enumerate in python
from collections import defaultdict
from typing import List

class Twitter:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.userToFollowees = defaultdict(set)
        self.userToTweets = defaultdict(list)
        self.timeStamp = 1

    def postTweet(self, userId: int, tweetId: int) -> None:
        """
        Compose a new tweet.
        """
        if userId not in self.userToFollowees:
            self.userToFollowees[userId].add(tweetId)

        self.userToTweets[userId].append((self.timeStamp, tweetId))
        return

    def getNewsFeed(self, userId: int) -> List[int]:
        """
        Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent.
        """
        pq = []
        for followee in self.userToFollowees[userId]:
            for tweets in self.userToTweets[followee]:
                for i in range(-1, -9, -1):
                    if len(pq) <= 10:
                        heapq.heappush(pq, tweets[-i])
                    else:
                        heapq.heappush(pq, tweets[-i])
                        heapq.heappop(pq)

        result = []
        while pq:
            result.append(heapq.heappop(pq)[1])
        return result

    def follow(self, followerId: int, followeeId: int) -> None:
        """
        Follower follows a followee. If the operation is invalid, it should be a no-op.
        """
        if followeeId == followerId:
            return
        self.userToFollowees[followerId].add(followeeId)
        return

    def unfollow(self, followerId: int, followeeId: int) -> None:
        """
        Follow
        """
        if followeeId in self.userToFollowees[followerId]:
            self.userToFollowees[followerId].remove(followeeId)

        return

class DesignTwitter(unittest.TestCase):

    def test_Leetcode(self):
        print([1])

if __name__ == '__main__':
    unittest.main()