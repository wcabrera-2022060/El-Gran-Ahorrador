<%-- 
    Document   : Afiliado
    Created on : 11/08/2023, 06:22:35 PM
    Author     : Douglas
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
        <title>Vista Afiliado</title>
        <link rel="stylesheet" href="./css/styles.css">

        <script
            src="https://code.jquery.com/jquery-3.7.0.slim.min.js"
            integrity="sha256-tG5mcZUtJsZvyKAxYLVXrmjKBVLd6VpVccqz/r4ypFE="
        crossorigin="anonymous"></script>

        <script src="./js/animacionBoton.js" defer></script>
    </head>
    <body>
        <div class="card-body">
            <h1 class="form-group text-center">Afiliado</h1>
            <form action="Controlador?menu=Afiliado" method="POST">
                <div class="form-group">
                    <label>ID Afiliado:</label>
                    <input type="text" value="${afiliadoSeleccionado.getIdAfiliado()}" name="txtIdAfiliado" class="form-control" readonly="true">
                </div>
                <div class="form-group">
                    <label>Rango Afiliado:</label>
                    <input type="text" value="${afiliadoSeleccionado.getRangoAfiliado()}" name="txtRangoAfiliado" class="form-control">
                </div>
                <div class="form-group">
                    <label>Beneficios:</label>
                    <input type="text" value="${afiliadoSeleccionado.getBeneficios()}" name="txtBeneficios" class="form-control">
                </div>
                <div class="form-group">
                    <label>Precio Rango:</label>
                    <input type="Number" value="${afiliadoSeleccionado.getPrecioRango()}" name="txtPrecioRango" class="form-control">
                </div>
                <div class="form-group">
                    <label>Fecha Expiracion:</label>
                    <input type="Date" value="${afiliadoSeleccionado.getFechaExpiracion()}" name="txtFechaExpiracion" class="form-control">
                </div>
                
                <div class="botones">
                    <div name="accion" value="Actualizar" class="button button-actualizar" href="#"><span><input class="quitar" type="submit" name="accion" value="Actualizar"></span></div>
                    <div name="accion" value="Agregar" class="button button-agregar" href="#"><span><input class="quitar" type="submit" name="accion" value="Agregar"></span></div>
                </div>
                
            </form>
        </div>

        <table class="table table-hover">
            <thead>
            <th>ID AFILIADO</th>
            <th>RANGO AFILIADO</th>
            <th>BENEFICIOS</th>
            <th>PRECIO RANGO</th>
            <th>FECHA EXPIRACION</th>
        </thead>
        <tbody>
            <c:forEach var="afiliado" items="${afiliados}">
                <tr>
                    <td>${afiliado.getIdAfiliado()}</td>
                    <td>${afiliado.getRangoAfiliado()}</td>
                    <td>${afiliado.getBeneficios()}</td>
                    <td>${afiliado.getPrecioRango()}</td>
                    <td>${afiliado.getFechaExpiracion()}</td>
                    <td>
                        <a class="button button-editar" href="Controlador?menu=Afiliado&accion=Editar&codigoAfiliado=${afiliado.getIdAfiliado()}"><span>Editar</span></a> 
                        <a class="button button-eliminar" href="#" data-toggle="modal" data-target="#deleteModal-${afiliado.getIdAfiliado()}">
                            <span>Eliminar</span>
                        </a>

                        <div class="modal fade" id="deleteModal-${afiliado.getIdAfiliado()}" tabindex="-1" role="dialog" aria-labelledby="deleteModalTitle-${afiliado.getIdAfiliado()}" aria-hidden="true">
                            <div class="modal-dialog modal-dialog-centered" role="document">
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <h5 class="modal-title" id="deleteModalTitle-${afiliado.getIdAfiliado()}">Eliminar Afiliado</h5>
                                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                            <span aria-hidden="true">&times;</span>
                                        </button>
                                    </div>
                                    <div class="modal-body">
                                        ¿Estás seguro de que deseas eliminar este afiliado?
                                    </div>
                                    <div class="modal-footer">
                                        <a class="btn btn-secondary" href="#" data-dismiss="modal">Cancelar</a>
                                        <a class="btn btn-primary" href="Controlador?menu=Afiliado&accion=Eliminar&codigoAfiliado=${afiliado.getIdAfiliado()}&action=accept">Eliminar</a>
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
