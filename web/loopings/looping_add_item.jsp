<%-- 
    Document   : create_item
    Created on : 21-Jun-2015, 16:51:33
    Author     : Arthur
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
    <head>
        <title>Trip hotel - Create new Item</title>
        <%@include file="../config/start_template.jsp" %>
    </head>
    <body>
        <%@include file="../config/header_adm.jsp" %>
        <%@include file="../config/body_config.jsp" %>
        <div class="friend">
            <div class="container">
                <div class="friend-main">
                    <div class="friend-top">
                        <h3>Add item ?</h3>
                        <form action="../result/add_item.jsp" method="post">
                            <p><input type="submit" value="Yes" href=""></p>    
                        </form>
                        <form action="../result/search_reservation.jsp" method="post">
                            <p><input type="submit" value="Go to payment"></p>
                        </form>
                    </div>                
                    <%@include file="../config/footer.jsp" %>
                    </body>
                    </html>