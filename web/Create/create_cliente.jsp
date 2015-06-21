<%-- 
    Document   : create_cliente
    Created on : 21-Jun-2015, 16:51:33
    Author     : Arthur
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
    <head>
        <title>Trip hotel - Create new Cliente</title>
        <%@include file="../config/start_template.jsp" %>
    </head>
    <body>
        <%@include file="../config/header_adm.jsp" %>
        <%@include file="../config/body_config.jsp" %>
        <div class="friend">
            <div class="container">
                <div class="friend-main">
                    <div class="friend-top">
                        <h3>Create New Cliente</h3>
                        <form action="CadastraCliente" method="post">
                            <p>Nome : <input name="nome" type="text" id="nome"</p>
                            <p>Endereco : <input name="endereco" type="text" id="endereco"</p>
                            <p>Bairro : <input name="bairro" type="text" id="bairro"</p>
                            <p>Cep : <input name="cep" type="text" id="cep"</p>
                            <p>Numero : <input name="numero" type="text" id="numero"</p>
                            <p>Cidade : <input name="cidade" type="text" id="cidade"</p>
                            <p>Telefone : <input name="telefone" type="text" id="telefone"</p>
                            <p>Email : <input name="email" type="text" id="email"</p>
                            <p><input type="submit" value="Enviar"></p>
                        </form>
                    </div>                
                    <%@include file="../config/footer.jsp" %>
                    </body>
                    </html>