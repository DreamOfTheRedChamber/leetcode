package multithreading;

/**
 * 
 */

public class ThreadBasicsJoin
{
	public static void main( String[] args ) throws InterruptedException
	{
		Thread thread = new Thread( new Runnable() {
			@Override
			public void run()
			{
				System.out.println( "Hello, world" );
			}
		} );
		
		thread.start( );
		thread.join( );
	}
}