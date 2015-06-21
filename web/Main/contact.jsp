<%-- 
    Document   : contact
    Created on : 21-Jun-2015, 16:44:47
    Author     : Arthur
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
    <head>
        <title>Trip Hotel - Contact </title>
        <%@include file="../config/start_template.jsp" %>
    </head>
    <body>
        <%@include file="../config/header_default.jsp" %>
        <div class="message">
            <div class="container">
                <div class="message-main">
                    <div class="message-bottom">
                        <div class="col-md-6 message-left">
                            <div class="con-info">
                                <h3>Information of contact</h3>
                                <p>But I must explain to you how all this mistaken idea of denouncing pleasure and praising pain was born and I will give you a complete account of the system, and expound the actual teachings of the great explorer of the truth, the master-builder of human happiness.</p>
                            </div>
                            <div class= "con-addr">
                                <h4>Address</h4>
                                <p>Address: Richard McClintock</p>
                                <p>New Street: Letraset sheets </p>
                                <p>mail : <a href="mailto:infoexample@email.com">info@travel.com </a></p>
                                <p>ph : +5289 568 407</p>
                            </div>
                        </div>
                        <div class="col-md-6 message-right">
                            <form>
                                <input type="text" value="Name" onfocus="this.value = '';" onblur="if (this.value == '') {
                                            this.value = 'Name';
                                        }"/>
                                <input type="text" class="mar-last" value="Email" onfocus="this.value = '';" onblur="if (this.value == '') {
                                            this.value = 'Email';
                                        }"/>
                                <textarea onfocus="this.value = '';" onblur="if (this.value == '') {
                                            this.value = 'Message';
                                        }"/>Message</textarea>
                                <input type="submit" value="Send"/>
                            </form>
                        </div>
                        <div class="clearfix"> </div>
                    </div>
                    <div class="map">
                        <iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d243647.25176871577!2d78.40804555!3d17.4123487!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x3bcb99daeaebd2c7%3A0xae93b78392bafbc2!2sHyderabad%2C+Telangana!5e0!3m2!1sen!2sin!4v1431417526242"> </iframe>
                    </div>
                    <div class="clearfix"> </div>
                </div>
            </div>
        </div>
        <%@include file="../config/footer.jsp" %>
    </body>
</html>