package edu.step.servlet;

import edu.step.model.PersonModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PersonModel.getInstance().deletePerson(Integer.parseInt(request.getParameter("position")));
        response.sendRedirect("list");
    }
}
