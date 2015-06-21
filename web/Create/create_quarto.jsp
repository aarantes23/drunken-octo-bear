<%-- 
    Document   : create_quarto
    Created on : 21-Jun-2015, 16:51:33
    Author     : Arthur
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
    <head>
        <title>Trip hotel - Create new Quarto</title>
        <%@include file="../config/start_template.jsp" %>
    </head>
    <body>        
        <%@include file="../config/header_adm.jsp" %>
        <%@include file="../config/body_config.jsp" %>
        <div class="friend">
            <div class="container">
                <div class="friend-main">
                    <div class="friend-top">
                        <h3>Create New Quarto</h3>
                        <form method="post" action="CadastraQuarto">
                            <p>Andar :  <input type="text" name="andar"></p>                                        
                            <p>Quant camas :  <input type="text" name="quantAcom"></p>       
                            <p>Valor da diaria :  <input type="text" name="valorDiaria" id="valorDiaria"></p>  
                            <p>Tipo do quarto :  
                                <select name="tipoQuarto" id="tipoQuarto" >
                                    <option value="1">Solteiro</option>
                                    <option value="2">Casal</option>
                                </select>
                            </p>                    
                            <p><input type="submit" value="Enviar"></p>                    
                        </form>
                    </div>                
                    <%@include file="../config/footer.jsp" %>
                    </body>
                    </html>