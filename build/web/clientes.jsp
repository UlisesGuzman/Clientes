<%-- 
    Document   : clientes
    Created on : 21-sep-2016, 22:27:55
    Author     : Ulises Guzman
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Agregar clientes</title>
    </head>
    <body>
        <form action="ClienteController" method="post">
            <fieldset>
                <div>
                <label>id de cliente: </label>
                <input type="text" name="idCliente" value="${cliente.idCliente}"
                       placeholder="idCliente"
                       readonly="readonly"/>
                </div>
                       <div>
                <label>Login: </label>
                <input type="text" name="login" value="${cliente.login}"
                       placeholder="Login"/>
                       </div>
                       <div>       
                <label>Password: </label>
                <input type="password" name="password" value="${cliente.password}"
                       placeholder="Password"/>
                       </div>
                       <div>
                <label>Nombre: </label>
                <input type="text" name="nombre" value="${cliente.nombre}"
                       placeholder="Nombre del cliente"/>
                       </div>
                       <div>
                <label>Edad: </label>
                <input type="text" name="edad" value="${cliente.edad}"
                       placeholder="Edad del cliente"/>
                       </div>
                       <div>
                           <input type="submit" value="Guardar"/>
                       </div>
            </fieldset>
        </form>
    </body>
</html>
