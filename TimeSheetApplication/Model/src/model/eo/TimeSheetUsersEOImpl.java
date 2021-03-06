package model.eo;

import java.math.BigDecimal;

import oracle.jbo.AttributeList;
import oracle.jbo.Key;
import oracle.jbo.server.EntityDefImpl;
import oracle.jbo.server.EntityImpl;
import oracle.jbo.server.SequenceImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Tue Jun 21 14:49:37 IST 2016
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class TimeSheetUsersEOImpl extends EntityImpl {
    /**
     * AttributesEnum: generated enum for identifying attributes and accessors. DO NOT MODIFY.
     */
    public enum AttributesEnum {
        UserEmailId,
        CompanyName,
        Password,
        RoleId,
        UserId,
        ManagerId,
        UserName,
        TimeSheetRolesEO;
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
    public static final int USEREMAILID = AttributesEnum.UserEmailId.index();
    public static final int COMPANYNAME = AttributesEnum.CompanyName.index();
    public static final int PASSWORD = AttributesEnum.Password.index();
    public static final int ROLEID = AttributesEnum.RoleId.index();
    public static final int USERID = AttributesEnum.UserId.index();
    public static final int MANAGERID = AttributesEnum.ManagerId.index();
    public static final int USERNAME = AttributesEnum.UserName.index();
    public static final int TIMESHEETROLESEO = AttributesEnum.TimeSheetRolesEO.index();

    /**
     * This is the default constructor (do not remove).
     */
    public TimeSheetUsersEOImpl() {
    }

    /**
     * Gets the attribute value for UserEmailId, using the alias name UserEmailId.
     * @return the value of UserEmailId
     */
    public String getUserEmailId() {
        return (String) getAttributeInternal(USEREMAILID);
    }

    /**
     * Sets <code>value</code> as the attribute value for UserEmailId.
     * @param value value to set the UserEmailId
     */
    public void setUserEmailId(String value) {
        setAttributeInternal(USEREMAILID, value);
    }

    /**
     * Gets the attribute value for CompanyName, using the alias name CompanyName.
     * @return the value of CompanyName
     */
    public String getCompanyName() {
        return (String) getAttributeInternal(COMPANYNAME);
    }

    /**
     * Sets <code>value</code> as the attribute value for CompanyName.
     * @param value value to set the CompanyName
     */
    public void setCompanyName(String value) {
        setAttributeInternal(COMPANYNAME, value);
    }

    /**
     * Gets the attribute value for Password, using the alias name Password.
     * @return the value of Password
     */
    public String getPassword() {
        return (String) getAttributeInternal(PASSWORD);
    }

    /**
     * Sets <code>value</code> as the attribute value for Password.
     * @param value value to set the Password
     */
    public void setPassword(String value) {
        setAttributeInternal(PASSWORD, value);
    }

    /**
     * Gets the attribute value for RoleId, using the alias name RoleId.
     * @return the value of RoleId
     */
    public BigDecimal getRoleId() {
        return (BigDecimal) getAttributeInternal(ROLEID);
    }

    /**
     * Sets <code>value</code> as the attribute value for RoleId.
     * @param value value to set the RoleId
     */
    public void setRoleId(BigDecimal value) {
        setAttributeInternal(ROLEID, value);
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
     * Gets the attribute value for ManagerId, using the alias name ManagerId.
     * @return the value of ManagerId
     */
    public BigDecimal getManagerId() {
        return (BigDecimal) getAttributeInternal(MANAGERID);
    }

    /**
     * Sets <code>value</code> as the attribute value for ManagerId.
     * @param value value to set the ManagerId
     */
    public void setManagerId(BigDecimal value) {
        setAttributeInternal(MANAGERID, value);
    }

    /**
     * Gets the attribute value for UserName, using the alias name UserName.
     * @return the value of UserName
     */
    public String getUserName() {
        return (String) getAttributeInternal(USERNAME);
    }

    /**
     * Sets <code>value</code> as the attribute value for UserName.
     * @param value value to set the UserName
     */
    public void setUserName(String value) {
        setAttributeInternal(USERNAME, value);
    }

    /**
     * @return the associated entity oracle.jbo.server.EntityImpl.
     */
    public EntityImpl getTimeSheetRolesEO() {
        return (EntityImpl) getAttributeInternal(TIMESHEETROLESEO);
    }

    /**
     * Sets <code>value</code> as the associated entity oracle.jbo.server.EntityImpl.
     */
    public void setTimeSheetRolesEO(EntityImpl value) {
        setAttributeInternal(TIMESHEETROLESEO, value);
    }

    /**
     * @param userId key constituent

     * @return a Key object based on given key constituents.
     */
    public static Key createPrimaryKey(BigDecimal userId) {
        return new Key(new Object[] { userId });
    }

    /**
     * @return the definition object for this instance class.
     */
    public static synchronized EntityDefImpl getDefinitionObject() {
        return EntityDefImpl.findDefObject("model.eo.TimeSheetUsersEO");
    }

    /**
     * Add attribute defaulting logic in this method.
     * @param attributeList list of attribute names/values to initialize the row
     */
    protected void create(AttributeList attributeList) {
        super.create(attributeList);
        this.setUserId(new SequenceImpl("TIMESHEET_USERS_ID_SEQ",getDBTransaction()).getSequenceNumber().getBigDecimalValue());
    }
}

