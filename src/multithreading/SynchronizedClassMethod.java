package multithreading;

/**
 * 
 */

public class SynchronizedClassMethod
{
	private static final long SLEEP_INTERVAL_MS = 5000;
	
	public void foo()
	{
		synchronized ( SynchronizedClassMethod.class )
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
	}
	
	public void bar()
	{
		synchronized ( SynchronizedClassMethod.class )
		{
			System.out.append( "Inside bar" );
		}
	}
	
	public void foobar()
	{
		System.out.println( "Inside foobar" );
	}
	
	public static void main( String[] args ) throws InterruptedException
	{
		final SynchronizedClassMethod s = new SynchronizedClassMethod();
		final SynchronizedClassMethod s2 = new SynchronizedClassMethod();
		
		Thread T1 = new Thread( ( Runnable) () 
									-> { s.foo( ); } );
		Thread T2 = new Thread( ( Runnable) () 
									-> { s2.bar( ); } );
		Thread T3 = new Thread( ( Runnable) () 
									-> { s.foobar( ); } );
		
		T1.start( );
		T2.start( );
		T3.start( );
		
		T1.join( );
		T2.join( );
		T3.join( );
	}
}