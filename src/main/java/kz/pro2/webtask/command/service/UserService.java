package kz.pro2.webtask.command.service;

import kz.pro2.webtask.action.UserAction;
import kz.pro2.webtask.dao.impl.BaseDaoImpl;
import kz.pro2.webtask.entity.Survey;
import kz.pro2.webtask.entity.User;

public class UserService {
    private static final int MAX_LENGTH = 45;
    private static final BaseDaoImpl BASE_DAO = new BaseDaoImpl();

    public static boolean checkLogin(String login, String password) {
        if (login.length() < MAX_LENGTH && password.length() < MAX_LENGTH) {
            return BASE_DAO.authenticateUser(UserAction.encryptInput(login), UserAction.encryptInput(password));
        }
        return false;
    }

    public static boolean addNewUser(User user) {
        if (user.getName().length() < MAX_LENGTH && user.getEmail().length() < MAX_LENGTH && user.getPassword().length() < MAX_LENGTH) {
            user.setName(UserAction.encryptInput(user.getName()));
            user.setEmail(UserAction.encryptInput(user.getEmail()));
            user.setPassword(UserAction.encryptInput(user.getPassword()));
            BASE_DAO.addNewUser(user);
        }
        return false;
    }

    public static void addSurveyResult(Survey survey) {
        survey.setEmail(UserAction.encryptInput(survey.getEmail()));
        BASE_DAO.addNewSurvey(survey);
    }

    public static double getAverageScore() {
        return BASE_DAO.averageScore();
    }
}
