package view.beans;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import java.math.BigDecimal;

import java.sql.SQLException;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;

import oracle.adf.model.AttributeBinding;
import oracle.adf.model.BindingContext;
import oracle.adf.model.binding.DCIteratorBinding;
import oracle.adf.share.ADFContext;
import oracle.adf.view.rich.component.rich.RichPopup;

import oracle.binding.BindingContainer;
import oracle.binding.OperationBinding;

import oracle.jbo.Row;
import oracle.jbo.ViewObject;
import oracle.jbo.domain.BlobDomain;
import oracle.jbo.server.ViewObjectImpl;

import org.apache.commons.io.IOUtils;
import org.apache.myfaces.trinidad.model.UploadedFile;
import org.apache.myfaces.trinidad.render.ExtendedRenderKitService;
import org.apache.myfaces.trinidad.util.Service;

public class TimeSheetsViewBean {
    private RichPopup tsDaysPopup;
    private RichPopup uploadPopup;
    private RichPopup delTsDaysPopup;
    private RichPopup submitConfirmPopup;
    private RichPopup createTsPopup;

    public void setUploadPopup(RichPopup uploadPopup) {
        this.uploadPopup = uploadPopup;
    }

    public RichPopup getUploadPopup() {
        return uploadPopup;
    }
    UploadedFile myFile;

    public void setMyFile(UploadedFile myFile) {
        this.myFile = myFile;
    }

    public UploadedFile getMyFile() {
        return myFile;
    }

    public TimeSheetsViewBean() {
    }

    public void setTsDaysPopup(RichPopup tsDaysPopup) {
        this.tsDaysPopup = tsDaysPopup;
    }

