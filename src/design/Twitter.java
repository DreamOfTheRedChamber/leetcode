package design;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

import org.junit.Test;

/**
Design a simplified version of Twitter where users can post tweets, follow/unfollow another user and is able to see the 10 most recent tweets in the user's news feed. Your design should support the following methods:

postTweet(userId, tweetId): Compose a new tweet.
getNewsFeed(userId): Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent.
follow(followerId, followeeId): Follower follows a followee.
unfollow(followerId, followeeId): Follower unfollows a followee.
*/
// TO_HURRY
public class Twitter 
{
	
	private Map<Integer, Set<Integer>> userToFollowee;
	private Map<Integer, List<Tweet>> userToTweets;
	private int timestamp;
	private final static int FEED_SIZE = 10;
	
	/** Initialize your data structure here. */
    public Twitter() 
    {
    	userToFollowee = new HashMap<>();
    	userToTweets = new HashMap<>();
    	timestamp = 0;
    }
    
    /** Compose a new tweet. */
    public void postTweet( int userId, int tweetId ) 
    {
    	setUpUser( userId );
    	List<Tweet> tweetList = userToTweets.get( userId );
    	tweetList.add( new Tweet( tweetId, timestamp, tweetList.size() ) );
    	timestamp++;
    }
    
    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed( int userId )
    {
    	Set<Integer> followeeList = userToFollowee.get( userId );
    	List<List<Tweet>> followeeTweets = new ArrayList<>();
    	for ( Integer followee : followeeList )
    	{
    		followeeTweets.add( userToTweets.get( followee ) );
    	}
    	PriorityQueue<Tweet> minQueue = new PriorityQueue<>( (o1, o2) -> ( o2.timestamp - o1.timestamp ) );
    	for ( List<Tweet> tweetList : followeeTweets )
    	{
    		if ( tweetList.size() > 0 )
    		{
    			minQueue.add( tweetList.get( tweetList.size() - 1 ) );
    		}
    	}
    	int counter = 0;
    	List<Integer> newsFeed = new ArrayList<>();
    	while ( !minQueue.isEmpty() 
    			&& counter < FEED_SIZE )
    	{
    		Tweet latestTweet = minQueue.poll();
    		newsFeed.add( latestTweet.tweetID );
    		if ( latestTweet.index > 0 )
    		{
    			minQueue.offer( userTo)
    		}
    	}
    }
    
    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) 
    {
    	setUpUser( followerId );
    	setUpUser( followeeId );
    	userToFollowee.get( followerId ).add( followeeId );
    }
    
    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) 
    {
    	userToFollowee.get( followerId ).remove( followeeId );
    }

    private void setUpUser( int userId )
    {
    	userToFollowee.putIfAbsent( userId, new HashSet<>() );
    	userToFollowee.get( userId ).add( userId ); // add user itself to followeelist
    	userToTweets.putIfAbsent( userId, new ArrayList<>() );	
    }
    
    class Tweet
    {
    	public final int tweetID;
    	public final int timestamp;
    	public final int index;
    	public Tweet( int tweetID, int timestamp, int index )
    	{
    		this.tweetID = tweetID;
    		this.timestamp = timestamp;
    		this.index = index;
    	}
    }    

    @Test
    public void test()
    {
    	Twitter obj = new Twitter();
    	obj.postTweet(1, 5);
    	System.out.println( obj.getNewsFeed(1) );
    	obj.follow(1, 2);
    	obj.postTweet(2, 6);
    	System.out.println( obj.getNewsFeed(1) );
    	obj.unfollow(1, 2);
    	System.out.println( obj.getNewsFeed(1) );
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */