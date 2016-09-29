package multithreading;

/**
 * 
 */

public class ConditionVariableExample
{
	private static final long SLEEP_INTERVAL_MS = 1000;
	private boolean running = true;
	private Thread thread;
	
	public void start()
	{
		thread = new Thread( ( Runnable ) () -> {
			print( "Hello world" );
			try
			{
				Thread.sleep( SLEEP_INTERVAL_MS );
			}
			catch ( InterruptedException e )
			{
				Thread.currentThread( ).interrupt( );
			}
			synchronized ( thread )
			{
				running = false;
				ConditionVariableExample.this.notify();
			}
		} );
		
		thread.start( );
	}
	
	public void join( ) throws InterruptedException 
	{
		synchronized ( thread )
		{
			while ( running )
			{
				print( "Waiting for the peer thread to finish." );
				wait();
			}
			print("Peer thread finished");
		}
	}
	
	private void print( String s)
	{
		System.out.println( s );
	}
	
	public static void main( String[] args ) throws InterruptedException
	{
		ConditionVariableExample cve = new ConditionVariableExample( );
		cve.start( );
		cve.join( );
	}
	
}
