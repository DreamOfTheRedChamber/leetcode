package multithreading;

/**
 * 
 */

public class HelloWorld
{
	public static void main( String[] args ) throws InterruptedException
	{
		Thread thread = new Thread( new PrintHello() );
		thread.start( );
		thread.join( );
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
