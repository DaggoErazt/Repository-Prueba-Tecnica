
package View;

import ControllerJpa.DetallesFacturaJpaController;
import ControllerJpa.FacturasJpaController;
import ControllerJpa.ProductosJpaController;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

/**
 *
 * @author Daggo Erazt
 */
public class View_Facturacion extends TagSupport{
    
    @Override
    
    public int doStartTag() throws JspException{
        JspWriter Out = pageContext.getOut();
        DetallesFacturaJpaController DetFacJpa = new DetallesFacturaJpaController();
        FacturasJpaController FacJpa = new FacturasJpaController();
        ProductosJpaController ProJpa = new ProductosJpaController();
        try {
            List list_Facturas = null;
            List list_Factura = null;
            Out.print("<tr>");
            Out.print("<td width ='15%' bgcolor='#404040'>");
            Out.print("<ul class='nav nav-pills nav-stacked'>");
            Out.print("<li class='active'><a href='Facturacion.jsp'>Factura</a></li>");
            Out.print("<hr>");
            Out.print("<li><a href='Productos.jsp'>Productos</a></li>");
            Out.print("<li><a href=''></a></li>");
            Out.print("<li><a href=''></a></li>");
            Out.print("<li><a href=''></a></li>");
            Out.print("<li><a href=''></a></li>");
            Out.print("<li><a href=''></a></li>");
            Out.print("<li><a href=''></a></li>");
            Out.print("<li><a href=''></a></li>");
            Out.print("</ul>");
            Out.print("</td>");
            Out.print("<td Width ='85%'>");
            //<editor-fold defaultstate="collapsed" desc="1. REGISTRAR">
                Out.print("<script language='Javascript'>"
                        + "function mostrar1() {"
                        + "var panel, mostrarr ;var pagina =''; panel = document.getElementById('RangoFecha');"
                        + "if(panel.style.visibility == 'hidden') {"
                        + "panel.style.visibility = 'visible';"
                        + "mostrarr = document.getElementById('mostrar');"
                        + "document.getElementById('cambiar').src='Interfaz/Contenido/Iconos/Min.png';"
                        + "document.getElementById('cambiar').title = 'Cancelar';"
                        + "}else {"
                        + "panel.style.visibility = 'hidden';"
                        + "mostrarr = document.getElementById('mostrar');"
                        + "document.getElementById('cambiar').src = 'Interfaz/Contenido/Iconos/Search.png';"
                        + "document.getElementById('cambiar').title = 'Consulta actividades';"
                        + "}"
                        + "}</script>");
                Out.print("<div style='float:left; margin: 20px;'>");
                Out.print("<a id='mostrarr' href='javascript:mostrar1();'><span id='cambiar' class='glyphicon glyphicon-plus'></span></a>");
                Out.print("</div>");
                Out.print("<fieldset id='RangoFecha' style='width: 466px;height: 380px;visibility: hidden;position: absolute;top: 150px;left:25%; background-color: #e3e1e1;'>");
                Out.print("<legend style='background-color: #428bca;'>Registar</legend>");
                Out.print("<form id='Registro' action='Facturacion?Opc=1' method='post' >");
                Out.print("<table id=\"tablaModif\"  class='table table-bordered'>");
                Out.print("<tr>");
                Out.print("<th colspan='2'># Factuta</th>");
                Out.print("<td colspan='2'><input type='number' class='form-control' name='Factura' required></td>");
                Out.print("<th colspan='1'>Documento</th>");
                Out.print("<td colspan='3'><input type='number' class='form-control' name='Documento' required></td>");
                Out.print("</tr>");
                Out.print("<tr>");
                Out.print("<th colspan='2'>Fecha</th>");
                Out.print("<td colspan='2'><input type='date' class='form-control' name='Fecha' required></td>");
                Out.print("<th colspan='1'>Nombre</th>");
                Out.print("<td colspan='3'><input type='text' class='form-control' name='Nombre' required></td>");
                Out.print("</tr>");
                Out.print("<tr>");
                Out.print("<th colspan='2'>Tipo Pago</th>");
                Out.print("<td colspan='2'>");
                Out.print("<select class='form-control' name='Pago' required>");
                Out.print("<option value=''>Seleccione Pago</option>");
                Out.print("<option value='Efectivo'>Efectivo</option>");
                Out.print("<option value='Tarjeta Credito'>Tarjeta Credito</option>");
                Out.print("<option value='Tarjeta Debito'>Tarjeta Debito</option>");
                Out.print("</select>");
                Out.print("</td>");
                Out.print("<td colspan='4'><input  type='hidden' value='1' id=\"ValueInset\" style='display: none;'  name='ValueInset' ></td>");
                Out.print("</tr>");
                Out.print("<tr>");
                Out.print("<th >Producto</th>");
                Out.print("<th >Cantidad</th>");
                Out.print("<th >Precio Unitario</th>");
                Out.print("<th >Iva %</th>");
                Out.print("<th >Total Impuesto</th>");
                Out.print("<th >Descuento %</th>");
                Out.print("<th >Total Descuento</th>");
                Out.print("<th >Subtotal</th>");
                Out.print("</tr>");
                Out.print("<tr>");
                Out.print("<td>");
                Out.print("<select id='Productos' class='form-control' name='Producto1' required>");
                Out.print("<option  value=''>Seleccione Pago</option>");
                List list_Productos = ProJpa.Productos();
                if (list_Productos != null) {
                    for (int i = 0; i < list_Productos.size(); i++) {
                        Object[] object_Producto = (Object[]) list_Productos.get(i);
                        int OptionCount = i + 1;
                        if (0 != Integer.parseInt(object_Producto[2].toString())) {
                            Out.print("<option id='Op"+OptionCount+"' value='"+object_Producto[0]+"'>"+object_Producto[1]+"</option>");
                        }
                    }
                }
                Out.print("</select>");
                Out.print("</td>");
                Out.print("<td ><input type='number' onkeyup=\"Operador(1)\" class='form-control' id='Precio1' name='Precio1' required></td>");
                Out.print("<td ><input type='number' onkeyup=\"Operador(1)\" class='form-control' id='Cantidad1' name='Cantidad1' required></td>");
                Out.print("<td ><input type='text' class='form-control' id='Iva1' name='Iva1' value='19' readonly></td>");
                Out.print("<td ><input type='text' class='form-control' id='Impuesto1' name='Impuesto1' readonly></td>");
                Out.print("<td ><input type='number' onkeyup=\"Operador(1)\" class='form-control'  id='Descuento1' name='Descuento1' required></td>");
                Out.print("<td ><input type='text' class='form-control' id='TotalDescuento1' name='TotalDescuento1' readonly></td>");
                Out.print("<td ><input type='text' class='form-control' id='Subtotal1' name='Subtotal1' readonly></td>");
                Out.print("</tr>");
                Out.print("</table>");
                Out.print("<table  class='table table-bordered'>");
                Out.print("<tr>");
                Out.print("<td colspan='1'></td>");
                Out.print("<td colspan='1'></td>");
                Out.print("<td colspan='1'><button type='submit' class='btn btn-success'><span id='cambiar' class='glyphicon glyphicon-floppy-disk'></span></button></td>");
                Out.print("<td colspan='2'></td>");
                Out.print("<th >Total</th>");
                Out.print("<td ><input type='text' id='Total' class='form-control' name='Total' readonly></td>");
                Out.print("</tr>");
                Out.print("</table>");
                Out.print("</form>");
                Out.print("<button type=\"button\" onclick=\"eliminarFila()\" class='btn btn-danger'><span id='cambiar' class='glyphicon glyphicon-remove-sign'></span></button>");
                Out.print("<button type=\"button\" onclick=\"agregarFila()\" class='btn btn-primary'><span id='cambiar' class='glyphicon glyphicon-plus-sign'></span></button>");
                Out.print("</fieldset>");
//</editor-fold>
            //<editor-fold defaultstate="collapsed" desc="2. MODIFICAR">
            list_Factura = (List) pageContext.getRequest().getAttribute("list_Factura");
            if (list_Factura != null) {
                Out.print("<script language='Javascript'>"
                        + "function mostrar2() {"
                        + "var panel, mostrarr ;var pagina =''; panel = document.getElementById('RangoFecha1');"
                        + "if(panel.style.visibility == 'hidden') {"
                        + "panel.style.visibility = 'visible';"
                        + "mostrrarr = document.getElementById('mostrar');"
                        + "document.getElementById('cambiar').src='Interfaz/Contenido/Iconos/Min.png';"
                        + "document.getElementById('cambiar').title = 'Cancelar';"
                        + "}else {"
                        + "panel.style.visibility = 'hidden';"
                        + "mostrrarr = document.getElementById('mostrar');"
                        + "document.getElementById('cambiar').src = 'Interfaz/Contenido/Iconos/Search.png';"
                        + "document.getElementById('cambiar').title = 'Consulta actividades';"
                        + "}"
                        + "}</script>");
                Out.print("<div style='float:left; margin: 20px;'>");
                Out.print("</div>");
                Out.print("<fieldset id='RangoFecha1' style='width:16%;visibility: visible;position: absolute;top: 150px;left: 18%; background-color: #e3e1e1;'>");
                Out.print("<legend style='background-color: #428bca;'>Detalle Factura</legend>");
                Object[] object_Factura = (Object[]) list_Factura.get(0);
                Out.print("<form action='Productos?Opc=4' method='post' >");
                Out.print("<table id=\"tablaModifModif\"  class='table table-bordered'>");
                Out.print("<tr>");
                Out.print("<th colspan='2'># Factuta</th>");
                Out.print("<td colspan='2'><input type='number' value='"+object_Factura[1]+"' class='form-control' name='Factura' required></td>");
                Out.print("<th colspan='1'>Documento</th>");
                Out.print("<td colspan='3'><input type='number' value='"+object_Factura[4]+"' class='form-control' name='Documento' required></td>");
                Out.print("</tr>");
                Out.print("<tr>");
                Out.print("<th colspan='2'>Fecha</th>");
                Out.print("<td colspan='2'><input type='date' value='"+object_Factura[2]+"' class='form-control' name='Fecha' required></td>");
                Out.print("<th colspan='2'>Nombre</th>");
                Out.print("<td colspan='3'><input type='text' value='"+object_Factura[5]+"' class='form-control' name='Nombre' required></td>");
                Out.print("</tr>");
                Out.print("<tr>");
                Out.print("<th colspan='2'>Tipo Pago</th>");
                Out.print("<td colspan='2'>");
                Out.print("<select class='form-control' name='Pago' required>");
                Out.print("<option value=''>Seleccione Pago</option>");
                if (object_Factura[2].equals("Efectivo")) {
                    Out.print("<option value='Efectivo' selected>Efectivo</option>");
                    Out.print("<option value='Tarjeta Credito'>Tarjeta Credito</option>");
                } if(object_Factura[2].equals("Tarjeta Credito")) {
                    Out.print("<option value='Efectivo'>Efectivo</option>");
                    Out.print("<option value='Tarjeta Credito' selected>Tarjeta Credito</option>");
                    Out.print("<option value='Tarjeta Debito'>Tarjeta Debito</option>");
                } else {
                    Out.print("<option value='Efectivo'>Efectivo</option>");
                    Out.print("<option value='Tarjeta Credito' >Tarjeta Credito</option>");
                    Out.print("<option value='Tarjeta Debito' selected>Tarjeta Debito</option>");
                }
                Out.print("</select>");
                Out.print("</td>");
                Out.print("<td colspan='9'><input  type='hidden' value='1' id=\"ValueMod\" style='display: none;'  name='ValueInset' ></td>");
                Out.print("</tr>");
                Out.print("<tr>");
                Out.print("<th >Producto</th>");
                Out.print("<th >Cantidad</th>");
                Out.print("<th >Precio Unitario</th>");
                Out.print("<th >Iva %</th>");
                Out.print("<th >Total Impuesto</th>");
                Out.print("<th >Descuento %</th>");
                Out.print("<th >Total Descuento</th>");
                Out.print("<th >Subtotal</th>");
                Out.print("<th >Eliminar</th>");
                Out.print("</tr>");
                Out.print("<tr>");
                List list_Destalle = DetFacJpa.Id_Factura(Integer.parseInt(object_Factura[0].toString()));
                double TotalT = 0;
                for (int i = 0; i < list_Destalle.size(); i++) {
                    Object[]  objDetaFac = (Object[]) list_Destalle.get(i);
                Out.print("<td>");
                Out.print("<select id='ProductosMod' class='form-control' name='Producto1' required>");
                Out.print("<option  value=''>Seleccione Pago</option>");
                list_Productos = ProJpa.Productos();
                if (list_Productos != null) {
                    for (int j = 0; j < list_Productos.size(); j++) {
                        Object[] object_Producto = (Object[]) list_Productos.get(j);
                        int OptionCount = j + 1;
                        if (0 != Integer.parseInt(object_Producto[2].toString())) {
                            if ( object_Producto[0] == objDetaFac[2] ) {
                                Out.print("<option id='Op"+OptionCount+"' value='"+object_Producto[0]+"' Selected>"+object_Producto[1]+"</option>");
                            } else {
                                Out.print("<option id='Op"+OptionCount+"' value='"+object_Producto[0]+"'>"+object_Producto[1]+"</option>");
                            }
                        }
                    }
                }
                Out.print("</select>");
                int iva = 19;
                float Canti = Float.parseFloat(objDetaFac[4].toString());
                int Val = Integer.parseInt(objDetaFac[3].toString());
                float ToTalCan = Canti * Val;
                double TImpu = ToTalCan * 0.19;
                float Descu = Float.parseFloat(objDetaFac[6].toString());
                float DescuT = (Canti * Val) * (Descu/100);
                double SubTT = (Canti * Val) + TImpu - DescuT;
                Out.print("</td>");
                Out.print("<td ><input type='text' value='"+Canti+"' onkeyup=\"OperadorM(1)\" class='form-control' id='CantidadM1' name='Cantidad1' readonly></td>");
                Out.print("<td ><input type='text' value='"+Val+"' id='PrecioM1' onkeyup='OperadorM(1)' class='form-control' name='Precio1' readonly></td>");                                                                             
                Out.print("<td ><input type='text' value='"+iva+"' id='IvaM1'  class='form-control' name='Iva1' value='19' readonly></td>");
                Out.print("<td ><input type='text' value='"+TImpu+"' id='ImpuestoM1' class='form-control' name='Impuesto1' readonly></td>");
                Out.print("<td ><input type='text' value='"+Descu+"' id='DescuentoM1' onkeyup='OperadorM(1)' class='form-control' name='Descuento1' readonly></td>");
                Out.print("<td ><input type='text' value='"+DescuT+"' id='TotalDescuentoM1' class='form-control' name='TotalDescuento1' readonly></td>");
                Out.print("<td ><input type='text' value='"+SubTT+"' id='SubtotalM1' class='form-control' name='Subtotal1' readonly></td>");
                if (i == 0) {
                    Out.print("<td><center><button type=\"button\" class='btn btn-danger'><span class='glyphicon glyphicon-trash'></span></a></center></td>");
                } else {
                    Out.print("<td><a href='Productos?Opc=5&Id_Producto="+objDetaFac[0]+"'><center><button type=\"button\" class='btn btn-danger'><span id='cambiar' class='glyphicon glyphicon-trash'></span></button></a></center></td>");
                }
                Out.print("</tr>");
                TotalT = TotalT + SubTT;
                }
                Out.print("</table>");
                Out.print("<table  class='table table-bordered'>");
                Out.print("<tr>");
                Out.print("<td colspan='1'></td>");
                Out.print("<td colspan='1'></td>");
//                Out.print("<td colspan='1'><button type='submit' class='btn btn-success'><span id='cambiar' class='glyphicon glyphicon-floppy-disk'></span></button></td>");
                Out.print("<td colspan='2'></td>");
                Out.print("<th >Total</th>");
                Out.print("<td ><input type='text' id='TotalM' value='"+TotalT+"' class='form-control' name='TotalM' readonly></td>");
                Out.print("</tr>");
                Out.print("</table>");
                Out.print("</form>");
//                Out.print("<button type=\"button\" onclick=\"eliminarFilaMod()\" class='btn btn-danger'><span id='cambiar' class='glyphicon glyphicon-remove-sign'></span></button>");
//                Out.print("<button type=\"button\" onclick=\"agregarFilaMod()\" class='btn btn-primary'><span id='cambiar' class='glyphicon glyphicon-plus-sign'></span></button>");
                Out.print("</fieldset>");
            }
//</editor-fold>
            Out.print("<h3>Facturacion</h3>");
            Out.print("<table class='table table-hover'>");
            list_Facturas = FacJpa.Facturas();
            if (list_Facturas != null) {
            Out.print("<tr>");
            Out.print("<th><center># Factura</center></th>");
            Out.print("<th><center>Fecha</center></th>");
            Out.print("<th><center>Tipo Pago</center></th>");
            Out.print("<th><center>Dcumento Cliente</center></th>");
            Out.print("<th><center>Nombre Cliente</center></th>");
            Out.print("<th><center>Total</center></th>");
            Out.print("<th><center>Detalle</center></th>");
            Out.print("<th><center>Eliminar</center></th>");
            Out.print("</tr>");  
                for (int i = 0; i < list_Facturas.size(); i++) {
                    Out.print("<tr>");  
                    Object[] Objet_Factura = (Object[]) list_Facturas.get(i);
                        Out.print("<td>"+Objet_Factura[1]+"</td>");
                        Out.print("<td>"+Objet_Factura[2]+"</td>");
                        Out.print("<td>"+Objet_Factura[3]+"</td>");
                        Out.print("<td>"+Objet_Factura[4]+"</td>");
                        Out.print("<td>"+Objet_Factura[5]+"</td>");
                        Out.print("<td>"+Objet_Factura[6]+"</td>");
                        if (list_Factura != null) {
                            Out.print("<td><a href='Facturacion.jsp'><center><button type=\"button\" class=\"btn btn-info\"><span id='cambiar' class='glyphicon glyphicon-th-list'></span></button></td>");
                        }else{
                            Out.print("<td><a href='Facturacion?Opc=2&Id_Factura="+Objet_Factura[0]+"'><center><button type=\"button\" class=\"btn btn-info\"><span id='cambiar' class='glyphicon glyphicon-th-list'></span></button></td>");
                        }
                        Out.print("<td><a href='Facturacion?Opc=3&Id_Factura="+Objet_Factura[0]+"'><center><button type=\"button\" class='btn btn-danger'><span id='cambiar' class='glyphicon glyphicon-trash'></span></button></a></center></td>");
                    Out.print("</tr>");
                }
            } else {
                Out.print("<center>");
                    Out.print("<h3>Lista Vacia</h3>");
                Out.print("</center>");
            }
            Out.print("</table class='table table-hover'>");
            Out.print("</td>");
            Out.print("</tr>");
            Out.print("</table>");
            Out.print("<footer>");
            Out.print("<p bgcolor='#404040'>");
            Out.print("<center>");
            Out.print("Copyright © 2016 Novain Proyect");
            Out.print("</center>");
            Out.print("</p>");
            Out.print("</footer>");
            Out.print("</div>");
        } catch (Exception e) {
            Logger.getLogger(View_Productos.class.getName()).log(Level.SEVERE, null, e);
        }
        return super.doStartTag();
    }
    
    
}
