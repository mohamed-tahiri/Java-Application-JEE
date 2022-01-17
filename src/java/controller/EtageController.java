package controller;

import beans.Etage;
import beans.Section;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import service.EtageService;
import service.SectionService;

/**
 *
 * @author Tahiri
 */
@WebServlet(urlPatterns = {"/EtageController"})
public class EtageController extends HttpServlet {

    private SectionService ss = new SectionService();
    private EtageService es = new EtageService();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        if (request.getParameter("op") != null) {
            if (request.getParameter("op").equals("load")) {
                response.setContentType("application/json");
                List<Etage> etages = es.findAll();
                Gson json = new Gson();
                response.getWriter().write(json.toJson(etages));

            } else if (request.getParameter("op").equals("delete")) {

                int id = Integer.parseInt(request.getParameter("id"));

                List<Section> sections = ss.findAllByNumeroEtage(es.findById(id).getNumero());

                for (Section section : sections) {
                    ss.delete(section);
                }

                es.delete(es.findById(id));

                response.setContentType("application/json");
                List<Etage> etages = es.findAll();
                Gson json = new Gson();
                response.getWriter().write(json.toJson(etages));

            } else if (request.getParameter("op").equals("modifier")) {

                int id = Integer.parseInt(request.getParameter("id"));
                Etage etage = es.findById(id);

                response.setContentType("application/json");
                Gson json = new Gson();
                response.getWriter().write(json.toJson(etage));

            } else if (request.getParameter("op").equals("Mod")) {

                int id = Integer.parseInt(request.getParameter("id"));
                int numero = Integer.parseInt(request.getParameter("numero"));
                int nbrSection = Integer.parseInt(request.getParameter("nbrSection"));

                Etage e1 = es.findByNumero(numero);
                Etage etage = es.findById(id);

                if (e1 == null || etage.getNumero() == numero) {
                    etage.setNumero(numero);
                    etage.setNbr_section(nbrSection);

                    es.update(etage);
                    response.setContentType("application/json");
                    List<Etage> machines = es.findAll();
                    Gson json = new Gson();

                    response.getWriter().write(json.toJson(machines));

                } else if (e1 != null) {
                    String msg = "2";
                    response.setContentType("application/json");
                    Gson json = new Gson();
                    response.getWriter().write(json.toJson(msg));
                }
            } else if (request.getParameter("op").equals("generer")) {
                int id_Etage = Integer.parseInt(request.getParameter("id_Etage"));
                int nbr_Section = Integer.parseInt(request.getParameter("nbr_Section"));
                int idParking = Integer.parseInt(request.getParameter("idParking"));

                List<Section> sections = ss.findAllByNumeroEtage(id_Etage);
                if (sections.isEmpty()) {
                    for (int i = 0; i < nbr_Section; i++) {
                        if (id_Etage == 1) {
                            ss.create(new Section("A" + (i + 1), id_Etage, idParking));
                        } else if (id_Etage == 2) {
                            ss.create(new Section("B" + (i + 1), id_Etage, idParking));
                        } else if (id_Etage == 3) {
                            ss.create(new Section("C" + (i + 1), id_Etage, idParking));
                        } else if (id_Etage == 4) {
                            ss.create(new Section("D" + (i + 1), id_Etage, idParking));
                        } else if (id_Etage == 5) {
                            ss.create(new Section("E" + (i + 1), id_Etage, idParking));
                        }
                    }

                    String msg = "1";
                    response.setContentType("application/json");
                    Gson json = new Gson();
                    response.getWriter().write(json.toJson(msg));
                } else {
                    String msg = "2";
                    response.setContentType("application/json");
                    Gson json = new Gson();
                    response.getWriter().write(json.toJson(msg));

                }

            }

        } else {
            int numero = Integer.parseInt(request.getParameter("numero"));
            int nbrSection = Integer.parseInt(request.getParameter("nbrSection"));
            int idParking = Integer.parseInt(request.getParameter("idParking"));

            Etage e1 = es.findByNumero(numero);

            if (e1 == null) {
                es.create(new Etage(numero, nbrSection, idParking));
                response.setContentType("application/json");
                List<Etage> etages = es.findAllByParking(idParking);
                Gson json = new Gson();

                response.getWriter().write(json.toJson(etages));
            } else if (e1 != null) {
                String msg = "2";
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
