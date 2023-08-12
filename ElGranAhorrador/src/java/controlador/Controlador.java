/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Envio;
import modelo.EnvioDAO;
import modelo.Inventario;
import modelo.InventarioDAO;
import modelo.MetodoPago;
import modelo.MetodoPagoDAO;

/**
 *
 * @author user
 */
public class Controlador extends HttpServlet {
    /* Agreguen sus instancias*/
    Inventario inventario = new Inventario();
    InventarioDAO inventarioDao = new InventarioDAO();
    int idInventario;
    MetodoPago metodopago = new MetodoPago();
    MetodoPagoDAO metodopagoDao = new MetodoPagoDAO();
    int idMetodoPago;
    Envio envio = new Envio();
    EnvioDAO envioDao = new EnvioDAO(); 
    int idEnvio;
  /**
   * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
   * methods.
   *
   * @param request servlet request
   * @param response servlet response
   * @throws ServletException if a servlet-specific error occurs
   * @throws IOException if an I/O error occurs
   */
  protected void processRequest(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    /*Donde termine el else if agreguen otro y cambian el menu.equals("Aqui ponen su entidad") 
      luego*/
        String menu = request.getParameter("menu");
        String accion = request.getParameter("accion");
        if (menu.equals("Principal")) {
            request.getRequestDispatcher("Principal.jsp").forward(request, response);
        }else if(menu.equals("Envio")){
      switch(accion){
        case "Listar":
            /*Sustituir listaEnvios = envioDao.listarEnvio()  conforme su entidad*/
          List listaEnvios = envioDao.listarEnvio();
          /*Sustituir con sus entidades request.setAttribute("envios", listaEnvios); 
          Se fijan bien los nombres que estan usando porque esos son los que se 
          utilizan en la tabla*/
          request.setAttribute("envios", listaEnvios);
          break;
          
        case "Agregar":
          
          break;
          
        case "Editar":
          
          break;
          
        case "Actualizar":
          
          break;
          
        case "Eliminar":
          
          break;
          
      }
      /*Sustitur con su archivo jsp osea su vista*/
      request.getRequestDispatcher("Envio.jsp").forward(request, response);
    }else if(menu.equals("Inventario")){
        switch(accion){
            case "Listar":
                List listaInventarios = inventarioDao.listarInventario();
                request.setAttribute("inventarios", listaInventarios);
            break;
        case "Agregar":
          
          break;
          
        case "Editar":
          
          break;
          
        case "Actualizar":
          
          break;
          
        case "Eliminar":
          
          break;
        }
        request.getRequestDispatcher("Inventario.jsp").forward(request, response);
    }else if(menu.equals("MetodoPago")){
        switch(accion){
            case "Listar":
                List listaMetodoPagos = metodopagoDao.listarMetodoPago();
                request.setAttribute("metodopagos", listaMetodoPagos);
            break;
            case "Agregar":
          
            break;
          
            case "Editar":
          
            break;
          
            case "Actualizar":
          
            break;
          
            case "Eliminar":
          
            break;
        }
        request.getRequestDispatcher("MetodoPago.jsp").forward(request, response);
    }
  }

  // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
  /**
   * Handles the HTTP <code>GET</code> method.
   *
   * @param request servlet request
   * @param response servlet response
   * @throws ServletException if a servlet-specific error occurs
   * @throws IOException if an I/O error occurs
   */
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    processRequest(request, response);
  }

  /**
   * Handles the HTTP <code>POST</code> method.
   *
   * @param request servlet request
   * @param response servlet response
   * @throws ServletException if a servlet-specific error occurs
   * @throws IOException if an I/O error occurs
   */
  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    processRequest(request, response);
  }

  /**
   * Returns a short description of the servlet.
   *
   * @return a String containing servlet description
   */
  @Override
  public String getServletInfo() {
    return "Short description";
  }// </editor-fold>

}
