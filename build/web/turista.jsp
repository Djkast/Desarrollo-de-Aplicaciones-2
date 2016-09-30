<%-- 
    Document   : producto
    Created on : 29-sep-2016, 12:19:40
    Author     : Omar Uriel Rodriguez Castañeda
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> Turistas </title>
    </head>
    <body>
        <form action="TuristaController" method="post">
            <fieldset>
                <legend>Formulario de registro</legend>
                                
                <div>
                <label for="id_turista">Id turista:</label>
                <input type="text" name="id_turista"
                       value="${turista.idTurista}"
                       readonly="readonly" 
                       placeholder="Id de turista"/>
                </div>
                
                <div>
                <label for="nombre">Nombre:</label>
                <input type="text" name="nombre"
                       value="${turista.nombre}"
                       placeholder="nombre"/>
                </div>
                
                <div>
                <label for="telefono">Observaciones de servicios:</label>
                <input type="text" name="telefono"
                       value="${turista.telefono}"
                       placeholder="telefono"/>
                </div>
                
                <div>
                <label for="pais">pais</label>
                <input type="text" name="pais"
                       value="${turista.pais}"
                       placeholder="Pais"/>
                </div>
                       
                <div>
                <label for="email">pais</label>
                <input type="text" name="email"
                       value="${turista.email}"
                       placeholder="email"/>
                </div>
                
                 <div>
                     <input type="submit" 
                       value="Guardar" />
                </div>
            </fieldset>
            
        </form>
    </body>
</html>
