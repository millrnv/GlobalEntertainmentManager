package com.example.tallerRecuperativo.controller;

import com.example.tallerRecuperativo.model.Actividad;
import com.example.tallerRecuperativo.model.dato.DBGenerator;
import com.example.tallerRecuperativo.model.dato.dao.ActividadDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "registroActividadServlet", value = "/registroActividad")
public class RegistroActividadServlet extends HttpServlet{

    public void init() throws ServletException {
        try{
            //DBGenerator.iniciarBD("TallerRecuperativoDB");
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher respuesta = req.getRequestDispatcher("/registroActividad.jsp");
        respuesta.forward(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String numeroActividad = req.getParameter("numeroActividad");
        int edadMin = Integer.parseInt(req.getParameter("edadMin"));
        String fecha = req.getParameter("fecha");
        String lugar = req.getParameter("lugar");
        String duracion = req.getParameter("duracion");

        Actividad actividad = new Actividad(0, numeroActividad, edadMin, fecha, lugar, duracion);

        try {
            ActividadDAO.agregarActividad(DBGenerator.conectarBD("TallerRecuperativoDB"), actividad);
            req.setAttribute("actividad", actividad);
            RequestDispatcher respuesta = req.getRequestDispatcher("/registroExitoso.jsp");
            respuesta.forward(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
            RequestDispatcher respuesta = req.getRequestDispatcher("/registroErroneo.jsp");
            respuesta.forward(req, resp);

        }








    }






}
