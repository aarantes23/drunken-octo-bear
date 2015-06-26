<%-- 
    Document   : header_new
    Created on : 22-Jun-2015, 08:30:07
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
        <li class='active has-sub'><a href='../Create/make_CheckIn.jsp'><span>CheckIn</span></a>
            <ul>
                <li class='has-sub'><a href='../Create/create_CheckIn.jsp'><span>New</span></a></li>
                <li class='has-sub'><a href='../Delete/delete_CheckIn.jsp'><span>Delete</span></a></li>
                <li class='has-sub'><a href='../Update/update_CheckIn.jsp'><span>Update</span></a></li>
                <li class='has-sub'><a href='../ListAll/all_CheckIn.jsp'><span>List All</span></a></li>
            </ul>
        </li>
        <% } %>        
        <% if ((request.getSession(true).getAttribute("login") != null) && ((usuario.getUserType() == 1) || (usuario.getUserType() == 2))){ %>
        <li class='active has-sub'><a href='#'><span>Clients</span></a>
            <ul>
                <li class='has-sub'><a href='../Create/create_client.jsp'><span>New</span></a></li>
                <li class='has-sub'><a href='../Delete/delete_client.jsp'><span>Delete</span></a></li>               
                <li class='has-sub'><a href='../Update/update_client.jsp'><span>Update</span></a></li>
                <li class='has-sub'><a href='../ListAll/all_client.jsp'><span>List all</span></a></li>
            </ul>
        </li>
        <li class='active has-sub'><a href='#'><span>Item</span></a>
            <ul>
                <li class='has-sub'><a href='../Create/create_item.jsp'><span>New</span></a></li>
                <li class='has-sub'><a href='../Delete/delete_item.jsp'><span>Delete</span></a></li>
                <li class='has-sub'><a href='../Update/update_item.jsp'><span>Update</span></a></li>
                <li class='has-sub'><a href='../ListAll/all_items.jsp'><span>List all</span></a></li>
            </ul>
        </li>
        <li class='active has-sub'><a href='#'><span>Reservation</span></a>
            <ul>
                <li class='has-sub'><a href='../Create/create_reservation.jsp'><span>New</span></a></li>
                <li class='has-sub'><a href='../Delete/delete_reservation.jsp'><span>Delete</span></a></li>
                <li class='has-sub'><a href='../Update/update_reservation.jsp'><span>Update</span></a></li>
                <li class='has-sub'><a href='../ListAll/all_reservation.jsp'><span>List all</span></a></li>
            </ul>
        </li>
        <li class='last'><a href='../Create/create_CheckOut.jsp'><span>CheckOut</span></a></li>
        <% } %>
        <li class='last'><a href='../Login/login.jsp'><span>Logoff</span></a></li>
    </ul>    
</ul>
</div>
