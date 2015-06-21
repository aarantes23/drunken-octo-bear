<%-- 
    Document   : delete_consumo
    Created on : 21-Jun-2015, 17:00:23
    Author     : Arthur
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
    <head>
        <title>Trip hotel - Delete Consumo</title>
        <%@include file="../config/start_template.jsp" %>
    </head>
    <body>
        <%@include file="../config/header_adm.jsp" %>
        <%@include file="../config/body_config.jsp" %>
        <div class="friend">
            <div class="container">
                <div class="friend-main">
                    <div class="friend-top">
                        <h3>Delete Consumo</h3>
                        <form action="RemoverConsumo" method="post">
                            <p>Codigo do cliente : <input name="codigo" type="text" id="codigo"</p>                        
                            <p><input type="submit" value="Pesquisar"></p>
                        </form>
                    </div>                
                    <%@include file="../config/footer.jsp" %>
                    </body>
                    </html>
