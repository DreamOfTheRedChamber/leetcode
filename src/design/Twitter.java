package design;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;
//TO_START
public class Twitter 
{
	private Map<Integer, List<Integer>> userIdToTweets;
	private Map<Integer, Set<Integer>> userIdToFollowees;
	
    /** Initialize your data structure here. */
    public Twitter() 
    {
    	userIdToTweets = new HashMap<>();
    	userIdToFollowees = new HashMap<>();
    }
    
    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) 
    {
        // add tweet to user itself's wall
    	userIdToTweets.putIfAbsent( userId, new ArrayList<>() );
    	userIdToTweets.get( userId ).add( tweetId );
    	
    	// add tweet to users' followers' wall
    	for ( Integer followerId : userIdToFollowees.get( userId ) )
    	{
    		userIdToTweets.putIfAbsent( followerId, new ArrayList<>() );
    		userIdToTweets.get( followerId ).add( tweetId );
    	}
    }
    
    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) 
    {
        // get the oldest 10 items in user's tweet list
    	List<Integer> latestTweets = new ArrayList<>();
    	List<Integer> allTweets = userIdToTweets.get( userId );
    	ListIterator<Integer> iterator = allTweets.listIterator( allTweets.size() );
    	int numTweet = 0;
    	while ( iterator.hasPrevious( ) )
    	{
    		latestTweets.add( iterator.next( ) );
    	}
    	return latestTweets;
    }
    
    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) 
    {
    	userIdToFollowees.get( followeeId ).add( followerId );
    }
    
    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) 
    {
    	userIdToFollowees.get( followeeId ).remove( followerId );
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