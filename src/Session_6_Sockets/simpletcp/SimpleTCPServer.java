/*
 * 08.09.2019 package name updated
 * 28.02.2011 Original version
 */
 
 
package Session_6_Sockets.simpletcp;


import java.net.ServerSocket;
import java.net.Socket;
import java.net.InetAddress;

import static Session_6_Sockets.simpletcp.SimpleTCPConfig.PORTNO;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


public class SimpleTCPServer
{
	public static void main( String[] args )
	{
		new SimpleTCPServer().run();
	}
	
	
	public void run()
	{
		try {
			ServerSocket welcomeSocket = new ServerSocket( PORTNO );
			
			System.out.println( "Server listening on " + InetAddress.getLocalHost().getHostAddress() );
			
			while( true ) {
				Socket clientSocket = welcomeSocket.accept();
				doWork( clientSocket );
			}
		} catch( Exception ex ) {
			ex.printStackTrace();
		}
	}
	
	
	private void doWork( Socket clientSocket )
		throws Exception
	{
		BufferedReader in = new BufferedReader(
			new InputStreamReader( clientSocket.getInputStream() ) );
					 
		OutputStreamWriter out =
			new OutputStreamWriter( clientSocket.getOutputStream() );
					
		String input = in.readLine();
		System.out.println( "RECEIVED: " + input );
		
		Thread.sleep( 15000 ); // wait 15 seconds to simulate work
				
		String output = input.toUpperCase();
		System.out.println( "SENDING: " + output );
		out.write( output );
		out.flush();
					
		clientSocket.close();
	}
}