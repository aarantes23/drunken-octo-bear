<%-- 
    Document   : testUser
    Created on : 26-Jun-2015, 16:34:41
    Author     : Arthur
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="dao.UserDao"%>
<%@page import="Beans.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <%
        // Objects used 
        User user = new User();
        UserDao userDao = new UserDao();
        ArrayList<User> arrayList = new ArrayList<User>();

        // Recover the object cod
        user.setLogin(request.getParameter("login"));
        user.setPassword(request.getParameter("password"));

        // Search in the db
        arrayList = userDao.search();

        // Analyse the results
        for (int i = 0; i < arrayList.size(); i++) {
            if (user.getLogin() == arrayList.get(i).getLogin()) {
                if (user.getPassword() == arrayList.get(i).getPassword()) {
                    response.sendRedirect("/web_system_hotel_1/Login/index_after_login.jsp");
                }
            }
        }

       response.sendRedirect("/web_system_hotel_1/Login/index_after_login.jsp");

    %>
</html>
