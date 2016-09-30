package multithreading;

/**
 * 
 */

public class ThreadBasicsJoin2
{	
	public static void main( String[] args ) throws InterruptedException
	{
		Thread childThread = new Thread( new PrintHello() );
		childThread.start( );
		
		// Join: used for thread synchronization. main thread will wait for child thread to finish
		childThread.join( );
		System.out.print( "Success!" );
	}
	
	private static class PrintHello implements Runnable
	{
		@Override
		public void run()
		{
			System.out.print( "Hello, world!" );
		}
	}
}
