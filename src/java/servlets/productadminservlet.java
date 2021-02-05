/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Product;
import model.User;
import service.ProductService;
import service.UserService;

/**
 *
 * @author cilli
 */
public class productadminservlet extends HttpServlet {

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
     
       String action = request.getParameter("action");
        ProductService pServ = new ProductService();
       
        String url = null;
        if (action == null)
            request.getRequestDispatcher("/Home").forward(request, response);
        if (action.equals("listProduct")){
            ArrayList<Product> product = pServ.getAllProduct();
            request.setAttribute("product", product);
            request.getRequestDispatcher("/userAdmin.jsp").forward(request, response);
        }
        if (action.equals("add")){
            request.getRequestDispatcher("/addproduct.jsp").forward(request, response);
        }
        if (action.equals("insertProduct")){
            insertProduct(request,response);
            ArrayList<Product> product = pServ.getAllProduct();
            request.setAttribute("product", product);
            request.getRequestDispatcher("/productadmin.jsp").forward(request, response);
        }
        else
            request.getRequestDispatcher("/Home").forward(request, response);
       
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

   private void insertProduct(HttpServletRequest request, HttpServletResponse response){
        
        String name = request.getParameter("name");
        String description = request.getParameter("description");
        String price = request.getParameter("price");
        String imageLocation = request.getParameter("imageLocation");
        String category = request.getParameter("category");
        
        double dPrice = Double.parseDouble(price);
        
        Product newProduct = new Product();
        newProduct.setName(name);
        newProduct.setDescription(description);
        newProduct.setPrice(dPrice);
        newProduct.setImageLocation(imageLocation);
        newProduct.setCategory(category);
        
        ProductService pServ = new ProductService();
        pServ.insertProduct(newProduct);
        
        
        
    }
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
