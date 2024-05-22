package lesson5.accountServer;

public class AccountServerImpl implements AccountServer
{
	private int usersCount;
	private int usersLimit;

	public AccountServerImpl(int usersLimit)
	{
		this.usersCount = 0;
		this.usersLimit = usersLimit;
	}

	@Override
	public int getUsersLimit()
	{
		return usersLimit;
	}

	@Override
	public void setUsersLimit(int usersLimit)
	{
		this.usersLimit = usersLimit;
	}

	@Override
	public int getUsersCount()
	{
		return usersCount;
	}
}
