<%-- 
    Document   : update_item
    Created on : 21-Jun-2015, 17:57:24
    Author     : Arthur
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
    <head>
        <title>Trip hotel - Update Item</title>
        <%@include file="../config/start_template.jsp" %>
    </head>
    <body>
        <%@include file="../config/header_adm.jsp" %>
        <%@include file="../config/body_config.jsp" %>
        <div class="friend">
            <div class="container">
                <div class="friend-main">
                    <div class="friend-top">
                        <h3>Update Item</h3>
                        <form action="UpdateItem" method="post">
                            <p>Code : <input name="code" type="number" id="code" required="true"</p>                            
                            <p>New Name : <input name="name" type="text" id="name" required="true"</p>
                            <p>New Price : <input name="price" type="number" id="price" required="true"</p>                            
                            <p><input type="submit" value="Update"></p>
                        </form>                        
                    </div>                
                    <%@include file="../config/footer.jsp" %>
                    </body>
                    </html>