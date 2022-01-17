<%-- 
    Document   : dashboard
    Author     : Tahiri
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <!-- Head -->
        <%@ include file="./template/partials/head_1.jsp" %>
    <!-- End Head -->
    <body class="header-fixed">
        <!-- Header -->
            <%@ include file="./template/partials/header_1.jsp" %>
        <!-- End Header -->
        <div class="page-body">
            <!-- Sidebar-->
                <%@ include file="./template/partials/sidebar_1.jsp" %>
            <!-- End Sidebar -->
            <div class="page-content-wrapper">
                <div class="page-content-wrapper-inner">
                    <div class="content-viewport">
                        <div class="row">
                            <h1><%=session.getAttribute("username") %></h1>
                            <h1><%=session.getAttribute("email") %></h1>
                            <h1><%=session.getAttribute("nomParking") %></h1>
                            <h1><%=session.getAttribute("addressParking") %></h1>
                            <h1><%=session.getAttribute("idParking") %></h1>
                            
                            <p><a href="logout.jsp">logout</a></p>
                        </div>
                    </div>
                </div>
        <!-- content viewport ends -->
            <!-- Footer -->
                <%@ include file="./template/partials/footer_1.jsp" %> 
            <!-- End Footer -->
        </div>
        <!-- page content ends -->
    </div>
    <!-- Script -->
        <%@ include file="./template/partials/script_1.jsp" %>
    <!-- End Script -->  
  </body>
</html>
