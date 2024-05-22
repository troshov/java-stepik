package lesson4.chat;

import org.eclipse.jetty.websocket.api.Session;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketConnect;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketMessage;
import org.eclipse.jetty.websocket.api.annotations.WebSocket;

@SuppressWarnings("UnusedDeclaration")
@WebSocket
public class ChatWebSocket
{
	private Session session;

	@OnWebSocketConnect
	public void onOpen(Session session)
	{
		this.session = session;
	}

	@OnWebSocketMessage
	public void onMessage(String data)
	{
		sendString(data);
	}

	public void sendString(String data)
	{
		try
		{
			session.getRemote().sendString(data);
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
}
