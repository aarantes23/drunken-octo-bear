<%-- 
    Document   : update_produto
    Created on : 21-Jun-2015, 17:57:24
    Author     : Arthur
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
    <head>
        <title>Trip hotel - Update Produto</title>
        <%@include file="../config/start_template.jsp" %>
    </head>
    <body>
        <%@include file="../config/header_adm.jsp" %>
        <%@include file="../config/body_config.jsp" %>
        <div class="friend">
            <div class="container">
                <div class="friend-main">
                    <div class="friend-top">
                        <h3>Update Produto</h3>
                        <form action="AtualizaProduto method="post">
                              <p>Codigo do produto : <input name="codigo" type="text" id="codigo"</p>
                            <p>Descricao : <input name="descricao" type="text" id="descricao"</p>
                            <p>Valor : <input name="valor" type="text" id="valor"</p>                        
                            <p><input type="submit" value="Enviar"></p>
                        </form>
                    </div>                
                    <%@include file="../config/footer.jsp" %>
                    </body>
                    </html>