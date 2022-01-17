<%-- 
    Document   : login
    Author     : Tahiri
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <%@include file="./template/partials/head_1.jsp" %>
        <script src="script/login.js" type="text/javascript"></script>
    </head>
    <body>
        <div class="authentication-theme auth-style_1">
            <div class="row">
                <div class="col-12 logo-section">
                    <a href="../../index.html" class="logo">
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
                                            <input type="password" id="password" class="form-control" placeholder="Password" />
                                        </div>
                                        <button type="submit" id="login" class="btn btn-primary btn-block"> Login </button>
                                    </form>
                                    <div class="signup-link">
                                        <p>Don't have an account yet?</p>
                                        <a href="signup.jsp">Sign Up</a>
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