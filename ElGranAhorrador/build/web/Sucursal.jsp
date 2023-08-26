<%-- 
    Document   : Envio
    Created on : 10/08/2023, 01:39:35 AM
    Author     : Mr Hermes Jr
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
        <%--Cambiar Nombre a su entidad osea donde dice Vista Envio--%>
        <title>Vista Sucursal</title>
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
            <h1 class="form-group text-center">Sucursales</h1>
            <form action="Controlador?menu=Sucursal" method="POST">
                <%--Si necesitan agregar más atributos copien lo que esta bajo de este comentario--%>
                <div class="form-group">
                    <%--Cambian el atributo: de la etiqueta <Label> y colocan sus atributos--%>
                    <label>ID Sucursal:</label>
                    <input type="text" value="${sucursalEncontrado.getIdSucursal()}" name="txtIdSucursal" class="form-control" readonly="true">
                </div>
                <%--Hasta aca, y lo pegan en orden porfa, conforme a sus atributos--%>
                <div class="form-group">
                    <label>Nombre del Sucursal:</label>
                    <input type="text" value="${sucursalEncontrado.getNombreSucursal()}" name="txtNombreSucursal" class="form-control" required>
                </div>
                <div class="form-group">
                    <label>Direccion del Sucursal:</label>
                    <input type="text" value="${sucursalEncontrado.getDireccionSucursal()}" name="txtDireccionSucursal" class="form-control" required>
                </div>
                <div class="form-group">
                    <label>Apertura:</label>
                    <input type="time" step="1" value="${sucursalEncontrado.getApertura()}" name="txtApertura" class="form-control" required>
                </div>
                <div class="form-group">
                    <label>Cierre:</label>
                    <input type="time" step="1" value="${sucursalEncontrado.getCierre()}" name="txtCierre" class="form-control" required>
                </div>
                <div class="botones">
                    <div name="accion" value="Actualizar" class="button button-actualizar"><span><input type="submit" name="accion" value="Actualizar"></span></div>
                    <div name="accion" value="Agregar" class="button button-agregar"><span><input type="submit" name="accion" value="Agregar"></span></div>
                </div>
            </form>
        </div>


        <table class="table table-hover">
            <thead>
            <th>ID SUCURSAL</th>
            <th>NOMBRE SUCURSAL</th>
            <th>DIRECCIÓN SUCURSAL</th>
            <th>APERTURA</th>
            <th>CIERRE</th>
            <th>ACCIONES</th>
        </thead>
        <tbody>
            <c:forEach var="sucursal" items="${sucursales}">
                <tr>
                    <td>${sucursal.getIdSucursal()}</td>
                    <td>${sucursal.getNombreSucursal()}</td>
                    <td>${sucursal.getDireccionSucursal()}</td>
                    <td>${sucursal.getApertura()}</td>
                    <td>${sucursal.getCierre()}</td>
                    <td>
                        <a class="button button-editar" href="Controlador?menu=Sucursal&accion=Editar&codigoSucursal=${sucursal.getIdSucursal()}"><span>Editar</span></a>
                        <a class="button button-eliminar" href="#" data-toggle="modal" data-target="#deleteModal-${sucursal.getIdSucursal()}"><span>Eliminar</span></a>
                        <div class="modal fade" id="deleteModal-${sucursal.getIdSucursal()}" tabindex="-1" role="dialog" aria-labelledby="deleteModalTitle-${sucursal.getIdSucursal()}" aria-hidden="true">
                            <div class="modal-dialog modal-dialog-centered" role="document">
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <h5 class="modal-title" id="deleteModalTitle-${sucursal.getIdSucursal()}">Advertencia</h5>
                                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                            <span aria-hidden="true">&times;</span>
                                        </button>
                                    </div>
                                    <div class="modal-body">
                                        ¿Esta seguro que desea eliminar el elemento?
                                    </div>
                                    <div class="modal-footer">
                                        <a class="btn btn-danger" href="#" data-dismiss="modal">Cancelar</a>
                                        <a class="btn btn-info" href="Controlador?menu=Sucursal&accion=Eliminar&codigoSucursal=${sucursal.getIdSucursal()}&Confirmar=Aceptar">Eliminar</a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </td>
                </tr>
            </c:forEach>        
        </tbody>
    </table>



    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.min.js" integrity="sha384-w1Q4orYjBQndcko6MimVbzY0tgp4pWB4lZ7lr30WKz0vr/aWKhXdBNmNb5D92v7s" crossorigin="anonymous"></script>
</body>
</html>
