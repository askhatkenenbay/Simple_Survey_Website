package kz.pro2.webtask.controller;


import kz.pro2.webtask.command.Command;
import kz.pro2.webtask.command.CommandFactory;
import kz.pro2.webtask.connection.ConnectionPool;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@WebServlet(urlPatterns = "/controller")
public class ControllerServlet extends HttpServlet {

    private static final String CONTENT_TYPE = "text/html";
    private static final String CHARACTER_ENCODING = "UTF-8";
    private static final String PAGE_INDEX = "index.jsp";
    private static final String PAGE_NULL_MESSAGE = "message nullpage";
    private static final String ATTRIBUTE_LOGIN = "login";
    private static final String ATTIBUTE_NULL_PAGE = "nullPage";
    private static final String PARAMETER_COMMAND = "command";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType(CONTENT_TYPE);
        request.setCharacterEncoding(CHARACTER_ENCODING);
        response.setCharacterEncoding(CHARACTER_ENCODING);
        HttpSession session = request.getSession();
        String login = (String) session.getAttribute(ATTRIBUTE_LOGIN);
        if (login != null) {
            session.setAttribute(ATTRIBUTE_LOGIN, login);
        }
        processRequest(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType(CONTENT_TYPE);
        request.setCharacterEncoding(CHARACTER_ENCODING);
        response.setCharacterEncoding(CHARACTER_ENCODING);
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String page = null;
        Command command = CommandFactory.defineCommand(request.getParameter(PARAMETER_COMMAND));
        page = command.execute(request);
        if (page != null) {
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(page);
            dispatcher.forward(request, response);
        } else {
            page = PAGE_INDEX;
            request.getSession().setAttribute(ATTIBUTE_NULL_PAGE, PAGE_NULL_MESSAGE);
            response.sendRedirect(request.getContextPath() + page);
        }
    }

    @Override
    public void destroy() {
        super.destroy();
        ConnectionPool.INSTANCE.destroyPool();
    }
}

