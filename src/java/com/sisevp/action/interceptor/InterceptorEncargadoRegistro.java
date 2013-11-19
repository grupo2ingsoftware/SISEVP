/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sisevp.action.interceptor;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author laptop-w8
 */
public class InterceptorEncargadoRegistro implements Interceptor {

    private String actionsPrivados;
    private List<String> actionsConFiltro = new ArrayList<String>();

    @Override
    public void destroy() {
    }

    @Override
    public void init() {
        actionsConFiltro = Arrays.asList(actionsPrivados.split(","));
    }

    @Override
    public String intercept(ActionInvocation actionInvocation) throws Exception {
        String result = Action.LOGIN;

        String actionActual = (String) ActionContext.getContext().get(ActionContext.ACTION_NAME);
        System.out.println("Action actual de Registro: " + actionActual);

        if (actionInvocation.getInvocationContext().getSession().containsKey("usuario") || actionsConFiltro.contains(actionActual)) {
            result = actionInvocation.invoke();
            System.out.println("Action result de Registro: " + actionActual);
        }

        return result;
    }

    public String getActionsPrivados() {
        return actionsPrivados;
    }

    public void setActionsPrivados(String actionsPrivados) {
        this.actionsPrivados = actionsPrivados;
    }
}
