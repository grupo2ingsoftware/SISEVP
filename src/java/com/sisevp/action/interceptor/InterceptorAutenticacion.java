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
public class InterceptorAutenticacion implements Interceptor {

    private String actionsPublicos;
    private List<String> actionsSinFiltrar = new ArrayList<String>();

    @Override
    public void destroy() {
    }

    @Override
    public void init() {
         actionsSinFiltrar = Arrays.asList(actionsPublicos.split(","));
    }

    @Override
    public String intercept(ActionInvocation actionInvocation) throws Exception {
        String result = Action.LOGIN;

        String actionActual = (String) ActionContext.getContext().get(ActionContext.ACTION_NAME);
        System.out.println("Action actual: "+actionActual);

        if (actionInvocation.getInvocationContext().getSession().containsKey("usuario") || actionsSinFiltrar.contains(actionActual)) {
            result = actionInvocation.invoke();
            
            System.out.println("Action result: "+actionActual);
        }

        return result;
    }

    public void setActionsPublicos(String actionsPublicos) {
        this.actionsPublicos = actionsPublicos;
    }
}
