package ru.mk.controllers;

import ru.mk.dao.GroupDAO;
import ru.mk.models.Group;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/groups")
public class GroupsPageServlet extends HttpServlet{

    private GroupDAO groupDAO = GroupDAO.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher //
                = this.getServletContext().getRequestDispatcher("/WEB-INF/pages/groups.jsp");
        List<Group> groups = groupDAO.getAllGroups();
        req.setAttribute("groups", groups);
        resp.setCharacterEncoding("Unicode");
        dispatcher.forward(req, resp);
    }
}
