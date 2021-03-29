<%@ page import="java.util.List" %>
<%--
  Created by IntelliJ IDEA.
  User: Oleg
  Date: 2/23/2021
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>View persons</title>
</head>
<body>
    Persons
    <%
//        List<String> person = (List<String>) request.getAttribute("persons");
//        System.out.println("Person size = "+ person.size());
////        if (person != null && !person.isEmpty()) {
//            out.println("<ui>");
//            for (int i = 0; i < person.size(); i++) {
//                out.println("<li>" + person.get(i) + "</li>");
////                out.print("<a href='delete'>Delete</a>");
//                out.print("<a href='delete?position=" + i + "'>Delete</a>");
//                out.print("<a href='edit?position=" + i + "'>Edit</a>");
//
//            }
//            out.println("</ui>");
////        } else {
//            out.println("<p>There are no persons yet!</p>");
////        }
    %>
    <a href="${pageContext.request.contextPath}/">Back to main page</a>
</body>
</html>
