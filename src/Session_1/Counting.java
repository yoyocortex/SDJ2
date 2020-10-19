package Session_1;/*
 * 24.08.2020 Switched from Thread to Runnable
 * 01.09.2019 Original version
 */



public class Counting
{
	public static void main( String[] args )
	{
		Counter counter = new Counter(); // Shared between the threads
		
		// Creating two Threads, that executes the same code

		Thread c1 = new Thread( new CountingThread( counter ) );
		Thread c2 = new Thread( new CountingThread( counter ) );

		c1.start();
		c2.start();
		
		try {
			c1.join(); // waits for the c1 Thread to end
			c2.join();
		} catch( InterruptedException ex ) {
			ex.printStackTrace();
		}
		
		System.out.println( counter.getCount() );
	}
}
