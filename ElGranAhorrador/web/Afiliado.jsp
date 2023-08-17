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
            <form>
                <div class="form-group">
                    <label>ID Afiliado:</label>
                    <input type="text" value="" name="" class="form-control">
                </div>

                <div class="form-group">
                    <label>Rango Afiliado:</label>
                    <input type="text" value="" name="" class="form-control">
                </div>

                <div class="form-group">
                    <label>Beneficios:</label>
                    <input type="text" value="" name="" class="form-control">
                </div>

                <div class="form-group">
                    <label>Precio Rango:</label>
                    <input type="text" value="" name="" class="form-control">
                </div>

                <div class="form-group">
                    <label>Fecha Expiracion:</label>
                    <input type="text" value="" name="" class="form-control">
                </div>
                <div class="botones">
                    <div name="accion" value="Actualizar" class="button button-actualizar" href="#"><span>Actualizar</span></div>
                    <div name="accion" value="Agregar" class="button button-agregar" href="#"><span>Agregar</span></div>
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
                        <div class="button button-editar" href="#"><span>Editar</span></div>
                        <div class="button button-eliminar" href="#"><span>Eliminar</span></div>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
