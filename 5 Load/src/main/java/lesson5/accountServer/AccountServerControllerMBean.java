package lesson5.accountServer;

@SuppressWarnings("UnusedDeclaration")
public interface AccountServerControllerMBean
{
	int getUsers();

	int getUsersLimit();

	void setUsersLimit(int usersLimit);
}
