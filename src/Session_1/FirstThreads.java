/*
 * 25.08.2020 ThreadOne switched from Thread to Runnable
 * 01.09.2019 Original version
 */
/*

public class FirstThreads
{
	public static void main( String[] args )
	{
		// A thread is created in two steps
		ThreadOne r1 = new ThreadOne(); // First step is to create your object (which must implement Runnable)
		Thread t1 = new Thread( r1 ); // Second step i to create the Thread using you object as the Runnable part
		
		Thread t2 = new Thread( new ThreadTwo() ); // Alternative -- doesn't work if you need to call methods in you object

		// Thread must be started before they do anything -- never call the run() method directly
		t1.start();
		t2.start();
	}
}*/
