package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("  <head>\r\n");
      out.write("    <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\" />\r\n");
      out.write("    <title>Access page</title>\r\n");
      out.write("    <link\r\n");
      out.write("      rel=\"stylesheet\"\r\n");
      out.write("      href=\"https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css\"\r\n");
      out.write("      integrity=\"sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2\"\r\n");
      out.write("      crossorigin=\"anonymous\"\r\n");
      out.write("      />\r\n");
      out.write("  </head>\r\n");
      out.write("  <body>\r\n");
      out.write("    <div class=\"container mt-4 col-lg-4\">\r\n");
      out.write("      <div class=\"card col-sm-10\">\r\n");
      out.write("        <div class=\"card-body\">\r\n");
      out.write("          <form class=\"form-sign\" action=\"Validar\" method=\"POST\">\r\n");
      out.write("            <div class=\"form-group text-center\">\r\n");
      out.write("              <h3>Login</h3>\r\n");
      out.write("              <img src=\"img/logo-ventas.png\" width=\"130\" /><br />\r\n");
      out.write("              <label>Bienvenidos al sistema</label>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"form-group\">\r\n");
      out.write("              <label>Usuario</label>\r\n");
      out.write("              <input type=\"text\" name=\"txtUser\" class=\"form-control\" />\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"form-group\">\r\n");
      out.write("              <label>Contraseña</label>\r\n");
      out.write("              <input type=\"password\" name=\"txtPass\" class=\"form-control\" />\r\n");
      out.write("            </div>\r\n");
      out.write("            <input\r\n");
      out.write("              type=\"submit\"\r\n");
      out.write("              name=\"action\"\r\n");
      out.write("              value=\"Ingresar\"\r\n");
      out.write("              class=\"btn btn-primary btn-block\"\r\n");
      out.write("              />\r\n");
      out.write("          </form>\r\n");
      out.write("        </div>\r\n");
      out.write("      </div>\r\n");
      out.write("    </div>\r\n");
      out.write("    <script\r\n");
      out.write("      src=\"https://code.jquery.com/jquery-3.5.1.slim.min.js\"\r\n");
      out.write("      integrity=\"sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj\"\r\n");
      out.write("      crossorigin=\"anonymous\"\r\n");
      out.write("    ></script>\r\n");
      out.write("    <script\r\n");
      out.write("      src=\"https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js\"\r\n");
      out.write("      integrity=\"sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN\"\r\n");
      out.write("      crossorigin=\"anonymous\"\r\n");
      out.write("    ></script>\r\n");
      out.write("    <script\r\n");
      out.write("      src=\"https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.min.js\"\r\n");
      out.write("      integrity=\"sha384-w1Q4orYjBQndcko6MimVbzY0tgp4pWB4lZ7lr30WKz0vr/aWKhXdBNmNb5D92v7s\"\r\n");
      out.write("      crossorigin=\"anonymous\"\r\n");
      out.write("    ></script>\r\n");
      out.write("  </body>\r\n");
      out.write("</html>\r\n");
      out.write("\r\n");
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
