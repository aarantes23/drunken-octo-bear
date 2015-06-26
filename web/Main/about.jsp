<%-- 
    Document   : about
    Created on : 21-Jun-2015, 16:42:42
    Author     : Arthur
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>  
<%@page import="Beans.User"%>
<%  
    // <jsp:include page="sessao.jsp" />
    request.getSession(false).setMaxInactiveInterval(3000);  
    int duracaoSessao = request.getSession(false).getMaxInactiveInterval();  
    long now = System.currentTimeMillis();  
    long ultimoAcesso = request.getSession(false).getLastAccessedTime();  
    User usuario = new User();  
    
    if (now - ultimoAcesso > duracaoSessao) { 
        usuario = new User();
        session.invalidate();
    //    out.println("sessão expirou");  
    } else {                      
                                      
        usuario = (User) request.getSession(true).getAttribute("login");       
    //    out.println("sessão válida");                                                  
    }  
%>

<!DOCTYPE HTML>
<html>
    <head>
        <title>Trip Hotel - About </title>
        <%@include file="../config/start_template.jsp" %>
    </head>
    <body>              
        <%@include file="../config/header_default.jsp" %>
        <%@include file="../config/body_config.jsp" %>
        <div class="about">
            <div class="container">
                <div class="about-main">
                    <div class="about-top">
                        <h3>About</h3>
                        <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.Duis aute irure dolor.</p>
                    </div>
                    <div class="about-bottom">
                        <div class="col-md-4 about-left">
                            <img src="../images/about/ab1.jpg" alt="" title="">
                        </div>
                        <div class="col-md-8 about-right">
                            <h4>On the other hand, we denounce with righteous indignation</h4>
                            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur There are many variations of passages of Lorem Ipsum available, but the majority have suffered alteration in some form, by injected humour, or randomised words which don't look even slightly believable.sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.Duis aute irure dolorNemo enim ipsam voluptatem quia voluptas sit aspernatur aut odit.</p>
                        </div>
                        <div class="clearfix"> </div>
                    </div>
                    <div class="our-team">
                        <h3>Our Team</h3>
                        <div class="col-md-3 team-grid">
                            <a href="../images/about/b-t1.jpg" class="b-link-stripe b-animate-go  swipebox"  title="Image Title">
                                <img src="../images/about/t1.jpg" /><div class="b-wrapper">
                                </div></a>
                            <div class="team-details">
                                <h4>McClintock</h4>
                                <p>Co-founder& CEO</p>
                            </div>
                        </div>
                        <div class="col-md-3 team-grid ma-more">
                            <a href="../images/about/b-t2.jpg" class="b-link-stripe b-animate-go  swipebox"  title="Image Title">
                                <img src="../images/about/t2.jpg" /><div class="b-wrapper">
                                </div></a>
                            <div class="team-details">
                                <h4>Malorum</h4>
                                <p>Co-founder</p>
                            </div>
                        </div>
                        <div class="col-md-3 team-grid">
                            <a href="../images/about/b-t3.jpg" class="b-link-stripe b-animate-go  swipebox"  title="Image Title">
                                <img src="../images/about/t3.jpg" /><div class="b-wrapper">
                                </div></a>
                            <div class="team-details">
                                <h4>Richard</h4>
                                <p>Head Of Sale</p>
                            </div>
                        </div>
                        <div class="col-md-3 team-grid mar-more">
                            <a href="../images/about/b-t4.jpg" class="b-link-stripe b-animate-go  swipebox"  title="Image Title">
                                <img src="../images/about/t4.jpg" /><div class="b-wrapper">
                                </div></a>
                            <div class="team-details">
                                <h4>Bonorum</h4>
                                <p>Operator</p>
                            </div>
                        </div>
                        <div class="clearfix"> </div>
                    </div>
                </div>
            </div>
        </div>
        <%@include file="../config/footer.jsp" %>        
    </body>
</html>
