<%-- 
    Document   : update_checkOut
    Created on : 21-Jun-2015, 17:57:24
    Author     : Arthur
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
    <head>
        <title>Trip hotel - Update CheckOut</title>
        <%@include file="../config/start_template.jsp" %>
    </head>
    <body>
        <%@include file="../config/header_adm.jsp" %>
        <%@include file="../config/body_config.jsp" %>
        <div class="friend">
            <div class="container">
                <div class="friend-main">
                    <div class="friend-top">
                        <h3>Update CheckOut</h3>
                        <form action="../dao/Update/update_checkOut.jsp" method="post">
                            <p>CheckOut Code : <input name="code" type="number" id="code" required="true"</p>                            
                            <p>New date : <input name="date" type="text" id="date" required="true"</p>
                            <p>New Status : <input name="status" type="number" id="status" required="true"</p>                            
                            <p><input type="submit" value="Update"></p>
                        </form>
                    </div>                
                    <%@include file="../config/footer.jsp" %>
                    </body>
                    </html>