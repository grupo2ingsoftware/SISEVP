/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sisevp.negocio.patrones.dao;

/**
 *
 * @author fisi
 */
public class BDMicrosoftSqlServerDAOFactoria extends FactoriaDAO{

    @Override
    public RegistroDAO getRegistroDAO() {
        return null;
    }

    @Override
    public CobroDAO getCobroDAO() {
        return null;
    }
    
}
