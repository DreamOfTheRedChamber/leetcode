package multithreading;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * This file demonstrate the use of ReentrantLock. The lock is only available to other 
 */

public class ReentrantLockExample
{
	private static final long SLEEP_INTERVAL_MS = 5000;
	private final Lock lock = new ReentrantLock();
	
	public void foo()
	{
		// Java's best practices to structure lock()/unlock() method at
		// http://www.javapractices.com/topic/TopicAction.do;jsessionid=E3DD19CD14CA19D1D9B9E0C019A7F018?Id=253
		lock.lock( );
		try
		{			
			System.out.println( "Inside foo" );
			try
			{
				// reentrantLock will be owned by foo() before unlocks it.
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
		// bar() will print out after foo() releases the reentrantlock()
		lock.lock( );
		try
		{
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
		final ReentrantLockExample s = new ReentrantLockExample();
		
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