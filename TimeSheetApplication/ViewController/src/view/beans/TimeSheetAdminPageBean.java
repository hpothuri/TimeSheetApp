package view.beans;


import java.io.File;

import java.io.IOException;
import java.io.InputStream;

import java.io.OutputStream;

import java.math.BigDecimal;

import java.sql.SQLException;

import javax.faces.context.FacesContext;

import oracle.adf.model.BindingContext;
import oracle.adf.model.binding.DCIteratorBinding;
import oracle.adf.view.rich.component.rich.RichPopup;

import oracle.binding.AttributeBinding;
import oracle.binding.BindingContainer;
import oracle.binding.OperationBinding;

import oracle.jbo.ViewCriteria;
import oracle.jbo.domain.BlobDomain;
import oracle.jbo.server.ViewObjectImpl;

import org.apache.myfaces.trinidad.event.DisclosureEvent;
import org.apache.myfaces.trinidad.model.UploadedFile;
import org.apache.myfaces.trinidad.render.ExtendedRenderKitService;
import org.apache.myfaces.trinidad.util.FileUtils;
import org.apache.myfaces.trinidad.util.Service;

public class TimeSheetAdminPageBean {
    private RichPopup tasksPopup;
    private RichPopup rolesPopup;
    private RichPopup usersPopup;
    private RichPopup tsHoursPopup;
    private RichPopup delConfrmPopup;
    private RichPopup delTasksPopup;
    private RichPopup delRolesPopup;
    private RichPopup delTsDaysPopup;


    public TimeSheetAdminPageBean() {
    }

    public void setTasksPopup(RichPopup tasksPopup) {
        this.tasksPopup = tasksPopup;
    }

    public RichPopup getTasksPopup() {
        return tasksPopup;
    }

    public void setRolesPopup(RichPopup rolesPopup) {
        this.rolesPopup = rolesPopup;
    }

    public RichPopup getRolesPopup() {
        return rolesPopup;
    }

    public void setUsersPopup(RichPopup usersPopup) {
        this.usersPopup = usersPopup;
    }

    public RichPopup getUsersPopup() {
        return usersPopup;
    }

