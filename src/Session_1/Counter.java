package Session_1;/*
 * 01.09.2019 Original version
 */


// A small utility class used for counting


public class Counter
{
	private long value = 0L;
	
	
	public void increment()
	{
		++value;
	}
	
	
	public long getCount()
	{
		return value;
	}
}
