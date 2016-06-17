package view.beans;

import java.math.BigDecimal;

import java.util.Date;

import java.util.Map;

import oracle.adf.model.BindingContext;

import oracle.adf.share.ADFContext;

import oracle.binding.BindingContainer;
import oracle.binding.OperationBinding;

public class TimeSheetHoursBean {
    public TimeSheetHoursBean() {
    }

    public String initTimeSheet() {
        // Add event code here...
        ADFContext con=ADFContext.getCurrent();
        Map scope = con.getPageFlowScope();
        if(scope.get("timeSheetID")== null){
        BindingContainer bc=getBindings();
        OperationBinding opr = bc.getOperationBinding("initTimeSheet");
        opr.getParamsMap().put("currentDate", getCurrentDate());
        BigDecimal timeSheetId = (BigDecimal) opr.execute();            
        scope.put("timeSheetId", timeSheetId);
        }
        return "view";

    }
    public Date getCurrentDate(){
        return new Date();
        }
    public BindingContainer getBindings(){
        return BindingContext.getCurrent().getCurrentBindingsEntry();
        }

    public void createTimeSheet() {
        // Add event code here...
        BindingContainer bc=getBindings();
        OperationBinding opr = bc.getOperationBinding("createTimeSheet");
        opr.execute();

    }
}

