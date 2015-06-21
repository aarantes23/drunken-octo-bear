<%-- 
    Document   : create_consumo
    Created on : 21-Jun-2015, 16:51:33
    Author     : Arthur
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
    <head>
        <title>Trip hotel - Create new Consumo</title>
        <%@include file="../config/start_template.jsp" %>
    </head>
    <body>
        <%@include file="../config/header_adm.jsp" %>
        <%@include file="../config/body_config.jsp" %>
        <div class="friend">
            <div class="container">
                <div class="friend-main">
                    <div class="friend-top">
                        <h3>Create New Consumo</h3>
                        <form action="CadastraConsumo" method="post">
                            <p>Codigo Produto : <input name="codProd" type="text" id="codProd"</p>
                            <p>Codigo Cliente : <input name="codCli" type="text" id="codCli"</p>
                            <p>Quantidade : <input name="quant" type="text" id="quant"</p>
                            <p>Valor Total : <input name="valor" type="text" id="valor"</p>                        
                            <p><input type="submit" value="Enviar"></p>
                        </form>
                    </div>                
                    <%@include file="../config/footer.jsp" %>
                    </body>
                    </html>