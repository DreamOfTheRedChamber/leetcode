package facebook.hard;

import java.util.LinkedList;
import java.util.Queue;

/*
The API: int read4(char *buf) reads 4 characters at a time from a file.

The return value is the actual number of characters read. For example, it returns 3 if there is only 3 characters left in the file.

By using the read4 API, implement the function int read(char *buf, int n) that reads n characters from the file.

Note:
The read function may be called multiple times.
 * */

public class ReadNCharactersGivenRead4II  extends Reader4 
{
	/* The read4 API is defined in the parent class Reader4.
	 int read4(char[] buf); */
	
	private Queue<Character> localCache = new LinkedList<>();
	/**
	* @param buf Destination buffer
	* @param n   Maximum number of characters to read
	* @return    The number of characters read
	*/
	public int read( char[] buf, int n )
	{
		if ( n < 0 || buf.length < n )
		{
			throw new IllegalArgumentException("");
		}
		
		int numRead = 0;
		for ( ; numRead < Math.min( n, localCache.size() ); numRead++ )
		{
			buf[numRead] = localCache.poll();
		}
		if ( numRead == n )
		{
			return n;
		}
		
		int numRound = ( n - numRead ) / 4;
		int remainder = ( n - numRead ) % 4;
		for ( int i = 0; i < numRound; i++ )
		{
			char[] buf4 = new char[4];
			int roundNumRead = read4( buf4 );
			for ( int j = 0; j < roundNumRead; j++, numRead++ ) 
			{
				buf[numRead] = buf4[j];
			}
			if ( roundNumRead < 4 )
			{
				return numRead;
			}
		}
		
		if ( remainder != 0 )
		{
			char[] buf4 = new char[4];
			int roundNumRead = read4( buf4 );
			for ( int i = 0; i < Math.min( roundNumRead, remainder ); numRead++, i++ )
			{
				buf[numRead] = buf4[i];
			}						
			if ( roundNumRead > remainder )
			{
				for ( int i = remainder; i < roundNumRead; i++ )
				{
					localCache.offer( buf[i] );
				}
			}
		}
		return numRead;
	}
}
