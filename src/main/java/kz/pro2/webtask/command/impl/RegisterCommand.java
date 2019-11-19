package kz.pro2.webtask.command.impl;

import kz.pro2.webtask.command.Command;

import javax.servlet.http.HttpServletRequest;

public class RegisterCommand implements Command {

    private static final String PAGE_REGISTER = "/jsp/register.jsp";

    @Override
    public String execute(HttpServletRequest request) {
        return PAGE_REGISTER;
    }
}
