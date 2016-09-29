package multithreading;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 
 */

public class LockExample
{
	private static final long SLEEP_INTERVAL_MS = 5000;
	private final Lock lock = new ReentrantLock();
	
	public void foo()
	{
		try
		{
			lock.lock( );
			System.out.println( "Inside foo" );
			try
			{
				Thread.sleep( SLEEP_INTERVAL_MS );
			}
			catch ( InterruptedException e )
			{
				
			}
		}
		finally
		{
			lock.unlock( );
		}
	}
	
	public void bar()
	{
		try
		{
			lock.lock( );
			System.out.println( "Inside bar" );
		}
		finally
		{
			lock.unlock( );
		}
	}
	
	public void foobar( )
	{
		System.out.println( "Inside foobar" );
	}
	
	public static void main( String[] args ) throws InterruptedException
	{
		final LockExample s = new LockExample();
		
		Thread T1 = new Thread( ( Runnable ) () -> {
			s.foo( );
		} );
		
		Thread T2 = new Thread( ( Runnable ) () -> {
			s.bar( );
		} );
		
		Thread T3 = new Thread( ( Runnable ) () -> {
			s.foobar( );
		} );
		
		T1.start( );
		T2.start( );
		T3.start( );
		
		T1.join( );
		T2.join( );
		T3.join( );
	}
}