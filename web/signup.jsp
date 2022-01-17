<%-- 
    Document   : signup
    Created on : Jan 2, 2022, 4:02:45 PM
    Author     : pc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <%@include file="./template/partials/head_1.jsp" %>
        <script src="script/signup.js" type="text/javascript"></script>
    </head>
    <body>
        <div class="authentication-theme auth-style_1">
            <div class="row">
                <div class="col-12 logo-section">
                    <a class="logo">
                        <img src="./assets/images/logo.svg" alt="logo" />
                    </a>
                </div>
            </div>
            <div class="row">
                <div class="col-lg-5 col-md-7 col-sm-9 col-11 mx-auto">
                    <div class="grid">
                        <div class="grid-body">
                            <div class="row">
                                <div class="col-lg-7 col-md-8 col-sm-9 col-12 mx-auto form-wrapper">
                                    <form action="#" id="frm-login">
                                        <div class="text-center" id="err" style="color:red">
                                        
                                        </div>
                                        <div class="form-group input-rounded">
                                            <input type="text" id="username" class="form-control" placeholder="Username" />
                                        </div>
                                        <div class="form-group input-rounded">
                                            <input type="email" id="email" class="form-control" placeholder="Email" />
                                        </div>
                                        <div class="form-group input-rounded">
                                            <input type="text" id="parking" class="form-control" placeholder="Parking Name" />
                                        </div>
                                        <div class="form-group input-rounded">
                                            <input type="text" id="parkingAdd" class="form-control" placeholder="Parking Address" />
                                        </div>
                                        <div class="form-group input-rounded">
                                            <input type="password" id="password" class="form-control" placeholder="Password" />
                                        </div>
                                        <div class="form-group input-rounded">
                                            <input type="password" id="password1" class="form-control" placeholder="Password Confirmed" />
                                        </div>
                                        <button type="submit" id="signup" class="btn btn-primary btn-block"> Signup </button>
                                    </form>
                                    <div class="signup-link">
                                        <p>if you have an account ?</p>
                                        <a href="login.jsp">Login</a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="auth_footer">
                <p class="text-muted text-center">© Tahiri 2022</p>
            </div>
        </div>
        <%@include file="./template/partials/script_1.jsp" %>
    </body>
</html>