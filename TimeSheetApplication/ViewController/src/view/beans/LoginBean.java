package view.beans;

import java.io.IOException;

import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import javax.security.auth.Subject;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.login.FailedLoginException;
import javax.security.auth.login.LoginException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import javax.servlet.http.HttpSession;

import oracle.adf.share.ADFContext;

import weblogic.security.URLCallbackHandler;
import weblogic.security.services.Authentication;

import weblogic.servlet.security.ServletAuthentication;


public class LoginBean {
    private String username;
    private String password;

    public LoginBean() {
    }

    public void setUserName(String username) {
        this.username = username.toLowerCase();
    }

    public String getUserName() {
        return username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public String doLogin() {
        String un = username;
        byte[] pw = password.getBytes();
        FacesContext ctx = FacesContext.getCurrentInstance();
        HttpServletRequest request = (HttpServletRequest) ctx.getExternalContext().getRequest();
        CallbackHandler handler = new URLCallbackHandler(un, pw);
        try {
            Subject mySubject = Authentication.login(handler);
            ServletAuthentication.runAs(mySubject, request);
            ServletAuthentication.generateNewSessionID(request);
            System.out.println(" Here :" + ctx.getViewRoot().getViewId());
            String loginUrl = "/adfAuthentication?success_url=/faces/home.jsf";
            HttpServletResponse response = (HttpServletResponse) ctx.getExternalContext().getResponse();
            Map sessionScope = ADFContext.getCurrent().getSessionScope();
            String userName = (String) sessionScope.put("userName",username);
            sendForward(request, response, loginUrl);
        } catch (FailedLoginException e) {
            FacesMessage msg =
                new FacesMessage(FacesMessage.SEVERITY_ERROR, "Incorrect user name or password",
                                 "Incorrect user name or password was specified");
            ctx.addMessage(null, msg);
        } catch (LoginException e) {
            e.printStackTrace();
        }
        return null;

    }

    public void sendForward(HttpServletRequest request, HttpServletResponse response, String forwardUrl) {
        System.out.println("Forwarding ..." + forwardUrl);
        FacesContext ctx = FacesContext.getCurrentInstance();

        RequestDispatcher dis = request.getRequestDispatcher(forwardUrl);
        try {
            dis.forward(request, response);
        } catch (IOException e) {
            reportUnexpectedLoginError("IOException Exception", e);
            e.printStackTrace();
        } catch (ServletException e) {
            reportUnexpectedLoginError("ServletException ", e);
            e.printStackTrace();
        }
        ctx.responseComplete();
    }

    public void reportUnexpectedLoginError(String errorType, Exception e) {
        FacesMessage msg =
            new FacesMessage(FacesMessage.SEVERITY_ERROR, "Unexpected Error during login", "Error type =" + errorType);
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public String doLogout() {
        FacesContext fctx = FacesContext.getCurrentInstance();
        ExternalContext ectx = fctx.getExternalContext();
        String url = ectx.getRequestContextPath() + "/adfAuthentication?logout=true&end_url=/faces/login.jsf";
        try {
            ectx.redirect(url);
        } catch (IOException e) {
            e.printStackTrace();
        }
        fctx.responseComplete();
        return null;

    }

}
