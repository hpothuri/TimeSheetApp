package model.eo;

import java.math.BigDecimal;

import oracle.jbo.AttributeList;
import oracle.jbo.Key;
import oracle.jbo.RowIterator;
import oracle.jbo.server.EntityDefImpl;
import oracle.jbo.server.EntityImpl;
import oracle.jbo.server.SequenceImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Wed Jun 22 11:38:33 IST 2016
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class TimeSheetRolesEOImpl extends EntityImpl {
    /**
     * AttributesEnum: generated enum for identifying attributes and accessors. DO NOT MODIFY.
     */
    public enum AttributesEnum {
        RoleId,
        Role,
        Description,
        TimeSheetUsersEO;
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
    public static final int ROLEID = AttributesEnum.RoleId.index();
    public static final int ROLE = AttributesEnum.Role.index();
    public static final int DESCRIPTION = AttributesEnum.Description.index();
    public static final int TIMESHEETUSERSEO = AttributesEnum.TimeSheetUsersEO.index();

    /**
     * This is the default constructor (do not remove).
     */
    public TimeSheetRolesEOImpl() {
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
     * Gets the attribute value for Role, using the alias name Role.
     * @return the value of Role
     */
    public String getRole() {
        return (String) getAttributeInternal(ROLE);
    }

    /**
     * Sets <code>value</code> as the attribute value for Role.
     * @param value value to set the Role
     */
    public void setRole(String value) {
        setAttributeInternal(ROLE, value);
    }

    /**
     * Gets the attribute value for Description, using the alias name Description.
     * @return the value of Description
     */
    public String getDescription() {
        return (String) getAttributeInternal(DESCRIPTION);
    }

    /**
     * Sets <code>value</code> as the attribute value for Description.
     * @param value value to set the Description
     */
    public void setDescription(String value) {
        setAttributeInternal(DESCRIPTION, value);
    }

    /**
     * @return the associated entity oracle.jbo.RowIterator.
     */
    public RowIterator getTimeSheetUsersEO() {
        return (RowIterator) getAttributeInternal(TIMESHEETUSERSEO);
    }

    /**
     * @param roleId key constituent

     * @return a Key object based on given key constituents.
     */
    public static Key createPrimaryKey(BigDecimal roleId) {
        return new Key(new Object[] { roleId });
    }

    /**
     * @return the definition object for this instance class.
     */
    public static synchronized EntityDefImpl getDefinitionObject() {
        return EntityDefImpl.findDefObject("model.eo.TimeSheetRolesEO");
    }

    /**
     * Add attribute defaulting logic in this method.
     * @param attributeList list of attribute names/values to initialize the row
     */
    protected void create(AttributeList attributeList) {
        super.create(attributeList);
        this.setRoleId(new SequenceImpl("TIMESHEET_ROLE_ID",getDBTransaction()).getSequenceNumber().getBigDecimalValue());
    }
}

