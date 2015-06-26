<%-- 
    Document   : create_client
    Created on : 21-Jun-2015, 16:51:33
    Author     : Arthur
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
<html>
    <head>
        <title>Trip hotel - Make Client</title>
        <%@include file="../config/start_template.jsp" %>        
    </head>
    <body>
        <%@include file="../config/header_adm.jsp" %>
        <%@include file="../config/body_config.jsp" %>
        <div class="friend">
            <div class="container">
                <div class="friend-main">
                    <div class="friend-top">   
                        <h3>All Clients</h3>
                        <jsp:useBean id="clientDao" class="dao.ClientDao"/>
                        <jsp:useBean id="client" class="Beans.Client"/>                        
                        <c:set var="list_client" value="${clientDao.search()}" scope="page"/>
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
                                        Address
                                    </th>
                                    <th>
                                        Cpf
                                    </th>
                                    <th>
                                        Rg
                                    </th>
                                    <th>
                                        Phone
                                    </th>
                                    <th>
                                        Sex
                                    </th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="new_client" items="${list_client}">
                                    <tr>
                                        <th>
                                            ${new_client.id}
                                        </th>
                                        <th>
                                            ${new_client.name}
                                        </th>
                                        <th>
                                            ${new_client.address}
                                        </th>               
                                        <th>
                                            ${new_client.cpf}
                                        </th>
                                        <th>
                                            ${new_client.rg}
                                        </th>
                                        <th>
                                            ${new_client.phone}
                                        </th>
                                        <th>
                                            ${new_client.sex}
                                        </th>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>                
                    <%@include file="../config/footer.jsp" %>
                    </body>
                    </html>