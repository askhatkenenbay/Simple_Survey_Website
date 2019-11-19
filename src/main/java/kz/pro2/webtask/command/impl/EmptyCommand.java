package kz.pro2.webtask.command.impl;

import kz.pro2.webtask.command.Command;

import javax.servlet.http.HttpServletRequest;

public class EmptyCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        return null;
    }
}
