package view.beans;

import java.math.BigDecimal;

import java.util.Date;

import java.util.Map;

import oracle.adf.model.BindingContext;

import oracle.adf.model.binding.DCIteratorBinding;
import oracle.adf.share.ADFContext;

import oracle.binding.BindingContainer;
import oracle.binding.OperationBinding;

import oracle.jbo.server.ViewObjectImpl;

public class TimeSheetHoursBean {
    public TimeSheetHoursBean() {
    }

    public String initTimeSheet() {
        // Add event code here...
        ADFContext con=ADFContext.getCurrent();
        Map scope = con.getPageFlowScope();
        BindingContainer bc=getBindings();
        if(scope.get("timeSheetID")== null){
        
        OperationBinding opr = bc.getOperationBinding("initTimeSheet");
        opr.getParamsMap().put("currentDate", getCurrentDate());
        BigDecimal timeSheetId = (BigDecimal) opr.execute();            
        scope.put("timeSheetId", timeSheetId);
        }
        else{
            DCIteratorBinding itr = (DCIteratorBinding) bc.get("TimeSheetWeekVO1Iterator");
            ViewObjectImpl tsWeekVO = (ViewObjectImpl) itr.getViewObject();
            tsWeekVO.setWhereClause(null);
            tsWeekVO.executeQuery();
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

