<%-- 
    Document   : listarClientes
    Created on : 21-sep-2016, 22:34:41
    Author     : Ulises Guzman
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listar clientes</title>
    </head>
    <body>
        <table>
            <thead>
                <tr>
                    <th>Id Cliente</th>
                    <th>Login</th>
                    <th>Password</th>
                    <th>Nombre</th>
                    <th>Edad</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="cliente" items="${clientes}">
                    <tr>
                        <td>${cliente.idCliente}</td>
                        <td>${cliente.login}</td>
                        <td>${cliente.password}</td>
                        <td>${cliente.nombre}</td>
                        <td>${cliente.edad}</td>
                        <td><a href="ClienteController?action=cambiar&idCliente=${cliente.idCliente}">Cambiar</a></td>
                        <td><a href="ClienteController?action=borrar&idCliente=${cliente.idCliente}">Borrar</a></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <p>
            <a href="ClienteController?action=agregar">Nuevo Cliente</a>
        </p>
    </body>
</html>
