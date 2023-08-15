package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class Envio_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css\" integrity=\"sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2\" crossorigin=\"anonymous\">\n");
      out.write("        ");
      out.write("\n");
      out.write("        <title>Vista Envío</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("\n");
      out.write("    <nav class=\"navbar navbar-expand-lg bg-dark\">\n");
      out.write("        <div class=\"container-fluid\">\n");
      out.write("            <a class=\"navbar-brand\" href=\"#\">\n");
      out.write("                <img src=\"https://img.icons8.com/nolan/48/warning-shield.png\" width=\"30\" class=\"logo\"/>\n");
      out.write("            </a>\n");
      out.write("            <button class=\"navbar-toggler\" type=\"button\" data-toggle=\"collapse\" data-target=\"#navbarNavAltMarkup\" aria-controls=\"navbarNavAltMarkup\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">\n");
      out.write("                <span class=\"navbar-toggler-icon\"></span>\n");
      out.write("            </button>\n");
      out.write("            <div class=\"collapse navbar-collapse\" id=\"navbarNavAltMarkup\">\n");
      out.write("                <div class=\"navbar-nav ml-auto\">\n");
      out.write("                    <a class=\"nav-link active\" aria-current=\"page\" href=\"#\">Inicio</a>\n");
      out.write("                    <a class=\"nav-link\" href=\"#\">Sobre Nosotros</a>\n");
      out.write("                    <a class=\"nav-link\" href=\"#\">Meet</a>\n");
      out.write("                    <a class=\"nav-link\" href=\"#\">Settings</a>\n");
      out.write("                    <div class=\"dropdown\">\n");
      out.write("                        <button style=\"border: none\" class=\"btn btn-outline-light dropdown-toggle\" type=\"button\" id=\"dropdownMenuButton\" data-toggle=\"dropdown\" aria-haspopup=\"true\" aria-expanded=\"false\">\n");
      out.write("                            ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${usuario.getNombresEmpleado()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\n");
      out.write("                        </button>\n");
      out.write("                        <div class=\"dropdown-menu text-center\" aria-labellebdy=\"dropdownMenuButton\">\n");
      out.write("                            <a class=\"dropdown-item\" href=\"#\">\n");
      out.write("                                <img src=\"img/UsuarioImagen.png\" alt=\"60\" width=\"60\"/>\n");
      out.write("                            </a>\n");
      out.write("                            <a class=\"dropdown-item\" href=\"#\" >");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${usuario.getUsuario()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</a>\n");
      out.write("                            <a class=\"dropdown-item\" href=\"#\" >");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${usuario.getUsuario()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("@gmail.com</a>\n");
      out.write("                            <div class=\"dropdown-divider\"></div>\n");
      out.write("                            <form action=\"Validar\" method=\"POST\">\n");
      out.write("                                <button name=\"accion\" name=\"Salir\" class=\"dropdown-item\" href=\"#\">Salir</button>\n");
      out.write("                            </form>\n");
      out.write("                        </div>             \n");
      out.write("                    </div>\n");
      out.write("\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </nav>\n");
      out.write("\n");
      out.write("            <div class=\"card-body\">\n");
      out.write("                ");
      out.write("\n");
      out.write("                <h1 class=\"form-group text-center\">Envío</h1>\n");
      out.write("                <form>\n");
      out.write("                    ");
      out.write("\n");
      out.write("                    <div class=\"form-group\">\n");
      out.write("                    ");
      out.write("\n");
      out.write("                        <label>ID Envío:</label>\n");
      out.write("                        <input type=\"text\" value=\"\" name=\"\" class=\"form-control\">\n");
      out.write("                    </div>\n");
      out.write("                    ");
      out.write("\n");
      out.write("                    <div class=\"form-group\">\n");
      out.write("                        <label>Direccion del Envio:</label>\n");
      out.write("                        <input type=\"text\" value=\"\" name=\"\" class=\"form-control\">\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"form-group\">\n");
      out.write("                        <label>Teléfono Contacto:</label>\n");
      out.write("                        <input type=\"text\" value=\"\" name=\"\" class=\"form-control\">\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"form-group\">\n");
      out.write("                        <label>ID Empleado:</label>\n");
      out.write("                        <input type=\"text\" value=\"\" name=\"\" class=\"form-control\">\n");
      out.write("                    </div>\n");
      out.write("                    <div>\n");
      out.write("                    <input type=\"submit\" name=\"accion\" value=\"Agregar\" class=\"btn\" style=\"background-color: #1E56A0;\">\n");
      out.write("                    <input type=\"submit\" name=\"accion\" value=\"Actualizar\" class=\"btn btn-success\">\n");
      out.write("                    <input type=\"submit\" name=\"accion\" value=\"Ver Tabla\" class=\"btn btn-success\">\n");
      out.write("                    </div>\n");
      out.write("                </form>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("        <script src=\"https://code.jquery.com/jquery-3.5.1.slim.min.js\" integrity=\"sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj\" crossorigin=\"anonymous\"></script>\n");
      out.write("        <script src=\"https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js\" integrity=\"sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN\" crossorigin=\"anonymous\"></script>\n");
      out.write("        <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.min.js\" integrity=\"sha384-w1Q4orYjBQndcko6MimVbzY0tgp4pWB4lZ7lr30WKz0vr/aWKhXdBNmNb5D92v7s\" crossorigin=\"anonymous\"></script>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
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
