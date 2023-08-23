/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.IOException;
import java.sql.Date;
import java.sql.Time;
import java.text.ParseException;
import java.time.LocalDate;
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
          System.out.println("Entro");
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
          List listaTipoProductos = tipoProductoDao.listarTipoProducto();
          request.setAttribute("tipoProductos", listaTipoProductos);
          List listaInventarios = inventarioDao.listarInventario();
          request.setAttribute("inventarios", listaInventarios);
          break;
        case "Agregar":
          String nombreProducto = request.getParameter("txtNombreProducto");
          double precioProducto = Double.parseDouble(request.getParameter("txtPrecioProducto"));
          String marca = request.getParameter("txtMarcaProducto");
          Date fechaVencimiento = java.sql.Date.valueOf(request.getParameter("txtFechaVencimientoProducto"));
          int idTipoProductos = Integer.parseInt(request.getParameter("txtIdTipoProducto"));
          int idInventarios = Integer.parseInt(request.getParameter("txtIdInventario"));
          producto.setNombreProducto(nombreProducto);
          producto.setPrecioProducto(precioProducto);
          producto.setMarca(marca);
          producto.setFechaVencimiento(fechaVencimiento);
          producto.setIdTipoProducto(idTipoProductos);
          producto.setIdInventario(idInventarios);
          productoDao.agregar(producto);
          request.getRequestDispatcher("Controlador?menu=Producto&accion=Listar").forward(request, response);
          break;
        case "Editar":
          idProducto = Integer.parseInt(request.getParameter("idProducto"));
          Producto prod = productoDao.listaCodigoProducto(idProducto);
          request.setAttribute("productoEncontrado", prod);
          request.getRequestDispatcher("Controlador?menu=Producto&accion=Listar").forward(request, response);
          break;
        case "Actualizar":
          idProducto = Integer.parseInt(request.getParameter("txtIdProducto"));
          System.out.println("Ingresó");
          String nombreProductoNuevo = request.getParameter("txtNombreProducto");
          System.out.println("txtNombreProducto");
          double precioProductoNuevo = Double.parseDouble(request.getParameter("txtPrecioProducto"));
          System.out.println("txtPrecioProducto");
          String marcaNuevo = request.getParameter("txtMarcaProducto");
          System.out.println("txtMarcaProducto");
          Date fechaVencimientoNuevo = java.sql.Date.valueOf(request.getParameter("txtFechaVencimientoProducto"));
          System.out.println("txtFechaVencimientoProducto");
          System.out.println("los set");
          producto.setNombreProducto(nombreProductoNuevo);
          producto.setPrecioProducto(precioProductoNuevo);
          producto.setMarca(marcaNuevo);
          producto.setFechaVencimiento(fechaVencimientoNuevo);
          producto.setIdProducto(idProducto);
          productoDao.actualizar(producto);
          request.getRequestDispatcher("Controlador?menu=Producto&accion=Listar").forward(request, response);
          break;
        case "Eliminar":
          idProducto = Integer.parseInt(request.getParameter("idProducto"));
          productoDao.eliminar(idProducto);
          request.getRequestDispatcher("Controlador?menu=Producto&accion=Listar").forward(request, response);
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
          String txtRangoAfiliado = request.getParameter("txtRangoAfiliado");
          String txtBeneficios = request.getParameter("txtBeneficios");
          double txtPrecioRango = Double.parseDouble(request.getParameter("txtPrecioRango"));
          Date fecha = java.sql.Date.valueOf(request.getParameter("txtFechaExpiracion"));
          afiliado.setRangoAfiliado(txtRangoAfiliado);
          afiliado.setBeneficios(txtBeneficios);
          afiliado.setPrecioRango(txtPrecioRango);
          afiliado.setFechaExpiracion(fecha);

          afiliadoDao.agregarAfiliado(afiliado);

          request.getRequestDispatcher("Controlador?menu=Afiliado&accion=Listar").forward(request, response);

          break;
        case "Editar":

          idAfiliado = Integer.parseInt(request.getParameter("codigoAfiliado"));
          Afiliado afiliadoSeleccionado = afiliadoDao.buscarAfiliado(idAfiliado);
          request.setAttribute("afiliadoSeleccionado", afiliadoSeleccionado);
          request.getRequestDispatcher("Controlador?menu=Afiliado&accion=Listar").forward(request, response);
          break;

        case "Actualizar":

          int txtIdAfiliadoMod = Integer.parseInt(request.getParameter("txtIdAfiliado"));
          String txtRangoAfiliadoMod = request.getParameter("txtRangoAfiliado");
          String txtBeneficiosMod = request.getParameter("txtBeneficios");
          double txtPrecioRangoMod = Double.parseDouble(request.getParameter("txtPrecioRango"));
          Date fechaMod = java.sql.Date.valueOf(request.getParameter("txtFechaExpiracion"));

          afiliado.setIdAfiliado(txtIdAfiliadoMod);
          afiliado.setRangoAfiliado(txtRangoAfiliadoMod);
          afiliado.setBeneficios(txtBeneficiosMod);
          afiliado.setPrecioRango(txtPrecioRangoMod);
          afiliado.setFechaExpiracion(fechaMod);

          afiliadoDao.actualizarAfiliado(afiliado);
          request.getRequestDispatcher("Controlador?menu=Afiliado&accion=Listar").forward(request, response);

          break;

        case "Eliminar":
          idAfiliado = Integer.parseInt(request.getParameter("codigoAfiliado"));
          afiliadoDao.eliminarAfiliado(idAfiliado);
          request.getRequestDispatcher("Controlador?menu=Afiliado&accion=Listar").forward(request, response);
          break;
      }
      request.getRequestDispatcher("Afiliado.jsp").forward(request, response);
    } else if (menu.equals("Factura")) {
      switch (accion) {
        case "Listar":
          List listaFacturas = facturaDao.listar();
          request.setAttribute("facturas", listaFacturas);

          List listaCompras = compraDao.listar();
          request.setAttribute("compras", listaCompras);

          List listaEnvios = envioDao.listarEnvio();
          request.setAttribute("envios", listaEnvios);

          List listaCupones = cuponDao.listaCupones();
          request.setAttribute("cupones", listaCupones);

          List listaMetodoPagos = metodoPagoDao.listarMetodoPago();
          request.setAttribute("metodoPagos", listaMetodoPagos);
          break;
        case "Agregar":
          Date Fech = java.sql.Date.valueOf(request.getParameter("txtFecha"));
          int IdComp = Integer.parseInt(request.getParameter("txtIdCompra"));
          int IdEnv = Integer.parseInt(request.getParameter("txtIdEnvio"));
          int IdMetPago = Integer.parseInt(request.getParameter("txtIdMetodoPago"));
          int IdCup = Integer.parseInt(request.getParameter("txtIdCupon"));

          factura.setFecha(Fech);
          factura.setIdCompra(IdComp);
          factura.setIdEnvio(IdEnv);
          factura.setIdMetodoPago(IdMetPago);
          factura.setIdCupon(IdCup);

          facturaDao.agregar(factura);
          request.getRequestDispatcher("Controlador?menu=Factura&accion=Listar").forward(request, response);
          break;
        case "Editar":
          idFactura = Integer.parseInt(request.getParameter("IdFactura"));
          Factura f = facturaDao.listaridFactura(idFactura);
          request.setAttribute("IdFacturaEncontrado", f);
          request.getRequestDispatcher("Controlador?menu=Factura&accion=Listar").forward(request, response);
          break;
        case "Actualizar":
          Date Fec = java.sql.Date.valueOf(request.getParameter("txtFecha"));
          int IdFactura = Integer.parseInt(request.getParameter("txtIdFactura"));
          factura.setFecha(Fec);
          factura.setIdFactura(IdFactura);
          factura.setIdFactura(idFactura);

          facturaDao.actualizarFactura(factura);

          request.getRequestDispatcher("Controlador?menu=Factura&accion=Listar").forward(request, response);
          break;
        case "Eliminar":
          String confirmar = request.getParameter("Confirmar");
          if ("Aceptar".equals(confirmar)) {
            idFactura = Integer.parseInt(request.getParameter("IdFactura"));
            facturaDao.eliminarFactura(idFactura);
            request.getRequestDispatcher("Controlador?menu=Factura&accion=Listar").forward(request, response);

          } else if ("Cancelar".equals(confirmar)) {
            request.getRequestDispatcher("Controlador?menu=Factura&accion=Listar").forward(request, response);
          }
          break;
      }

      request.getRequestDispatcher("Factura.jsp").forward(request, response);
    } else if (menu.equals("Compra")) {
      switch (accion) {
        case "Listar":
          List listaCompras = compraDao.listar();
          request.setAttribute("compras", listaCompras);

          List listaEmpleados = empleadoDao.listarEmpleados();
          request.setAttribute("empleados", listaEmpleados);

          List listaClientes = clienteDao.listarCliente();
          request.setAttribute("clientes", listaClientes);

          List listaProductos = productoDao.listarProductos();
          request.setAttribute("productos", listaProductos);

          break;

        case "Agregar":
          int cantprod = Integer.parseInt(request.getParameter("txtCantidadProducto"));
          int Idemp = Integer.parseInt(request.getParameter("txtIdEmpleado"));
          int Idcli = Integer.parseInt(request.getParameter("txtIdCliente"));
          int Idprod = Integer.parseInt(request.getParameter("txtIdProducto"));

          compra.setCantidadProducto(cantprod);
          compra.setIdEmpleado(Idemp);
          compra.setIdCliente(Idcli);
          compra.setIdProducto(Idprod);

          compraDao.agregar(compra);

          request.getRequestDispatcher("Controlador?menu=Compra&accion=Listar").forward(request, response);
          break;

        case "Editar":
          idCompra = Integer.parseInt(request.getParameter("codigoCompra"));
          // cantidadProducto = Integer.parseInte(request.getParameter(menu))
          Compra c = compraDao.listarCodigoCompra(idCompra);
          request.setAttribute("compraEncontrada", c);
          request.getRequestDispatcher("Controlador?menu=Compra&accion=Listar").forward(request, response);
          break;
        case "Actualizar":

          int cantprodcomp = Integer.parseInt(request.getParameter("txtCantidadProducto"));

          compra.setCantidadProducto(cantprodcomp);
          compra.setIdCompra(idCompra);

          compraDao.actualizar(compra);

          request.getRequestDispatcher("Controlador?menu=Compra&accion=Listar").forward(request, response);
          break;
        case "Eliminar":
          String confirmar = request.getParameter("Confirmar");
          if ("Aceptar".equals(confirmar)) {
            idCompra = Integer.parseInt(request.getParameter("codigoCompra"));
            compraDao.eliminar(idCompra);
            request.getRequestDispatcher("Controlador?menu=Compra&accion=Listar").forward(request, response);

          } else if ("Cancelar".equals(confirmar)) {
            request.getRequestDispatcher("Controlador?menu=Compra&accion=Listar").forward(request, response);
          }
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
          List listaTipoEmpleados = tipoEmpleadoDao.listarTipoEmpleado();
          request.setAttribute("tipoEmpleados", listaTipoEmpleados);
          break;
        case "Agregar":
          String txtTipoEmpleado = request.getParameter("txtTipoEmpleado");
          String txtDescripcion = request.getParameter("txtDescripcion");
          String txtDepartamento = request.getParameter("txtDepartamento");

          tipoEmpleado.setTipoEmpleado(txtTipoEmpleado);
          tipoEmpleado.setDescripcion(txtDescripcion);
          tipoEmpleado.setDepartamento(txtDepartamento);

          tipoEmpleadoDao.agregarTipoEmpleado(tipoEmpleado);
          request.getRequestDispatcher("Controlador?menu=TipoEmpleado&accion=Listar").forward(request,
                  response);

          break;
        case "Editar":
          idTipoEmpleado = Integer.parseInt(request.getParameter("codigoTipoEmpleado"));
          TipoEmpleado tipoEmpleadoSeleccionado = tipoEmpleadoDao.buscarTipoEmpleado(idTipoEmpleado);

          request.setAttribute("tipoEmpleadoSeleccionado", tipoEmpleadoSeleccionado);

          request.getRequestDispatcher("Controlador?menu=TipoEmpleado&accion=Listar").forward(request,
                  response);
          break;
        case "Actualizar":
          String actualizarTipoEmpleado = request.getParameter("txtTipoEmpleado");
          String actualizarDescripcion = request.getParameter("txtDescripcion");
          String actualizarDepartamento = request.getParameter("txtDepartamento");
          String actualizarIdTipoEmpleado = request.getParameter("txtIdEmpleado");

          tipoEmpleado.setIdTipoEmpleado(idTipoEmpleado);
          tipoEmpleado.setTipoEmpleado(actualizarTipoEmpleado);
          tipoEmpleado.setDescripcion(actualizarDescripcion);
          tipoEmpleado.setDepartamento(actualizarDepartamento);

          tipoEmpleadoDao.actualizarTipoEmpleado(tipoEmpleado);

          request.getRequestDispatcher("Controlador?menu=TipoEmpleado&accion=Listar").forward(request,
                  response);

          break;
        case "Eliminar":
          String confirmar = request.getParameter("Confirmar");
          if ("Aceptar".equals(confirmar)) {
            idTipoEmpleado = Integer.parseInt(request.getParameter("codigoTipoEmpleado"));
            tipoEmpleadoDao.eliminarTipoEmpleado(idTipoEmpleado);
            request.getRequestDispatcher("Controlador?menu=TipoEmpleado&accion=Listar").forward(request,
                    response);

          } else if ("Cancelar".equals(confirmar)) {
            request.getRequestDispatcher("Controlador?menu=TipoEmpleado&accion=Listar").forward(request,
                    response);

          }
          break;
      }
      request.getRequestDispatcher("TipoEmpleado.jsp").forward(request, response);

      request.getRequestDispatcher("TipoEmpleado.jsp").forward(request, response);
    } else if (menu.equals("Envio")) {
      switch (accion) {
        case "Listar":
          List listaEnvios = envioDao.listarEnvio();
          request.setAttribute("envios", listaEnvios);

          List listaEmpleados = empleadoDao.listarEmpleados();
          request.setAttribute("empleados", listaEmpleados);

          break;

        case "Agregar":
          String direccionEn = request.getParameter("txtDireccionEnvio");
          String telefonoCont = request.getParameter("txtTelefonoContacto");
          int idEmpl = Integer.parseInt(request.getParameter("txtIdEmpleado"));

          envio.setDireccionEnvio(direccionEn);
          envio.setTelefonoContacto(telefonoCont);
          envio.setIdEmpleado(idEmpl);

          envioDao.agregarEnvio(envio);

          request.getRequestDispatcher("Controlador?menu=Envio&accion=Listar").forward(request, response);
          break;

        case "Editar":
          idEnvio = Integer.parseInt(request.getParameter("codigoEnvio"));
          Envio e = envioDao.listarCodigoEnvio(idEnvio);
          request.setAttribute("envioEncontrado", e);
          request.getRequestDispatcher("Controlador?menu=Envio&accion=Listar").forward(request, response);
          break;

        case "Actualizar":
          int IDEN = Integer.parseInt(request.getParameter("txtIdEnvio"));
          String DIRCEN = request.getParameter("txtDireccionEnvio");
          String TELCO = request.getParameter("txtTelefonoContacto");
          int IDEMPL = Integer.parseInt(request.getParameter("txtIdEmpleado"));

          envio.setIdEnvio(IDEN);
          envio.setDireccionEnvio(DIRCEN);
          envio.setTelefonoContacto(TELCO);
          envio.setIdEmpleado(IDEMPL);

          envio.setIdEnvio(idEnvio);
          envioDao.actualizarEnvio(envio);
          request.getRequestDispatcher("Controlador?menu=Envio&accion=Listar").forward(request, response);

          break;

        case "Eliminar":
          String confirmar = request.getParameter("Confirmar");
          if ("Aceptar".equals(confirmar)) {
            idEnvio = Integer.parseInt(request.getParameter("codigoEnvio"));
            envioDao.eliminarEnvio(idEnvio);
            request.getRequestDispatcher("Controlador?menu=Envio&accion=Listar").forward(request, response);

          } else if ("Cancelar".equals(confirmar)) {
            request.getRequestDispatcher("Controlador?menu=Envio&accion=Listar").forward(request, response);
          }
          break;

      }
      request.getRequestDispatcher("Envio.jsp").forward(request, response);
    } else if (menu.equals("Cupon")) {
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
    } else if (menu.equals("Proveedor")) {
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
    } else if (menu.equals("Sucursal")) {
      switch (accion) {
        case "Listar":

          List listaSucursales = sucursalDao.listarSucursal();
          request.setAttribute("sucursales", listaSucursales);
          break;

        case "Agregar":
          String nombreSu = request.getParameter("txtNombreSucursal");
          String direccionSu = request.getParameter("txtDireccionSucursal");
          Time aperturaSu = java.sql.Time.valueOf(request.getParameter("txtApertura"));
          Time cierreSu = java.sql.Time.valueOf(request.getParameter("txtCierre"));

          sucursal.setNombreSucursal(nombreSu);
          sucursal.setDireccionSucursal(direccionSu);
          sucursal.setApertura(aperturaSu);
          sucursal.setCierre(cierreSu);

          sucursalDao.agregarSucursal(sucursal);

          request.getRequestDispatcher("Controlador?menu=Sucursal&accion=Listar").forward(request, response);
          break;

        case "Editar":
          idSucursal = Integer.parseInt(request.getParameter("codigoSucursal"));
          Sucursal s = sucursalDao.listarCodigoSucursal(idSucursal);
          request.setAttribute("sucursalEncontrado", s);
          request.getRequestDispatcher("Controlador?menu=Sucursal&accion=Listar").forward(request, response);
          break;

        case "Actualizar":
          int IDSU = Integer.parseInt(request.getParameter("txtIdSucursal"));
          String NOMBSU = request.getParameter("txtNombreSucursal");
          String DIRECSU = request.getParameter("txtDireccionSucursal");
          Time APERSU = java.sql.Time.valueOf(request.getParameter("txtApertura"));
          Time CIERSU = java.sql.Time.valueOf(request.getParameter("txtCierre"));

          sucursal.setIdSucursal(IDSU);
          sucursal.setNombreSucursal(NOMBSU);
          sucursal.setDireccionSucursal(DIRECSU);
          sucursal.setApertura(APERSU);
          sucursal.setCierre(CIERSU);

          sucursal.setIdSucursal(idSucursal);
          sucursalDao.actualizarSucursal(sucursal);
          request.getRequestDispatcher("Controlador?menu=Sucursal&accion=Listar").forward(request, response);
          break;

        case "Eliminar":
          String confirmar = request.getParameter("Confirmar");
          if ("Aceptar".equals(confirmar)) {
            idSucursal = Integer.parseInt(request.getParameter("codigoSucursal"));
            sucursalDao.eliminarSucursal(idSucursal);
            request.getRequestDispatcher("Controlador?menu=Sucursal&accion=Listar").forward(request, response);

          } else if ("Cancelar".equals(confirmar)) {
            request.getRequestDispatcher("Controlador?menu=Sucursal&accion=Listar").forward(request, response);
          }
          break;

      }
      request.getRequestDispatcher("Sucursal.jsp").forward(request, response);
    } else if (menu.equals("Empleado")) {
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
    } else if (menu.equals("TipoProducto")) {
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
