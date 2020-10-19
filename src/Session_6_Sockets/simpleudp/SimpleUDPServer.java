/*
 * 08.09.2019 package name changed
 * 01.03.2011 Original version
 */
 
 
package Session_6_Sockets.simpleudp;


import static dk.via.jpe.simpleudp.SimpleUDPConfig.PORTNO;

import java.net.DatagramSocket;
import java.net.DatagramPacket;
import java.net.InetAddress;


public class SimpleUDPServer
{
	public static void main( String[] args )
	{
		new SimpleUDPServer().run();
	}
	
	
	public void run()
	{
		try {
			DatagramSocket serverSocket = new DatagramSocket( PORTNO );
		
			System.out.println( "Server listening on " + InetAddress.getLocalHost().getHostAddress() );
			
			while( true ) {
				byte[] receiveData = new byte[2048];
				DatagramPacket receivePacket = 
					new DatagramPacket( receiveData, receiveData.length );
				
				serverSocket.receive( receivePacket );
				
				String sentence = new String( receivePacket.getData() ).trim();
				System.out.println( "RECEIVED: " + sentence );
			
				Thread.sleep( 15000 ); // simulate work
			
				InetAddress IPAddress = receivePacket.getAddress();
				int port = receivePacket.getPort();
			
				String capitalizedSentence = sentence.toUpperCase();
			
				byte[] sendData = capitalizedSentence.getBytes();
				DatagramPacket sendPacket = 
					new DatagramPacket( sendData, sendData.length, IPAddress, port );
			
				serverSocket.send( sendPacket );
				System.out.println( "SENT: " + capitalizedSentence );
			}
		} catch( Exception ex ) {
			ex.printStackTrace();
		}
	}
}