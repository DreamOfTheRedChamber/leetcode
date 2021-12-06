package stack;

import static org.junit.Assert.assertEquals;

import java.util.LinkedList;

import org.junit.Test;

/*
Given an absolute path for a file (Unix-style), simplify it.

For example,
path = "/home/", => "/home"
path = "/a/./b/../../c/", => "/c"
 * */

public class SimplifyPath 
{
 public String simplifyPath( String path )
 {
 	String[] tokens = path.split( "/" );
 	LinkedList<String> simplified = new LinkedList<>();

 	for ( String token : tokens )
 	{
 		if ( token.equals( "." )
 				|| token.equals( "" ) ) 
 		{
 			continue;
 		}
 		else if ( token.equals( ".." ) )
 		{
 			if ( !simplified.isEmpty() )
 			{
 				simplified.removeLast( );
 			}
 		}
 		else
 		{
 			simplified.addLast( token );
 		}
 	}
 	
 	if ( simplified.isEmpty() )
 	{
 		return "/";
 	}
 	else
 	{
  	StringBuilder result = new StringBuilder();
		 for ( String token : simplified )
		 {
		    	result.append( "/" + token );
		 }
	 	return result.toString( );
 	}
 }
  
 @Test
 public void testEdgeCase()
 {
 	// multi ..
 	assertEquals( "/", simplifyPath( "/home/../../.." ) );
 	// single /
 	assertEquals( "/", simplifyPath( "/" ) );
 	// double //
 	assertEquals( "/home/foo", simplifyPath( "/home//foo/" ) );
 	// empty split
 	assertEquals( "/", simplifyPath( "/../" ) );
 }
 
 @Test
 public void testNormalCase()
 {
 	assertEquals( "/c", simplifyPath( "/a/./b/../../c/" ) ); 	
 }
}