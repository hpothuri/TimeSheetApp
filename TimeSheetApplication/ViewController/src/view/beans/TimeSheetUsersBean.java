package view.beans;

import java.math.BigDecimal;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import oracle.adf.model.BindingContext;

import oracle.adf.model.binding.DCIteratorBinding;

import oracle.adf.view.rich.component.rich.RichPopup;

import oracle.binding.AttributeBinding;
import oracle.binding.BindingContainer;

import oracle.binding.OperationBinding;

import oracle.jbo.Row;
import oracle.jbo.ViewObject;

public class TimeSheetUsersBean {

    public TimeSheetUsersBean() {
    }

    public String saveUsers() {
        // Add event code here...
        BindingContainer bc = getBindings();
        OperationBinding opr = bc.getOperationBinding("saveUsers");
        AttributeBinding attr = (AttributeBinding) bc.get("UserId");
        BigDecimal userId = (BigDecimal) attr.getInputValue();
        opr.getParamsMap().put("userId", userId);
        opr.execute();
        FacesContext fc = FacesContext.getCurrentInstance();
        FacesMessage fm = new FacesMessage("User Info saved successfully");
        fm.setSeverity(FacesMessage.SEVERITY_INFO);
        fc.addMessage(null, fm);
        return "home";
    }

 /*   public String createUsersView() {
        // Add event code here...
        BindingContainer bc = getBindings();
        OperationBinding opr = bc.getOperationBinding("createUsers");
        opr.execute();
        return "createUser";
    }*/

    public BindingContainer getBindings() {
        return BindingContext.getCurrent().getCurrentBindingsEntry();
    }

}
