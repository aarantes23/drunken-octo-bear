<%-- 
    Document   : update_quarto
    Created on : 21-Jun-2015, 17:57:24
    Author     : Arthur
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
    <head>
        <title>Trip hotel - Update Quarto</title>
        <%@include file="../config/start_template.jsp" %>
    </head>
    <body>
        <%@include file="../config/header_adm.jsp" %>
        <%@include file="../config/body_config.jsp" %>
        <div class="friend">
            <div class="container">
                <div class="friend-main">
                    <div class="friend-top">
                        <h3>Update Quarto</h3>
                        <form method="post" action="AtualizaQuarto">
                            <p>Codigo do quarto :  <input type="text" name="codigo" id="codigo"></p>                                        
                            <p>Andar :  <input type="text" name="andar" id="andar"></p>                                        
                            <p>Quant camas :  <input type="text" name="quantAcom" id="quantAcom"></p>                    
                            <p>Valor da diaria :  <input type="text" name="valorDiaria" id="valorDiaria"></p>  
                            <p>Tipo do quarto :  
                                <select name="tipoQuarto" id="tipoQuarto">
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
