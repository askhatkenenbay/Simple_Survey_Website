package kz.pro2.webtask.command.impl;

import kz.pro2.webtask.command.Command;
import kz.pro2.webtask.command.service.UserService;

import javax.servlet.http.HttpServletRequest;

public class LoginCommand implements Command {
    private static final String PARAM_LOGIN = "login";
    private static final String PARAM_PASSWORD = "password";
    private static final String PAGE_SURVEY = "/jsp/survey.jsp";
    private static final String PAGE_LOGIN = "/jsp/login.jsp";

    @Override
    public String execute(HttpServletRequest request) {
        String login = request.getParameter(PARAM_LOGIN);
        String pass = request.getParameter(PARAM_PASSWORD);
        if (UserService.checkLogin(login, pass)) {
            request.setAttribute("user", login);
            request.getSession().setAttribute("login", login);
            return PAGE_SURVEY;
        }
        return PAGE_LOGIN;
    }
}
