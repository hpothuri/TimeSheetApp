package model.eo;

import java.math.BigDecimal;

import java.sql.Timestamp;

import oracle.jbo.AttributeList;
import oracle.jbo.Key;
import oracle.jbo.domain.BlobDomain;
import oracle.jbo.server.EntityDefImpl;
import oracle.jbo.server.EntityImpl;
import oracle.jbo.server.SequenceImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Thu Jun 30 13:04:45 IST 2016
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class TimeSheetAttachmentsEOImpl extends EntityImpl {
    /**
     * AttributesEnum: generated enum for identifying attributes and accessors. DO NOT MODIFY.
     */
    public enum AttributesEnum {
        AttachmentId,
        TimesheetId,
        FileType,
        FileName,
        AttachedFile,
        CreatedBy,
        CreatedDate,
        LastUpdatedBy,
        LastUpdatedDate;
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

    public static final int ATTACHMENTID = AttributesEnum.AttachmentId.index();
    public static final int TIMESHEETID = AttributesEnum.TimesheetId.index();
    public static final int FILETYPE = AttributesEnum.FileType.index();
    public static final int FILENAME = AttributesEnum.FileName.index();
    public static final int ATTACHEDFILE = AttributesEnum.AttachedFile.index();
    public static final int CREATEDBY = AttributesEnum.CreatedBy.index();
    public static final int CREATEDDATE = AttributesEnum.CreatedDate.index();
    public static final int LASTUPDATEDBY = AttributesEnum.LastUpdatedBy.index();
    public static final int LASTUPDATEDDATE = AttributesEnum.LastUpdatedDate.index();

    /**
     * This is the default constructor (do not remove).
     */
    public TimeSheetAttachmentsEOImpl() {
    }

    /**
     * @return the definition object for this instance class.
     */
    public static synchronized EntityDefImpl getDefinitionObject() {
        return EntityDefImpl.findDefObject("model.eo.TimeSheetAttachmentsEO");
    }

    /**
     * Gets the attribute value for AttachmentId, using the alias name AttachmentId.
     * @return the value of AttachmentId
     */
    public BigDecimal getAttachmentId() {
        return (BigDecimal) getAttributeInternal(ATTACHMENTID);
    }

    /**
     * Sets <code>value</code> as the attribute value for AttachmentId.
     * @param value value to set the AttachmentId
     */
    public void setAttachmentId(BigDecimal value) {
        setAttributeInternal(ATTACHMENTID, value);
    }

    /**
     * Gets the attribute value for TimesheetId, using the alias name TimesheetId.
     * @return the value of TimesheetId
     */
    public BigDecimal getTimesheetId() {
        return (BigDecimal) getAttributeInternal(TIMESHEETID);
    }

    /**
     * Sets <code>value</code> as the attribute value for TimesheetId.
     * @param value value to set the TimesheetId
     */
    public void setTimesheetId(BigDecimal value) {
        setAttributeInternal(TIMESHEETID, value);
    }

    /**
     * Gets the attribute value for FileType, using the alias name FileType.
     * @return the value of FileType
     */
    public String getFileType() {
        return (String) getAttributeInternal(FILETYPE);
    }

    /**
     * Sets <code>value</code> as the attribute value for FileType.
     * @param value value to set the FileType
     */
    public void setFileType(String value) {
        setAttributeInternal(FILETYPE, value);
    }

    /**
     * Gets the attribute value for FileName, using the alias name FileName.
     * @return the value of FileName
     */
    public String getFileName() {
        return (String) getAttributeInternal(FILENAME);
    }

    /**
     * Sets <code>value</code> as the attribute value for FileName.
     * @param value value to set the FileName
     */
    public void setFileName(String value) {
        setAttributeInternal(FILENAME, value);
    }

    /**
     * Gets the attribute value for AttachedFile, using the alias name AttachedFile.
     * @return the value of AttachedFile
     */
    public BlobDomain getAttachedFile() {
        return (BlobDomain) getAttributeInternal(ATTACHEDFILE);
    }

    /**
     * Sets <code>value</code> as the attribute value for AttachedFile.
     * @param value value to set the AttachedFile
     */
    public void setAttachedFile(BlobDomain value) {
        setAttributeInternal(ATTACHEDFILE, value);
    }

    /**
     * Gets the attribute value for CreatedBy, using the alias name CreatedBy.
     * @return the value of CreatedBy
     */
    public BigDecimal getCreatedBy() {
        return (BigDecimal) getAttributeInternal(CREATEDBY);
    }

    /**
     * Sets <code>value</code> as the attribute value for CreatedBy.
     * @param value value to set the CreatedBy
     */
    public void setCreatedBy(BigDecimal value) {
        setAttributeInternal(CREATEDBY, value);
    }

    /**
     * Gets the attribute value for CreatedDate, using the alias name CreatedDate.
     * @return the value of CreatedDate
     */
    public Timestamp getCreatedDate() {
        return (Timestamp) getAttributeInternal(CREATEDDATE);
    }

    /**
     * Sets <code>value</code> as the attribute value for CreatedDate.
     * @param value value to set the CreatedDate
     */
    public void setCreatedDate(Timestamp value) {
        setAttributeInternal(CREATEDDATE, value);
    }

    /**
     * Gets the attribute value for LastUpdatedBy, using the alias name LastUpdatedBy.
     * @return the value of LastUpdatedBy
     */
    public BigDecimal getLastUpdatedBy() {
        return (BigDecimal) getAttributeInternal(LASTUPDATEDBY);
    }

    /**
     * Sets <code>value</code> as the attribute value for LastUpdatedBy.
     * @param value value to set the LastUpdatedBy
     */
    public void setLastUpdatedBy(BigDecimal value) {
        setAttributeInternal(LASTUPDATEDBY, value);
    }

    /**
     * Gets the attribute value for LastUpdatedDate, using the alias name LastUpdatedDate.
     * @return the value of LastUpdatedDate
     */
    public Timestamp getLastUpdatedDate() {
        return (Timestamp) getAttributeInternal(LASTUPDATEDDATE);
    }

    /**
     * Sets <code>value</code> as the attribute value for LastUpdatedDate.
     * @param value value to set the LastUpdatedDate
     */
    public void setLastUpdatedDate(Timestamp value) {
        setAttributeInternal(LASTUPDATEDDATE, value);
    }


    /**
     * @param attachmentId key constituent

     * @return a Key object based on given key constituents.
     */
    public static Key createPrimaryKey(BigDecimal attachmentId) {
        return new Key(new Object[] { attachmentId });
    }

    /**
     * Add attribute defaulting logic in this method.
     * @param attributeList list of attribute names/values to initialize the row
     */
    protected void create(AttributeList attributeList) {
        super.create(attributeList);
        this.setAttachmentId(new SequenceImpl("TIMESHEET_ATTACHMENT_ID_SEQ",getDBTransaction()).getSequenceNumber().getBigDecimalValue());
    }
}

