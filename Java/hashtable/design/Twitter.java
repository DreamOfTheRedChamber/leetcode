package hashtable.design;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.junit.Test;

/**
Design a simplified version of Twitter where users can post tweets, follow/unfollow another user and is able to see the 10 most recent tweets in the user's news feed. Your design should support the following methods:

postTweet(userId, tweetId): Compose a new tweet.
getNewsFeed(userId): Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent.
follow(followerId, followeeId): Follower follows a followee.
unfollow(followerId, followeeId): Follower unfollows a followee.
*/

/*
Really great interview question !!!

1. class design: Tweet class
2. handle details: 
   a. user is its own follower.
3. system design: two basic ways to implement twitter. Pull-based model/Push-based model. 
   a. For a specific user, whether to use pull-based/push-based model also depends on its social graph size. 
      Pull-based model will have O(1) time complexity for write, but O(n) time complexity for read.
      Push-based model will have O(n) time complexity for write, but O(1) time complexity for write.
      If the user has a lot of followers, using push-based model, each time he posts a tweet, will have O(n) time complexity. 
      If the user has a lot of followees, using pull-based model, each time he get news feed, will have O(n) time complexity. 
      From statistics perspective, a normal user usually have more followees than followers. We prefer push-based model.
   b. That means the read QPS is much higher than write QPS. 
      From the standpoint of read/write frequency, functions including postTweet/follow/unfollow are all write operations. function postTweet is a read operation. 
      So it is better to put complex operation ( read social graph ) inside postTweet function. 
   c. In practice, both push-based/pull-based model works (Facebook/Instagram) via corresponding optimization
4. Data structure design:
   a. social graph: userId to follower/followee? how to avoid refollow?
      Map<UserId, Set<UserId>> userIdToFollowers ( for push-based model ) or userIdToFollowees ( for pull-based model )
   b. newsfeed
      Map<UserId, List<TweetId>> userToTweets
5. Language features
   a. syntactic sugar. PutIfAbsent()
6. If adopting pull-based model
   a. the problem reduces to a get latest tweets from k-sorted list operation.
   b. an naive approach is to take 10 latest tweets from each followee and then sort them according to timestamp. But with space complexity.
   c. an improved approach is to use priorityQueue to take the latest tweets from k-sorted list. But need some implementation trick to make it work.
7. If adopting push-based model
   a. for postTweet() function, just two nested for loop
      for follow() function, need to insert 10 latest tweets of followee to follower's timeline
      for unfollow() function, need to delete all tweets of follower's from follower's timeline
      Three functions, three set of logics. this will be kind of overkilling for an interview setting. 
 * */

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
    	tweetList.add( new Tweet( tweetId, timestamp ) );
    	timestamp++;
    }
    
    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed( int userId )
    {
    	setUpUser( userId );
    	// aggregate 10 latest news feed for all followees
    	List<Tweet> aggregatedTweets = new ArrayList<>();
    	for ( Integer followeeId : userToFollowee.get( userId ) )
    	{    		
    		List<Tweet> followeeTweets = userToTweets.get( followeeId );
    		aggregatedTweets.addAll( followeeTweets.subList( Math.max( 0, followeeTweets.size() - FEED_SIZE ), 
    																	followeeTweets.size() ) );    		
    	}
    		
    	// sort and take the latest 10 tweets
		aggregatedTweets.sort( (o1, o2) -> 
								o1.timestamp - o2.timestamp);
		
		return aggregatedTweets.subList( Math.max( 0, aggregatedTweets.size() - FEED_SIZE ), 
													aggregatedTweets.size() )
				               .stream()
				               .sorted( (o1, o2) -> 
								o2.timestamp - o1.timestamp) 
				               .map( i -> i.tweetID )
				               .collect( Collectors.toList() );
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
    	setUpUser( followerId );
    	setUpUser( followeeId );

    	if ( followerId != followeeId )
    	{
    		userToFollowee.get( followerId ).remove( followeeId );
    	}
    }
    
    private void setUpUser( int userId )
    {
    	userToFollowee.putIfAbsent( userId, new HashSet<>() );
    	userToFollowee.get( userId ).add( userId ); // add user itself to followee set
    	userToTweets.putIfAbsent( userId, new ArrayList<>() );	
    }
    
    class Tweet
    {
    	public final int tweetID;
    	public final int timestamp;
    	public Tweet( int tweetID, int timestamp )
    	{
    		this.tweetID = tweetID;
    		this.timestamp = timestamp;
    	}
    }    

    @Test
    public void testFourAtomicOperations()
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

    @Test
    public void testNewsFeedOrder()
    {
    	Twitter obj = new Twitter();
    	obj.postTweet( 1, 1 );
    	System.out.println( obj.getNewsFeed( 1 ) );
    	obj.follow( 1, 2 );
    	obj.postTweet( 2, 2 );
    	System.out.println( obj.getNewsFeed( 2 ) );
    }
    
    @Test
    public void testGetNewsFeedWithoutSetup()
    {
    	Twitter obj = new Twitter();
    	System.out.println( obj.getNewsFeed( 1 ) );
    }
    
    @Test
    public void testNumberOfReturnedTweets()
    {
    	Twitter obj = new Twitter();
    	
    	obj.postTweet( 1, 5 );
    	obj.postTweet( 1, 3 );
    	obj.postTweet( 1, 101 );
    	obj.postTweet( 1, 13 );
    	obj.postTweet( 1, 10 );
    	
    	obj.postTweet( 1, 2 );
    	obj.postTweet( 1, 94 );
    	obj.postTweet( 1, 505 );
    	obj.postTweet( 1, 333 );
    	obj.postTweet( 1, 22 );

    	obj.postTweet( 1, 11 );
    	
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