package hashtable;

import java.util.HashMap;
import java.util.Map;

public class Logger 
{
	private Map<String, Integer> msgToLatestStamp;
	
    /** Initialize your data structure here. */
    public Logger() 
    {
    	msgToLatestStamp = new HashMap<>();
    }
    
    /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
        If this method returns false, the message will not be printed.
        The timestamp is in seconds granularity. */
    public boolean shouldPrintMessage(int timestamp, String message) 
    {
    	if ( msgToLatestStamp.containsKey( message ) )
    	{
    		int oldStamp = msgToLatestStamp.get( message );
    		msgToLatestStamp.put( message, timestamp );
    		if ( timestamp - oldStamp >= 10 )
    		{
    			return true;
    		}
    		else
    		{
    			return false;
    		}
    	}
    	else
    	{
    		msgToLatestStamp.put( message, timestamp );
    		return true;
    	}
    }
}

/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */