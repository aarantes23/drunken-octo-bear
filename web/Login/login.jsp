<%-- 
    Document   : login
    Created on : 21-Jun-2015, 16:50:35
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

<!DOCTYPE html>
<html>	
    <head>
        <title>Trip Hotel - Login</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
        <meta name="keywords" content="Developed by Arthur Arantes Faria, arthurarantes23@hotmail.com"/>
        <link href="../css/styleLogin.css" rel='stylesheet' type='text/css' />
        <!--webfonts-->
        <link href='http://fonts.googleapis.com/css?family=Open+Sans:700,300,600,800,400' rel='stylesheet' type='text/css'>
        <link href='http://fonts.googleapis.com/css?family=Marvel:400,700' rel='stylesheet' type='text/css'>
        <!--//webfonts-->
    </head>
    <body>
        <% if ((request.getSession(true).getAttribute("login") == null)){ %>
        <h1>Trip Hotel - Restricted Area </h1>
        <div class="registration">
            <div class="form-info">
                <form action="../Login/index_after_login.jsp" method="post">
                    <h2>Login</h2>
                    <input type="text" class="text" placeholder="Username" required="true"/>
                    <input type="password" class="Password" placeholder="Password" required="true"/>
                    <div class="btn"><input type="submit" value="Login" name="login"></div>
                    <div class="roundedOne">
                        <input type="checkbox" value="None" id="roundedOne" name="check" />
                        <label for="roundedOne"> </label>
                        <p>Remember me</p>
                    </div>
                </form>	
                <div class="clear"> </div>
            </div>
            <div class="strip"></div>            
        </div>
        <div class="copy-rights">
            <p>Developed by Arthur Arantes Faria, arthurarantes23@hotmail.com </p>
        </div>
        <% } else{ response.sendRedirect("login.jsp"); } %>
    </body>
</html>
