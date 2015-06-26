<%-- 
    Document   : create_item
    Created on : 21-Jun-2015, 16:51:33
    Author     : Arthur
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
<html>
    <head>
        <title>Trip hotel - All Item</title>
        <%@include file="../config/start_template.jsp" %>        
    </head>
    <body>
        <%@include file="../config/header_adm.jsp" %>
        <%@include file="../config/body_config.jsp" %>
        <div class="friend">
            <div class="container">
                <div class="friend-main">
                    <div class="friend-top">   
                        <h3>All Items</h3>
                        <jsp:useBean id="itemDao" class="dao.ItemDao"/>
                        <jsp:useBean id="item" class="Beans.Item"/>                        
                        <c:set var="list_item" value="${itemDao.search()}" scope="page"/>
                        <table class="table table-bordered">
                            <thead>
                                <tr>
                                    <th>
                                        Id
                                    </th>
                                    <th>
                                        Price
                                    </th>
                                    <th>
                                        Name
                                    </th>
                                </tr>
                            </thead>
                            <tbody>
                            <c:forEach var="new_item" items="${list_item}">
                                <tr>
                                    <th>
                                        ${new_item.id}
                                    </th>
                                    <th>
                                        ${new_item.price}
                                    </th>
                                    <th>
                                        ${new_item.name}
                                    </th>                                       
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>                
                    <%@include file="../config/footer.jsp" %>
                    </body>
                    </html>