    private BindingContainer getBindings() {
        return BindingContext.getCurrent().getCurrentBindingsEntry();
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

    public String newTasksAction() {
        // Add event code here...
        BindingContainer bc = getBindings();
        OperationBinding opr = bc.getOperationBinding("createTasks");
        opr.execute();
        //   showPopup(tasksPopup, false);
        return null;
    }

    public String deleteTasksAction() {
        // Add event code here...
        BindingContainer bc = getBindings();
        OperationBinding opr = bc.getOperationBinding("deleteTimeSheetTasks");
        Boolean flag = (Boolean) opr.execute();
        delTasksPopup.hide();
        return null;
    }

    public String saveTasksAction() {
        // Add event code here...
        BindingContainer bc = getBindings();
        OperationBinding opr = bc.getOperationBinding("saveTasks");
        AttributeBinding attr = (AttributeBinding) bc.get("TaskId");
        BigDecimal taskId = (BigDecimal) attr.getInputValue();
        opr.getParamsMap().put("taskId", taskId);
        opr.execute();
        tasksPopup.hide();
        return null;
    }

    public String cancelTasksAction() {
        // Add event code here...
        BindingContainer bc = getBindings();
        OperationBinding opr = bc.getOperationBinding("cancel");
        opr.execute();
        tasksPopup.hide();
        return null;
    }

    public String newRolesAction() {
        // Add event code here...
        BindingContainer bc = getBindings();
        OperationBinding opr = bc.getOperationBinding("createRoles");
        opr.execute();
        return null;
    }

    public String deleteRolesAction() {
        // Add event code here...
        BindingContainer bc = getBindings();
        OperationBinding opr = bc.getOperationBinding("deleteTimeSheetRoles");
        Boolean flag = (Boolean) opr.execute();
        delRolesPopup.hide();
        return null;
    }

    public String saveRolesAction() {
        // Add event code here...
        BindingContainer bc = getBindings();
        OperationBinding opr = bc.getOperationBinding("saveRoles");
        AttributeBinding attr = (AttributeBinding) bc.get("RoleId");
        BigDecimal roleId = (BigDecimal) attr.getInputValue();
        opr.getParamsMap().put("roleId", roleId);
        opr.execute();
        rolesPopup.hide();
        return null;
    }

    public String cancelRolesAction() {
        // Add event code here...
        BindingContainer bc = getBindings();
        OperationBinding opr = bc.getOperationBinding("cancel");
        opr.execute();
        rolesPopup.hide();
        return null;
    }

    public String newUsersAction() {
        // Add event code here...
        BindingContainer bc = getBindings();
        OperationBinding opr = bc.getOperationBinding("createUsers");
        opr.execute();
        return null;
    }

    public String deleteUsersAction() {
        // Add event code here...
        BindingContainer bc = getBindings();
        OperationBinding opr = bc.getOperationBinding("deleteTimeSheetUsers");
        Boolean flag = (Boolean) opr.execute();
        delConfrmPopup.hide();
        return null;
    }

    public String saveUsersAction() {
        // Add event code here...
        BindingContainer bc = getBindings();
        OperationBinding opr = bc.getOperationBinding("saveUsers");
        AttributeBinding attr = (AttributeBinding) bc.get("UserId");
        BigDecimal userId = (BigDecimal) attr.getInputValue();
        opr.getParamsMap().put("userId", userId);
        opr.execute();
        usersPopup.hide();
        return null;
    }

    public String cancelUsersAction() {
        // Add event code here...
        BindingContainer bc = getBindings();
        OperationBinding opr = bc.getOperationBinding("cancel");
        opr.execute();
        usersPopup.hide();
        return null;
    }

    public String saveAction() {
        // Add event code here...
        BindingContainer bc = getBindings();
        OperationBinding opr = bc.getOperationBinding("save");
        opr.execute();
        return null;
    }

    public String cancelAction() {
        // Add event code here...
        BindingContainer bc = getBindings();
        OperationBinding opr = bc.getOperationBinding("cancel");
        opr.execute();
        return null;
    }

    public void viewSubmittedTs(DisclosureEvent disclosureEvent) {
        // Add event code here...
        BindingContainer bc = getBindings();
        DCIteratorBinding itr = (DCIteratorBinding) bc.get("TimeSheetWeekVO1Iterator");
        ViewObjectImpl vo = (ViewObjectImpl) itr.getViewObject();
        ViewCriteria vc = vo.getViewCriteria("TimeSheetWeekStatusVC");
        vo.applyViewCriteria(vc);
        vo.setNamedWhereClauseParam("p_status", "Submitted");
        vo.executeQuery();
    }

    public void setTsHoursPopup(RichPopup tsHoursPopup) {
        this.tsHoursPopup = tsHoursPopup;
    }

    public RichPopup getTsHoursPopup() {
        return tsHoursPopup;
    }


    public void setDelConfrmPopup(RichPopup delConfrmPopup) {
        this.delConfrmPopup = delConfrmPopup;
    }

    public RichPopup getDelConfrmPopup() {
        return delConfrmPopup;
    }

    public String undoDeleteUsers() {
        // Add event code here...
        delConfrmPopup.hide();
        return null;
    }

    public String undoDeleteTasks() {
        // Add event code here...
        delTasksPopup.hide();
        return null;
    }

    public String undoDeleteRole() {
        // Add event code here...
        delRolesPopup.hide();
        return null;
    }

    public void setDelTasksPopup(RichPopup delTasksPopup) {
        this.delTasksPopup = delTasksPopup;
    }

    public RichPopup getDelTasksPopup() {
        return delTasksPopup;
    }

    public void setDelRolesPopup(RichPopup delRolesPopup) {
        this.delRolesPopup = delRolesPopup;
    }

    public RichPopup getDelRolesPopup() {
        return delRolesPopup;
    }

    public void setDelTsDaysPopup(RichPopup delTsDaysPopup) {
        this.delTsDaysPopup = delTsDaysPopup;
    }

    public RichPopup getDelTsDaysPopup() {
        return delTsDaysPopup;
    }
}
