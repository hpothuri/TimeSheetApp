package view.beans;

import java.math.BigDecimal;

import javax.faces.context.FacesContext;

import oracle.adf.model.AttributeBinding;
import oracle.adf.model.BindingContext;

import oracle.adf.model.binding.DCIteratorBinding;
import oracle.adf.view.rich.component.rich.RichPopup;

import oracle.binding.BindingContainer;
import oracle.binding.OperationBinding;

import oracle.jbo.ViewObject;

import org.apache.myfaces.trinidad.render.ExtendedRenderKitService;
import org.apache.myfaces.trinidad.util.Service;

public class TimeSheetRolesBean {
    private RichPopup tsRolesPopup;

    public TimeSheetRolesBean() {
    }

 /*   public String addRoles() {
        // Add event code here...
        BindingContainer bc = getBindings();
        OperationBinding opr = bc.getOperationBinding("saveRoles");
        AttributeBinding attr = (AttributeBinding) bc.get("RoleId");
        BigDecimal roleId = (BigDecimal) attr.getInputValue();
        opr.getParamsMap().put("roleId", roleId);
        opr.execute();
        return "home";
    }
*/
  /*  public String createRolesView() {
        // Add event code here...
        BindingContainer bc = getBindings();
        OperationBinding opr = bc.getOperationBinding("createRoles");
        opr.execute();
        return "createRoles";
    }
*/
    private BindingContainer getBindings() {
        return BindingContext.getCurrent().getCurrentBindingsEntry();
    }

    public String editTsRoles() {
        // Add event code here...
        showPopup(tsRolesPopup, false);
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

    public void setTsRolesPopup(RichPopup tsRolesPopup) {
        this.tsRolesPopup = tsRolesPopup;
    }

    public RichPopup getTsRolesPopup() {
        return tsRolesPopup;
    }

  /*  public String deleteTsRoles() {
        // Add event code here...
        BindingContainer bc = getBindings();
        OperationBinding opr = bc.getOperationBinding("deleteTimeSheetRoles");
        Boolean flag = (Boolean) opr.execute();
        DCIteratorBinding itr = (DCIteratorBinding) bc.get("TimeSheetRolesVO1Iterator");
        ViewObject vo = itr.getViewObject();
        if (vo.getEstimatedRowCount() == 0) {
            return "home";
        } else{
            return null;
        }
    }
*/
    public String saveTsRoles() {
        // Add event code here...
        BindingContainer bc = getBindings();
        OperationBinding opr = bc.getOperationBinding("save");
        opr.execute();


        return "home";
    }

    public String rollback() {
        // Add event code here...
        showPopup(tsRolesPopup, false);
        return null;
    }

    public String cancelUpdates() {
        // Add event code here...
        BindingContainer bc = getBindings();
        OperationBinding opr = bc.getOperationBinding("cancel");
        opr.execute();
        return "home";
    }
}
