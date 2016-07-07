package view.beans;

import java.math.BigDecimal;

import java.util.Date;

import java.util.Iterator;
import java.util.List;

import java.util.Map;

import java.util.Set;

import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import javax.faces.model.SelectItem;

import oracle.adf.model.AttributeBinding;
import oracle.adf.model.BindingContext;
import oracle.adf.model.binding.DCIteratorBinding;
import oracle.adf.view.rich.component.rich.RichPopup;
import oracle.adf.view.rich.component.rich.input.RichInputText;

import oracle.binding.BindingContainer;
import oracle.binding.OperationBinding;

import oracle.jbo.Row;
import oracle.jbo.ViewObject;

import oracle.jbo.server.ViewObjectImpl;

import org.apache.myfaces.trinidad.render.ExtendedRenderKitService;
import org.apache.myfaces.trinidad.util.Service;

public class TimeSheetDaysBean {
    private RichInputText timeSheetDate;
    private RichPopup timeSheetDaysPopup;
    private List<SelectItem> list;
    private Boolean flag;

    public TimeSheetDaysBean() {
        
    }

    public void setList(List<SelectItem> list) {
        this.list = list;
    }

    public List<SelectItem> getList() {
        return list;
    }

    public void setTimeSheetDate(RichInputText timeSheetDate) {
        this.timeSheetDate = timeSheetDate;
    }

    public RichInputText getTimeSheetDate() {
        return timeSheetDate;
    }

    public void initTimeSheet(ActionEvent actionEvent) {
        // Add event code here...
        BindingContainer bc = getBindings();
        OperationBinding opr = bc.getOperationBinding("initTimeSheet");
        opr.getParamsMap().put("currentDate", new Date());
        opr.execute();
    }

    public BindingContainer getBindings() {
        return BindingContext.getCurrent().getCurrentBindingsEntry();
    }


    public void setFlag(Boolean flag) {
        this.flag = flag;
    }

    public Boolean getFlag() {
        return flag;
    }

    public void cancelTimeSheetHours(ActionEvent actionEvent) {
        // Add event code here...
        showPopup(timeSheetDaysPopup, false);
    }

    public void showTimeSheetDaysPopup(ActionEvent actionEvent) {
        // Add event code here...
        BindingContainer bc = getBindings();
        OperationBinding opr = bc.getOperationBinding("CreateInsert");
        opr.execute();
        showPopup(timeSheetDaysPopup, true);
    }

    private void showPopup(RichPopup pop, boolean visible) {
        try {
            FacesContext context = FacesContext.getCurrentInstance();
            if (context != null && pop != null) {
                String popupId = pop.getClientId(context);
                if (popupId != null) {
                    StringBuilder script = new StringBuilder();
                    script.append("var popup = AdfPage.PAGE.findComponent('").append(popupId).append("'); ");
                    if (visible) {
                        script.append("if (!popup.isPopupVisible()) { ").append("popup.show();}");
                    } else {
                        script.append("if (popup.isPopupVisible()) { ").append("popup.hide();}");
                    }
                    ExtendedRenderKitService erks =
                        Service.getService(context.getRenderKit(), ExtendedRenderKitService.class);
                    erks.addScript(context, script.toString());
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void setTimeSheetDaysPopup(RichPopup timeSheetDaysPopup) {
        this.timeSheetDaysPopup = timeSheetDaysPopup;
    }

    public RichPopup getTimeSheetDaysPopup() {
        return timeSheetDaysPopup;
    }

    public void showTimeSheetHours(ActionEvent actionEvent) {
        // Add event code here...
        BindingContainer bc = getBindings();
        DCIteratorBinding itr = (DCIteratorBinding) bc.get("TimeSheetDaysVO1Iterator");
        ViewObject daysVO = itr.getViewObject();
        long count = daysVO.getEstimatedRowCount();
        if (count == 0) {
            OperationBinding opr = bc.getOperationBinding("addTimeSheetHours");
            AttributeBinding attr = (AttributeBinding) bc.get("TimeSheetId");
            BigDecimal timeSheetId = (BigDecimal) attr.getInputValue();
            opr.getParamsMap().put("timeSheetId", timeSheetId);
            opr.execute();

        }

        showPopup(timeSheetDaysPopup, true);

    }

    public String deleteOperation() {
        // Add event code here...
        BindingContainer bc = getBindings();
        /*DCIteratorBinding itr = (DCIteratorBinding) bc.get("TimeSheetDaysVO1Iterator");
        ViewObject daysVO = itr.getViewObject();
        Row daysRow = daysVO.getCurrentRow();
        daysRow.remove();
        long count = daysVO.getEstimatedRowCount();
        if (count == 0) {
            DCIteratorBinding weekItr = (DCIteratorBinding) bc.get("TimeSheetWeekVO1Iterator");
            ViewObjectImpl weekVO = (ViewObjectImpl) weekItr.getViewObject();
            Row weekRow = weekVO.getCurrentRow();
            weekRow.setAttribute("TotalHours", 0);
            showPopup(timeSheetDaysPopup, false);
        }*/
        OperationBinding opr = bc.getOperationBinding("deleteTimeSheetHours");
        AttributeBinding attr = (AttributeBinding) bc.get("TimeSheetId");
        BigDecimal timeSheetId = (BigDecimal) attr.getInputValue();
        opr.getParamsMap().put("timeSheetId", timeSheetId);
        Boolean flag = (Boolean) opr.execute();
        if (flag == Boolean.FALSE) {
            showPopup(timeSheetDaysPopup, false);
        } else {
            showPopup(timeSheetDaysPopup, true);
        }

        return null;
    }

    public String editHours() {
        // Add event code here...
        BindingContainer bc = getBindings();
        OperationBinding opr = bc.getOperationBinding("editTimeSheetHours");
        AttributeBinding attr = (AttributeBinding) bc.get("TimeSheetId");
        BigDecimal timeSheetId = (BigDecimal) attr.getInputValue();
        opr.getParamsMap().put("timeSheetId", timeSheetId);
        opr.execute();


        return null;
    }

    public String submitTimeSheet() {
        // Add event code here...
        BindingContainer bc = getBindings();
        OperationBinding opr = bc.getOperationBinding("submitForApproval");
        AttributeBinding attr = (AttributeBinding) bc.get("TimeSheetId");
        BigDecimal timeSheetId = (BigDecimal) attr.getInputValue();
        opr.getParamsMap().put("timeSheetId", timeSheetId);
        opr.execute();
        showPopup(timeSheetDaysPopup, false);
        return null;
    }

    public String addTimeSheetHoursForTasks() {
        // Add event code here...
        BindingContainer bc = getBindings();
        OperationBinding opr = bc.getOperationBinding("addTimeSheetHours");
        AttributeBinding attr = (AttributeBinding) bc.get("TimeSheetId");
        BigDecimal timeSheetId = (BigDecimal) attr.getInputValue();
        opr.getParamsMap().put("timeSheetId", timeSheetId);
        opr.execute();
        return null;
    }

  /*  public List<SelectItem> populateList() {
        BindingContainer bc = getBindings();
        OperationBinding opr = bc.getOperationBinding("populateWeekList");
        opr.getParamsMap().put("currentDate", new Date());
        Map weekMap = (Map) opr.execute();
        Set keys = weekMap.keySet();
        Iterator itr = keys.iterator();

        String key;
        List stDate;
        while (itr.hasNext()) {
            key = (String) itr.next();
            stDate = (List) weekMap.get(key);

        }
        return null;
    }*/

}
