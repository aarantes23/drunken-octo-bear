<%-- 
    Document   : header_adm
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
        <li><a href='../Login/index_after_login.jsp'><span>Trip Hotel</span></a></li>    
        <li class='active has-sub'><a href='#'><span>Create</span></a>
            <ul>     
                <% if ((request.getSession(true).getAttribute("login") != null) && ((usuario.getUserType() == 1) || (usuario.getUserType() == 2))){ %>                
                    <% if ((request.getSession(true).getAttribute("login") != null) && ((usuario.getUserType() == 2))){ %> 
                        <li class='has-sub'><a href='../Create/create_CheckOut.jsp'><span>CheckOut</span></a></li>       
                        <li class='has-sub'><a href='../Create/create_item.jsp'><span>Item</span></a></li>       
                        <li class='has-sub'><a href='../Create/create_room.jsp'><span>Room</span></a></li>
                        <li class='has-sub'><a href='../Create/create_user.jsp'><span>User</span></a></li> 
                    <% } %>
                    <li class='has-sub'><a href='../Create/create_client.jsp'><span>Client</span></a></li>
                    <li class='has-sub'><a href='../Create/create_reservation.jsp'><span>Reservation</span></a></li>
                <% } %>
            </ul>
        </li>
        <li class='active has-sub'><a href='#'><span>Delete</span></a>
            <ul>
                <% if ((request.getSession(true).getAttribute("login") != null) && ((usuario.getUserType() == 1) || (usuario.getUserType() == 2))){ %>                
                    <% if ((request.getSession(true).getAttribute("login") != null) && ((usuario.getUserType() == 2))){ %> 
                        <li class='has-sub'><a href='../Delete/delete_CheckOut.jsp'><span>CheckOut</span></a></li>
                        <li class='has-sub'><a href='../Delete/delete_item.jsp'><span>Item</span></a></li>
                        <li class='has-sub'><a href='../Delete/delete_room.jsp'><span>Room</span></a></li>
                        <li class='has-sub'><a href='../Delete/delete_user.jsp'><span>User</span></a></li>
                    <% } %>
                        <li class='has-sub'><a href='../Delete/delete_reservation.jsp'><span>Reservation</span></a></li>                
                        <li class='has-sub'><a href='../Delete/delete_client.jsp'><span>Client</span></a></li>
                <% } %>
                
            </ul>
        </li>
        <li class='active has-sub'><a href='#'><span>Search</span></a>
            <ul>
                <% if ((request.getSession(true).getAttribute("login") != null) && ((usuario.getUserType() == 1) || (usuario.getUserType() == 2))){ %>                
                    <% if ((request.getSession(true).getAttribute("login") != null) && ((usuario.getUserType() == 2))){ %> 
                        <li class='has-sub'><a href='../Search/search_CheckOut.jsp'><span>CheckOut</span></a></li>
                        <li class='has-sub'><a href='../Search/search_item.jsp'><span>Item</span></a></li>
                        <li class='has-sub'><a href='../Search/search_room.jsp'><span>Room</span></a></li>
                        <li class='has-sub'><a href='../Search/search_user.jsp'><span>User</span></a></li>
                    <% } %>
                        <li class='has-sub'><a href='../Search/search_client.jsp'><span>Client</span></a></li>
                        <li class='has-sub'><a href='../Search/search_reservation.jsp'><span>Reservation</span></a></li>                
                <% } %>
            </ul>
        </li>
        <li class='active has-sub'><a href='#'><span>Update</span></a>
            <ul>
                <% if ((request.getSession(true).getAttribute("login") != null) && ((usuario.getUserType() == 1) || (usuario.getUserType() == 2))){ %>                
                    <% if ((request.getSession(true).getAttribute("login") != null) && ((usuario.getUserType() == 2))){ %>
                        <li class='has-sub'><a href='../Update/update_CheckOut.jsp'><span>CheckOut</span></a></li>
                        <li class='has-sub'><a href='../Update/update_item.jsp'><span>Item</span></a></li>
                        <li class='has-sub'><a href='../Update/update_room.jsp'><span>Room</span></a></li>
                        <li class='has-sub'><a href='../Update/update_user.jsp'><span>User</span></a></li>
                    <% } %>             
                        <li class='has-sub'><a href='../Update/update_client.jsp'><span>Client</span></a></li>
                        <li class='has-sub'><a href='../Update/update_reservation.jsp'><span>Reservation</span></a></li>
                <% } %>
            </ul>
        </li>
        <% if ((request.getSession(true).getAttribute("login") == null) ){ %>                                
            <li class='last'><a href='../Login/login.jsp'><span>Logoff</span></a></li>
        <% } %>    
    </ul>    
</ul>
</div>
