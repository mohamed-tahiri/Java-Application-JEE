package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("  <head>\n");
      out.write("    <meta charset=\"utf-8\" />\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">\n");
      out.write("    <title>Label - Premium Responsive Bootstrap 4 Admin & Dashboard Template</title>\n");
      out.write("    <!-- plugins:css -->\n");
      out.write("    <link rel=\"stylesheet\" href=\"../../../assets/vendors/iconfonts/mdi/css/materialdesignicons.css\" />\n");
      out.write("    <link rel=\"stylesheet\" href=\"../../../assets/vendors/css/vendor.addons.css\" />\n");
      out.write("    <!-- endinject -->\n");
      out.write("    <!-- vendor css for this page -->\n");
      out.write("    <!-- End vendor css for this page -->\n");
      out.write("    <!-- inject:css -->\n");
      out.write("    <link rel=\"stylesheet\" href=\"../../../assets/css/shared/style.css\" />\n");
      out.write("    <!-- endinject -->\n");
      out.write("    <!-- Layout style -->\n");
      out.write("    <link rel=\"stylesheet\" href=\"../../../assets/css/demo_1/style.css\">\n");
      out.write("    <!-- Layout style -->\n");
      out.write("    <link rel=\"shortcut icon\" href=\"../../../assets/images/favicon.ico\" />\n");
      out.write("  </head>\n");
      out.write("  <body>\n");
      out.write("    <div class=\"authentication-theme auth-style_1\">\n");
      out.write("      <div class=\"row\">\n");
      out.write("        <div class=\"col-12 logo-section\">\n");
      out.write("          <a href=\"../../index.html\" class=\"logo\">\n");
      out.write("            <img src=\"../../../assets/images/logo.svg\" alt=\"logo\" />\n");
      out.write("          </a>\n");
      out.write("        </div>\n");
      out.write("      </div>\n");
      out.write("      <div class=\"row\">\n");
      out.write("        <div class=\"col-lg-5 col-md-7 col-sm-9 col-11 mx-auto\">\n");
      out.write("          <div class=\"grid\">\n");
      out.write("            <div class=\"grid-body\">\n");
      out.write("              <div class=\"row\">\n");
      out.write("                <div class=\"col-lg-7 col-md-8 col-sm-9 col-12 mx-auto form-wrapper\">\n");
      out.write("                  <form action=\"#\">\n");
      out.write("                    <div class=\"form-group input-rounded\">\n");
      out.write("                      <input type=\"text\" class=\"form-control\" placeholder=\"Username\" />\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"form-group input-rounded\">\n");
      out.write("                      <input type=\"password\" class=\"form-control\" placeholder=\"Password\" />\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"form-inline\">\n");
      out.write("                      <div class=\"checkbox\">\n");
      out.write("                        <label>\n");
      out.write("                          <input type=\"checkbox\" class=\"form-check-input\" />Remember me <i class=\"input-frame\"></i>\n");
      out.write("                        </label>\n");
      out.write("                      </div>\n");
      out.write("                    </div>\n");
      out.write("                    <button type=\"submit\" class=\"btn btn-primary btn-block\"> Login </button>\n");
      out.write("                  </form>\n");
      out.write("                  <div class=\"signup-link\">\n");
      out.write("                    <p>Don't have an account yet?</p>\n");
      out.write("                    <a href=\"#\">Sign Up</a>\n");
      out.write("                  </div>\n");
      out.write("                </div>\n");
      out.write("              </div>\n");
      out.write("            </div>\n");
      out.write("          </div>\n");
      out.write("        </div>\n");
      out.write("      </div>\n");
      out.write("      <div class=\"auth_footer\">\n");
      out.write("        <p class=\"text-muted text-center\">© Label Inc 2019</p>\n");
      out.write("      </div>\n");
      out.write("    </div>\n");
      out.write("    <!--page body ends -->\n");
      out.write("    <!-- SCRIPT LOADING START FORM HERE /////////////-->\n");
      out.write("    <!-- plugins:js -->\n");
      out.write("    <script src=\"../../../assets/vendors/js/core.js\"></script>\n");
      out.write("    <script src=\"../../../assets/vendors/js/vendor.addons.js\"></script>\n");
      out.write("    <!-- endinject -->\n");
      out.write("    <!-- Vendor Js For This Page Ends-->\n");
      out.write("    <!-- Vendor Js For This Page Ends-->\n");
      out.write("    <!-- build:js -->\n");
      out.write("    <script src=\"../../../assets/js/template.js\"></script>\n");
      out.write("    <!-- endbuild -->\n");
      out.write("  </body>\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
