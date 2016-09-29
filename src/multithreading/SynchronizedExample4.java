package multithreading;

/**
 * 
 */

public class SynchronizedExample4
{
	private static final long SLEEP_INTERVAL_MS = 5000;
	
	public void foo()
	{
		synchronized ( SynchronizedExample4.class )
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
		synchronized ( SynchronizedExample4.class )
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
		final SynchronizedExample4 s = new SynchronizedExample4();
		final SynchronizedExample4 s2 = new SynchronizedExample4();
		
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