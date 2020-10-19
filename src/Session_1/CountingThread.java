package Session_1;/*
 * 24.08.2020 Switched from Thread to Runnable
 * 01.09.2019 Original version
 */



public class CountingThread
	implements Runnable
{
	private static final int COUNT = 50000000;
	
	private Counter counter;
	
	
	public CountingThread( Counter counter )
	{
		this.counter = counter;
	}
	
	
	@Override
	public void run()
	{
		for( int i = 0; i < COUNT; ++i )
			counter.increment();
	}
}
