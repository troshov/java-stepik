package lesson7.main;

import java.io.IOException;

import lesson7.сhat.ChatServer;

public class Main
{
	public static void main(String[] args) throws IOException
	{
		try
		{
			ChatServer server = new ChatServer(5050);
			server.start();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
}
