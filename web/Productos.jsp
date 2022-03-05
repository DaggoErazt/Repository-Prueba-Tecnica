<%-- 
    Document   : Productos
    Created on : 2/03/2022, 09:29:55 PM
    Author     : Daggo Erazt
--%>
<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<%@taglib uri="/WEB-INF/tlds/Bar_Menu" prefix="Tag_BarMenu" %>
<%@taglib uri="/WEB-INF/tlds/Productos" prefix="Tag_Productos" %>
<!DOCTYPE html>
<html>
    <head>
        <link href="./Bootstrap/css/bootstrap.min.css" rel="stylesheet">
        <link href="./Bootstrap/css/main.css" rel="stylesheet">
        <script src="./Bootstrap/js/jquery.min.js"></script>
        <script src="./Bootstrap/js/bootstrap.min.js"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Produccion</title>
    </head>
    <body>
        <Tag_BarMenu:Tag_BarMenu></Tag_BarMenu:Tag_BarMenu>
        <Tag_Productos:Tag_Productos></Tag_Productos:Tag_Productos>
    </body>
</html>
