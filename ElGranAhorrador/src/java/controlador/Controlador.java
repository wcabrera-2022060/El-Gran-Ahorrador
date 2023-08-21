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
import modelo.Afiliado;
import modelo.AfiliadoDAO;

import modelo.Cliente;
import modelo.ClienteDAO;
import modelo.Compra;
import modelo.CompraDAO;
import modelo.Cupon;
import modelo.CuponDAO;
import modelo.Empleado;
import modelo.EmpleadoDAO;
import modelo.Envio;
import modelo.EnvioDAO;
import modelo.Factura;
import modelo.FacturaDAO;
import modelo.Inventario;
import modelo.InventarioDAO;
import modelo.MetodoPago;
import modelo.MetodoPagoDAO;
import modelo.Producto;
import modelo.ProductoDAO;
import modelo.Proveedor;
import modelo.ProveedorDAO;
import modelo.Sucursal;
import modelo.SucursalDAO;
import modelo.TipoEmpleado;
import modelo.TipoEmpleadoDAO;
import modelo.TipoProducto;
import modelo.TipoProductoDAO;

/**
 *
 * @author user
 */
public class Controlador extends HttpServlet {

    Cliente cliente = new Cliente();
    ClienteDAO clienteDao = new ClienteDAO();
    int idCliente;
    Producto producto = new Producto();
    ProductoDAO productoDao = new ProductoDAO();
    int idProducto;
    Afiliado afiliado = new Afiliado();
    AfiliadoDAO afiliadoDao = new AfiliadoDAO();
    int idAfiliado;
    Factura factura = new Factura();
    FacturaDAO facturaDao = new FacturaDAO();
    int idFactura;
    Compra compra = new Compra();
    CompraDAO compraDao = new CompraDAO();
    int idCompra;
    MetodoPago metodoPago = new MetodoPago();
    MetodoPagoDAO metodoPagoDao = new MetodoPagoDAO();
    int idMetodoPago;
    Inventario inventario = new Inventario();
    InventarioDAO inventarioDao = new InventarioDAO();
    int idInventario;
    TipoEmpleado tipoEmpleado = new TipoEmpleado();
    TipoEmpleadoDAO tipoEmpleadoDao = new TipoEmpleadoDAO();
    int idTipoEmpleado;
    Envio envio = new Envio();
    EnvioDAO envioDao = new EnvioDAO();
    int idEnvio;
    Cupon cupon = new Cupon();
    CuponDAO cuponDao = new CuponDAO();
    int idCupon;
    Proveedor proveedor = new Proveedor();
    ProveedorDAO proveedorDao = new ProveedorDAO();
    int idProveedor;
    Sucursal sucursal = new Sucursal();
    SucursalDAO sucursalDao = new SucursalDAO();
    int idSucursal;
    Empleado empleado = new Empleado(); 
    EmpleadoDAO empleadoDao = new EmpleadoDAO();
    int idEmpleado;
    TipoProducto tipoProducto = new TipoProducto();
    TipoProductoDAO tipoProductoDao = new TipoProductoDAO();
    int idTipoProducto;
    
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
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
        } else if (menu.equals("Cliente")) {
            switch (accion) {
                case "Listar":
                    List listaClientes = clienteDao.listarCliente();
                    request.setAttribute("clientes", listaClientes);
                    List listaAfiliados = afiliadoDao.listarAfiliado();
                    request.setAttribute("afiliados", listaAfiliados);
                    break;
                case "Agregar":
                    String nombres = request.getParameter("txtNombreCliente");
                    String apellido = request.getParameter("txtApellidoCliente");
                    String telefono = request.getParameter("txtTelefonoCliente");
                    String direccion = request.getParameter("txtDireccionCliente");
                    int ilog = Integer.parseInt(request.getParameter("txtIdLogin"));
                    int IAf = Integer.parseInt(request.getParameter("txtIdAfiliado"));
                    
                    cliente.setNombreCliente(nombres);
                    cliente.setApellidoCliente(apellido);
                    cliente.setTelefonoCliente(telefono);
                    cliente.setDireccionCliente(direccion);
                    cliente.setIdLogin(ilog);
                    cliente.setIdAfiliado(IAf);
                    
                    clienteDao.agregar(cliente);
                    
                    request.getRequestDispatcher("Controlador?menu=Cliente&accion=Listar").forward(request, response);
                    break;
                case "Editar":
                    idCliente = Integer.parseInt(request.getParameter("idCliente"));
                    Cliente c = clienteDao.listarCodigoCliente(idCliente);
                    
                    request.setAttribute("clienteEncontrado", c);
                    
                    request.getRequestDispatcher("Controlador?menu=Cliente&accion=Listar").forward(request, response);
                    break;
                case "Actualizar":
                    idCliente = Integer.parseInt(request.getParameter("txtIdCliente"));
                    String nombresCli = request.getParameter("txtNombreCliente");
                    String apellidoCli = request.getParameter("txtApellidoCliente");                   
                    String telefonoCli = request.getParameter("txtTelefonoCliente");                    
                    String direccionCli = request.getParameter("txtDireccionCliente");
                    System.out.println("Se presiono botn actualizar");
                    cliente.setNombreCliente(nombresCli);
                    cliente.setApellidoCliente(apellidoCli);
                    cliente.setTelefonoCliente(telefonoCli);
                    cliente.setDireccionCliente(direccionCli);
                    
                    cliente.setIdCliente(idCliente);
                    
                    clienteDao.actualizar(cliente);
                    
                    request.getRequestDispatcher("Controlador?menu=Cliente&accion=Listar").forward(request, response);
                    break;
                case "Eliminar":
                    String confirmar = request.getParameter("Confirmar");
                    if ("Aceptar".equals(confirmar)) {
                        idCliente = Integer.parseInt(request.getParameter("idCliente"));
                        clienteDao.eliminar(idCliente);
                        request.getRequestDispatcher("Controlador?menu=Cliente&accion=Listar").forward(request, response);

                    } else if ("Cancelar".equals(confirmar)) {
                        request.getRequestDispatcher("Controlador?menu=Cliente&accion=Listar").forward(request, response);
                    }
                    break;
            }
            request.getRequestDispatcher("Cliente.jsp").forward(request, response);
        } else if (menu.equals("Producto")) {
            switch (accion) {
                case "Listar":
                    List listaProductos = productoDao.listarProductos();
                    request.setAttribute("productos", listaProductos);
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
            request.getRequestDispatcher("Producto.jsp").forward(request, response);
        
        } else if (menu.equals("Afiliado")) {

            switch (accion) {
                case "Listar":
                    List listaAfiliados = afiliadoDao.listarAfiliado();
                    request.setAttribute("afiliados", listaAfiliados);
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
            request.getRequestDispatcher("Afiliado.jsp").forward(request, response);
        } else if (menu.equals("Factura")) {
            switch (accion) {
                case "Listar":
                    List listaFacturas = facturaDao.listar();
                    request.setAttribute("facturas", listaFacturas);
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
            request.getRequestDispatcher("Factura.jsp").forward(request, response);
        } else if (menu.equals("Compra")) {
            switch (accion) {
                case "Listar":
                    List listaCompras = compraDao.listar();
                    request.setAttribute("compras", listaCompras);
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
            request.getRequestDispatcher("Compra.jsp").forward(request, response);
        } else if (menu.equals("MetodoPago")) {
            switch (accion) {
                case "Listar":
                    List listaMetodoPagos = metodoPagoDao.listarMetodoPago();
                    request.setAttribute("metodoPagos", listaMetodoPagos);
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
        } else if (menu.equals("Inventario")) {
            switch (accion) {
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
        } else if (menu.equals("TipoEmpleado")) {
            switch (accion) {
                case "Listar":
                    List listaTipoEmpleados = tipoEmpleadoDao.listar();
                    request.setAttribute("tipoEmpleados", listaTipoEmpleados);
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
            request.getRequestDispatcher("TipoEmpleado.jsp").forward(request, response);
        } else if (menu.equals("Envio")) {
            switch (accion) {
                case "Listar":

                    List listaEnvios = envioDao.listarEnvio();
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
            request.getRequestDispatcher("Envio.jsp").forward(request, response);
        }else if (menu.equals("Cupon")) {
            switch (accion) {
                case "Listar":
                    List listaCupones = cuponDao.listaCupones();
                    request.setAttribute("cupones", listaCupones);
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
            request.getRequestDispatcher("Cupon.jsp").forward(request, response);
        }else if (menu.equals("Proveedor")) {
            switch (accion) {
                case "Listar":
                    List listaProveedores = proveedorDao.listaProveedores();
                    request.setAttribute("proveedores", listaProveedores);
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
            request.getRequestDispatcher("Proveedor.jsp").forward(request, response);
        }else if (menu.equals("Sucursal")) {
            switch (accion) {
                case "Listar":
                    List listaSucursales = sucursalDao.listar();
                    request.setAttribute("sucursales", listaSucursales);
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
            request.getRequestDispatcher("Sucursal.jsp").forward(request, response);
        }else if (menu.equals("Empleado")) {
            switch (accion) {
                case "Listar":
                    List listaEmpleados = empleadoDao.listarEmpleados();
                    request.setAttribute("empleados", listaEmpleados);
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
            request.getRequestDispatcher("Empleado.jsp").forward(request, response);
        }else if (menu.equals("TipoProducto")) {
            switch (accion) {
                case "Listar":
                    List listaTipoProductos = tipoProductoDao.listarTipoProducto();
                    request.setAttribute("tipoProductos", listaTipoProductos);
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
            request.getRequestDispatcher("TipoProducto.jsp").forward(request, response);
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
