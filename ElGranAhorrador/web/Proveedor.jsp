<%-- 
    Document   : Proveedor
    Created on : 11/08/2023, 07:47:43 AM
    Author     : JJ
--%>

<%-- 
    Document   : Cupon
    Created on : 11/08/2023, 07:47:23 AM
    Author     : JJ
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
        <%--Cambiar Nombre a su entidad osea donde dice Vista Envio--%>
        <title>Vista Proveedor</title>
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
            <h1 class="form-group text-center">Proveedor</h1>
            <form action="Controlador?menu=Proveedor" method="POST">
                <%--Si necesitan agregar más atributos copien lo que esta bajo de este comentario--%>
                <div class="form-group">
                    <%--Cambian el atributo: de la etiqueta <Label> y colocan sus atributos--%>
                    <label>ID Proveedor:</label>
                    <input type="text" value="${proveedorEncontrado.getIdProveedor()}" name="txtIdProveedor" class="form-control" readonly="true">
                </div>
                <%--Hasta aca, y lo pegan en orden porfa, conforme a sus atributos--%>
                <div class="form-group">
                    <label>Proveedor:</label>
                    <input type="text" value="${proveedorEncontrado.getProveedor()}" name="txtProveedor" class="form-control" required>
                </div>
                <div class="form-group">
                    <label>Cantidad Adquirida:</label>
                    <input type="number" min="0" step="any" value="${proveedorEncontrado.getCantidadAdquirida()}" name="txtCantidadAdquirida" class="form-control" required>
                </div>
                <div class="form-group">
                    <label>Total a Pagar:</label>
                    <input type="number" min="0" step="any" value="${proveedorEncontrado.getTotalPagar()}" name="txtTotalPagar" class="form-control" required>
                </div>


               <div class="form-group">
                    <label>ID Producto:</label>
                    <select name="txtIdProducto">
                        <c:forEach var="producto" items="${productos}">
                            <option name="txtIdProducto" value="${producto.getIdProducto()}">${producto.getIdProducto()} || ${producto.getNombreProducto()}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="botones">
                    <div name="accion" value="Actualizar" class="button button-actualizar"><span><input type="submit" name="accion" value="Actualizar"></span></div>
                    <div name="accion" value="Agregar" class="button button-agregar"><span><input type="submit" name="accion" value="Agregar"></span></div>                
                </div>
            </form>
        </div>


        <table class="table table-hover">
            <thead>
            <th>ID PROVEEDOR</th>
            <th>PROVEEDOR</th>
            <th>CANTIDAD ADQUIRIDA</th>
            <th>TOTAL PAGAR</th>
            <th>ID PRODUCTO</th>
            <th>ACCIONES</th>
        </thead>
        <tbody>
            <c:forEach var="proveedor" items="${proveedores}">
                <tr>
                    <td>${proveedor.getIdProveedor()}</td>
                    <td>${proveedor.getProveedor()}</td>
                    <td>${proveedor.getCantidadAdquirida()}</td>
                    <td>${proveedor.getTotalPagar()}</td>
                    <td>${proveedor.getIdProducto()}</td>
                    <td>
                        <a class="button button-editar" href="Controlador?menu=Proveedor&accion=Editar&codigoProveedor=${proveedor.getIdProveedor()}"><span>Editar</span></a> 
                        <a class="button button-eliminar" href="#" data-toggle="modal" data-target="#deleteModal-${proveedor.getIdProveedor()}">
                            <span>Eliminar</span>
                        </a>

                        <div class="modal fade" id="deleteModal-${proveedor.getIdProveedor()}" tabindex="-1" role="dialog" aria-labelledby="deleteModalTitle-${proveedor.getIdProveedor()}" aria-hidden="true">
                            <div class="modal-dialog modal-dialog-centered" role="document">
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <h5 class="modal-title" id="deleteModalTitle-${proveedor.getIdProveedor()}">Eliminar Proveedor</h5>
                                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                            <span aria-hidden="true">&times;</span>
                                        </button>
                                    </div>
                                    <div class="modal-body">
                                        ¿Estás seguro de que deseas eliminar este Proveeedor?
                                    </div>
                                    <div class="modal-footer">
                                        <a class="btn btn-secondary" href="#" data-dismiss="modal">Cancelar</a>
                                        <a class="btn btn-primary" href="Controlador?menu=Proveedor&accion=Eliminar&codigoProveedor=${proveedor.getIdProveedor()}">Eliminar</a>
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

