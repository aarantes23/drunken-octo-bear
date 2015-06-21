<%-- 
    Document   : update_reserva
    Created on : 21-Jun-2015, 17:57:24
    Author     : Arthur
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
    <head>
        <title>Trip hotel - Update Reserva</title>
        <%@include file="../config/start_template.jsp" %>
    </head>
    <body>
        <%@include file="../config/header_adm.jsp" %>
        <%@include file="../config/body_config.jsp" %>
        <div class="friend">
            <div class="container">
                <div class="friend-main">
                    <div class="friend-top">
                        <h3>Update Reserva</h3>
                        <form action="AtualizaReserva method="post">
                              <p>Codigo da Reserva : <input name="codigo" type="text" id="codigo"</p>
                            <p>Codigo do Cliente : <input name="codCli" type="text" id="codCli"</p>
                            <p>Codigo do Quarto : <input name="codQuarto" type="text" id="codQuarto"</p>                        
                            <p>Data Check in : <input name="checkin" type="text" id="checkin"</p>                        
                            <p>Data Check out : <input name="checkout" type="text" id="checkout"</p>                        
                            <p>Quantidade de Pessoas : <input name="qtdePessoa" type="text" id="qtdePessoa"</p>                        
                            <p><input type="submit" value="Enviar"></p>
                        </form>
                    </div>                
                    <%@include file="../config/footer.jsp" %>
                    </body>
                    </html>