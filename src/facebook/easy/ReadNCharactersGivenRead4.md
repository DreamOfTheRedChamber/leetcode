package facebook.easy;

/*
The API: int read4(char *buf) reads 4 characters at a time from a file.

The return value is the actual number of characters read. For example, it returns 3 if there is only 3 characters left in the file.

By using the read4 API, implement the function int read(char *buf, int n) that reads n characters from the file.

Note:
The read function will only be called once for each test case.
 * */

public class ReadNCharactersGivenRead4 extends Reader4 
{
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    public int read( char[] buf, int n )
    {
		char[] localBuf = new char[4];
		int totalNumRead = 0;
		while ( totalNumRead < n )
    	{
    		int localNumRead = read4( localBuf );
    		for ( int j = 0; totalNumRead < n && j < localNumRead; j++, totalNumRead++ )
    		{
    			buf[i] = localBuf[j];
    		}
    		if ( localNumRead < 4 )
    		{
    			break;
    		}
    	}
    	return totalNumRead;
    }
}