package kz.pro2.webtask.dao.impl;

import kz.pro2.webtask.connection.ConnectionPool;
import kz.pro2.webtask.dao.BaseDao;
import kz.pro2.webtask.entity.Survey;
import kz.pro2.webtask.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BaseDaoImpl implements BaseDao {
    private static final String INSERT_USER = "INSERT INTO user VALUES(?,?,?)";
    private static final String AUTHENTICATE_USER = "SELECT * FROM user WHERE email=? and password=?";
    private static final String INSERT_RESULT = "INSERT INTO result values(?,NOW(),?,?,?,?)";
    private static final String AVERAGE_SCORE = "SELECT AVG(score) as average FROM result";

    @Override
    public boolean addNewUser(User user) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = ConnectionPool.INSTANCE.getConnection();
            preparedStatement = connection.prepareStatement(INSERT_USER);
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getPassword());
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(preparedStatement);
            close(connection);
        }
        return false;
    }

    @Override
    public boolean authenticateUser(String email, String password) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = ConnectionPool.INSTANCE.getConnection();
            preparedStatement = connection.prepareStatement(AUTHENTICATE_USER);
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            close(preparedStatement);
            close(connection);
        }
        return false;
    }

    @Override
    public void addNewSurvey(Survey survey) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = ConnectionPool.INSTANCE.getConnection();
            preparedStatement = connection.prepareStatement(INSERT_RESULT);
            preparedStatement.setString(1, survey.getEmail());
            preparedStatement.setInt(2, survey.getScore());
            preparedStatement.setString(3, survey.getQuestionOne());
            preparedStatement.setString(4, survey.getQuestionTwo());
            preparedStatement.setString(5, survey.getQuestionThree());
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(preparedStatement);
            close(connection);
        }
    }

    @Override
    public double averageScore() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = ConnectionPool.INSTANCE.getConnection();
            preparedStatement = connection.prepareStatement(AVERAGE_SCORE);
            resultSet = preparedStatement.executeQuery();
            resultSet.next();
            return resultSet.getDouble("average");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            close(preparedStatement);
            close(connection);
        }
        return -1;
    }
}
