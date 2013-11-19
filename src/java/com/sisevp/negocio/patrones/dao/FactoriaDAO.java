/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sisevp.negocio.patrones.dao;

/**
 *
 * @author fisi
 */
public abstract class FactoriaDAO {
    //Lista de tipos DAO soportados por la factoria
    public static final int MYSQL = 1;
    public static final int MICROSOFTSQLSERVER = 2;
    
    //las factorias concretas son las responsables de implementarlos
    //Existe un metodo por cada DAO a crear
    public abstract RegistroDAO getRegistroDAO();

    public abstract CobroDAO getCobroDAO();

    public static FactoriaDAO getFactoriaDAO(int queFactoria) {
        switch (queFactoria) {
            case MYSQL:
                return new BDMysqlDAOFactoria();
            case MICROSOFTSQLSERVER:
                return new BDMicrosoftSqlServerDAOFactoria();
            default:
                return null;

        }

    }
}
