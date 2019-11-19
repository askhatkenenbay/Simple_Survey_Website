package kz.pro2.webtask.command.impl;

import kz.pro2.webtask.command.Command;
import kz.pro2.webtask.command.service.UserService;
import kz.pro2.webtask.entity.User;

import javax.servlet.http.HttpServletRequest;

public class RegisterUserCommand implements Command {
    private static final String PARAM_NAME = "user_name";
    private static final String PARAM_EMAIL = "user_email";
    private static final String PARAM_PASSWORD = "user_password";
    private static final String REGISTRATION_SUCCEEDED = "Registered";
    private static final String REGISTRATION_FAILED = "Registration failed";
    private static final String PAGE_LOGIN = "/jsp/login.jsp";

    @Override
    public String execute(HttpServletRequest request) {
        String name = request.getParameter(PARAM_NAME);
        String email = request.getParameter(PARAM_EMAIL);
        String password = request.getParameter(PARAM_PASSWORD);
        if (UserService.addNewUser(new User(name, email, password))) {
            request.setAttribute("user", REGISTRATION_SUCCEEDED);
        } else {
            request.setAttribute("errorLoginPassMessage", REGISTRATION_FAILED);
        }
        return PAGE_LOGIN;
    }
}
