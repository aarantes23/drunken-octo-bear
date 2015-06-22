<%-- 
    Document   : search_reservation
    Created on : 21-Jun-2015, 17:47:48
    Author     : Arthur
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
    <head>
        <title>Trip hotel - Search Reservation</title>
        <%@include file="../config/start_template.jsp" %>
    </head>
    <body>
        <%@include file="../config/header_adm.jsp" %>
        <%@include file="../config/body_config.jsp" %>
        <div class="friend">
            <div class="container">
                <div class="friend-main">
                    <div class="friend-top">
                        <h3>Search Reservation</h3>
                        <form action="SearchReservation" method="post">
                            <p>Reservation code : <input name="code" type="number" id="code" required="true"</p>                        
                            <p><input type="submit" value="Search"></p>
                        </form>
                    </div>                
                    <%@include file="../config/footer.jsp" %>
                    </body>
                    </html>