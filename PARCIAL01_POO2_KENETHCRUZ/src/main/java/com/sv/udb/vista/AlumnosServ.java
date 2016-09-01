/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.vista;

import com.sv.udb.controlador.AlumnoCtrl;
import com.sv.udb.modelo.Alumnos;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Orlando Vasquez
 */
@WebServlet(name = "AlumnosServ", urlPatterns = {"/AlumnosServ"})
public class AlumnosServ extends HttpServlet {

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
                String CRUD = request.getParameter("cursBton");
                if(CRUD.equals("Guardar"))
                {
                    Alumnos obje = new Alumnos();
                    obje.setNombAlum(request.getParameter("nombAlum"));
                    obje.setApelAlum(request.getParameter("apelAlum"));
                    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                    Date fechaNacimiento;
                    try
                    {
                       fechaNacimiento= formatter.parse(request.getParameter("fechNaciAlum"));
                    }
                    catch(Exception err)
                    {
                        fechaNacimiento=new Date();
                    }
                    obje.setFechNaciAlum(fechaNacimiento);
                    obje.setMailAlum(request.getParameter("mailAlum"));
                    obje.setTeleAlum(request.getParameter("teleAlum"));
                    obje.setDireAlum(request.getParameter("direAlum"));
                    obje.setGeneAlum((request.getParameter("geneAlum")).charAt(0));
                    
                    mens = new AlumnoCtrl().guar(obje) ? "Datos guardados" : "Datos NO guardados";
                }
                request.setAttribute("mensAler", mens);
                request.getRequestDispatcher("/Alumno.jsp").forward(request, response);
            }
            else
            {
                response.sendRedirect(request.getContextPath() + "/Alumno.jsp");
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
