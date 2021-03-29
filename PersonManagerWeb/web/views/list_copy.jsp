<%@ page import="java.util.List" %>
<%@ page import="com.step.entity.Person" %>
<%--
  Created by IntelliJ IDEA.
  User: Oleg
  Date: 2/23/2021
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/styles.css" />
<html>
<head>
    <title>View persons</title>
</head>
<body>
    Persons
    <%
        List<Person> person = (List<Person>) request.getAttribute("persons");
        if (person != null && !person.isEmpty()) {
            out.println("<table>");
            out.println("<THead>");
            out.println("<tr>");
            out.println("<th>name</th>");
            out.println("<th>surname</th>");
            out.println("<th>description</th>");
            out.println("<th>phone</th>");
            out.println("<th>mobil</th>");
            out.println("<th>email</th>");
            out.println("<th>regdate</th>");
            out.println("<th>idnp</th>");
            out.println("<th>birthday</th>");
            out.println("<th colspan=2>Quick Edit</th>");
            out.println("</tr>");
            out.println("</THead>");
            for (int i = 0; i < person.size(); i++) {
//                out.println("<li>" + person.get(i) + " <a href='delete?position=" + i + "'> Delete </a>" + "<a href='edit?position=" + i + "'> Edit </a>" +  "</li>");
                out.println("<tbody>");
                out.println("<tr>");
                out.println("<td>" + person.get(i).getName() + "</td>");
                out.println("<td>" + person.get(i).getSurname() + "</td>");
                out.println("<td>" + person.get(i).getDescription() + "</td>");
                out.println("<td>" + person.get(i).getPhone() + "</td>");
                out.println("<td>" + person.get(i).getMobile() + "</td>");
                out.println("<td>" + person.get(i).getEmail() + "</td>");
                out.println("<td>" + person.get(i).getRegDate() + "</td>");
                out.println("<td>" + person.get(i).getIdnp() + "</td>");
                out.println("<td>" + person.get(i).getBirthday() + "</td>");
                out.println("<td>" + "<a href='delete?position=" + person.get(i).getPersonId() + "'> Delete </a>" + "</td>");
                out.println("<td>" + "<a href='edit?position=" + person.get(i).getPersonId() + "'> Edit </a>" + "</td>");
                out.println("</tr>");
                out.println("</tbody>");

            }
            out.println("</table>");
        } else {
            out.println("<p>There are no persons yet!</p>");
        }
    %>
    <a href="${pageContext.request.contextPath}/">Back to main page</a>
</body>
</html>
