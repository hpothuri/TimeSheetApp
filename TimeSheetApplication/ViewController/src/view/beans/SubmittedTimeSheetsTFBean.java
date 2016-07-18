package view.beans;

import java.math.BigDecimal;

import oracle.adf.model.BindingContext;

import oracle.adf.model.OperationBinding;

import oracle.binding.BindingContainer;

import oracle.adf.model.binding.DCIteratorBinding;

import oracle.jbo.ViewObject;
import oracle.jbo.server.ViewObjectImpl;

public class SubmittedTimeSheetsTFBean {
    public SubmittedTimeSheetsTFBean() {
    }

  /*  public String initSumittedTS() {
        // Add event code here...
        BindingContainer bc = getBindings();
        oracle.binding.OperationBinding opr = bc.getOperationBinding("initSubmittedTS");
        opr.getParamsMap().put("status", "Submitted");
        opr.execute();
        return "view";

    }*/

    public BindingContainer getBindings() {
        return BindingContext.getCurrent().getCurrentBindingsEntry();
    }

}
