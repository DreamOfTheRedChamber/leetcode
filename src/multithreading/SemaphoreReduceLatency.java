package multithreading;

import java.util.concurrent.Semaphore;

public class SemaphoreReduceLatency
{
	private static final int NUM_THREADS = 4;
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
					// acquires a permit from this semaphore
					semaphore.acquire( );
					readFile();
				}
				catch ( InterruptedException e )
				{
					// 
				}
				finally
				{
					// releases a permit from this semaphore
					semaphore.release( );
				}
			} );
			thread.start( );
		}
		
		// wait for all semaphore threads to finish
		while ( !semaphore.tryAcquire( NUM_THREADS ) )
		{
			;
		}
		
		// TODO: Why the constant NUM_THREADS does not influence execution time
		long end = System.currentTimeMillis( );
		System.out.println( end - start );
	}
}
