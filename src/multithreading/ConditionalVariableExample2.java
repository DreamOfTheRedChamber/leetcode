package multithreading;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 
 */

public class ConditionalVariableExample2
{
	private static final long SLEEP_INTERVALS_MS = 1000;
	private boolean running = true;
	private final Lock lock = new ReentrantLock();
	private final Condition condition = lock.newCondition( );
	
	public void start()
	{
		Thread thread = new Thread( ( Runnable ) () -> {
			print( "Hello, world!" );
			try
			{
				Thread.sleep( SLEEP_INTERVALS_MS );
			}
			catch ( InterruptedException e )
			{
				Thread.currentThread( ).interrupt( );
			}
			
			try
			{
				lock.lock( );
				running = false;
				
				// wake up all waiting threads
				condition.signalAll( );
			}
			finally
			{
				lock.unlock( );
			}
		} );
		thread.start( );
	}
	
	public void join( ) throws InterruptedException
	{
		try
		{
			lock.lock( );
			while ( running )
			{
				print( "Waiting for the peer thread to finish" );
				condition.await( );
			}
			
			print( "Peer thread finished." );
		}
		finally
		{
			lock.unlock( );
		}
	}
	
	private void print( String s )
	{
		System.out.println( s );
	}
	
	public static void main( String[] args ) throws InterruptedException
	{
		ConditionalVariableExample2 cve = new ConditionalVariableExample2( );
		cve.start( );
		cve.join( );
	}
}
