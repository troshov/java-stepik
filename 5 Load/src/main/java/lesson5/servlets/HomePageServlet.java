package lesson5.servlets;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lesson5.accountServer.AccountServer;

public class HomePageServlet extends HttpServlet
{
	public static final String PAGE_URL = "/admin";
	private final AccountServer accountServer;

	public HomePageServlet(AccountServer accountServer)
	{
		this.accountServer = accountServer;
	}

	public void doGet(HttpServletRequest request,
	                  HttpServletResponse response) throws ServletException, IOException
	{
		response.setContentType("text/html");
		response.setStatus(HttpServletResponse.SC_OK);
		response.getWriter().println(accountServer.getUsersLimit());
		return;
	}
}
