<%-- 
    Document   : CreationBD
    Created on : 2013-01-30, 14:15:12
    Author     : 0910062
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>

        <h1>The SQL Gateway</h1>
        <form action="CreationBaseDeDonnees" method="post">
            <input type="submit" value="Créer">
        </form>

        <p>
            <b> Résultat : </b><br>
            ${Resultat}
        </p>
    </body>
</html>
