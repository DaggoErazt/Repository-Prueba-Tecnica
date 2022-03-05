<%-- 
    Document   : Facturacion
    Created on : 2/03/2022, 10:47:48 AM
    Author     : Daggo Erazt
--%>
<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<%@taglib uri="/WEB-INF/tlds/Bar_Menu" prefix="Tag_BarMenu" %>
<%@taglib uri="/WEB-INF/tlds/Facturacion" prefix="Tag_Facturacion"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="./Bootstrap/css/bootstrap.min.css" rel="stylesheet">
        <link href="./Bootstrap/css/main.css" rel="stylesheet">
        <script src="./Bootstrap/js/jquery.min.js"></script>
        <script src="./Bootstrap/js/bootstrap.min.js"></script>
                <script>
            function OperadorM(N) {
                    var Preci = document.getElementById("PrecioM"+N+"").value;
                    var Cant = document.getElementById("CantidadM"+N+"").value;
                    if (Preci < 1 || Cant < 1) {
                        alert('No puede ser menor de 1');
                    }
                    var ValorT = Preci * Cant ;
                    var Iva = document.getElementById("IvaM"+N+"").value;
                    var IvaVa = ValorT * (Iva/100);
                    var Descu = document.getElementById("DescuentoM"+N+"").value;
                    var DescT = ValorT * (Descu/100);
                    var SubT = ValorT + IvaVa - DescT;
                    document.getElementById("TotalDescuentoM"+N+"").value = DescT;
                    document.getElementById("ImpuestoM"+N+"").value = IvaVa;
                    document.getElementById("SubtotalM"+N+"").value = SubT  ;
                    var Total = 0;
                    for (var i = 0; i < N; i++) {
                        var Td = i + 1;
                       var SubTT = document.getElementById("SubtotalM"+Td+"").value;
                       Total = Total + SubTT * 1;
                    }
                    
                    
                    document.getElementById("TotalM").value = Total  ;
                }
            function Operador(N) {
                    var Preci = document.getElementById("Precio"+N+"").value;
                    var Cant = document.getElementById("Cantidad"+N+"").value;
                    if (Preci < 1 || Cant < 1) {
                        alert('No puede ser menor de 1');
                    }
                    var ValorT = Preci * Cant ;
                    var Iva = document.getElementById("Iva"+N+"").value;
                    var IvaVa = ValorT * (Iva/100);
                    var Descu = document.getElementById("Descuento"+N+"").value;
                    var DescT = ValorT * (Descu/100);
                    var SubT = ValorT + IvaVa - DescT;
                    document.getElementById("TotalDescuento"+N+"").value = DescT;
                    document.getElementById("Impuesto"+N+"").value = IvaVa;
                    document.getElementById("Subtotal"+N+"").value = SubT  ;
                    var Total = 0;
                    for (var i = 0; i < N; i++) {
                        var Td = i + 1;
                       var SubTT = document.getElementById("Subtotal"+Td+"").value;
                       Total = Total + SubTT * 1;
                    }
                    
                    
                    document.getElementById("Total").value = Total  ;
                }
            
            function agregarFilaMod(){
                var table = document.getElementById("tablaModifModif");
                var rowCount = table.rows.length;
                var rowInitial = rowCount - 3;
                var CountOption =  document.getElementById("ProductosMod").options.length;
                for (var i = 0; i < CountOption; i++) {
                    var OptionValue = Registro.Productos.options[i].value;
                    var OptionText = Registro.Productos.options[i].text;
                    var Optionss =  Optionss + '<option  value="'+OptionValue+'">'+OptionText+'</option>';
                }
                document.getElementById("ValueMod").value = rowInitial;
                document.getElementById("tablaModifModif").insertRow(rowCount).innerHTML = '<td ><select id="Productos'+rowInitial+'" class="form-control" name="Producto'+rowInitial+'" required>\n\
                                                                                        '+
                                                                                        Optionss
                                                                                       +'</select></td>\n\
                                                                                        <td ><input type="number" id="CantidadM'+rowInitial+'" onkeyup="OperadorM('+rowInitial+')" class="form-control" name="Cantidad'+rowInitial+'" required></td>\n\
                                                                                        <td ><input type="number" id="PrecioM'+rowInitial+'" onkeyup="OperadorM('+rowInitial+')" class="form-control" name="Precio'+rowInitial+'" required></td>\n\
                                                                                        <td ><input type="text" id="IvaM'+rowInitial+'"  class="form-control" name="Iva'+rowInitial+'" value="19" readonly></td>\n\
                                                                                        <td ><input type="text" id="ImpuestoM'+rowInitial+'" class="form-control" name="Impuesto'+rowInitial+'" readonly></td>     \n\
                                                                                        <td ><input type="number" id="DescuentoM'+rowInitial+'" onkeyup="OperadorM('+rowInitial+')" class="form-control" name="Descuento'+rowInitial+'" required></td>\n\
                                                                                        <td ><input type="text" id="TotalDescuentoM'+rowInitial+'" class="form-control" name="TotalDescuento'+rowInitial+'" readonly></td>\n\
                                                                                        <td ><input type="text" id="SubtotalM'+rowInitial+'" class="form-control" name="Subtotal'+rowInitial+'" readonly></td>';
              }
              function eliminarFilaMod(){
                var table = document.getElementById("tablaModifModif");
                var rowCount = table.rows.length;
                if(rowCount <= 5){
                    alert('No se puede eliminar el encabezado');
                }else {
                    table.deleteRow(rowCount -1);
                    var rows = rowCount;
                    var rowInitial = rows - 5;
                    document.getElementById("ValueMod").value = rowInitial;
                }
              }
            function agregarFila(){
                var table = document.getElementById("tablaModif");
                var rowCount = table.rows.length;
                var rowInitial = rowCount - 3;
                var CountOption =  document.getElementById("Productos").options.length;
                for (var i = 0; i < CountOption; i++) {
                    var OptionValue = Registro.Productos.options[i].value;
                    var OptionText = Registro.Productos.options[i].text;
                    var Optionss =  Optionss + '<option  value="'+OptionValue+'">'+OptionText+'</option>';
                }
                document.getElementById("ValueInset").value = rowInitial;
                document.getElementById("tablaModif").insertRow(rowCount).innerHTML = '<td ><select id="Productos'+rowInitial+'" class="form-control" name="Producto'+rowInitial+'" required>\n\
                                                                                        '+
                                                                                        Optionss
                                                                                       +'</select></td>\n\
                                                                                        <td ><input type="number" id="Cantidad'+rowInitial+'" onkeyup="Operador('+rowInitial+')" class="form-control" name="Cantidad'+rowInitial+'" required></td>\n\
                                                                                        <td ><input type="number" id="Precio'+rowInitial+'" onkeyup="Operador('+rowInitial+')" class="form-control" name="Precio'+rowInitial+'" required></td>\n\
                                                                                        <td ><input type="text" id="Iva'+rowInitial+'"  class="form-control" name="Iva'+rowInitial+'" value="19" readonly></td>\n\
                                                                                        <td ><input type="text" id="Impuesto'+rowInitial+'" class="form-control" name="Impuesto'+rowInitial+'" readonly></td>     \n\
                                                                                        <td ><input type="number" id="Descuento'+rowInitial+'" onkeyup="Operador('+rowInitial+')" class="form-control" name="Descuento'+rowInitial+'" required></td>\n\
                                                                                        <td ><input type="text" id="TotalDescuento'+rowInitial+'" class="form-control" name="TotalDescuento'+rowInitial+'" readonly></td>\n\
                                                                                        <td ><input type="text" id="Subtotal'+rowInitial+'" class="form-control" name="Subtotal'+rowInitial+'" readonly></td>';
              }
              function eliminarFila(){
                var table = document.getElementById("tablaModif");
                var rowCount = table.rows.length;
                if(rowCount <= 5){
                    alert('No se puede eliminar el encabezado');
                }else {
                    table.deleteRow(rowCount -1);
                    var rows = rowCount;
                    var rowInitial = rows - 5;
                    document.getElementById("ValueInset").value = rowInitial;
                }
              }
        </script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Facturacion</title>
    </head>
    <body>
        <Tag_BarMenu:Tag_BarMenu></Tag_BarMenu:Tag_BarMenu>
        <Tag_Facturacion:Tag_Factura></Tag_Facturacion:Tag_Factura>
    </body>
</html>
