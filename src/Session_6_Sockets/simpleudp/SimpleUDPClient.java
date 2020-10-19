/*
 * 08.09.2019 package name changed
 * 01.03.2011 Original version
 */
 
 
package Session_6_Sockets.simpleudp;


import static dk.via.jpe.simpleudp.SimpleUDPConfig.PORTNO;

import java.net.DatagramSocket;
import java.net.DatagramPacket;
import java.net.InetAddress;

import javax.swing.JOptionPane;


public class SimpleUDPClient
{
	public static void main( String[] args )
	{
		new SimpleUDPClient().run();
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
			DatagramSocket clientSocket = new DatagramSocket();
			InetAddress IPAddress = InetAddress.getByName( ip );
		
			byte[] sendData = text.getBytes();
			DatagramPacket sendPacket = 
				new DatagramPacket( sendData, sendData.length, IPAddress, PORTNO );
			
			clientSocket.send( sendPacket );
				
			byte[] receiveData = new byte[2048];
			DatagramPacket receivePacket = 
				new DatagramPacket( receiveData, receiveData.length );
				
			clientSocket.receive( receivePacket );
		
			result = new String( receivePacket.getData() ).trim();
		
			clientSocket.close();
		} catch( Exception ex ) {
			ex.printStackTrace();
		}
		
		return result;
	}
}
