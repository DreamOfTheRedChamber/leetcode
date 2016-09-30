package string;

import java.util.LinkedList;
import java.util.Queue;

/**
The API: int read4(char *buf) reads 4 characters at a time from a file.

The return value is the actual number of characters read. For example, it returns 3 if there is only 3 characters left in the file.

By using the read4 API, implement the function int read(char *buf, int n) that reads n characters from the file.

Note:
The read function may be called multiple times. 
 */

/* The read4 API is defined in the parent class Reader4.
int read4(char[] buf); */

public class ReadNCharactersGivenRead4II extends Reader4 
{
	/**
	* @param buf Destination buffer
	* @param n   Maximum number of characters to read
	* @return    The number of characters read
	*/
	
	private Queue<Character> cache = new LinkedList<>();
	
	public int read( char[] buf, int n )
	{
		// calculate number of times to read
		// 0
		if ( n <= cache.size() )
		{
			for ( int i = 0; i < n; i++ )
			{
				buf[i] = cache.poll();
			}
			return n;
		}
		
		// > 1
		int numRead4 = ( n - cache.size() ) / 4;
		
		int bufPos = 0;
		while ( !cache.isEmpty() )
		{
			buf[bufPos] = cache.poll();
			bufPos++;
		}
		
		for ( int i = 0; i < numRead4; i++ )
		{
			char[] read4Buf = new char[4];
			int readNum = read4( read4Buf );
			for ( int j = 0; j < readNum; j++ )
			{
				buf[bufPos] = read4Buf[j];
				bufPos++;
			}
			
			if ( readNum < 4 )
			{
				return bufPos;
			}
		}
		
		// need a incomplete read
		int residualChars = ( n - cache.size() ) % 4;
		if ( residualChars != 0 )
		{
			char[] read4Buf = new char[4];
			int readNum = read4( read4Buf );
			
			int minLast = Math.min( readNum, residualChars );
			for ( int i = 0; i < minLast; i++ )
			{
				buf[bufPos] = read4Buf[i];
				bufPos++;
			}
			
			if ( readNum > residualChars )
			{
				for ( int i = residualChars; i < readNum; i++ )
				{
					cache.offer( read4Buf[i] );
				}
			}
		}
		
		return bufPos;
	}
}