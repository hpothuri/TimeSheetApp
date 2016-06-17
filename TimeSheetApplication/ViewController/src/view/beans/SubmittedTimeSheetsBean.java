package view.beans;

import java.math.BigDecimal;

import javax.faces.context.FacesContext;

import oracle.adf.model.AttributeBinding;
import oracle.adf.model.BindingContext;
import oracle.adf.view.rich.component.rich.RichPopup;

import oracle.adf.view.rich.component.rich.input.RichInputText;

import oracle.binding.BindingContainer;

import oracle.binding.OperationBinding;

import org.apache.myfaces.trinidad.render.ExtendedRenderKitService;
import org.apache.myfaces.trinidad.util.Service;

public class SubmittedTimeSheetsBean {
    private RichPopup submittedTSPopup;
    private RichInputText comments;

    public SubmittedTimeSheetsBean() {
    }

    public String viewSubmittedTs() {
        // Add event code here...
        showPopup(submittedTSPopup, true);
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

    public void setSubmittedTSPopup(RichPopup submittedTSPopup) {
        this.submittedTSPopup = submittedTSPopup;
    }

    public RichPopup getSubmittedTSPopup() {
        return submittedTSPopup;
    }

    public void setComments(RichInputText comments) {
        this.comments = comments;
    }

    public RichInputText getComments() {
        return comments;
    }

    public String approveTS() {
        // Add event code here...
        BindingContainer bc = getBindings();
        OperationBinding opr = bc.getOperationBinding("approveTimeSheet");
        AttributeBinding attr = (AttributeBinding) bc.get("TimeSheetId");
        BigDecimal timeSheetId = (BigDecimal) attr.getInputValue();
        opr.getParamsMap().put("timeSheetId", timeSheetId);
        opr.getParamsMap().put("comments",comments.getValue());


        return null;
    }

    public BindingContainer getBindings() {
        return BindingContext.getCurrent().getCurrentBindingsEntry();
    }
}
