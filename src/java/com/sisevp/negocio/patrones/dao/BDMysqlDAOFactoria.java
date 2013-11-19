/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sisevp.negocio.patrones.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * abstract factory
 *
 * @author fisi
 */
//implementacion de DAO FACTORIAS usando el motor Mysql
public class BDMysqlDAOFactoria extends FactoriaDAO {

    public static final String url = "jdbc:mysql://localhost/sisevp";
    public static final String driver = "com.mysql.jdbc.Driver";

    //metodo para crear la conexion
    public static Connection crearconexion() {

        try {
            Class.forName(driver);
            return DriverManager.getConnection(url, "root", "root");

        } catch (ClassNotFoundException e) {
            System.out.println(e);
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    @Override
    public RegistroDAO getRegistroDAO() {
       return new BDMysqlRegistroDAO();
    }

    @Override
    public CobroDAO getCobroDAO() {
        return null;
    }
}
