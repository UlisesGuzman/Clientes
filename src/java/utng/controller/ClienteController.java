/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utng.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import utng.dao.ClienteDAO;
import utng.dao.ClienteDAOImp;
import utng.model.Cliente;

/**
 *
 * @author Ulises Guzman
 */
public class ClienteController extends HttpServlet {
    
    private static final String LISTA_CLIENTES = "/listarClientes.jsp";
    private static final String AGREGAR_O_CAMBIAR = "/clientes.jsp";
    private ClienteDAO dao;
    
    public ClienteController() { 
        dao = new ClienteDAOImp();
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String forward = "";
        String action = request.getParameter("action");
        if (action.equalsIgnoreCase("borrar")) {
            forward = LISTA_CLIENTES;
            int idCliente = Integer.parseInt(request.getParameter("idCliente"));
            dao.borrarCliente(idCliente);
            request.setAttribute("clientes", dao.desplegarClientes());
        } else if (action.equalsIgnoreCase("cambiar")) {
            forward = AGREGAR_O_CAMBIAR;
            int idCliente = Integer.parseInt(request.getParameter("idCliente"));
            Cliente cliente = dao.elegirCliente(idCliente);
            request.setAttribute("cliente", cliente);
            
        } else if (action.equalsIgnoreCase("agregar")) {
            forward = AGREGAR_O_CAMBIAR;
        } else {
            forward = LISTA_CLIENTES;
            request.setAttribute("clientes", dao.desplegarClientes());
        }
        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Cliente cliente = new Cliente();
        String idCliente = request.getParameter("idCliente");
        cliente.setNombre(request.getParameter("nombre"));
        cliente.setLogin(request.getParameter("login"));
        cliente.setPassword(request.getParameter("password"));
        cliente.setEdad(Integer.parseInt(request.getParameter("edad")));
        if (idCliente == null || idCliente.isEmpty()) {
            dao.agregarCliente(cliente);
        } else {
            cliente.setIdCliente(Integer.parseInt(idCliente));
            dao.cambiarCliente(cliente);
        }
        RequestDispatcher view = request.getRequestDispatcher(LISTA_CLIENTES);
        request.setAttribute("clientes", dao.desplegarClientes());
        view.forward(request, response);
    }
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }
    
}
