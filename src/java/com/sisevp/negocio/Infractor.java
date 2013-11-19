/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sisevp.negocio;

import com.sisevp.negocio.patrones.observer.Observable;

/**
 *
 * @author laptop-w8
 */
public class Infractor extends Observable {

    private String id_infractor;
    private double monto_adeudado;
    private boolean estado;
    private double monto_pagado;

    public String getId_infractor() {
        return id_infractor;
    }

    public void setId_infractor(String id_infractor) {
        this.id_infractor = id_infractor;
    }

    public double getMonto_adeudado() {
        return monto_adeudado;
    }

    public void setMonto_adeudado(double monto_adeudado) {
        this.monto_adeudado = monto_adeudado;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public double getMonto_pagado() {
        return monto_pagado;
    }

    public void setMonto_pagado(double monto_pagado) {
        this.monto_pagado = monto_pagado;
    }
}
