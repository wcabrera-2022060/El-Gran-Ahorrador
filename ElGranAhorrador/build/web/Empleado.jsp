<%-- 
    Document   : Empleados
    Created on : 15/08/2023, 19:17:19
    Author     : Edy Aroche 
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
        <title>Vista Empleados</title>
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
            <%--Cambiar Nombre a su entidad osea donde dice Empleados--%>
            <h1 class="form-group text-center">Empleados</h1>
            <form action="Controlador?menu=Empleado" method="POST">
                <%--Si necesitan agregar más atributos copien lo que esta bajo de este comentario--%>
                <div class="form-group">
                    <%--Cambian el atributo: de la etiqueta <Label> y colocan sus atributos--%>
                    <label>ID Empleado:</label>
                    <input type="text" value="${empleadoEncontrado.getIdEmpleado()}" name="txtIdEmpleado" class="form-control" readonly="true">
                </div>
                <%--Hasta aca, y lo pegan en orden porfa, conforme a sus atributos--%>
                <div class="form-group">
                    <label>Nombre Empleado:</label>
                    <input type="text" value="${empleadoEncontrado.getNombreEmpleado()}" name="txtNombreEmpleado" class="form-control" required>
                </div>
                <div class="form-group">
                    <label>Apellido Empleado:</label>
                    <input type="text" value="${empleadoEncontrado.getApellidoEmpleado()}" name="txtApellidoEmpleado" class="form-control" required>
                </div>
                <div class="form-group">
                    <label>Sueldo:</label>
                    <input type="text" value="${empleadoEncontrado.getSueldo()}" name="txtSueldo" class="form-control" required>
                </div>
                <div class="form-group">
                    <label>ID Tipo Empleado:</label>
                    <select name="txtIdTipoEmpleado">
                        <c:forEach var="tipoEmpleado" items="${tipoEmpleados}">
                            <option name="txtIdTipoEmpleado" value="${tipoEmpleado.getIdTipoEmpleado()}">${tipoEmpleado.getIdTipoEmpleado()} || ${tipoEmpleado.getTipoEmpleado()}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="form-group">
                    <label>ID Sucursal:</label>
                    <select name="txtIdSucursal">
                        <c:forEach var="sucursal" items="${sucursales}">
                            <option name="txtIdSucursal" value="${sucursal.getIdSucursal()}">${sucursal.getIdSucursal()} || ${sucursal.getNombreSucursal()}</option>
                        </c:forEach>
                    </select>
                </div>              
                <div class="botones">
                    <div name="accion" value="Actualizar" class="button button-actualizar" href="#"><span><input class="quitar" type="submit" name="accion" value="Actualizar"></span></div>
                    <div name="accion" value="Agregar" class="button button-agregar" href="#"><span><input class="quitar" type="submit" name="accion" value="Agregar"></span></div>
                </div>
            </form>
        </div>


        <table class="table table-hover">
            <thead>
            <th>ID EMPLEADO</th>
            <th>NOMBRE EMPLEADO</th>
            <th>APELLIDO EMPLEADO</th>
            <th>SUELDO</th>
            <th>ID TIPO EMPLEADO</th>
            <th>ID SUCURSAL</th>
            <th>ACCIONES</th>
        </thead>
        <tbody>
            <c:forEach var="empleado" items="${empleados}">
                <tr>
                    <td>${empleado.getIdEmpleado()}</td>
                    <td>${empleado.getNombreEmpleado()}</td>
                    <td>${empleado.getApellidoEmpleado()}</td>
                    <td>${empleado.getSueldo()}</td>
                    <td>${empleado.getIdTipoEmpleado()}</td>
                    <td>${empleado.getIdSucursal()}</td>                    
                    <td>
                        <a class="button button-editar" href="Controlador?menu=Empleado&accion=Editar&idEmpleado=${empleado.getIdEmpleado()}"><span>Editar</span></a>
                        <a class="button button-eliminar" href="#" data-toggle="modal" data-target="#deleteModal-${empleado.getIdEmpleado()}"><span>Eliminar</span></a>

                        <div class="modal fade" id="deleteModal-${empleado.getIdEmpleado()}" tabindex="-1" role="dialog" aria-labelledby="deleteModalTitle-${empleado.getIdEmpleado()}" aria-hidden="true">
                            <div class="modal-dialog modal-dialog-centered" role="document">
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <h5 class="modal-title" id="deleteModalTitle-${empleado.getIdEmpleado()}">Eliminar Afiliado</h5>
                                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                            <span aria-hidden="true">&times;</span>
                                        </button>
                                    </div>
                                    <div class="modal-body">¿Estás seguro de que deseas eliminar este elemento?</div>
                                    <div class="modal-footer">
                                        <a class="btn btn-secondary" href="#" data-dismiss="modal">Cancelar</a>
                                        <a class="btn btn-primary" href="Controlador?menu=Empleado&accion=Eliminar&idEmpleado=${empleado.getIdEmpleado()}&action=accept">Eliminar</a>
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