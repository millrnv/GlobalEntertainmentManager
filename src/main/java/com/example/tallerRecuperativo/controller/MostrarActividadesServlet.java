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
import java.util.List;

@WebServlet(name = "mostrarActividadesServlet", value = "/mostrarActividades")
public class MostrarActividadesServlet extends HttpServlet{

    @Override
    public void init() throws ServletException {
        try{
            DBGenerator.iniciarBD("TallerRecuperativoDB");
        } catch (ClassNotFoundException e){
            e.printStackTrace();

        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            List<Actividad> actividades = ActividadDAO.obtenerActividades(DBGenerator.conectarBD("TallerRecuperativoDB"));
            req.setAttribute("actividades", actividades);
            RequestDispatcher respuesta = req.getRequestDispatcher("/mostrarActividades.jsp");
            respuesta.forward(req, resp);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }









}
