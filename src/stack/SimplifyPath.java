package stack;

import java.util.Stack;

/*
Given an absolute path for a file (Unix-style), simplify it.

For example,
path = "/home/", => "/home"
path = "/a/./b/../../c/", => "/c"
 * */

// TODO: README. summarize use of exceptions: EmptyStackException
//TO_TEST
public class SimplifyPath 
{
    public String simplifyPath( String path )
    {
    	// whether the path always starts with '/'
    	String[] tokens = path.split( "/" );
    	Stack<String> tokenStack = new Stack<>();
    	
    	// remove .. and .
    	for ( String token : tokens )
    	{
    		if ( token.equals( "." ))
    		{
    			continue;
    		}
    		else if ( token.equals( ".." ) )
    		{
    			tokenStack.pop( );
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
    		simplifiedPath.insert( 0, '/' );
    		simplifiedPath.insert( 0, tokenStack.pop( ) );
    	}
    	return simplifiedPath.toString( );
    }
}