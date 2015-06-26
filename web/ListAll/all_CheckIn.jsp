<%-- 
    Document   : create_checkIn
    Created on : 21-Jun-2015, 16:51:33
    Author     : Arthur
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
<html>
    <head>
        <title>Trip hotel - All CheckIn</title>
        <%@include file="../config/start_template.jsp" %>        
    </head>
    <body>
        <%@include file="../config/header_adm.jsp" %>
        <%@include file="../config/body_config.jsp" %>
        <div class="friend">
            <div class="container">
                <div class="friend-main">
                    <div class="friend-top">   
                        <h3>All CheckIns</h3>
                        <jsp:useBean id="checkInDao" class="dao.CheckInDao"/>
                        <jsp:useBean id="checkIn" class="Beans.CheckIn"/>                        
                        <c:set var="list_checkIn" value="${checkInDao.search()}" scope="page"/>
                        <table class="table table-bordered">
                            <thead>
                                <tr>
                                    <th>
                                        Id
                                    </th>
                                    <th>
                                        Date
                                    </th>
                                    <th>
                                        Status
                                    </th>
                                </tr>
                            </thead>
                            <tbody>
                            <c:forEach var="checkIn" items="${list_checkIn}">
                                <tr>
                                    <th>
                                        ${checkIn.id}
                                    </th>
                                    <th>
                                        ${checkIn.date}
                                    </th>
                                    <th>
                                        ${checkIn.status}
                                    </th>                                       
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>                
                    <%@include file="../config/footer.jsp" %>
                    </body>
                    </html>