    public RichPopup getTsDaysPopup() {
        return tsDaysPopup;
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

    private int totalHours() {
        BindingContainer bc = getBindings();
        DCIteratorBinding itr = (DCIteratorBinding) bc.get("TimeSheetDaysVO1Iterator");
        ViewObject vo = itr.getViewObject();
        Row row = vo.getCurrentRow();
        int count = 0;
        int day1 = (Integer) row.getAttribute("Day1");
        int day2 = (Integer) row.getAttribute("Day2");
        int day3 = (Integer) row.getAttribute("Day3");
        int day4 = (Integer) row.getAttribute("Day4");
        int day5 = (Integer) row.getAttribute("Day5");
        int day6 = (Integer) row.getAttribute("Day6");
        int day7 = (Integer) row.getAttribute("Day7");
        count = day1 + day2 + day3 + day4 + day5 + day6 + day7;
        return count;
    }

    public String submitTsAction() {
        // Add event code here...
        if (totalHours() > 0) {
            BindingContainer bc = getBindings();
            OperationBinding opr = bc.getOperationBinding("submitForApproval");
            AttributeBinding attr = (AttributeBinding) bc.get("TimeSheetId");
            BigDecimal timeSheetId = (BigDecimal) attr.getInputValue();
            opr.getParamsMap().put("timeSheetId", timeSheetId);
            opr.execute();
            submitConfirmPopup.hide();
            showPopup(tsDaysPopup, false);
        } else {
            submitConfirmPopup.hide();
            FacesMessage fm = new FacesMessage("Please enter time sheet hours for atleast one day");
            fm.setSeverity(FacesMessage.SEVERITY_ERROR);
            FacesContext ctx = FacesContext.getCurrentInstance();
            ctx.addMessage(null, fm);
        }
        return null;
    }

    public String deleteTsAction() {
        // Add event code here...
        //delete from tsDays
        //if 0 count then close popup
        BindingContainer bc = getBindings();
        OperationBinding opr = bc.getOperationBinding("deleteTimeSheetHours");
        AttributeBinding attr = (AttributeBinding) bc.get("TimeSheetId");
        BigDecimal timeSheetID = (BigDecimal) attr.getInputValue();
        opr.getParamsMap().put("timeSheetId", timeSheetID);
        Boolean flag = (Boolean) opr.execute();
        delTsDaysPopup.hide();
        if (flag == Boolean.FALSE) {
            showPopup(tsDaysPopup, false);
        } else {
            showPopup(tsDaysPopup, true);
        }
        return null;
    }

    public String unSubmitAction() {
        // Add event code here...
        BindingContainer bc = getBindings();
        OperationBinding opr = bc.getOperationBinding("unSubmitTimeSheet");
        AttributeBinding statusAttr = (AttributeBinding) bc.get("Status");
        String status = statusAttr.getInputValue().toString();
        if (status.equalsIgnoreCase("Submitted")) {
            AttributeBinding attr = (AttributeBinding) bc.get("TimeSheetId");
            BigDecimal timeSheetID = (BigDecimal) attr.getInputValue();
            opr.getParamsMap().put("timeSheetId", timeSheetID);
            opr.execute();
        } else {
            FacesMessage fm = new FacesMessage("Can't unsubmit Approved/Rejected TimeSheet");
            fm.setSeverity(FacesMessage.SEVERITY_ERROR);
            FacesContext ctx = FacesContext.getCurrentInstance();
            ctx.addMessage(null, fm);
        }
        return null;
    }

 /*   public String newTsAction() {
        // Add event code here...
        BindingContainer bc = getBindings();
        OperationBinding opr = bc.getOperationBinding("createTimeSheet");
        opr.getParamsMap().put("currentDate", new Date());
        opr.execute();
        return null;
    }*/

    private Date getDate() {
        String dateStr = "22/Jan/2016";
        Date startDate = null;
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MMM/yyyy");
        try {
            startDate = (Date) formatter.parse(dateStr);
        } catch (ParseException e) {
        }
        return startDate;
    }

    public String editTsAction() {
        // Add event code here...
        BindingContainer bc = getBindings();

        DCIteratorBinding itr = (DCIteratorBinding) bc.get("TimeSheetDaysVO1Iterator");
        ViewObject daysVO = itr.getViewObject();
        long count = daysVO.getEstimatedRowCount();
        if (count == 0) {
            OperationBinding opr = bc.getOperationBinding("addTimeSheetHours");
            AttributeBinding attr = (AttributeBinding) bc.get("TimeSheetId");
            opr.getParamsMap().put("timeSheetId", (BigDecimal) attr.getInputValue());
            opr.execute();
        }

        OperationBinding opr1 = bc.getOperationBinding("getAttachments");
        opr1.execute();
        return null;
    }

    public String addTsHourssAction() {
        // Add event code here...
        BindingContainer bc = getBindings();
        OperationBinding opr = bc.getOperationBinding("addTimeSheetHours");
        AttributeBinding attr = (AttributeBinding) bc.get("TimeSheetId");
        opr.getParamsMap().put("timeSheetId", (BigDecimal) attr.getInputValue());
        opr.execute();

        return null;
    }

    public String viewAllAction() {
        // Add event code here...
        BindingContainer bc = getBindings();
        OperationBinding opr = bc.getOperationBinding("ViewAllTs");
        opr.execute();
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

    public String uploadFile() {
        // Add event code here...
        UploadedFile myfile = this.getMyFile();
        BindingContainer bc = getBindings();

        //set parameters for uploadFile()
        oracle.binding.AttributeBinding attr = (oracle.binding.AttributeBinding) bc.get("TimeSheetId");
        BigDecimal timeSheetId = (BigDecimal) attr.getInputValue();
        String contentType = myfile.getContentType();
        String fName = myfile.getFilename();

        OperationBinding opr = bc.getOperationBinding("uploadFile");
        opr.getParamsMap().put("fileName", fName);
        opr.getParamsMap().put("contentType", contentType);
        opr.getParamsMap().put("file", createBlobDomain(myfile));
        opr.execute();
       
        DCIteratorBinding itr = (DCIteratorBinding) bc.get("TimeSheetAttachmentsVO3Iterator");
        ViewObject attchVO = itr.getViewObject();
        attchVO.executeQuery();
        showPopup(uploadPopup, false);
        return null;
    }

    private BlobDomain createBlobDomain(UploadedFile myfile) {
        InputStream in = null;
        BlobDomain blobDomain = null;
        OutputStream out = null;
        try {
            in = myfile.getInputStream();
            blobDomain = new BlobDomain();
            out = blobDomain.getBinaryOutputStream();
            IOUtils.copy(in, out);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
        }
        return blobDomain;
    }

    public String undoDelete() {
        // Add event code here...
        delTsDaysPopup.hide();
        return null;
    }

    public void setDelTsDaysPopup(RichPopup delTsDaysPopup) {
        this.delTsDaysPopup = delTsDaysPopup;
    }

    public RichPopup getDelTsDaysPopup() {
        return delTsDaysPopup;
    }

    public String saveTs() {
        // Add event code here...
        BindingContainer bc = getBindings();
        OperationBinding opr = bc.getOperationBinding("saveTimeSheet");
        AttributeBinding attr = (AttributeBinding) bc.get("TimeSheetId");
        BigDecimal timeSheetId = (BigDecimal) attr.getInputValue();
        opr.getParamsMap().put("timeSheetId", timeSheetId);
        opr.execute();
        showPopup(tsDaysPopup, false);
        return null;
    }

    public void setSubmitConfirmPopup(RichPopup submitConfirmPopup) {
        this.submitConfirmPopup = submitConfirmPopup;
    }

    public RichPopup getSubmitConfirmPopup() {
        return submitConfirmPopup;
    }

    public String cancelSubmission() {
        // Add event code here...
        submitConfirmPopup.hide();
        return null;
    }

    public void setCreateTsPopup(RichPopup createTsPopup) {
        this.createTsPopup = createTsPopup;
    }

    public RichPopup getCreateTsPopup() {
        return createTsPopup;
    }

    public String createTsForSelectDate() {
        // Add event code here...
        BindingContainer bc = getBindings();
        OperationBinding opr = bc.getOperationBinding("createNewTimeSheet");
        AttributeBinding attr = (AttributeBinding) bc.get("currentDate");
        Date selectedDate = (Date) attr.getInputValue();
        opr.getParamsMap().put("currentDate", selectedDate);
        opr.execute();
        return null;
    }

    public Date getCurrentDate() {

        Date cdate = new Date();

        return cdate;

    }
}
