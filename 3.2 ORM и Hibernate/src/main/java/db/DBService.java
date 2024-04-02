package db;

import org.h2.jdbcx.JdbcDataSource;
import accounts.UserProfile;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBService {
    private Connection connection;

    public DBService() throws SQLException {
        this.connection = getH2Connection();
    }


    private static Connection getH2Connection() throws SQLException {
        String url = "jdbc:h2:./h2db";
        String name = "test";
        String pass = "test";

        JdbcDataSource ds = new JdbcDataSource();
        ds.setURL(url);
        ds.setUser(name);
        ds.setPassword(pass);

        Connection connection = DriverManager.getConnection(url, name, pass);
        return connection;
    }

    public void create() throws SQLException{
        System.out.println("Creating table users if needed");
        (new UserDAO(connection)).createTable();
    }

    public long addUser(UserProfile userProfile) throws Exception {
        try {
            connection.setAutoCommit(false);
            UserDAO dao = new UserDAO(connection);
            dao.insertUser(userProfile);
            connection.commit();
            return dao.getUserId(userProfile.getLogin());
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ignore) {
            }
            throw new Exception(e);
        } finally {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException ignore) {
            }
        }
    }

    public UserProfile getUser(String login) throws SQLException {
        UserDAO dao = new UserDAO(connection);
        UserDS dataSet = dao.get(login);
        return new UserProfile(dataSet.getLogin(), dataSet.getPassword());
    }

    public void cleanUp() throws SQLException {
        UserDAO dao = new UserDAO(connection);
        
        dao.cleanup();
    }

}