<%-- 
    Document   : Cliente
    Created on : 11/08/2023, 05:45:14 PM
    Author     : Edson_Alf
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
    <%--Cambiar Nombre a su entidad osea donde dice Vista Envio--%>
    <title>Vista Cliente</title>
    <%-- Link hacia el CSS --%>
    <link rel="stylesheet" href="./css/styles.css">

    <%-- Importando jQuery libreria --%>
    <script
      src="https://code.jquery.com/jquery-3.7.0.slim.min.js"
      integrity="sha256-tG5mcZUtJsZvyKAxYLVXrmjKBVLd6VpVccqz/r4ypFE="
    crossorigin="anonymous"></script>

    <%-- Link hacia las animaciones con jQuery --%>
    <script src="./js/animacionBoton.js" defer></script>
  </head>
  <body>


    <div class="card-body">
      <%--Cambiar Nombre a su entidad osea donde dice Envio--%>
      <h1 class="form-group text-center">Cliente</h1>
      <form action="Controlador?menu=Cliente" method="POST">
        <div class="form-group">
          <label>ID Cliente:</label>
          <input type="text" value="${clienteEncontrado.getIdCliente()}" name="txtIdCliente" class="form-control" readonly="true">
        </div>
        <%--Hasta aca, y lo pegan en orden porfa, conforme a sus atributos--%>
        <div class="form-group">
          <label>Nombre Cliente:</label>
          <input type="text" value="${clienteEncontrado.getNombreCliente()}" name="txtNombreCliente" class="form-control" required>
        </div>
        <div class="form-group">
          <%--Cambian el atributo: de la etiqueta <Label> y colocan sus atributos--%>
          <label>Apellido Cliente:</label>
          <input type="text" value="${clienteEncontrado.getApellidoCliente()}" name="txtApellidoCliente" class="form-control" required>
        </div>
        <div class="form-group">
          <label>Teléfono Cliente:</label>
          <input type="number" value="${clienteEncontrado.getTelefonoCliente()}" name="txtTelefonoCliente" class="form-control" required>
        </div>
        <div class="form-group">
          <label>Direccion Cliente:</label>
          <input type="text" value="${clienteEncontrado.getDireccionCliente()}" name="txtDireccionCliente" class="form-control" required>
        </div>
        <div class="form-group">
          <%--Cambian el atributo: de la etiqueta <Label> y colocan sus atributos--%>
          <label>ID Login:</label>
          <input type="text" value="${clienteEncontrado.getIdLogin()}" name="txtIdLogin" class="form-control" >
        </div>
        <div class="form-group">
          <label>ID Afiliado:</label>
          <select name="txtIdAfiliado">
            <c:forEach var="afiliado" items="${afiliados}">
              <option name="txtIdAfiliado" value="${afiliado.getIdAfiliado()}">${afiliado.getIdAfiliado()} || ${afiliado.getRangoAfiliado()}</option>

              <%--<option>${empleado.getNombreEmpleado()}</option>--%>
            </c:forEach>
          </select>
        </div>

        <div class="botones">
          <div class="botones">
            <div name="accion" value="Actualizar" class="button button-actualizar" href="#">
              <span>
                <input class="quitar" type="submit" name="accion" value="Actualizar">
              </span>
            </div>
            <div name="accion" value="Agregar" class="button button-agregar" href="#">
              <span>
                <input class="quitar" type="submit" name="accion" value="Agregar">
              </span>
            </div>
           </div>
        </div>
      </form>
    </div>


    <table class="table table-hover">
      <thead>
      <th>ID CLIENTE</th>
      <th>NOMBRE CLIENTE</th>
      <th>APELLIDO CLIENTE</th>
      <th>TELÉFONO CLIENTE</th>
      <th>DIRECCIÓN CLIENTE</th>
      <th>ID LOGIN</th>
      <th>ID AFILIADO</th>
      <th>ACCIONES</th>
    </thead>
    <tbody>
      <c:forEach var="cliente" items="${clientes}">
        <tr>
          <td>${cliente.getIdCliente()}</td>                        
          <td>${cliente.getNombreCliente()}</td>
          <td>${cliente.getApellidoCliente()}</td>
          <td>${cliente.getTelefonoCliente()}</td>
          <td>${cliente.getDireccionCliente()}</td>
          <td>${cliente.getIdLogin()}</td>
          <td>${cliente.getIdAfiliado()}</td>
          <td>
            <a class="button button-editar" href="Controlador?menu=Cliente&accion=Editar&idCliente=${cliente.getIdCliente()}"><span>Editar</span></a>
            <a class="button button-eliminar" href="Controlador?menu=Cliente&accion=Eliminar&idCliente=${cliente.getIdCliente()}" data-toggle="modal" data-target="#deleteModal-${cliente.getIdCliente()}"><span>Eliminar</span></a>
            <div class="modal fade" id="deleteModal-${cliente.getIdCliente()}" tabindex="-1" role="dialog" aria-labelledby="deleteModalTitle-${cliente.getIdCliente()}" aria-hidden="true">
              <div class="modal-dialog modal-dialog-centered" role="document">
                <div class="modal-content">
                  <div class="modal-header">
                    <h5 class="modal-title" id="deleteModalTitle-${cliente.getIdCliente()}">Advertencia</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                      <span aria-hidden="true">&times;</span>
                    </button>
                  </div>
                  <div class="modal-body">
                    ¿Esta seguro que desea eliminar el elemento?
                  </div>
                  <div class="modal-footer">
                    <a class="btn btn-danger" href="#" data-dismiss="modal">Cancelar</a>
                    <a class="btn btn-info" href="Controlador?menu=Cliente&accion=Eliminar&idCliente=${cliente.getIdCliente()}&Confirmar=Aceptar">Eliminar</a>
                    <div class="modal fade" id="deleteModal-${cliente.getIdCliente()}" tabindex="-1" role="dialog" aria-labelledby="deleteModalTitle-${cliente.getIdCliente()}" aria-hidden="true">

                      <div class="modal-dialog modal-dialog-centered" role="document">

                        <div class="modal-content">

                          <div class="modal-header">

                            <h5 class="modal-title" id="deleteModalTitle-${cliente.getIdCliente()}">Advertencia</h5>

                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">

                              <span aria-hidden="true">&times;</span>

                            </button>

                          </div>

                          <div class="modal-body">

                            ¿Esta seguro que desea eliminar el elemento?

                          </div>

                          <div class="modal-footer">

                            <a class="btn btn-danger" href="#" data-dismiss="modal">Cancelar</a>

                            <a class="btn btn-info" href="Controlador?menu=Cliente&accion=Eliminar&idCliente=${cliente.getIdCliente()}&Confirmar=Aceptar">Eliminar</a>

                          </div>

                        </div>

                      </div>

                    </div>  </td>
                    </tr>
                  </c:forEach>        
                  </tbody>
                  </table>



                  <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
                  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
                  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.min.js" integrity="sha384-w1Q4orYjBQndcko6MimVbzY0tgp4pWB4lZ7lr30WKz0vr/aWKhXdBNmNb5D92v7s" crossorigin="anonymous"></script>
                  </body>
                  </html>
