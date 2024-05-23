package lesson7.сhat;

import java.io.IOException;
import java.net.ServerSocket;

public class ChatServer
{

	private ServerSocket serverSocket;
	private boolean finished;

	public ChatServer(int port) throws IOException
	{
		serverSocket = new ServerSocket(port);
		serverSocket.setSoTimeout(100000);
		finished = false;
	}

	public void close()
	{
		finished = true;
	}

	public void start()
	{
		java.util.logging.Logger.getGlobal().info("Server started");
		while (!finished)
		{
			try
			{
				new ChatSocket(serverSocket.accept(), this).start();
			}
			catch (IOException io)
			{
				io.printStackTrace();
			}
		}
	}
}
