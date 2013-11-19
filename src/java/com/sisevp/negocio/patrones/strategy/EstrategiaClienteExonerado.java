/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sisevp.negocio.patrones.strategy;

import com.sisevp.negocio.Registro;
import com.sisevp.negocio.patrones.dao.FactoriaDAO;
import com.sisevp.negocio.patrones.dao.RegistroDAO;

/**
 *
 * @author laptop-w8
 */
public class EstrategiaClienteExonerado extends EstrategiaRegistro {

    @Override
    public void registrar(Registro registro,String id_codigo) {
        FactoriaDAO factoriaMysql=FactoriaDAO.getFactoriaDAO(1);
        RegistroDAO registroDAO=factoriaMysql.getRegistroDAO();
        
        //registrar un nuevo ingreso
        registroDAO.registrar(registro, id_codigo);
    }
    
}
