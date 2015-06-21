<%-- 
    Document   : update_usuario
    Created on : 21-Jun-2015, 17:57:24
    Author     : Arthur
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
    <head>
        <title>Trip hotel - Update Usuario</title>
        <%@include file="../config/start_template.jsp" %>
    </head>
    <body>
        <%@include file="../config/header_adm.jsp" %>
        <%@include file="../config/body_config.jsp" %>
        <div class="friend">
            <div class="container">
                <div class="friend-main">
                    <div class="friend-top">
                        <h3>Update Usuario</h3>
                        <form action="AtualizaUsuario" method="post">                        
                            <p>Codigo do Usuario : <input name="codigo" type="text" id="codigo"</p>
                            <p>Nome : <input name="nome" type="text" id="nome"</p>
                            <p>Email : <input name="email" type="text" id="email"</p>
                            <p>Senha : <input name="endereco" type="password" id="senha"</p>
                            <p>Tipo :  
                                <select name="tipoAcesso" id="tipoAcesso" >
                                    <option value="1">Recepcionista</option>
                                    <option value="2">Administrador</option>
                                </select>
                            </p>                                                          
                            <p><input type="submit" value="Enviar"></p>
                        </form>
                    </div>                
                    <%@include file="../config/footer.jsp" %>
                    </body>
                    </html>
