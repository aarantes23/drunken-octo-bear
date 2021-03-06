<%-- 
    Document   : delete_client
    Created on : 23-Jun-2015, 11:44:32
    Author     : Arthur
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Trip hotel - Delete</title>
    </head>
    <body>        
        <jsp:useBean id="client" class="Beans.Client"/>
        <jsp:useBean id="clientDao" class="dao.ClientDao"/>

        ${client.setId(param.code)}

        <c:if test="${clientDao.delete(cliente)}">
            <c:redirect url="/config/operation_success.jsp"/>
        </c:if>
        <c:redirect url="/config/operation_erro.jsp"/>

    </body>
</html>
