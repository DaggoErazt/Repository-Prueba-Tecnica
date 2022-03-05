/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import ControllerJpa.DetallesFacturaJpaController;
import ControllerJpa.FacturasJpaController;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Daggo Erazt
 */
@WebServlet(name = "Facturacion", urlPatterns = {"/Facturacion"})
public class Facturacion extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            FacturasJpaController FacJpa = new  FacturasJpaController();
            DetallesFacturaJpaController DetFacJpa = new DetallesFacturaJpaController();
            int Opc = Integer.parseInt(request.getParameter("Opc"));
            int Factura; 
            int Id_Factura; 
            long Documento; 
            int ValueInset; 
            int Producto; 
            int Cantidad; 
            int Iva; 
            int Descuento; 
            float Precio; 
            float Impuesto; 
            float TotalDescuento; 
            float Subtotal; 
            float Total; 
            String Fecha; 
            String Nombre; 
            String Pago;
            List Resultado;
            boolean Result; 
            switch (Opc){
                case 1:
                   Factura = Integer.parseInt(request.getParameter("Factura"));
                   Documento = Long.parseLong(request.getParameter("Documento"));
                   Fecha = request.getParameter("Fecha");
                   Nombre = request.getParameter("Nombre");
                   Pago = request.getParameter("Pago");
                   Total = Float.parseFloat(request.getParameter("Total"));
                   Result = FacJpa.Insert(Factura, Documento, Fecha, Nombre, Pago,Total);
                   ValueInset = Integer.parseInt(request.getParameter("ValueInset"));
                    for (int i = 0; i < ValueInset; i++) {
                        int Select = i+ 1;
                        List OB_Id_Factura = FacJpa.Factura(Factura);
                        Object[] object_Factura = (Object[]) OB_Id_Factura.get(0);
                        Producto = Integer.parseInt(request.getParameter("Producto"+Select+""));
                        Cantidad = Integer.parseInt(request.getParameter("Cantidad"+Select+""));
                        Precio = Float.parseFloat(request.getParameter("Precio"+Select+""));
                        Iva = Integer.parseInt(request.getParameter("Iva"+Select+""));
                        Impuesto = Float.parseFloat(request.getParameter("Impuesto"+Select+""));
                        Descuento = Integer.parseInt(request.getParameter("Descuento"+Select+""));
                        TotalDescuento = Float.parseFloat(request.getParameter("TotalDescuento"+Select+""));
                        Subtotal = Float.parseFloat(request.getParameter("Subtotal"+Select+""));
                        Result = DetFacJpa.Insert(Integer.parseInt(object_Factura[0].toString()), Producto, Cantidad, Precio, Iva, Descuento);
                    }
                   
                    request.getRequestDispatcher("Facturacion.jsp").forward(request, response);
                break;
                case 2:
                        Id_Factura = Integer.parseInt(request.getParameter("Id_Factura"));
                        Resultado = FacJpa.Id_Factura(Id_Factura);
                        request.setAttribute("list_Factura", Resultado);
                        request.getRequestDispatcher("Facturacion.jsp").forward(request, response);
                break;
                case 3:
                        Id_Factura = Integer.parseInt(request.getParameter("Id_Factura"));
                        Result = FacJpa.Delate(Id_Factura);
                        request.getRequestDispatcher("Facturacion.jsp").forward(request, response);
                break;
            }
            
        } catch (Exception e) {
        }
{
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
