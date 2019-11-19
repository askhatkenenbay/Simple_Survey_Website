package kz.pro2.webtask.command.impl;

import kz.pro2.webtask.command.Command;

import javax.servlet.http.HttpServletRequest;

public class LogoutCommand implements Command {
    /**
     * This methiod is used to invalidate seesion of current user
     *
     * @param request request from JSP
     * @return login page
     */
    private static final String PAGE_LOGIN = "/jsp/login.jsp";

    @Override
    public String execute(HttpServletRequest request) {
        request.getSession().invalidate();
        return PAGE_LOGIN;
    }
}
