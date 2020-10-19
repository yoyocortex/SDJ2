/*
 * 25.08.2020 Switched from Thread to Runnable
 * 01.09.2019 Original version
 */


// A thread that extends class Thread directly

package Session_1;


public class ThreadOne
	implements Runnable
{
	private static final int NO_OF_REPETITIONS = 10;
	
	// All threads must have a public void run() method
	
	@Override
	public void run()
	{
		for( int i = 0; i < NO_OF_REPETITIONS; ++i )
			System.out.println( "The eagle has landed " + i );
	}
}
