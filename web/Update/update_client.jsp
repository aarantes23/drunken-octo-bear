<%-- 
    Document   : update_client
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
        <title>Trip hotel - Update Client</title>
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
                        <h3>Update Client</h3>
                        <form  method="post" action="UpdateCliente">
                            <p>Code : <input name="code" type="number" id="code" required="true"</p>                            
                            <p>New Name : <input name="name" type="text" id="name" required="true"</p>
                            <p>New Address : <input name="address" type="text" id="address" required="true"</p>
                            <p>New Cpf : <input name="bairro" type="text" id="cpf" required="true"</p>
                            <p>New Rg : <input name="cep" type="text" id="rg" required="true"</p>                            
                            <p>New Phone : <input name="phone" type="text" id="phone" required="true"</p>
                            <p>New Sex : <input name="sex" type="text" id="sex" required="true"</p>
                            <p><input type="submit" value="Create"></p>
                        </form>
                    </div>                
                    <%@include file="../config/footer.jsp" %>
            <% } else{ response.sendRedirect("index.jsp"); } %>
        </body>
    </html>