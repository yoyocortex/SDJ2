/*
 * 08.09.2019 package name changed
 * 28.02.2011 Original version
 */
 
 
package Session_6_Sockets.simpletcp;


import java.net.Socket;

import static Session_6_Sockets.simpletcp.SimpleTCPConfig.PORTNO;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import javax.swing.JOptionPane;


public class SimpleTCPClient
{
	public static void main( String[] args )
	{
		new SimpleTCPClient().run();
	}
	
	
	private String ip;
	
	
	private void run()
	{
		ip = JOptionPane.showInputDialog( null, "IP address" );
		
		if( ip == null || ip.length() == 0 )
			return;
			
			
		String text = JOptionPane.showInputDialog( null, "Text" );
		while( text != null && text.length() > 0 ) {
			String res = upper( text );
			JOptionPane.showMessageDialog( null, res );
			
			text = JOptionPane.showInputDialog( null, "Text" );
		}
	}
	
	
	private String upper( String text )
	{
		String result = "";
		
		try {
			Socket socket = new Socket( ip, 1000 );
		
			BufferedReader in = new BufferedReader( new InputStreamReader( socket.getInputStream() ) );
			OutputStreamWriter out = new OutputStreamWriter( socket.getOutputStream() );
		
			out.write( text + "\n" ); // write to server
			out.flush();
			result = in.readLine(); // read from server
		
			socket.close();
		} catch( Exception ex ) {
			ex.printStackTrace();
		}
		
		return result;
	}
}
