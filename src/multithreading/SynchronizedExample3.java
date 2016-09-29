package multithreading;

/**
 * 
 */

public class SynchronizedExample3
{
	public void foo() throws InterruptedException
	{
		synchronized ( this )
		{
			System.out.println( "Inside foo" );
			bar();
			Thread.sleep( 2000 );
		}
	}
	
	public void bar()
	{
		synchronized ( this )
		{
			System.out.print( "Inside bar" );
		}
	}
	
	public static void main( String[] args ) throws InterruptedException
	{
		final SynchronizedExample3 s = new SynchronizedExample3();
		
		Thread T1 = new Thread( new Runnable() {
			@Override
			public void run()
			{
				try
				{
					s.foo( );
				}
				catch ( InterruptedException e )
				{
					//
				}
			}
		} );
		
		Thread T2 = new Thread( new Runnable() {
			@Override
			public void run()
			{
				s.bar( );
			}
		} );
		
		T1.start( );
		T1.join( );
		
		T2.start( );
		T2.join( );
	}
}
