package view.beans;

import oracle.adf.model.BindingContext;
import oracle.adf.model.binding.DCIteratorBinding;

import oracle.binding.BindingContainer;

import oracle.binding.OperationBinding;

import oracle.jbo.server.ViewObjectImpl;

public class TimeSheetTFBean {
    public TimeSheetTFBean() {
    }

    /*public String initTimeSheet() {
        // Add event code here...
        BindingContainer bc = getBindings();
        OperationBinding opr = bc.getOperationBinding("initSubmittedTS");
        opr.getParamsMap().put("status", "All");
        opr.execute();
        return "view";

    }*/
    public BindingContainer getBindings(){
        return BindingContext.getCurrent().getCurrentBindingsEntry();
        }
}
