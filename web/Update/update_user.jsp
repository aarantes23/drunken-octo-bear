<%-- 
    Document   : update_user
    Created on : 21-Jun-2015, 17:57:24
    Author     : Arthur
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>  
<%@page import="Beans.User"%>
<%  
    // <jsp:include page="sessao.jsp" />
    request.getSession(false).setMaxInactiveInterval(3000);  
    int duracaoSessao = request.getSession(false).getMaxInactiveInterval();  
    long now = System.currentTimeMillis();  
    long ultimoAcesso = request.getSession(false).getLastAccessedTime();  
    User usuario = new User();  
    
    if (now - ultimoAcesso > duracaoSessao) { 
        usuario = new User();
        session.invalidate();
    //    out.println("sessão expirou");  
    } else {                      
                                      
        usuario = (User) request.getSession(true).getAttribute("login");       
    //    out.println("sessão válida");                                                  
    }  
%>

<!DOCTYPE HTML>
<html>
    <head>
        <title>Trip hotel - Update User</title>
        <%@include file="../config/start_template.jsp" %>
    </head>
    <body>
        <% if ((request.getSession(true).getAttribute("login") != null) && (usuario.getUserType() == 2)){ %>
        <%@include file="../config/header_adm.jsp" %>
        <%@include file="../config/body_config.jsp" %>
        <div class="friend">
            <div class="container">
                <div class="friend-main">
                    <div class="friend-top">
                        <h3>Update User</h3>
                        <form action="UpdateUser" method="post">
                            <p>Code : <input name="code" type="number" id="code" required="true"</p>                            
                            <p>New Login : <input name="login" type="text" id="login" required="true"</p>
                            <p>New Password : <input name="password" type="password" id="password" required="true"</p>
                            <p>New Cpf : <input name="cpf" type="text" id="cpf" </p>
                            <p>New Phone : <input name="phone" type="text" id="phone" </p>
                            <p>New Address : <input name="address" type="text" id="address" </p>
                            <p>New Rg : <input name="rg" type="text" id="rg" </p>
                            <p>New Sex : <input name="sex" type="text" id="sex" </p>
                            <p>New Birthday : <input name="birthday" type="text" id="birthday"</p>
                            <p>User type : 
                                <select name="userType" id="userType">
                                    <option value="1">Manager</option>
                                    <option value="2">Receptionist</option>
                                </select></p>
                            <p><input type="submit" value="Update"></p>
                        </form>
                    </div>                
                    <%@include file="../config/footer.jsp" %>
        <% } else{ response.sendRedirect("index.jsp"); } %>
    </body>
</html>