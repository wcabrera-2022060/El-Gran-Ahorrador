
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%-- 
    Document   : Compra
    Created on : 10/09/2023, 04:40:07 PM
    Author     : Dell
--%>



<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
    <title>Vista Compra</title>
  </head>
  <body>       


    <div class="d-flex" style="margin: 1em">
      <div class="col-sm-4">
        <form action="Controlador?menu=Compra" method="POST">
          <div class="card">
            <!-- FORMULARIO CLIENTE -->
            <div class="card-body">
              <div class="form-group">
                <label>Datos del Cliente</label>
              </div>
              <div class="form-group d-flex">
                <div class="col-sm-6">
                  <input type="text" name="txtNombreCliente" value="${cliente.getNombreCliente()}" class="form-control">
                  <button type="submit" name="accion" value="BuscarCliente" class="btn-outline-info">Buscar</button>

                </div>
                <div class="col-sm-6">
                  <input type="text" name="txtIdCliente" value="${cliente.getIdCliente()}" class="form-control" placeholder="Id Cliente" readonly="true">
                </div>
              </div>

              <!-- FORMULARIO EMPLEADO  -->
              <div class="form-group">
                <label>Datos del Empleado</label>
              </div>
              <div class="form-group d-flex">
                <div class="col-sm-6">
                  <input type="number" name="idEmpleado" value="${empleado.getIdEmpleado()}" class="form-control" min="1">
                  <button type="submit" name="accion" value="BuscarEmpleado" class="btn-outline-info">Buscar</button>
                </div>
                <div class="col-sm-6">
                  <input type="text" name="txtIdCliente" value="${empleado.getNombreEmpleado()}" class="form-control" placeholder="Nombre Empleado" readonly="true">
                </div>
              </div>

              <!-- FORMULARIO PRODUCTO -->
              <div class="form-group">
                <label>Datos Producto:</label>
              </div>
              <div class="form-group d-flex">
                <div class="col-sm-6 d-flex">
                  <input type="number" min="1" step="any" name="txtIdProducto" value="${producto.getIdProducto()}" class="form-control" placeholder="Codigo Producto">
                  <button type="submit" name="accion" value="BuscarProducto" class="btn-outline-info">Buscar</button>
                </div>
                <div class="col-sm-6">
                  <input type="text" name="txtNombreProducto" value="${producto.getNombreProducto()}" class="form-control" placeholder="Nombre Producto" readonly="true">
                </div>
              </div>
              <div class="form-group d-flex">
                <div class="col-sm-6 d-flex">
                  <input type="text" name="txtPrecioProducto" value="${producto.getPrecioProducto()}" class="form-control" placeholder="Q. 00.00" readonly="true" >
                </div>
                <div class="col-sm-3">
                  <input type="number" min="1" step="any" name="txtCantidad" value="1" class="form-control">
                </div>
                <div class="col-sm-3">
                  <input type="text" name="txtStock" value="${inventario.getCantidadDisponible()}" class="form-control" placeholder="Stock" readonly="true">
                </div>
              </div>

              <div class="form-group">
                <!--<button type="submit" name="accion" value="Agregar" class="btn btn-outline-info">Agregar Producto</button>-->
                <button type="submit" name="accion" value="Comprar" class="btn btn-success">Generar Venta</button>

              </div>
            </div>
          </div>
        </form>
      </div>



      <div class="col-sm-7">
        <div class="card">
          <div class="card-body">
            <!--<div class="d-flex col-sm-6 ml-auto">
              <label>Factura No.</label>
              <input type="text" name="txtFactura" class="form-control"><br>
            </div>-->
            <table class="table table-hover">
              <thead>
                <tr>
                  <td><strong>ID CLIENTE</strong></td>
                  <td><strong>NOMBRE CLIENTE</strong></td>
                  <td><strong>NOMBRE EMPLEADO</strong></td>
                  <td><strong>NOMBRE PRODUCTO</strong></td>
                  <td><strong>CANTIDAD PRODUCTO</strong></td>
                </tr>
              </thead>
              <tbody>
                <c:forEach var="historial" items="${historial}">
                  <tr>
                    <td>${historial.getIdCliente()}</td>
                    <td>${historial.getNombreCliente()}</td>
                    <td>${historial.getNombreEmpleado()}</td>
                    <td>${historial.getNombreProducto()}</td>
                    <td>${historial.getCantidadProducto()}</td>
                    <!--<td class="d-flex">
                      <a href="#" class="btn btn-danger" style="margin-left: 10px">Eliminar</a>
                    </td>-->
                  </tr>
                </c:forEach>
                <c:forEach var="historialCliente" items="${historialCliente}">
                  <tr>
                    <td>${historialCliente.getIdCliente()}</td>
                    <td>${historialCliente.getNombreCliente()}</td>
                    <td>${historialCliente.getNombreEmpleado()}</td>
                    <td>${historialCliente.getNombreProducto()}</td>
                    <td>${historialCliente.getCantidadProducto()}</td>        
                    <!--<td class="d-flex">
                      <a href="#" class="btn btn-danger" style="margin-left: 10px">Eliminar</a>
                    </td>-->
                  </tr>
                </c:forEach>
              </tbody>
            </table>
          </div>

          <form action="Controlador?menu=Compra" method="POST">
            <div class="form-group d-flex">
              <div class="col-sm-6">
                <span>Id Cliente: </span>
                <input type="number" min="1" name="idCliente" required="true">
              </div>
              <div class="col-sm-4 ml-auto">
                <button type="submit" name="accion" value="BuscarHistorial" class="btn btn-success">Historial de compras</button>
              </div>
            </div>
          </form>

        </div>
      </div>
    </div>

    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.min.js" integrity="sha384-w1Q4orYjBQndcko6MimVbzY0tgp4pWB4lZ7lr30WKz0vr/aWKhXdBNmNb5D92v7s" crossorigin="anonymous"></script>
  </body>
</html>
