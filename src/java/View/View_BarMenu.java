/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

/**
 *
 * @author Daggo Erazt
 */
public class View_BarMenu extends TagSupport{
    
        
    @Override
    
    public int doStartTag() throws JspException{
        JspWriter Out = pageContext.getOut();
        try {
            Out.print("<div class='container'>");
            Out.print("<header>");
            Out.print("<center>");
            Out.print("Imagen");
            Out.print("</center>");
            Out.print("</header>");
            Out.print("<table class='table table-bordered'>");
            Out.print("<tr>");
            Out.print("<td colspan='2'>");
            Out.print("<nav class='navbar navbar-inverse' role='navigation'>");
            Out.print("<div class='navbar-header'>");
            Out.print("<button type='button' class='navbar-toggle' data-toggle='collapse' data-target='.navbar-ex1-collapse'>");
            Out.print("<span class='sr-only'>Desplegar navegación</span>");
            Out.print("<span class='icon-bar'></span>");
            Out.print("<span class='icon-bar'></span>");
            Out.print("<span class='icon-bar'></span>");
            Out.print("</button>");
            Out.print("<a class='navbar-brand' href='#'>Prueba Tecnica</a>");
            Out.print("</div>");
            Out.print("<div class='collapse navbar-collapse navbar-ex1-collapse'>");
            Out.print("<ul class='nav navbar-nav navbar-right'>");
            Out.print("<li class='dropdown'>");
            Out.print("<a href='#' class='dropdown-toggle' data-toggle='dropdown'>");
            Out.print("<p class='navbar-text'>Conectado'Usuario'</p> <b class='caret'></b>");
            Out.print("</a>");
            Out.print("<ul class='dropdown-menu'>");
            Out.print("<li><a href='#'>Correo</a></li>");
            Out.print("<li><a href='#'>Perfil</a></li>");
            Out.print("<li class='divider'></li>");
            Out.print("<li><a href='Salir.jsp'>Salir</a></li>");
            Out.print("</ul>");
            Out.print("</li>");
            Out.print("</ul>");
            Out.print("</div>");
            Out.print("</nav>");
            Out.print("</td>");
            Out.print("</tr>");
        } catch (Exception e) {
            Logger.getLogger(View_Productos.class.getName()).log(Level.SEVERE, null, e);
        }
        return super.doStartTag();
    }
 
    
}
