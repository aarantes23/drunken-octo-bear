<%-- 
    Document   : delete_client
    Created on : 21-Jun-2015, 17:00:23
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
        <title>Trip hotel - Delete Client</title>
        <%@include file="../config/start_template.jsp" %>
    </head>
    <body>
        <% if ((request.getSession(true).getAttribute("login") != null) && ((usuario.getUserType() == 1) || (usuario.getUserType() == 2))){ %>
        <%@include file="../config/header_adm.jsp" %>
        <%@include file="../config/body_config.jsp" %>
        <div class="friend">
            <div class="container">
                <div class="friend-main">
                    <div class="friend-top">
                        <h3>Delete Client</h3>
                        <form action="../dao/Delete/delete_client.jsp" method="post">
                            <p>Client code : <input name="code" type="number" id="code" required="true"</p>                        
                            <p><input type="submit" value="Delete"></p>
                        </form>
                    </div>                
                    <%@include file="../config/footer.jsp" %>
        <% } else{ response.sendRedirect("index.jsp"); } %>
    </body>
</html>
