package multithreading;

/**
 *  
 */

public class SynchronizedMethods
{
	private static final long SLEEP_INTERVAL_MS = 5000;
	
	public synchronized void foo()
	{
		System.out.println( "Inside foo" );
		try
		{
			Thread.sleep( SLEEP_INTERVAL_MS );
		}
		catch ( InterruptedException e )
		{
			
		}
	}
	
	// have not fully understand, why bar() needs to wait for foo() to finish
	public synchronized void bar() 
	{
		System.out.println( "Inside bar" );
	}
	
	public void foobar()
	{
		System.out.println( "Inside foo bar" );
	}
	
	public static void main( String[] args ) throws InterruptedException
	{
		final SynchronizedMethods s = new SynchronizedMethods();
		
		Thread T1 = new Thread( new Runnable() {
			@Override
			public void run()
			{
				s.foo( );
			}
		} );
		
		Thread T2 = new Thread( new Runnable() {
			@Override
			public void run()
			{
				s.bar( );
			}
		} );
		
		Thread T3 = new Thread( new Runnable() {
			@Override
			public void run()			
			{
				s.foobar( );
			}
		} );
		
		T1.start( );
		T2.start( );
		T3.start( );
	}
}
