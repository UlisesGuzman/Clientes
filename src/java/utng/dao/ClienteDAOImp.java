/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utng.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import utng.model.Cliente;
import utng.util.utilDB;

/**
 *
 * @author Ulises Guzman
 */
public  class ClienteDAOImp implements ClienteDAO {
    
    private Connection connection;
    
    public ClienteDAOImp() {
        connection = utilDB.getConnection();
    }
    
    @Override
    public void agregarCliente(Cliente cliente) {
        try {
            String query = "INSERT INTO clientes(login,password, nombre,edad)" + "VALUES(?,?,?,?)";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, cliente.getLogin());
            ps.setString(2, cliente.getPassword());
            ps.setString(3, cliente.getNombre());
            ps.setInt(4, cliente.getEdad());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    @Override
    public void borrarCliente(int idCliente) {
        try {
            String query = "DELETE FROM clientes WHERE "
                    + " id_cliente=?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, idCliente);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }
    
    @Override
    public void cambiarCliente(Cliente cliente) {
        try {
            String query = "UPDATE clientes SET login= ?"
                    + ", password=?"
                    + ", nombre=?"
                    + ", edad=?"
                    + "WHERE id_cliente=?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, cliente.getLogin());
            ps.setString(2, cliente.getPassword());
            ps.setString(3, cliente.getNombre());
            ps.setInt(4, cliente.getEdad());
            ps.setInt(5, cliente.getIdCliente());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public List<Cliente> desplegarClientes() {
        List<Cliente> clientes = new ArrayList<Cliente>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM clientes");
            while (rs.next()) {
                Cliente cliente = new Cliente(rs.getInt("id_cliente"),
                        rs.getString("login"),
                        rs.getString("password"),
                        rs.getString("nombre"),
                        rs.getInt("edad"));
                clientes.add(cliente);
            }
            rs.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return clientes;
    }
    
     @Override
    public Cliente elegirCliente(int idCliente) {
        Cliente cliente=null;
        try {
            String query = " SELECT * FROM clientes WHERE id_cliente=?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, idCliente);
            ResultSet rs = statement.executeQuery();
            
            if (rs.next()) {
                  cliente = new Cliente(
                        rs.getInt("id_cliente"),
                        rs.getString("login"),
                        rs.getString("password"),
                        rs.getString("nombre"),
                        rs.getInt("edad"));
             
            }
            rs.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cliente;
    }

    
}
