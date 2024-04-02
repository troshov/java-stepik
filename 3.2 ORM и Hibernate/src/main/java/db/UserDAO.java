package db;

import accounts.UserProfile;

import java.sql.Connection;
import java.sql.SQLException;

public class UserDAO {
    private db.Executor executor;

    public UserDAO(Connection connection) {
        this.executor = new db.Executor(connection);
    }

    public void createTable() throws SQLException {
        executor.execUpdate("create table if not exists users (id bigint auto_increment, login varchar(256), password varchar(256), primary key (id))");
    }

    public void insertUser(UserProfile profile) throws SQLException {
        executor.execUpdate("insert into users (login, password) values ('" + profile.getLogin() + "','" + profile.getPassword() + "')");
    }

    public UserDS get(String login) throws SQLException {
        return executor.execQuery("select * from users where login='" + login + "'", result -> {
            result.next();
            return new UserDS(result.getLong(1), result.getString(2), result.getString(3));
        });
    }

    public long getUserId(String login) throws SQLException {
        return executor.execQuery("select id from users where login='" + login + "'", result -> {
            result.next();
            return result.getLong(1);
        });
    }

    public void cleanup() throws SQLException {
        executor.execUpdate("drop table users");
    }

}