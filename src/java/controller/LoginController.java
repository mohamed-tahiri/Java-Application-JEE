/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import beans.Admin;
import beans.Parking;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import service.AdminService;
import service.ParkingService;

/**
 *
 * @author pc
 */
@WebServlet(urlPatterns = {"/LoginController"})
public class LoginController extends HttpServlet {
    
    private AdminService as = new AdminService();
    private ParkingService ps = new ParkingService();
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (request.getParameter("op") != null) {
            if (request.getParameter("op").equals("login")) {
                String username = (request.getParameter("username"));
                String password = (request.getParameter("password"));
            
                Admin admin = as.Login(username, password);
               
                HttpSession session = request.getSession();
                
                if(admin != null){
                    Parking p = ps.findByNom(admin.getParking());
                    
                    session.setAttribute("email", admin.getEmail());
                    session.setAttribute("username", admin.getUsername());
                    session.setAttribute("nomParking", admin.getParking());
                    session.setAttribute("addressParking", p.getAddress());
                    session.setAttribute("idParking", p.getId());
                    
                    String msg = "1";
                    response.setContentType("application/json");
                    Gson json = new Gson();
                    response.getWriter().write(json.toJson(msg));
                }
                else
                {
                    String msg = "3";
                    response.setContentType("application/json");
                    Gson json = new Gson();
                    response.getWriter().write(json.toJson(msg));
                }
                
            }else if(request.getParameter("op").equals("signup")) {
                String username    = (request.getParameter("username"));
                String email       = (request.getParameter("email"));
                String parking     = (request.getParameter("parking"));
                String parkingAddr = (request.getParameter("parkingAddr"));
                String password    = (request.getParameter("password"));
            
               
                HttpSession session = request.getSession();
                Admin admin = new Admin(email, username, password, parking);
                Parking parking1 = ps.findByNom(parking);
                Parking park = new Parking(parking, parkingAddr);
                Admin admin1 = as.findByEmail(email);
                Admin admin2 = as.findByUsername(username);
                
                
                if(admin1 == null && admin2 == null && parking1 == null){
                    
                    as.create(admin);
                    ps.create(park);
                    
                    String msg = "1";
                    response.setContentType("application/json");
                    Gson json = new Gson();
                    response.getWriter().write(json.toJson(msg));
                }
                else if(admin1 != null)
                {
                    String msg = "2";
                    response.setContentType("application/json");
                    Gson json = new Gson();
                    response.getWriter().write(json.toJson(msg));
                }
                else if(admin2 != null)
                {
                    String msg = "3";
                    response.setContentType("application/json");
                    Gson json = new Gson();
                    response.getWriter().write(json.toJson(msg));
                }
                else if(parking1 != null)
                {
                    String msg = "4";
                    response.setContentType("application/json");
                    Gson json = new Gson();
                    response.getWriter().write(json.toJson(msg));
                }
                
            }
            
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
