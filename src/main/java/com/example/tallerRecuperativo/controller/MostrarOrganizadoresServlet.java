package com.example.tallerRecuperativo.controller;

import com.example.tallerRecuperativo.model.Organizador;
import com.example.tallerRecuperativo.model.dato.DBGenerator;
import com.example.tallerRecuperativo.model.dato.dao.OrganizadorDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "MostrarOrganizadoresServlet", value = "/mostrarOrganizadores")
public class MostrarOrganizadoresServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        try {
            DBGenerator.iniciarBD("TallerRecuperativoDB");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            List<Organizador> organizadores = OrganizadorDAO.obtenerOrganizadores(DBGenerator.conectarBD("TallerRecuperativoDB"));
            req.setAttribute("organizadores", organizadores);
            RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/mostrarOrganizadores.jsp");
            dispatcher.forward(req, resp);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

}
