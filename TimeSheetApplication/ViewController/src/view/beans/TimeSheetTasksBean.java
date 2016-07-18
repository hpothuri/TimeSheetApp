package view.beans;

import java.math.BigDecimal;

import javax.faces.context.FacesContext;

import oracle.adf.model.BindingContext;


import oracle.adf.model.binding.DCIteratorBinding;
import oracle.adf.view.rich.component.rich.RichPopup;

import oracle.binding.AttributeBinding;
import oracle.binding.BindingContainer;
import oracle.binding.OperationBinding;

import oracle.jbo.ViewObject;

import org.apache.myfaces.trinidad.event.DisclosureEvent;
import org.apache.myfaces.trinidad.render.ExtendedRenderKitService;
import org.apache.myfaces.trinidad.util.Service;

public class TimeSheetTasksBean {
    private RichPopup tsTasksPopup;

    public TimeSheetTasksBean() {
    }

  /*  public String createTaskView() {
        // Add event code here...
        BindingContainer bc = getBindings();
        OperationBinding opr = bc.getOperationBinding("createTasks");
        opr.execute();
        return "createTasks";
    }
*/
    private BindingContainer getBindings() {
        return BindingContext.getCurrent().getCurrentBindingsEntry();
    }

    /*public String addTasks() {
        // Add event code here...
        BindingContainer bc = getBindings();
        OperationBinding opr = bc.getOperationBinding("saveTasks");
        AttributeBinding attr = (AttributeBinding) bc.get("TaskId");
        BigDecimal taskId = (BigDecimal) attr.getInputValue();
        opr.getParamsMap().put("taskId", taskId);
        opr.execute();
        showPopup(tsTasksPopup, false);
        return null;
    }
*/
    public String editTasks() {
        // Add event code here...
        showPopup(tsTasksPopup, false);
        return null;
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

    public void setTsTasksPopup(RichPopup tsTasksPopup) {
        this.tsTasksPopup = tsTasksPopup;
    }

    public RichPopup getTsTasksPopup() {
        return tsTasksPopup;
    }

 /*   public String deleteTasks() {
        // Add event code here...
        BindingContainer bc = getBindings();
        OperationBinding opr = bc.getOperationBinding("deleteTimeSheetTasks");
        Boolean flag = (Boolean) opr.execute();
        DCIteratorBinding itr = (DCIteratorBinding) bc.get("TimeSheetTasksVO1Iterator");
        ViewObject vo = itr.getViewObject();
        if (vo.getEstimatedRowCount() == 0) {
            return "home";
        } else{
            return null;
        }

    }
*/
    public String saveTsTasks() {
        // Add event code here...
        BindingContainer bc = getBindings();
        OperationBinding opr = bc.getOperationBinding("save");
        opr.execute();
        return "home";
    }

    public String cancelTasks() {
        // Add event code here...
        BindingContainer bc = getBindings();
        OperationBinding opr = bc.getOperationBinding("cancel");
        opr.execute();
        return "home";
    }

  /*  public void createTask(DisclosureEvent disclosureEvent) {
        // Add event code here...
        createTaskView();
    }
*/
    public String cancelEditPopup() {
        // Add event code here...
        showPopup(tsTasksPopup, false);
        return null;
    }
}
