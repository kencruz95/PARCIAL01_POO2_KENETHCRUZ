/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.vista;

import com.sv.udb.controlador.AlumnoCtrl;
import com.sv.udb.controlador.GruposACtrl;
import com.sv.udb.controlador.GruposCtrl;
import com.sv.udb.modelo.GruposAlumnos;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Orlando Vasquez
 */
@WebServlet(name = "GruposAluServ", urlPatterns = {"/GruposAluServ"})
public class GruposAluServ extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            boolean esValido = request.getMethod().equals("POST");
            if(esValido)
            {
                String mens = "";
                String CRUD = request.getParameter("accionBtn");
                if(CRUD.equals("Guardar"))
                {
                    GruposAlumnos obje = new GruposAlumnos();
                    obje.setCodiAlum(AlumnoCtrl.get(Integer.parseInt(request.getParameter("alumno"))));
                    obje.setEstaGrupAlum('A');
                    obje.setCodiGrup(GruposCtrl.get(Integer.parseInt(request.getParameter("grupo"))));
                    mens = new GruposACtrl().guar(obje) ? "Datos guardados " : "Datos NO guardados";
                }
                request.setAttribute("mensAler", mens);
                request.getRequestDispatcher("/Grupo.jsp").forward(request, response);
            }
            else
            {
                response.sendRedirect(request.getContextPath() + "/Grupo.jsp");
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
