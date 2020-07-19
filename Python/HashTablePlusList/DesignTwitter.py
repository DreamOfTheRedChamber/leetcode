# Definition for a binary tree node.
import collections
import heapq
import time
import unittest

# Read about enumerate in python
from collections import defaultdict
from typing import List

# please see https://leetcode.com/problems/design-twitter/discuss/714702/python-solution%3A-simplest-data-structure

class Twitter:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.twitter = collections.defaultdict(list)
        self.following = collections.defaultdict(set)

    def postTweet(self, userId: int, tweetId: int) -> None:
        """
        Compose a new tweet.
        """
        self.twitter[userId].append((tweetId, time.time()))

    def getNewsFeed(self, userId: int) -> List[int]:
        """
        Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent.
        """
        allNews = []
        for tweets in self.twitter[userId]:
            allNews.append(tweets)

        for followingId in self.following[userId]:
            if followingId == userId: continue
            for tweets in self.twitter[followingId]:
                allNews.append(tweets)

        allNews.sort(key=lambda x: x[1], reverse=True)

        return list(map(lambda x: x[0], allNews))[:10]

    def follow(self, followerId: int, followeeId: int) -> None:
        """
        Follower follows a followee. If the operation is invalid, it should be a no-op.
        """
        self.following[followerId].add(followeeId)

    def unfollow(self, followerId: int, followeeId: int) -> None:
        """
        Follower unfollows a followee. If the operation is invalid, it should be a no-op.
        """
        if followeeId in self.following[followerId]:
            self.following[followerId].remove(followeeId)

class DesignTwitter(unittest.TestCase):

    def test_Leetcode(self):
        twitter = Twitter()
        twitter.postTweet(1, 5)
        twitter.getNewsFeed(1)
        twitter.follow(1, 2)
        twitter.postTweet(2, 6)
        twitter.getNewsFeed(1)
        twitter.unfollow(1, 2)
        twitter.getNewsFeed(1)

if __name__ == '__main__':
    unittest.main()