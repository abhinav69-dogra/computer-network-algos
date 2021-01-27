package lab7;
import java.net.*;
import java.io.*;
import java.util.*;
public class UdpServer {
	public static void main(String[] args) throws IOException
	{
		DatagramSocket server = new DatagramSocket(1537);
		System.out.println("Enter server message:");
		Scanner scan = new Scanner(System.in);
		while(true)
		{
		byte[] buffer = new byte[1000];
		DatagramPacket request = new DatagramPacket(buffer,
		buffer.length);
		server.receive(request);
		String message = scan.nextLine();
		byte[] sendMessage = message.getBytes();
		DatagramPacket reply = new DatagramPacket(sendMessage,
		sendMessage.length, request.getAddress(), request.getPort());
		server.send(reply);
		server.close();
		scan.close();
		}
		}
}
