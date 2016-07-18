package view.beans;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import java.math.BigDecimal;

import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import javax.servlet.http.HttpSession;

import oracle.adf.model.AttributeBinding;
import oracle.adf.model.BindingContext;

import oracle.adf.model.binding.DCIteratorBinding;
import oracle.adf.share.ADFContext;
import oracle.adf.view.rich.component.rich.PartialRichPopup;
import oracle.adf.view.rich.component.rich.RichPopup;
import oracle.adf.view.rich.component.rich.input.RichInputText;

import oracle.binding.BindingContainer;

import oracle.binding.OperationBinding;

import oracle.jbo.Row;
import oracle.jbo.ViewObject;

import oracle.jbo.domain.BlobDomain;

import org.apache.myfaces.trinidad.event.DisclosureEvent;
import org.apache.myfaces.trinidad.render.ExtendedRenderKitService;
import org.apache.myfaces.trinidad.util.Service;

import org.apache.commons.io.IOUtils;

public class TimeSheetHomeBean {
    private RichInputText newPwd;
    private RichInputText confirmNewPwd;
    private RichPopup changePwdPopup;
    private RichPopup changeRolePopup;

    public TimeSheetHomeBean() {
    }

    public BindingContainer getBindings() {
        return BindingContext.getCurrent().getCurrentBindingsEntry();
    }

    public void setNewPwd(RichInputText newPwd) {
        this.newPwd = newPwd;
    }

    public RichInputText getNewPwd() {
        return newPwd;
    }

    public void setConfirmNewPwd(RichInputText confirmNewPwd) {
        this.confirmNewPwd = confirmNewPwd;
    }

    public RichInputText getConfirmNewPwd() {
        return confirmNewPwd;
    }

    public void setChangePwdPopup(RichPopup changePwdPopup) {
        this.changePwdPopup = changePwdPopup;
    }

    public RichPopup getChangePwdPopup() {
        return changePwdPopup;
    }

    public void SubmittedTSDisclosureListener(DisclosureEvent disclosureEvent) {
        // Add event code here...
        BindingContainer bc = getBindings();
        OperationBinding opr = bc.getOperationBinding("initSubmittedTS");
        opr.getParamsMap().put("status", "Submitted");
        opr.execute();
    }

    public void MyTSDisclosureListener(DisclosureEvent disclosureEvent) {
        // Add event code here...
        BindingContainer bc = getBindings();
        OperationBinding opr = bc.getOperationBinding("initSubmittedTS");
        opr.getParamsMap().put("status", "All");
        opr.execute();
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

    public String saveNewPassword() {
        // Add event code here...
        BindingContainer bc = getBindings();
        Map sessionScope = ADFContext.getCurrent().getSessionScope();
        String userName = (String) sessionScope.get("userName");
        String nPwd = newPwd.getValue().toString();
        String cnfrmPwd = confirmNewPwd.getValue().toString();
        if (nPwd.equalsIgnoreCase(cnfrmPwd)) {
            OperationBinding opr = bc.getOperationBinding("updatePassword");
            opr.getParamsMap().put("userName", userName);
            opr.getParamsMap().put("password", nPwd);
            opr.execute();
        } else {
            FacesContext ctx = FacesContext.getCurrentInstance();
            FacesMessage fm = new FacesMessage("Password not matched");
            fm.setSeverity(FacesMessage.SEVERITY_ERROR);
            ctx.addMessage(null, fm);
        }
        showPopup(changePwdPopup, false);
        return null;
    }

    public String cancelChangePassword() {
        // Add event code here...
        changePwdPopup.hide();
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

    public void setChangeRolePopup(RichPopup changeRolePopup) {
        this.changeRolePopup = changeRolePopup;
    }

    public RichPopup getChangeRolePopup() {
        return changeRolePopup;
    }

    public String cancelChangeRole() {
        // Add event code here...
        changeRolePopup.hide();
        return null;

    }

    public String createUserRole() {
        // Add event code here...

        BindingContainer bc = getBindings();
        DCIteratorBinding itr = (DCIteratorBinding) bc.get("USerRoleTransVO1Iterator");
        ViewObject vo = itr.getViewObject();
        Row row = vo.createRow();
        vo.insertRow(row);
        RichPopup.PopupHints ph = new RichPopup.PopupHints();
        changeRolePopup.show(ph);
        return null;
    }


    public String saveUserProfile() {
        // Add event code here...
        BindingContainer bc = getBindings();
        OperationBinding opr = bc.getOperationBinding("saveUserChange");
        opr.execute();
        changeRolePopup.hide();
        return null;
    }
}
