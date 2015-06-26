<%-- 
    Document   : insert_client
    Created on : 23-Jun-2015, 11:44:32
    Author     : Arthur
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Trip hotel - Insert</title>
    </head>
    <body>        
        <jsp:useBean id="client" class="Beans.Client"/>
        <jsp:useBean id="clientDao" class="dao.ClientDao"/>

        ${client.setName(param.name)}
        ${client.setAddress(param.address)}
        ${client.setCpf(param.cpf)}
        ${client.setRg(param.rg)}
        ${client.setPhone(param.phone)}
        ${client.setSex(param.sex)}

        <c:if test="${clientDao.insert(client)}">
            <c:redirect url="/config/operation_success.jsp"/>
        </c:if>
        <c:redirect url="/config/operation_erro.jsp"/>

    </body>
</html>
