package stack;

import static org.junit.Assert.assertEquals;

import java.util.Stack;

import org.junit.Test;

/*
Given an absolute path for a file (Unix-style), simplify it.

For example,
path = "/home/", => "/home"
path = "/a/./b/../../c/", => "/c"
 * */

// TODO: README. summarize use of exceptions: EmptyStackException
public class SimplifyPath 
{
    public String simplifyPath( String path )
    {
    	// whether the path always starts with '/'
    	String[] tokens = path.split( "/" );
    	Stack<String> tokenStack = new Stack<>();
    	tokenStack.push( "" );

    	// remove .. and .
    	for ( String token : tokens )
    	{
    		if ( token.equals( "." )
    				|| token.equals( "" ) ) // handle "//" case
    		{
    			continue;
    		}
    		else if ( token.equals( ".." ) )
    		{
    			if ( !tokenStack.isEmpty() )
    			{
    				tokenStack.pop( );
    			}
    		}
    		else
    		{
    			tokenStack.push( token );
    		}
    	}
    	
    	// reconstruct path
    	StringBuilder simplifiedPath = new StringBuilder();
    	while( !tokenStack.isEmpty( ) )
    	{
    		String token = tokenStack.pop();
    		simplifiedPath.insert( 0, '/' );
        	simplifiedPath.insert( 0, token );
    	}
    	// delete tailing '/'
    	if ( simplifiedPath.length() > 1 )
    	{
    		simplifiedPath.deleteCharAt( simplifiedPath.length() - 1 );
    	}
    	return simplifiedPath.toString( );
    }
    
    @Test
    public void test()
    {
    	assertEquals( "", simplifyPath( "/home/../../.." ) );

    	assertEquals( "/", simplifyPath( "/" ) );
    	assertEquals( "/", simplifyPath( "/." ) );
    	assertEquals( "/", simplifyPath( "/.." ) );
    	
    	assertEquals( "", simplifyPath( "/../" ) );
    	assertEquals( "/c", simplifyPath( "/a/./b/../../c/" ) );
    	
    	assertEquals( "/home/foo", simplifyPath( "/home//foo/" ) );
    }
}