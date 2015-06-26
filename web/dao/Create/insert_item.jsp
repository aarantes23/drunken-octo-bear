<%-- 
    Document   : insert_item
    Created on : 24-Jun-2015, 02:10:56
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
        <jsp:useBean id="item" class="Beans.Item"/>
        <jsp:useBean id="itemDao" class="dao.ItemDao"/>

        ${item.setName(param.name)}
        ${item.setPrice(param.price)}

        <c:if test="${itemDao.insert(item)}">
            <c:redirect url="/config/operation_success.jsp"/>
        </c:if>
        <c:redirect url="/config/operation_erro.jsp"/>         

    </body>
</html>
