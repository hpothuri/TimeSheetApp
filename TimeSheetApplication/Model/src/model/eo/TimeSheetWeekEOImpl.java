package model.eo;

import java.math.BigDecimal;

import java.sql.Timestamp;

import oracle.jbo.AttributeList;
import oracle.jbo.Key;
import oracle.jbo.RowIterator;
import oracle.jbo.domain.BFileDomain;
import oracle.jbo.domain.DBSequence;
import oracle.jbo.server.EntityDefImpl;
import oracle.jbo.server.EntityImpl;
import oracle.jbo.server.SequenceImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Tue Jun 14 11:29:15 IST 2016
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class TimeSheetWeekEOImpl extends EntityImpl {
    /**
     * AttributesEnum: generated enum for identifying attributes and accessors. DO NOT MODIFY.
     */
    public enum AttributesEnum {
        TimeSheetId,
        WeekStartDate,
        WeekEndDate,
        TotalHours,
        TotalExpences,
        ApproverComments,
        UserId,
        Status,
        SubmittedBy,
        SubmittedTs,
        ApprovedTs,
        ApprovedBy,
        TaskId,
        TimeSheetWeekHoursEO,
        TimeSheetDaysEO1,
        TimeSheetDaysEO;
        private static AttributesEnum[] vals = null;
        private static final int firstIndex = 0;

        public int index() {
            return AttributesEnum.firstIndex() + ordinal();
        }

        public static final int firstIndex() {
            return firstIndex;
        }

        public static int count() {
            return AttributesEnum.firstIndex() + AttributesEnum.staticValues().length;
        }

        public static final AttributesEnum[] staticValues() {
            if (vals == null) {
                vals = AttributesEnum.values();
            }
            return vals;
        }
    }


    public static final int TIMESHEETID = AttributesEnum.TimeSheetId.index();
    public static final int WEEKSTARTDATE = AttributesEnum.WeekStartDate.index();
    public static final int WEEKENDDATE = AttributesEnum.WeekEndDate.index();
    public static final int TOTALHOURS = AttributesEnum.TotalHours.index();
    public static final int TOTALEXPENCES = AttributesEnum.TotalExpences.index();
    public static final int APPROVERCOMMENTS = AttributesEnum.ApproverComments.index();
    public static final int USERID = AttributesEnum.UserId.index();
    public static final int STATUS = AttributesEnum.Status.index();
    public static final int SUBMITTEDBY = AttributesEnum.SubmittedBy.index();
    public static final int SUBMITTEDTS = AttributesEnum.SubmittedTs.index();
    public static final int APPROVEDTS = AttributesEnum.ApprovedTs.index();
    public static final int APPROVEDBY = AttributesEnum.ApprovedBy.index();
    public static final int TASKID = AttributesEnum.TaskId.index();
    public static final int TIMESHEETWEEKHOURSEO = AttributesEnum.TimeSheetWeekHoursEO.index();
    public static final int TIMESHEETDAYSEO1 = AttributesEnum.TimeSheetDaysEO1.index();
    public static final int TIMESHEETDAYSEO = AttributesEnum.TimeSheetDaysEO.index();

    /**
     * This is the default constructor (do not remove).
     */
    public TimeSheetWeekEOImpl() {
    }

    /**
     * @return the definition object for this instance class.
     */
    public static synchronized EntityDefImpl getDefinitionObject() {
        return EntityDefImpl.findDefObject("model.eo.TimeSheetWeekEO");
    }


    /**
     * Gets the attribute value for TimeSheetId, using the alias name TimeSheetId.
     * @return the value of TimeSheetId
     */
    public BigDecimal getTimeSheetId() {
        return (BigDecimal) getAttributeInternal(TIMESHEETID);
    }

    /**
     * Sets <code>value</code> as the attribute value for TimeSheetId.
     * @param value value to set the TimeSheetId
     */
    public void setTimeSheetId(BigDecimal value) {
        setAttributeInternal(TIMESHEETID, value);
    }

    /**
     * Gets the attribute value for WeekStartDate, using the alias name WeekStartDate.
     * @return the value of WeekStartDate
     */
    public Timestamp getWeekStartDate() {
        return (Timestamp) getAttributeInternal(WEEKSTARTDATE);
    }

    /**
     * Sets <code>value</code> as the attribute value for WeekStartDate.
     * @param value value to set the WeekStartDate
     */
    public void setWeekStartDate(Timestamp value) {
        setAttributeInternal(WEEKSTARTDATE, value);
    }

    /**
     * Gets the attribute value for WeekEndDate, using the alias name WeekEndDate.
     * @return the value of WeekEndDate
     */
    public Timestamp getWeekEndDate() {
        return (Timestamp) getAttributeInternal(WEEKENDDATE);
    }

    /**
     * Sets <code>value</code> as the attribute value for WeekEndDate.
     * @param value value to set the WeekEndDate
     */
    public void setWeekEndDate(Timestamp value) {
        setAttributeInternal(WEEKENDDATE, value);
    }

    /**
     * Gets the attribute value for TotalHours, using the alias name TotalHours.
     * @return the value of TotalHours
     */
    public Integer getTotalHours() {
        return (Integer) getAttributeInternal(TOTALHOURS);
    }

    /**
     * Sets <code>value</code> as the attribute value for TotalHours.
     * @param value value to set the TotalHours
     */
    public void setTotalHours(Integer value) {
        setAttributeInternal(TOTALHOURS, value);
    }

    /**
     * Gets the attribute value for TotalExpences, using the alias name TotalExpences.
     * @return the value of TotalExpences
     */
    public BigDecimal getTotalExpences() {
        return (BigDecimal) getAttributeInternal(TOTALEXPENCES);
    }

    /**
     * Sets <code>value</code> as the attribute value for TotalExpences.
     * @param value value to set the TotalExpences
     */
    public void setTotalExpences(BigDecimal value) {
        setAttributeInternal(TOTALEXPENCES, value);
    }

    /**
     * Gets the attribute value for ApproverComments, using the alias name ApproverComments.
     * @return the value of ApproverComments
     */
    public String getApproverComments() {
        return (String) getAttributeInternal(APPROVERCOMMENTS);
    }

    /**
     * Sets <code>value</code> as the attribute value for ApproverComments.
     * @param value value to set the ApproverComments
     */
    public void setApproverComments(String value) {
        setAttributeInternal(APPROVERCOMMENTS, value);
    }

    /**
     * Gets the attribute value for UserId, using the alias name UserId.
     * @return the value of UserId
     */
    public BigDecimal getUserId() {
        return (BigDecimal) getAttributeInternal(USERID);
    }

    /**
     * Sets <code>value</code> as the attribute value for UserId.
     * @param value value to set the UserId
     */
    public void setUserId(BigDecimal value) {
        setAttributeInternal(USERID, value);
    }

    /**
     * Gets the attribute value for Status, using the alias name Status.
     * @return the value of Status
     */
    public String getStatus() {
        return (String) getAttributeInternal(STATUS);
    }

    /**
     * Sets <code>value</code> as the attribute value for Status.
     * @param value value to set the Status
     */
    public void setStatus(String value) {
        setAttributeInternal(STATUS, value);
    }

    /**
     * Gets the attribute value for SubmittedBy, using the alias name SubmittedBy.
     * @return the value of SubmittedBy
     */
    public BigDecimal getSubmittedBy() {
        return (BigDecimal) getAttributeInternal(SUBMITTEDBY);
    }

    /**
     * Sets <code>value</code> as the attribute value for SubmittedBy.
     * @param value value to set the SubmittedBy
     */
    public void setSubmittedBy(BigDecimal value) {
        setAttributeInternal(SUBMITTEDBY, value);
    }

    /**
     * Gets the attribute value for SubmittedTs, using the alias name SubmittedTs.
     * @return the value of SubmittedTs
     */
    public Timestamp getSubmittedTs() {
        return (Timestamp) getAttributeInternal(SUBMITTEDTS);
    }

    /**
     * Sets <code>value</code> as the attribute value for SubmittedTs.
     * @param value value to set the SubmittedTs
     */
    public void setSubmittedTs(Timestamp value) {
        setAttributeInternal(SUBMITTEDTS, value);
    }

    /**
     * Gets the attribute value for ApprovedTs, using the alias name ApprovedTs.
     * @return the value of ApprovedTs
     */
    public Timestamp getApprovedTs() {
        return (Timestamp) getAttributeInternal(APPROVEDTS);
    }

    /**
     * Sets <code>value</code> as the attribute value for ApprovedTs.
     * @param value value to set the ApprovedTs
     */
    public void setApprovedTs(Timestamp value) {
        setAttributeInternal(APPROVEDTS, value);
    }

    /**
     * Gets the attribute value for ApprovedBy, using the alias name ApprovedBy.
     * @return the value of ApprovedBy
     */
    public BigDecimal getApprovedBy() {
        return (BigDecimal) getAttributeInternal(APPROVEDBY);
    }

    /**
     * Sets <code>value</code> as the attribute value for ApprovedBy.
     * @param value value to set the ApprovedBy
     */
    public void setApprovedBy(BigDecimal value) {
        setAttributeInternal(APPROVEDBY, value);
    }



    /**
     * Gets the attribute value for TaskId, using the alias name TaskId.
     * @return the value of TaskId
     */
    public BigDecimal getTaskId() {
        return (BigDecimal) getAttributeInternal(TASKID);
    }

    /**
     * Sets <code>value</code> as the attribute value for TaskId.
     * @param value value to set the TaskId
     */
    public void setTaskId(BigDecimal value) {
        setAttributeInternal(TASKID, value);
    }

    /**
     * @return the associated entity oracle.jbo.RowIterator.
     */
    public RowIterator getTimeSheetWeekHoursEO() {
        return (RowIterator) getAttributeInternal(TIMESHEETWEEKHOURSEO);
    }


    /**
     * @return the associated entity oracle.jbo.RowIterator.
     */
    public RowIterator getTimeSheetDaysEO1() {
        return (RowIterator) getAttributeInternal(TIMESHEETDAYSEO1);
    }


    /**
     * @return the associated entity oracle.jbo.RowIterator.
     */
    public RowIterator getTimeSheetDaysEO() {
        return (RowIterator) getAttributeInternal(TIMESHEETDAYSEO);
    }


    /**
     * @param timeSheetId key constituent

     * @return a Key object based on given key constituents.
     */
    public static Key createPrimaryKey(BigDecimal timeSheetId) {
        return new Key(new Object[] { timeSheetId });
    }

    /**
     * Add attribute defaulting logic in this method.
     * @param attributeList list of attribute names/values to initialize the row
     */
    protected void create(AttributeList attributeList) {
        super.create(attributeList);
        this.setTimeSheetId(new SequenceImpl("TIMESHEET_WEEK_ID_SEQ",getDBTransaction()).getSequenceNumber().getBigDecimalValue());
    }
}

