<%-- 
    Document   : update_user
    Created on : 23-Jun-2015, 11:44:32
    Author     : Arthur
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Trip hotel - Update</title>
    </head>
    <body>        
        <jsp:useBean id="user" class="Beans.User"/>
        <jsp:useBean id="userDao" class="dao.UserDao"/>

        ${user.setId(param.code)}
        ${user.setName(param.name)}
        ${user.setLogin(param.login)}
        ${user.setPassword(param.password)}
        ${user.setCpf(param.cpf)}
        ${user.setPhone(param.phone)}
        ${user.setAddress(param.address)}
        ${user.setRg(param.rg)}
        ${user.setSex(param.sex)}
        ${user.setBirthday(param.birthday)}
        ${user.setUserType(param.userType)}

        <c:if test="${userDao.update(user)}">
            <c:redirect url="/config/operation_success.jsp"/>
        </c:if>
        <c:redirect url="/config/operation_erro.jsp"/>

    </body>
</html>
