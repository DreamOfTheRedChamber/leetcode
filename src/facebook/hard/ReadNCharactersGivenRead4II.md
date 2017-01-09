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
		int totalNumRead = 0;
		char[] buf4 = new char[4];
		while ( localCache.size() > 0 && totalNumRead < n )
		{
			buf[totalNumRead++] = localCache.poll();
		}
		
		while ( totalNumRead < n )
		{
			int readNum = read4( buf4 );
			int remainingNum = n - totalNumRead;
			for ( int i = 0; i < readNum; i++ )
			{
				if ( i < remainingNum )
				{
					buf[totalNumRead++] = buf4[i];
				}
				else
				{
					localCache.offer( buf4[i] );
				}
			}
			
			if ( readNum < 4 )
			{
				break;
			}
		}
		return totalNumRead;
	}
}
