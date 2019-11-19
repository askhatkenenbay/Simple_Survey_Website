package kz.pro2.webtask.dao;

import kz.pro2.webtask.connection.ConnectionPool;
import kz.pro2.webtask.connection.ConnectionPoolException;
import kz.pro2.webtask.entity.Survey;
import kz.pro2.webtask.entity.User;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public interface BaseDao {

    boolean addNewUser(User user);

    boolean authenticateUser(String email, String password);

    void addNewSurvey(Survey survey);

    double averageScore();

    default void close(Statement statement) {
        try {
            if (statement != null) {
                statement.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    default void close(Connection connection) {
        if (connection != null) {
            try {
                ConnectionPool.INSTANCE.releaseConnection(connection);
            } catch (ConnectionPoolException e) {
                e.printStackTrace();
            }
        }
    }
}
