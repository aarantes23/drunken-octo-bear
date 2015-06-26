<%-- 
    Document   : index_default
    Created on : 21-Jun-2015, 16:44:58
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
        <title>Trip Hotel </title>
        <%@include file="../config/start_template.jsp" %>
        <!--pop-up-box-->
        <script type="text/javascript" src="../js/modernizr.custom.53451.js"></script>  
        <link href="../css/popup-box.css" rel="stylesheet" type="text/css" media="all">
        <script src="../js/jquery.magnific-popup.js" type="text/javascript"></script>
        <!--pop-up-box-->
    </head>
    <body>
        <%@include file="../config/header_default.jsp" %>
        <!--banner start here-->
        <script src="../js/responsiveslides.min.js"></script>
        <script>
            $(function () {
                $("#slider").responsiveSlides({
                    auto: true,
                    speed: 500,
                    namespace: "callbacks",
                    pager: true,
                });
            });
        </script>
        <div class="slider">
            <div class="callbacks_container">
                <ul class="rslides" id="slider">
                    <li>
                        <div class="banner">
                            <div class="caption">
                                <h3>Welcome, Bienvenido, Bem vindo</h3>
                                <span class="head-line"> </span>
                                <div class="video-play-bwn">
                                    <a href="#small-dialog5" class="thickbox play-icon popup-with-zoom-anim"><span class="roundplay-bwn"> </span></a>
                                </div>

                            </div>
                        </div>
                    </li>
                    <li>
                        <div class="banner1">
                            <div class="caption">
                                <h3>Bitte, Vous Accueillez, Welkom</h3>
                                <span class="head-line"> </span>
                                <div class="video-play-bwn">
                                    <a href="#small-dialog5" class="thickbox play-icon popup-with-zoom-anim"><span class="roundplay-bwn"> </span></a>
                                </div>

                            </div>
                        </div>
                    </li>
                    <li>
                        <div class="banner2">
                            <div class="caption">
                                <h3>Mark Hodding,sydney trip</h3>
                                <span class="head-line"> </span>
                                <div class="video-play-bwn">
                                    <a href="#small-dialog5" class="thickbox play-icon popup-with-zoom-anim"><span class="roundplay-bwn"> </span></a>
                                </div>

                            </div>
                        </div>
                    </li>
                </ul>
            </div>
        </div>
        <!--banner end here-->
        <div id="small-dialog5" class="mfp-hide">
            <iframe src="//player.vimeo.com/video/111679725" width="500" height="213" frameborder="0" webkitallowfullscreen mozallowfullscreen allowfullscreen></iframe>
        </div>
        <script>
            $(document).ready(function () {
                $('.popup-with-zoom-anim').magnificPopup({
                    type: 'inline',
                    fixedContentPos: false,
                    fixedBgPos: true,
                    overflowY: 'auto',
                    closeBtnInside: true,
                    preloader: false,
                    midClick: true,
                    removalDelay: 300,
                    mainClass: 'my-mfp-zoom-in'
                });

            });
        </script>        
        <%@include file="../config/body_config.jsp" %>
        <div class="portfolio">
            <div class="portfolio-main">
                <div class="portfolio-bottom">
                    <div class="port-nav-left">
                        <h6>Portfolio</h6>
                        <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.Duis aute irure dolor.</p>
                    </div>
                    <div id="portfoliolist">
                        <div class="col-md-3 pa-more">
                            <a href="#small-dialog5" class="thickbox play-icon popup-with-zoom-anim">
                                <div class="work-column">
                                    <img src="../images/main/room_1.jpg" alt="" class="img-cap img-responsive">
                                    <div class="porthover">
                                        <h3>Simple room for 2</br>U$ 49.99/day</h3>
                                        <span class="hover-line"> </span>                                        
                                        <div class="porthover-grids">
                                            <div class="clearfix"> </div>
                                        </div>
                                        <div class="clearfix"> </div>
                                    </div>
                                </div>
                            </a>

                            <div id="small-dialog" class="mfp-hide">
                                <div class="image-top">
                                    <div class="video-play-bwn">
                                        <a href="#small-dialog5" class="thickbox play-icon popup-with-zoom-anim"> </a>
                                    </div>

                                </div>
                            </div>
                        </div>				
                        <div class="col-md-3 pa-more">
                            <a href="#small-dialog5" class="thickbox play-icon popup-with-zoom-anim">
                                <div class="work-column">
                                    <img src="../images/main/room_2.jpg" alt="" class="img-cap img-responsive">
                                    <div class="porthover">
                                        <h3>Simple room for family </br>U$ 79.99/day</h3>
                                        <span class="hover-line"> </span>
                                        <div class="porthover-grids">
                                            <div class="clearfix"> </div>
                                        </div>
                                        <div class="clearfix"> </div>
                                    </div>
                                </div>
                            </a>
                        </div>				
                        <div class="col-md-3 pa-more">
                            <a href="#small-dialog5" class="thickbox play-icon popup-with-zoom-anim">
                                <div class="work-column">
                                    <img src="../images/main/room_3.jpg" alt="" class="img-cap img-responsive">
                                    <div class="porthover">
                                        <h3>President room</br> U$199.99/day</h3>
                                        <span class="hover-line"> </span>
                                        <div class="porthover-grids">
                                            <div class="clearfix"> </div>
                                        </div>
                                        <div class="clearfix"> </div>
                                    </div>
                                </div>
                            </a>
                        </div>			
                        <div class="col-md-3 pa-more">
                            <a href="#small-dialog5" class="thickbox play-icon popup-with-zoom-anim">
                                <div class="work-column">
                                    <img src="../images/main/room_4.jpg" alt="" class="img-cap img-responsive">
                                    <div class="porthover">
                                        <h3>Classic room<br> U$99.99</h3>
                                        <span class="hover-line"> </span>                                        
                                        <div class="porthover-grids">
                                            <div class="clearfix"> </div>
                                        </div>
                                        <div class="clearfix"> </div>
                                    </div>
                                </div>
                            </a>
                        </div>			
                        <div class="clearfix"> </div>
                    </div>
                    <div id="portfoliolist">
                        <div class="col-md-3 pa-more">
                            <a href="#small-dialog5" class="thickbox play-icon popup-with-zoom-anim">
                                <div class="work-column">
                                    <img src="../images/main/loft_1.jpg" alt="" class="img-cap img-responsive">
                                    <div class="porthover">
                                        <h3>Hotel reception</h3>
                                        <span class="hover-line"> </span>                                       
                                        <div class="porthover-grids">
                                            <div class="clearfix"> </div>
                                        </div>
                                        <div class="clearfix"> </div>
                                    </div>
                                </div>
                            </a>
                        </div>				
                        <div class="col-md-3 pa-more">
                            <a href="#small-dialog5" class="thickbox play-icon popup-with-zoom-anim">
                                <div class="work-column">
                                    <img src="../images/main/loft_2.jpg" alt="" class="img-cap img-responsive">
                                    <div class="porthover">
                                        <h3>Hotel gym</h3>
                                        <span class="hover-line"> </span>                                        
                                        <div class="porthover-grids">                                        
                                            <div class="clearfix"> </div>
                                        </div>
                                        <div class="clearfix"> </div>
                                    </div>
                                </div>
                            </a>
                        </div>				
                        <div class="col-md-3 pa-more">
                            <a href="#small-dialog5" class="thickbox play-icon popup-with-zoom-anim">
                                <div class="work-column">
                                    <img src="../images/main/loft_3.jpg" alt="" class="img-cap img-responsive">
                                    <div class="porthover">
                                        <h3>Hotel dinner room</h3>
                                        <span class="hover-line"> </span>
                                        <div class="porthover-grids">                                            
                                            <div class="clearfix"> </div>
                                        </div>
                                        <div class="clearfix"> </div>
                                    </div>
                                </div>
                            </a>
                        </div>			
                        <div class="col-md-3 pa-more">
                            <a href="#small-dialog5" class="thickbox play-icon popup-with-zoom-anim">
                                <div class="work-column">
                                    <img src="../images/main/loft_4.jpg" alt="" class="img-cap img-responsive">
                                    <div class="porthover">
                                        <h3>Hotel pool 1</h3>
                                        <span class="hover-line"> </span>                                        
                                        <div class="porthover-grids">                                            
                                            <div class="clearfix"> </div>
                                        </div>
                                        <div class="clearfix"> </div>
                                    </div>
                                </div>
                            </a>
                        </div>			
                        <div class="clearfix"> </div>
                    </div>
                    <div id="portfoliolist">
                        <div class="col-md-3 pa-more">
                            <a href="#small-dialog5" class="thickbox play-icon popup-with-zoom-anim">
                                <div class="work-column">
                                    <img src="../images/main/hotel_1.jpg" alt="" class="img-cap img-responsive">
                                    <div class="porthover">
                                        <h3>Hotel reception 2</h3>
                                        <span class="hover-line"> </span>
                                        <div class="porthover-grids">                                            
                                            <div class="clearfix"> </div>
                                        </div>
                                        <div class="clearfix"> </div>
                                    </div>
                                </div>
                            </a>
                        </div>				
                        <div class="col-md-3 pa-more">
                            <a href="#small-dialog5" class="thickbox play-icon popup-with-zoom-anim">
                                <div class="work-column">
                                    <img src="../images/main/hotel_2.jpg" alt="" class="img-cap img-responsive">
                                    <div class="porthover">
                                        <h3>Hotel reception 3</h3>
                                        <span class="hover-line"> </span>
                                        <div class="porthover-grids">                                            
                                            <div class="clearfix"> </div>
                                        </div>
                                        <div class="clearfix"> </div>
                                    </div>
                                </div>
                            </a>
                        </div>				
                        <div class="col-md-3 pa-more">
                            <a href="#small-dialog5" class="thickbox play-icon popup-with-zoom-anim">
                                <div class="work-column">
                                    <img src="../images/main/hotel_3.jpg" alt="" class="img-cap img-responsive">
                                    <div class="porthover">
                                        <h3>Hotel pool 2</h3>
                                        <span class="hover-line"> </span>                                        
                                        <div class="porthover-grids">                                            
                                            <div class="clearfix"> </div>
                                        </div>
                                        <div class="clearfix"> </div>
                                    </div>
                                </div>
                            </a>
                        </div>			
                        <div class="col-md-3 pa-more">
                            <a href="#small-dialog5" class="thickbox play-icon popup-with-zoom-anim">
                                <div class="work-column">
                                    <img src="../images/main/hotel_4.jpg" alt="" class="img-cap img-responsive">
                                    <div class="porthover">
                                        <h3>Hotel private jacuzzi</h3>
                                        <span class="hover-line"> </span>                                        
                                        <div class="porthover-grids">                                            
                                            <div class="clearfix"> </div>
                                        </div>
                                        <div class="clearfix"> </div>
                                    </div>
                                </div>
                            </a>

                        </div>			
                        <div class="clearfix"> </div>
                    </div>
                </div>
            </div>
        </div>	
        <%@include file="../config/footer.jsp" %>
    </body>
</html>
