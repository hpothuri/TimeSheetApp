package model.vo;

import java.math.BigDecimal;

import model.eo.RecExpInfoEOImpl;

import oracle.jbo.server.ViewRowImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Mon Jul 18 16:14:20 IST 2016
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class RecExpInfoVORowImpl extends ViewRowImpl {

    public static final int ENTITY_RECEXPINFOEO = 0;

    /**
     * AttributesEnum: generated enum for identifying attributes and accessors. DO NOT MODIFY.
     */
    public enum AttributesEnum {
        ExpId,
        CandidateId,
        CompanyName,
        Title,
        ReasonsForLeaving;
        static AttributesEnum[] vals = null;
        ;
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

    public static final int EXPID = AttributesEnum.ExpId.index();
    public static final int CANDIDATEID = AttributesEnum.CandidateId.index();
    public static final int COMPANYNAME = AttributesEnum.CompanyName.index();
    public static final int TITLE = AttributesEnum.Title.index();
    public static final int REASONSFORLEAVING = AttributesEnum.ReasonsForLeaving.index();

    /**
     * This is the default constructor (do not remove).
     */
    public RecExpInfoVORowImpl() {
    }

    /**
     * Gets RecExpInfoEO entity object.
     * @return the RecExpInfoEO
     */
    public RecExpInfoEOImpl getRecExpInfoEO() {
        return (RecExpInfoEOImpl) getEntity(ENTITY_RECEXPINFOEO);
    }

    /**
     * Gets the attribute value for EXP_ID using the alias name ExpId.
     * @return the EXP_ID
     */
    public BigDecimal getExpId() {
        return (BigDecimal) getAttributeInternal(EXPID);
    }

    /**
     * Sets <code>value</code> as attribute value for EXP_ID using the alias name ExpId.
     * @param value value to set the EXP_ID
     */
    public void setExpId(BigDecimal value) {
        setAttributeInternal(EXPID, value);
    }

    /**
     * Gets the attribute value for CANDIDATE_ID using the alias name CandidateId.
     * @return the CANDIDATE_ID
     */
    public BigDecimal getCandidateId() {
        return (BigDecimal) getAttributeInternal(CANDIDATEID);
    }

    /**
     * Sets <code>value</code> as attribute value for CANDIDATE_ID using the alias name CandidateId.
     * @param value value to set the CANDIDATE_ID
     */
    public void setCandidateId(BigDecimal value) {
        setAttributeInternal(CANDIDATEID, value);
    }

    /**
     * Gets the attribute value for COMPANY_NAME using the alias name CompanyName.
     * @return the COMPANY_NAME
     */
    public String getCompanyName() {
        return (String) getAttributeInternal(COMPANYNAME);
    }

    /**
     * Sets <code>value</code> as attribute value for COMPANY_NAME using the alias name CompanyName.
     * @param value value to set the COMPANY_NAME
     */
    public void setCompanyName(String value) {
        setAttributeInternal(COMPANYNAME, value);
    }

    /**
     * Gets the attribute value for TITLE using the alias name Title.
     * @return the TITLE
     */
    public String getTitle() {
        return (String) getAttributeInternal(TITLE);
    }

    /**
     * Sets <code>value</code> as attribute value for TITLE using the alias name Title.
     * @param value value to set the TITLE
     */
    public void setTitle(String value) {
        setAttributeInternal(TITLE, value);
    }

    /**
     * Gets the attribute value for REASONS_FOR_LEAVING using the alias name ReasonsForLeaving.
     * @return the REASONS_FOR_LEAVING
     */
    public String getReasonsForLeaving() {
        return (String) getAttributeInternal(REASONSFORLEAVING);
    }

    /**
     * Sets <code>value</code> as attribute value for REASONS_FOR_LEAVING using the alias name ReasonsForLeaving.
     * @param value value to set the REASONS_FOR_LEAVING
     */
    public void setReasonsForLeaving(String value) {
        setAttributeInternal(REASONSFORLEAVING, value);
    }
}

