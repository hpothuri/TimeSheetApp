package view.beans;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import java.math.BigDecimal;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import oracle.adf.model.AttributeBinding;
import oracle.adf.model.BindingContext;
import oracle.adf.model.binding.DCBindingContainer;
import oracle.adf.model.binding.DCIteratorBinding;
import oracle.adf.view.rich.component.rich.PartialRichPopup;
import oracle.adf.view.rich.component.rich.RichPopup;

import oracle.adf.view.rich.component.rich.input.RichInputText;

import oracle.binding.BindingContainer;

import oracle.binding.OperationBinding;

import oracle.jbo.Row;
import oracle.jbo.RowSetIterator;
import oracle.jbo.ViewObject;
import oracle.jbo.domain.BlobDomain;
import oracle.jbo.uicli.binding.JUCtrlListBinding;

import org.apache.commons.io.IOUtils;
import org.apache.myfaces.trinidad.render.ExtendedRenderKitService;
import org.apache.myfaces.trinidad.util.Service;

public class SubmittedTimeSheetsBean {
    private RichPopup submittedTSPopup;
    private RichInputText comments;
    private RichPopup attachmentsPopup;
    Boolean flag = Boolean.TRUE;

    public SubmittedTimeSheetsBean() {
    }

    public void setAttachmentsPopup(RichPopup attachmentsPopup) {
        this.attachmentsPopup = attachmentsPopup;
    }

    public RichPopup getAttachmentsPopup() {
        return attachmentsPopup;
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

    public String viewSubmittedTs() {
        // Add event code here...
        enableAttachment();
        submittedTSPopup.show(new RichPopup.PopupHints());
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

    public String approveTS() {
        // Add event code here...
        BindingContainer bc = getBindings();
        DCIteratorBinding itr = (DCIteratorBinding) bc.get("TimeSheetWeekVO1Iterator");
        ViewObject tsVO = itr.getViewObject();
        Row tsRow = tsVO.getCurrentRow();
        BigDecimal timeSheetId = (BigDecimal) tsRow.getAttribute("TimeSheetId");
        OperationBinding opr = bc.getOperationBinding("approveTimeSheet");
        AttributeBinding attr = (AttributeBinding) bc.get("TimeSheetId");
        opr.getParamsMap().put("timeSheetId", timeSheetId);
        opr.getParamsMap().put("comments", comments.getValue());
        opr.execute();
        showPopup(submittedTSPopup, false);
        return null;
    }

    public BindingContainer getBindings() {
        return BindingContext.getCurrent().getCurrentBindingsEntry();
    }

    public String rejectTS() {
        // Add event code here...
        BindingContainer bc = getBindings();
        DCIteratorBinding itr = (DCIteratorBinding) bc.get("TimeSheetWeekVO1Iterator");
        ViewObject tsVO = itr.getViewObject();
        Row tsRow = tsVO.getCurrentRow();
        BigDecimal timeSheetId = (BigDecimal) tsRow.getAttribute("TimeSheetId");
        OperationBinding opr = bc.getOperationBinding("rejectTimeSheet");
        AttributeBinding attr = (AttributeBinding) bc.get("TimeSheetId");
        opr.getParamsMap().put("timeSheetId", timeSheetId);
        opr.getParamsMap().put("comments", comments.getValue());
        opr.execute();
        showPopup(submittedTSPopup, false);
        return null;
    }

    public void setFlag(Boolean flag) {
        this.flag = flag;
    }

    public Boolean getFlag() {
        return flag;
    }

    public String showAttachments() {
        // Add event code here...
        AttributeBinding idAttr = (AttributeBinding) getBindings().get("WeekId");
        BigDecimal weekId = (BigDecimal) idAttr.getInputValue();
       // filterAttachmentViewObject(weekId);
        attachmentsPopup.show(new RichPopup.PopupHints());
        return null;
    }

    public void downloadFile(FacesContext facesContext, OutputStream outputStream) {
        // Add event code here...
        AttributeBinding fileAttr = (AttributeBinding) getBindings().get("AttachedFile");
        BlobDomain blob = (BlobDomain) fileAttr.getInputValue();
        InputStream in = blob.getInputStream();
        try {
            IOUtils.copy(in, outputStream);
            blob.closeInputStream();
            outputStream.flush();
        } catch (IOException e) {
            // handle errors
            e.printStackTrace();
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), "");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }

    public void filterAttachmentViewObject(BigDecimal weekId) {
        DCIteratorBinding itr = (DCIteratorBinding) getBindings().get("TimeSheetAttachmentsVO3Iterator");
        ViewObject vo = itr.getViewObject();
        vo.setWhereClause("TIMESHEET_ID=" + weekId);
        vo.executeQuery();
        if (vo.getEstimatedRowCount() > 0) {
            this.flag = Boolean.TRUE;
        } else {
            this.flag = Boolean.FALSE;
        }
    }

    /**
     * Set values on transient attributes, set read-only indicators, etc.  Called by View, Copy, and Reverse listeners
     * @param
     */
    public void enableAttachment() {

        BindingContext bc = BindingContext.getCurrent();
        DCBindingContainer bindings = (DCBindingContainer) bc.getCurrentBindingsEntry();
        // Get the Attachments iteraor
        DCIteratorBinding glIter = bindings.findIteratorBinding("TimeSheetDaysVO1Iterator");
        if (glIter != null && glIter.getRowSetIterator().getRowCount() > 0) {
            RowSetIterator rsi = glIter.getViewObject().createRowSetIterator(null);
            Row glRow;
            while (rsi.next() != null) {
                glRow = rsi.getCurrentRow();
                BigDecimal weekId = (BigDecimal) glRow.getAttribute("WeekId");
                // Set “rendered” indicators
                DCIteratorBinding itr = (DCIteratorBinding) getBindings().get("TimeSheetAttachmentsVO1Iterator");
                ViewObject vo = itr.getViewObject();
                vo.setWhereClause("TIMESHEET_ID=" + weekId);
                vo.executeQuery();

                if (vo.getEstimatedRowCount() > 0) {
                    this.flag = Boolean.TRUE;
                } else {
                    this.flag = Boolean.FALSE;
                }
                if (this.flag) {
                    glRow.setAttribute("IsAttached", Boolean.FALSE);
                } else {
                    glRow.setAttribute("IsAttached", Boolean.TRUE);
                }
            }
            rsi.closeRowSetIterator();
        }

    }
}
