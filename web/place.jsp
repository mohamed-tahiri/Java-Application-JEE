<%-- 
    Document   : place
    Author     : Tahiri
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <!-- Head -->
    <head>
        <%@ include file="template/partials/head_1.jsp" %>
        <script src="script/place.js" type="text/javascript"></script>
        
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
                                    <p class="grid-header">Les Informations des places</p>
                                    <div class="grid-body">
                                        <div class="item-wrapper">
                                            <div class="row">
                                                <div class="col-md-10 mx-auto">
                                                    <div class="row showcase_row_area">
                                                        <div class="col-md-9"></div>
                                                        <div class="col-md-3 showcase_content_area">
                                                            <select name="state" id="maxRows" class="custom-select" style="width: 150px;">
                                                                <option value="5000000000">Afficher Tous</option>
                                                                <option value="5">5</option>
                                                                <option value="10">10</option>
                                                                <option value="15">15</option>
                                                                <option value="20">20</option>
                                                                <option value="50">50</option>
                                                                <option value="75">75</option>
                                                                <option value="100">100</option>
                                                            </select>
                                                        </div>
                                                    </div>

                                                    <div class="table-responsive">
                                                        <table id="mytable" class="table table-hover">
                                                            <thead>
                                                                <tr>
                                                                    <th>ID</th>
                                                                    <th>Referance</th>
                                                                    <th>Etat</th>
                                                                    <th>Section</th>
                                                                    <th>Etage</th>
                                                                </tr>
                                                            </thead>
                                                            <tbody id="content">

                                                            </tbody>
                                                        </table>
                                                        <div class="pagination-container">
                                                            <nav>
                                                                <ul class="pagination">
                                                                </ul>
                                                            </nav>
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
    <script>
        var table = '#mytable';
        $('#maxRows').on('change', function () {
            $('.pagination').html('');
            var trnum = 0;
            var maxRows = parseInt($(this).val());
            var totalRows = $(table + ' tbody tr').length;
            $(table + ' tr:gt(0)').each(function () {
                trnum++;
                if (trnum > maxRows) {
                    $(this).hide();
                }
                if (trnum <= maxRows) {
                    $(this).show();
                }
            });
            if (totalRows > maxRows) {
                var pagenum = Math.ceil(totalRows / maxRows);
                for (var i = 1; i <= pagenum; ) {
                    $('.pagination').append('<li class="page-item" data-page="' + i + '">\<span class="page-link">' + i++ + '<span class="sr-only">(current)</span>\n\
                    </span>\</li>').show();
                }
            }
            $('.pagination li:first-child').addClass('active');
            $('.pagination li').on('click', function () {
                var pageNum = $(this).attr('data-page');
                var trIndex = 0;

                $('.pagination li').removeClass('active');
                $(this).addClass('active');
                $(table + ' tr:gt(0)').each(function () {
                    trIndex++;
                    if (trIndex > (maxRows * pageNum) || trIndex <= ((maxRows * pageNum) - maxRows)) {
                        $(this).hide();
                    } else {
                        $(this).show();
                    }
                });
            });

        });

    </script>
</html>

