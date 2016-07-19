package model.vo;

import java.math.BigDecimal;

import model.eo.RecStatesEOImpl;

import oracle.jbo.server.ViewRowImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Mon Jul 18 16:15:22 IST 2016
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class RecStatesVORowImpl extends ViewRowImpl {
    public static final int ENTITY_RECSTATESEO = 0;

    /**
     * AttributesEnum: generated enum for identifying attributes and accessors. DO NOT MODIFY.
     */
    public enum AttributesEnum {
        StateId,
        StateName;
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
    public static final int STATEID = AttributesEnum.StateId.index();
    public static final int STATENAME = AttributesEnum.StateName.index();

    /**
     * This is the default constructor (do not remove).
     */
    public RecStatesVORowImpl() {
    }

    /**
     * Gets RecStatesEO entity object.
     * @return the RecStatesEO
     */
    public RecStatesEOImpl getRecStatesEO() {
        return (RecStatesEOImpl) getEntity(ENTITY_RECSTATESEO);
    }

    /**
     * Gets the attribute value for STATE_ID using the alias name StateId.
     * @return the STATE_ID
     */
    public BigDecimal getStateId() {
        return (BigDecimal) getAttributeInternal(STATEID);
    }

    /**
     * Sets <code>value</code> as attribute value for STATE_ID using the alias name StateId.
     * @param value value to set the STATE_ID
     */
    public void setStateId(BigDecimal value) {
        setAttributeInternal(STATEID, value);
    }

    /**
     * Gets the attribute value for STATE_NAME using the alias name StateName.
     * @return the STATE_NAME
     */
    public String getStateName() {
        return (String) getAttributeInternal(STATENAME);
    }

    /**
     * Sets <code>value</code> as attribute value for STATE_NAME using the alias name StateName.
     * @param value value to set the STATE_NAME
     */
    public void setStateName(String value) {
        setAttributeInternal(STATENAME, value);
    }
}
