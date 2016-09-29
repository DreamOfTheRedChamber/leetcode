package multithreading;

import java.util.concurrent.Semaphore;

public class ReduceLatency2
{
	private static final int NUM_THREADS = 8;
	private static final Semaphore semaphore = new Semaphore( NUM_THREADS );
	
	public static void readFile() throws InterruptedException
	{
		Thread.sleep( 1000 );
	}
	
	public static void main( String[] args ) throws InterruptedException
	{
		long start = System.currentTimeMillis( );
		for ( int i = 0; i < NUM_THREADS; i++ )
		{
			Thread thread = new Thread( ( Runnable ) () -> {
				try 
				{
					semaphore.acquire( );
					readFile();
				}
				catch ( InterruptedException e )
				{
					//
				}
				finally
				{
					semaphore.release( );
				}
			} );
			thread.start( );
		}
		
		while ( !semaphore.tryAcquire( NUM_THREADS ) )
		{
			;
		}
		
		long end = System.currentTimeMillis( );
		System.out.println( end - start );
	}
}
