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
public class View_Productos extends TagSupport{
    
    @Override
    
    public int doStartTag() throws JspException{
        JspWriter Out = pageContext.getOut();
        DetallesFacturaJpaController DetFacJpa = new DetallesFacturaJpaController();
        ProductosJpaController ProJpa = new ProductosJpaController();
        List list_Producto = null;
        try {
            Out.print("<tr>");
            Out.print("<td width ='15%' bgcolor='#404040'>");
            Out.print("<ul class='nav nav-pills nav-stacked'>");
            Out.print("<li><a href='Facturacion.jsp'>Factura</a></li>");
            Out.print("<hr>");
            Out.print("<li class='active'><a href='Productos.jsp'>Productos</a></li>");
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
                Out.print("<fieldset id='RangoFecha' style='width:16%;visibility: hidden;position: absolute;top: 150px;left:25%; background-color: #e3e1e1;'>");
                Out.print("<legend style='background-color: #428bca;'>Registar</legend>");
                Out.print("<form action='Productos?Opc=1' method='post' >");
                Out.print("<b>Producto</b><input type='text' class='form-control' name='Producto'  >");
                Out.print("<button type='submit' class='btn btn-success'><span id='cambiar' class='glyphicon glyphicon-floppy-disk'></span></button>");
                Out.print("</form>");
                Out.print("</fieldset>");
//</editor-fold>
            //<editor-fold defaultstate="collapsed" desc="2. MODIFICAR">
            list_Producto = (List) pageContext.getRequest().getAttribute("list_Producto");
            if (list_Producto != null) {
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
                Out.print("<fieldset id='RangoFecha1' style='width:16%;visibility: visible;position: absolute;top: 150px;left:65%; background-color: #e3e1e1;'>");
                Out.print("<legend style='background-color: #428bca;'>Modificar</legend>");
                Object[] Object_Producto = (Object[]) list_Producto.get(0);
                Out.print("<form action='Productos?Opc=4' method='post' >");
                Out.print("<input type='hidden' name='Id_Producto' value='"+Object_Producto[0]+"'>");
                Out.print("<b>Producto</b><input type='text' class='form-control' name='Producto' value='"+Object_Producto[1]+"'>");
                Out.print("<button type='submit' class='btn btn-success'><span id='cambiar' class='glyphicon glyphicon-floppy-disk'></span></button>");
                Out.print("</form>");
                Out.print("</fieldset>");
            }
//</editor-fold>
            Out.print("<h3>Productos</h3>");
            Out.print("<table class='table table-hover'>");
            List list_Productos = ProJpa.Productos();
            if (list_Productos != null) {
            Out.print("<tr>");
            Out.print("<th>Producto</th>");
            Out.print("<th><center>Estado</center></th>");
            Out.print("<th><center>Modificar</center></th>");
            Out.print("<th><center>Eliminar</center></th>");
            Out.print("</tr>");  
                for (int i = 0; i < list_Productos.size(); i++) {
                    Out.print("<tr>");  
                    Object[] Objet_Producto = (Object[]) list_Productos.get(i);
                        Out.print("<td>"+Objet_Producto[1]+"</td>");
                        if (0 != Integer.parseInt(Objet_Producto[2].toString())) {
                        Out.print("<td><a href='Productos?Opc=2&Id_Producto="+Objet_Producto[0]+"&Estado="+Objet_Producto[2]+"'><center><button type=\"button\" class=\"btn btn-success\"><span id='cambiar' class='glyphicon glyphicon-ok'></span></button></a></center></td>");
                        }else{
                        Out.print("<td><a href='Productos?Opc=2&Id_Producto="+Objet_Producto[0]+"&Estado="+Objet_Producto[2]+"'><center><button type=\"button\" class=\"btn btn-warning\"><span id='cambiar' class='glyphicon glyphicon-minus'></span></button></a></center></td>");
                        }
                        if (list_Producto != null) {
                            Out.print("<td><a href='Productos.jsp'><center><button type=\"button\" class=\"btn btn-primary\"><span id='cambiar' class='glyphicon glyphicon-pencil'></span></button></a></center></td>");
                        }else{
                            Out.print("<td><a href='Productos?Opc=3&Id_Producto="+Objet_Producto[0]+"'><center><button type=\"button\" class=\"btn btn-primary\"><span id='cambiar' class='glyphicon glyphicon-pencil'></span></button></a></center></td>");
                        }
                        Out.print("<td><a href='Productos?Opc=5&Id_Producto="+Objet_Producto[0]+"'><center><button type=\"button\" class='btn btn-danger'><span id='cambiar' class='glyphicon glyphicon-trash'></span></button></a></center></td>");
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
