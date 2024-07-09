package com.example.tallerRecuperativo.controller;

import com.example.tallerRecuperativo.model.Cliente;
import com.example.tallerRecuperativo.model.dato.DBGenerator;
import com.example.tallerRecuperativo.model.dato.dao.ClienteDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "registroClienteServlet", value = "/registroCliente")
public class RegistroClienteServlet extends HttpServlet{
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
        RequestDispatcher respuesta = req.getRequestDispatcher("/registroCliente.jsp");
        respuesta.forward(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String nombre = req.getParameter("nombre");
        String email = req.getParameter("email");
        String direccion = req.getParameter("direccion");
        String nTelefonico = req.getParameter("nTelefonico");
        String preferencias = req.getParameter("preferencias");

        Cliente cliente = new Cliente(0, nombre, email, direccion, nTelefonico, preferencias);
        try{
            ClienteDAO.agregarCliente(DBGenerator.conectarBD("TallerRecuperativoDB"), cliente);
            req.setAttribute("cliente", cliente);
            RequestDispatcher respuesta = req.getRequestDispatcher("/registroExitoso.jsp");
            respuesta.forward(req, resp);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            RequestDispatcher respuesta = req.getRequestDispatcher("/registroErroneo.jsp");
            respuesta.forward(req, resp);

        }




    }






}
