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
                        <h3>Add Item to checkOut</h3>
                        <form action="../dao/Add/add_item.jsp" method="post">
                            <p>Item id: <input name="item_id" type="text" id="item_id" required="true"</p>
                            <p>Reservation id: <input name="reservation_id" type="text" id="reservation_id" required="true"</p>                            
                            <p><input type="submit" value="Add"></p>
                        </form>
                    </div>                
                    <%@include file="../config/footer.jsp" %>
                    </body>
                    </html>