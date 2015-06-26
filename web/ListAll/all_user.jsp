<%-- 
    Document   : create_user
    Created on : 21-Jun-2015, 16:51:33
    Author     : Arthur
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
<html>
    <head>
        <title>Trip hotel - All User</title>
        <%@include file="../config/start_template.jsp" %>        
    </head>
    <body>
        <%@include file="../config/header_adm.jsp" %>
        <%@include file="../config/body_config.jsp" %>
        <div class="friend">
            <div class="container">
                <div class="friend-main">
                    <div class="friend-top">   
                        <h3>All Users</h3>
                        <jsp:useBean id="userDao" class="dao.UserDao"/>
                        <jsp:useBean id="user" class="Beans.User"/>                        
                        <c:set var="list_user" value="${userDao.search()}" scope="page"/>
                        <table class="table table-bordered">
                            <thead>
                                <tr>
                                    <th>
                                        Id
                                    </th>
                                    <th>
                                        Name
                                    </th>
                                    <th>
                                        Cpf
                                    </th>
                                    <th>
                                        Phone
                                    </th>
                                    <th>
                                        Address
                                    </th>
                                    <th>
                                        Rg
                                    </th>
                                    <th>
                                        Sex
                                    </th>
                                    <th>
                                        Birthday
                                    </th>
                                    <th>
                                        User Type
                                    </th>                                                                     
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="new_user" items="${list_user}">
                                    <tr>
                                        <th>
                                            ${new_user.id}
                                        </th>
                                        <th>
                                            ${new_user.name}
                                        </th>
                                        <th>
                                            ${new_user.cpf}
                                        </th>
                                         <th>
                                            ${new_user.phone}
                                        </th>
                                        <th>
                                            ${new_user.address}
                                        </th>
                                        <th>
                                            ${new_user.rg}
                                        </th>   
                                         <th>
                                            ${new_user.sex}
                                        </th>
                                        <th>
                                            ${new_user.birthday}
                                        </th>
                                        <th>
                                            ${new_user.userType}
                                        </th>   
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>                
                    <%@include file="../config/footer.jsp" %>
                    </body>
                    </html>