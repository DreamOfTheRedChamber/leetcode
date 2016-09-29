package multithreading;

/**
 * 
 */

public class ReduceLatency
{
	public static void readFile() throws InterruptedException
	{
		Thread.sleep( 1000 );
	}
	
	public static void main( String[] args ) throws InterruptedException
	{
		long start = System.currentTimeMillis( );
		for ( int i = 0; i < 8; ++i )
		{
			readFile();
		}
		long end = System.currentTimeMillis( );
		System.out.println( end - start );
	}
}
