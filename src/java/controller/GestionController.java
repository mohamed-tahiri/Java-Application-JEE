package controller;

import beans.Etage;
import beans.Place;
import beans.Section;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import service.EtageService;
import service.PlaceService;
import service.SectionService;

/**
 *
 * @author Tahiri
 */
@WebServlet(name = "GestionController", urlPatterns = {"/GestionController"})
public class GestionController extends HttpServlet {

    private EtageService es = new EtageService();
    private SectionService ss = new SectionService();
    private PlaceService ps = new PlaceService();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        if (request.getParameter("op") != null) {
            if (request.getParameter("op").equals("load")) {
                response.setContentType("application/json");
                List<Etage> etages = es.findAll();

                List<Etage> etagesEmpty = new ArrayList<Etage>();
                for (Etage e : etages) {
                    if (es.EtageisEmpty(e)) {
                        etagesEmpty.add(e);
                    }
                }

                Gson json = new Gson();
                response.getWriter().write(json.toJson(etagesEmpty));

            } else if (request.getParameter("op").equals("loadSection")) {
                
                int id = Integer.parseInt(request.getParameter("id"));
                
                List<Section> sections = ss.findAllByNumeroEtage(id);

                System.out.println(sections);

                List<Section> sectionsEmpty = new ArrayList<Section>();
                for (Section s : sections) {
                    if (ss.SectionisEmpty(s)) {
                        sectionsEmpty.add(s);
                    }
                }

                response.setContentType("application/json");

                Gson json = new Gson();
                response.getWriter().write(json.toJson(sectionsEmpty));
            
            } else if (request.getParameter("op").equals("loadPlace")) {
                int etage = Integer.parseInt(request.getParameter("etage"));
                String section = request.getParameter("section");
                
                Etage etage1 = es.findByNumero(etage);
                
                List<Place> places = ps.findAllBySection(section, etage, etage1.getId_parking());

                System.out.println(places);

                response.setContentType("application/json");

                Gson json = new Gson();
                response.getWriter().write(json.toJson(places));
                
            } else if (request.getParameter("op").equals("choisiPlace")) {
                int place = Integer.parseInt(request.getParameter("place"));
                
                Place place1 = ps.findById(place);
                
                place1.setEtat(true);
                
                System.out.println(place1);
                
                ps.update(place1);
                
                String msg = "1";
                response.setContentType("application/json");
                Gson json = new Gson();
                response.getWriter().write(json.toJson(msg));
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
