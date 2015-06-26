<%-- 
    Document   : create_checkIn
    Created on : 21-Jun-2015, 16:51:33
    Author     : Arthur
--%>
  
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

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
    <head>
        <title>Trip hotel - Create CheckIn</title>
        <%@include file="../config/start_template.jsp" %> 
        <!--Datepicker Start-->
        <link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
        <script src="//code.jquery.com/jquery-1.10.2.js"></script>
        <script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
        <link rel="stylesheet" href="/resources/demos/style.css">
        <script>
            $(function () {
                $("#date").datepicker();
            });
        </script>
        <!--Datepicker ends-->
    </head>
    <body>
        <% if ((request.getSession(true).getAttribute("login") != null) && ((usuario.getUserType() == 2))){ %>
        <%@include file="../config/header_adm.jsp" %>
        <%@include file="../config/body_config.jsp" %>
        <div class="friend">
            <div class="container">
                <div class="friend-main">
                    <div class="friend-top">                        
                        <h3>Create CheckIn</h3>
                        <form action="../dao/Create/insert_checkIn.jsp" method="post">
                            <p>Date : <input name="date" type="text" id="date" required="true"</p>
                            <p>Status : <input name="status" type="number" id="status" required="true"</p>                            
                            <p><input type="submit" value="Update"></p>
                        </form>
                    </div>                
                    <%@include file="../config/footer.jsp" %>
        <% } else{ response.sendRedirect("index.jsp"); } %>
    </body>
</html>
