<%-- 
    Document   : create_reservation
    Created on : 21-Jun-2015, 16:51:33
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
        <title>Trip hotel - Create new Reservation</title>
        <%@include file="../config/start_template.jsp" %>
    </head>
    <body>
        <% if ((request.getSession(true).getAttribute("login") != null) && ((usuario.getUserType() == 2))){ %>
        <%@include file="../config/header_adm.jsp" %>
        <%@include file="../config/body_config.jsp" %>
        <div class="friend">
            <div class="container">
                <div class="friend-main">
                    <div class="friend-top">
                        <h3>Create New Reservation</h3>
                        <form action="CreateReservation" method="post">
                            <p>Room code : <input name="room_id" type="number" id="room_id" required="true"</p>                        
                            <p>Client code : <input name="client_id" type="number" id="client_id" required="true"</p>
                            <p>User Responsible code : <input name="user_id" type="number" id="user_id" required="true"</p>
                            <p>Check out code : <input name="check_out_id" type="number" id="check_out_id" required="true"</p>                        
                            <p>Check in code : <input name="check_in_id" type="number" id="check_in_id" required="true"</p>                        
                            <p><input type="submit" value="Create"></p>
                        </form>
                    </div>                
                    <%@include file="../config/footer.jsp" %>
        <% } else{ response.sendRedirect("index.jsp"); } %>
    </body>
</html>