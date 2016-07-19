package model.vo;

import java.math.BigDecimal;

import model.eo.RecReferralInfoEOImpl;

import oracle.jbo.server.ViewRowImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Mon Jul 18 16:14:55 IST 2016
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class RecReferralInfoVORowImpl extends ViewRowImpl {

    public static final int ENTITY_RECREFERRALINFOEO = 0;

    /**
     * AttributesEnum: generated enum for identifying attributes and accessors. DO NOT MODIFY.
     */
    public enum AttributesEnum {
        ReferralId,
        CandidateId,
        RecruiterName,
        ReferenceName;
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

    public static final int REFERRALID = AttributesEnum.ReferralId.index();
    public static final int CANDIDATEID = AttributesEnum.CandidateId.index();
    public static final int RECRUITERNAME = AttributesEnum.RecruiterName.index();
    public static final int REFERENCENAME = AttributesEnum.ReferenceName.index();

    /**
     * This is the default constructor (do not remove).
     */
    public RecReferralInfoVORowImpl() {
    }

    /**
     * Gets RecReferralInfoEO entity object.
     * @return the RecReferralInfoEO
     */
    public RecReferralInfoEOImpl getRecReferralInfoEO() {
        return (RecReferralInfoEOImpl) getEntity(ENTITY_RECREFERRALINFOEO);
    }

    /**
     * Gets the attribute value for REFERRAL_ID using the alias name ReferralId.
     * @return the REFERRAL_ID
     */
    public BigDecimal getReferralId() {
        return (BigDecimal) getAttributeInternal(REFERRALID);
    }

    /**
     * Sets <code>value</code> as attribute value for REFERRAL_ID using the alias name ReferralId.
     * @param value value to set the REFERRAL_ID
     */
    public void setReferralId(BigDecimal value) {
        setAttributeInternal(REFERRALID, value);
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
     * Gets the attribute value for RECRUITER_NAME using the alias name RecruiterName.
     * @return the RECRUITER_NAME
     */
    public String getRecruiterName() {
        return (String) getAttributeInternal(RECRUITERNAME);
    }

    /**
     * Sets <code>value</code> as attribute value for RECRUITER_NAME using the alias name RecruiterName.
     * @param value value to set the RECRUITER_NAME
     */
    public void setRecruiterName(String value) {
        setAttributeInternal(RECRUITERNAME, value);
    }

    /**
     * Gets the attribute value for REFERENCE_NAME using the alias name ReferenceName.
     * @return the REFERENCE_NAME
     */
    public String getReferenceName() {
        return (String) getAttributeInternal(REFERENCENAME);
    }

    /**
     * Sets <code>value</code> as attribute value for REFERENCE_NAME using the alias name ReferenceName.
     * @param value value to set the REFERENCE_NAME
     */
    public void setReferenceName(String value) {
        setAttributeInternal(REFERENCENAME, value);
    }
}
