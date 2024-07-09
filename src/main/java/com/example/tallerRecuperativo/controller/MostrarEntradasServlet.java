package com.example.tallerRecuperativo.controller;

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
import java.util.List;

@WebServlet(name = "mostrarEntradasServlet", value = "/mostrarEntradas")
public class MostrarEntradasServlet extends HttpServlet{

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
            List<Entrada> entradas = EntradaDAO.obtenerEntradas(DBGenerator.conectarBD("TallerRecuperativoDB"));
            req.setAttribute("entradas", entradas);
            RequestDispatcher respuesta = req.getRequestDispatcher("/mostrarEntradas.jsp");
            respuesta.forward(req, resp);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
