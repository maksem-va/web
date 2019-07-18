package ru.mk.controllers;

import ru.mk.dao.StudentsInGroupsDAO;
import ru.mk.models.Student;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(urlPatterns = "/students_in_group")
public class StudentInGroupsServlet extends HttpServlet{

    private StudentsInGroupsDAO studentsInGroupsDAO = StudentsInGroupsDAO.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher //
                = this.getServletContext().getRequestDispatcher("/WEB-INF/pages/studentsingroups.jsp");
        List<Student> students = null;
        try {
            students = studentsInGroupsDAO.getStudentByGroup("45841/1");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        req.setAttribute("students", students);
        resp.setCharacterEncoding("Unicode");
        dispatcher.forward(req, resp);
    }
}