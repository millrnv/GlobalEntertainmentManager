package com.example.tallerRecuperativo.controller;

import com.example.tallerRecuperativo.model.Actividad;
import com.example.tallerRecuperativo.model.dato.dao.*;
import com.example.tallerRecuperativo.model.Cliente;
import com.example.tallerRecuperativo.model.Entrada;
import com.example.tallerRecuperativo.model.dato.DBGenerator;
import com.example.tallerRecuperativo.model.dato.dao.EntradaDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "registroEntradaServlet", value = "/registroEntrada")
public class RegistroEntradaServlet {

    public void init() throws ServletException {
        try {
            //DBGenerator.iniciarBD("TallerRecuperativoDB");
        } catch (Exception e) {
            e.printStackTrace();


        }
    }


    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher respuesta = req.getRequestDispatcher("/registroEntrada.jsp");
        respuesta.forward(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int idCliente = Integer.parseInt(req.getParameter("idCliente"));
        int idActividad = Integer.parseInt(req.getParameter("idActividad"));
        String tipoEntrada = req.getParameter("tipoEntrada");
        int disponibilidad = Integer.parseInt(req.getParameter("disponibilidad"));
        double precio = Double.parseDouble(req.getParameter("precio"));

        try{
            Actividad actividad = ActividadDAO.obtenerActividadPorId(DBGenerator.conectarBD("TallerRecuperativoDB"), idActividad);
            Cliente cliente = ClienteDAO.obtenerClientePorId(DBGenerator.conectarBD("TallerRecuperativoDB"), idCliente);
            Entrada entrada = new Entrada(0, actividad, cliente, tipoEntrada, disponibilidad, precio);
            EntradaDAO.agregarEntrada(DBGenerator.conectarBD("TallerRecuperativoDB"), entrada);
            req.setAttribute("entrada", entrada);
            RequestDispatcher respuesta = req.getRequestDispatcher("/registroExitoso.jsp");
            respuesta.forward(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
            RequestDispatcher respuesta = req.getRequestDispatcher("/registroErroneo.jsp");
            respuesta.forward(req, resp);





        }




    }

}

