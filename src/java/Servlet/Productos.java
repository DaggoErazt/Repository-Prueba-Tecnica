/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import ControllerJpa.ProductosJpaController;
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
@WebServlet(name = "Productos", urlPatterns = {"/Productos"})
public class Productos extends HttpServlet {

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
            ProductosJpaController ProJpa = new ProductosJpaController();
            int Opc = Integer.parseInt(request.getParameter("Opc"));
            int Id_Producto;
            int Estado;
            List Resultado;
            String Productos;
            boolean Result;
            switch(Opc) {
                case 1 :
                   Productos = request.getParameter("Producto");
                   Result = ProJpa.Insert(Productos);
                   request.getRequestDispatcher("Productos.jsp").forward(request, response);
                break;
                case 2 :
                    Id_Producto = Integer.parseInt(request.getParameter("Id_Producto"));
                    Estado = Integer.parseInt(request.getParameter("Estado"));
                    if (Estado != 0) {
                    Result = ProJpa.Estado(Id_Producto, 0);
                    }else{
                    Result = ProJpa.Estado(Id_Producto, 1);
                    }
                    request.getRequestDispatcher("Productos.jsp").forward(request, response);
                break;
                case 3 :
                    Id_Producto = Integer.parseInt(request.getParameter("Id_Producto"));
                    Resultado = ProJpa.Id_Producto(Id_Producto);
                    request.setAttribute("list_Producto", Resultado);
                    request.getRequestDispatcher("Productos.jsp").forward(request, response);
                break;
                case 4 :
                   Id_Producto = Integer.parseInt(request.getParameter("Id_Producto"));
                   Productos = request.getParameter("Producto");
                   Result = ProJpa.Update(Id_Producto,Productos);
                   request.getRequestDispatcher("Productos.jsp").forward(request, response);
                break;
                case 5 :
                   Id_Producto = Integer.parseInt(request.getParameter("Id_Producto"));
                   Result = ProJpa.Delate(Id_Producto);
                   request.getRequestDispatcher("Productos.jsp").forward(request, response); 
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
