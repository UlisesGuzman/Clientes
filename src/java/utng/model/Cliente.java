/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utng.model;

/**
 *
 * @author Ulises Guzman
 */
public class Cliente {
    
    private int idCliente;
    private String login;
    private String password;
    private String nombre;
    private int edad;

    public Cliente(int idCliente, String login, String password, String nombre, int edad) {
        this.idCliente = idCliente;
        this.login = login;
        this.password = password;
        this.nombre = nombre;
        this.edad = edad;
    }
    
    public Cliente(){
        this(0,"","","",0);
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "Cliente{" + "idCliente=" + idCliente + ", login=" + login + ", password=" + password + ", nombre=" + nombre + ", edad=" + edad + '}';
    }

   
    
    
    
}
