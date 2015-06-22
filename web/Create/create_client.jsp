<%-- 
    Document   : create_client
    Created on : 21-Jun-2015, 16:51:33
    Author     : Arthur
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
    <head>
        <title>Trip hotel - Create new Client</title>
        <%@include file="../config/start_template.jsp" %>
    </head>
    <body>
        <%@include file="../config/header_adm.jsp" %>
        <%@include file="../config/body_config.jsp" %>
        <div class="friend">
            <div class="container">
                <div class="friend-main">
                    <div class="friend-top">
                        <h3>Create New Client</h3>
                        <form  method="post" action="CreateCliente">
                            <p>Name : <input name="name" type="text" id="name" required="true"</p>
                            <p>Address : <input name="address" type="text" id="address" required="true"</p>
                            <p>Cpf : <input name="bairro" type="text" id="cpf" required="true"</p>
                            <p>Rg : <input name="cep" type="text" id="rg" required="true"</p>                            
                            <p>Phone : <input name="phone" type="text" id="phone" required="true"</p>
                            <p>Sex : <input name="sex" type="text" id="sex" required="true"</p>
                            <p><input type="submit" value="Create"></p>
                        </form>
                    </div>                
                    <%@include file="../config/footer.jsp" %>
                    </body>
                    </html>