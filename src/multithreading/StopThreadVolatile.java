package multithreading;

import java.util.concurrent.TimeUnit;

/**
 * 
 */

public class StopThreadVolatile
{
	// volatile keyword is used to indicate that the value of a variable will be modified by different threads. 
	// here it is modified by background thread and the main thread
	private static volatile boolean stopRequested;
	
	public static void main ( String[] args ) throws InterruptedException
	{
		Thread backgroundThread = new Thread( new Runnable() {
			public void run()
			{
				int i = 0;
				while ( !stopRequested )
				{
					i++;
				}
			}
		} );
		
		backgroundThread.start( );
		TimeUnit.SECONDS.sleep( 1 );
		stopRequested = true;
	}
}
