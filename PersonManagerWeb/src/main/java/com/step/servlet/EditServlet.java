package edu.step.servlet;

import edu.step.entity.Person;
import edu.step.model.PersonModel;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class EditServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        final int position = Integer.parseInt(request.getParameter("position"));
        final Person personToEdit = PersonModel.getInstance().get(position);
        request.setAttribute("name", personToEdit.getName());
        request.setAttribute("position", position);
        RequestDispatcher rd = request.getRequestDispatcher("views/edit.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String empName = req.getParameter("name");
        int position = Integer.parseInt(req.getParameter("position"));
        PersonModel model = PersonModel.getInstance();
        model.edit(position, empName);
        resp.sendRedirect("list");
    }
}
