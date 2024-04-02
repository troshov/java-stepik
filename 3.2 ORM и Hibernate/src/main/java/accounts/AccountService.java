package accounts;

import db.DBService;

public class AccountService {
    private final DBService dbService;

    public AccountService(DBService dbService) {
        this.dbService = dbService;
    }


    public void signUp(String login, String password) {
        try {
            dbService.addUser(new UserProfile(login, password));
        } catch (Exception e) {
            System.out.println("Can't sing in: " + e.getMessage());
        }

    }

    public boolean signIn(String login, String password) {
        try {
            UserProfile profile = dbService.getUser(login);
            return profile != null && profile.getLogin().equals(login) && profile.getPassword().equals(password);
        } catch (Exception e) {
            System.out.println("Can't sing in: " + e.getMessage());
            return false;
        }

    }
}