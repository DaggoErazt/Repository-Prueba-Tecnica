
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
@WebServlet(name = "DetalleFactura", urlPatterns = {"/DetalleFactura"})
public class DetalleFactura extends HttpServlet {

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
        try {
            FacturasJpaController FacJpa = new  FacturasJpaController();
            DetallesFacturaJpaController DetFacJpa = new DetallesFacturaJpaController();
            int Opc = Integer.parseInt(request.getParameter("Opc"));
            int Factura; 
            int Id_Detalle; 
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
                    Id_Detalle = Integer.parseInt(request.getParameter("Id_Detalle"));
                    Result = DetFacJpa.Delate(Id_Detalle);
                    request.getRequestDispatcher("Facturacion.jsp").forward(request, response);
                break;
                case 2:
                break;
                case 3:
                break;
            }
            
        } catch (Exception e) {
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
