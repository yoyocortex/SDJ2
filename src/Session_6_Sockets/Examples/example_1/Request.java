/*
 * 11.09.2019 Original version
 */


package Session_6_Sockets.Examples.example_1;


public class Request
{
	private int action;
	private String text;
	
	
	public Request( int action, String text )
	{
		this.action = action;
		this.text = text;
	}
	
	
	public int getAction()
	{
		return action;
	}
	
	
	public String getText()
	{
		return text;
	}
}
