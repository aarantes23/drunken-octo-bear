<%-- 
    Document   : header_default
    Created on : 21-Jun-2015, 16:30:27
    Author     : Arthur
--%>
<%@page import="Beans.User"%>
<%  
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
<div id='cssmenu'>
    <ul>
        <div class="top-nav">
            <ul class="res">                         
                <li><a href='../Main/index_default.jsp'><span>Trip Hotel</span></a></li>
                <li><a href='../Main/services.jsp'><span>Services</span></a></li>
                <li><a href='../Main/about.jsp'><span>About</span></a></li>
                <li><a href='../Main/contact.jsp'><span>Contact</span></a></li>                
                <% if ((request.getSession(true).getAttribute("login") == null) ){ %>  
                    <li class='last'><a href='../Login/login.jsp'><span>Restricted Area</span></a></li>
                <% } %>
            </ul>    
        </div>
    </ul>
</div>