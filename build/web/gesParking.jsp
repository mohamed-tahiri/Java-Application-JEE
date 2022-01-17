<%-- 
    Document   : gesParking
    Author     : Tahiri
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <!-- Head -->
    <head>
        <%@ include file="template/partials/head_1.jsp" %>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        <script src="script/gestion.js" type="text/javascript"></script>

    </head>
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
                            <div class="col-lg-12">
                                <div class="grid">
                                    <p class="grid-header">Gerer Votre Parking</p>
                                    <div class="grid-body">
                                        <div class="item-wrapper">
                                            <div class="row">
                                                <div class="col-md-10 mx-auto">

                                                    <div>
                                                        <p class="grid-header">Etages </p>
                                                    </div>
                                                    <div class="row showcase_row_area mb-3">
                                                        <div class="col-md-8">
                                                            <select class="form-select" aria-label="Default select example" id="contentEtage">

                                                            </select>
                                                        </div>
                                                        <div class="col-md-1"></div>
                                                        <div class="col-md-3"> 
                                                            <button id="sectionLibre" class="btn btn-primary has-icon btn-rounded" type="submit">
                                                                <i class="mdi mdi-autorenew"></i>Section Libre
                                                            </button>
                                                        </div>
                                                    </div>

                                                    <div id="section_">
                                                        <div>
                                                            <p class="grid-header">Sections </p>
                                                        </div>
                                                        <div class="row showcase_row_area mb-3">
                                                            <div class="col-md-8">
                                                                <select class="form-select" aria-label="Default select example" id="contentSection">

                                                                </select>  
                                                            </div>
                                                            <div class="col-md-1"></div>
                                                            <div class="col-md-3"> 
                                                                <button id="placeLibre" class="btn btn-primary has-icon btn-rounded" type="submit">
                                                                    <i class="mdi mdi-autorenew"></i>Place Libre
                                                                </button>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    
                                                    <div id="place_">
                                                        <div>
                                                            <p class="grid-header">Places </p>
                                                        </div>
                                                        <div class="row showcase_row_area mb-3">
                                                            <div class="col-md-8">
                                                                <select class="form-select" aria-label="Default select example" id="contentPlace">

                                                                </select>  
                                                            </div>
                                                            <div class="col-md-1"></div>
                                                            <div class="col-md-3"> 
                                                                <button id="placechoisi" class="btn btn-primary has-icon btn-rounded" type="submit">
                                                                    <i class="mdi mdi-autorenew"></i>Choisi
                                                                </button>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
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

