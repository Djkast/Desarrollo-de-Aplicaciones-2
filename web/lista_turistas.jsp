<%-- 
    Document   : lista_productos
    Created on : 29-sep-2016, 12:18:40
    Author     : Omar Uriel Rodriguez Castañeda
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de cedulas</title>
    </head>
    <body>
        
        <table>
            <thead>  
            <tr>
                <th>Id turista</th>
                <th>Nombre</th>
                <th>telefono</th>
                <th>pais</th>
                <th>email</th>
            </tr>
            </thead>
            <tbody>
                <c:forEach var="turista" 
                           items="${turistas}">
                    <tr>
                        <td>${turista.idTurista}</td>
                        <td>${turista.nombre}</td>
                        <td>${turista.telefono}</td>
                        <td>${turista.pais}</td>
                        <td>${turista.email}</td>
                        <td><a href="TuristaController?action=cambiar&id_turista=${turista.idTurista}">Cambiar</a></td>
                        <td><a href="TuristaController?action=borrar&id_turista=${turista.idTurista}">Borrar</a></td>
                     </tr>  
                </c:forEach> 
            </tbody>
        </table>
        <p>
            <a href="TuristaController?action=agregar">
                Agregar turista
            </a>
        </p>
        
    </body>
</html>
