package accounts;

import java.util.HashMap;
import java.util.Map;

public class AccountService {
    private final Map<String, UserProfile> usersAccounts;

    public AccountService() {
        usersAccounts = new HashMap<>();
    }

    public void singUp(String login, String password) {
        usersAccounts.put(login, new UserProfile(login, password));
    }

    public boolean singIn(String login, String password) {
        UserProfile profile = usersAccounts.get(login);
        return profile != null && profile.getLogin().equals(login) && profile.getPass().equals(password);
    }
}
