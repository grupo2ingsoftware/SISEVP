/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sisevp.negocio.patrones.strategy;

import com.sisevp.negocio.Registro;
import java.io.Serializable;

/**
 *
 * @author laptop-w8
 */
public abstract class EstrategiaRegistro  implements Serializable{

    public abstract void registrar(Registro registro,String id_codigo);
}
