package kz.pro2.webtask.command.impl;

import kz.pro2.webtask.command.Command;
import kz.pro2.webtask.command.service.UserService;
import kz.pro2.webtask.entity.Survey;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class SubmitSurveyCommand implements Command {
    private static final String PAGE_END = "/jsp/end.jsp";

    @Override
    public String execute(HttpServletRequest request) {
        HttpSession session = request.getSession();
        String rate = request.getParameter("rating");
        String questionOne = request.getParameter("user_message_one");
        String questionTwo = request.getParameter("user_message_two");
        String questionThree = request.getParameter("user_message_three");
        String email = (String) request.getSession().getAttribute("login");
        UserService.addSurveyResult(new Survey(email, rate, questionOne, questionTwo, questionThree));
        session.setAttribute("rate", rate);
        session.setAttribute("average", Double.toString(UserService.getAverageScore()));
        return PAGE_END;
    }
}
