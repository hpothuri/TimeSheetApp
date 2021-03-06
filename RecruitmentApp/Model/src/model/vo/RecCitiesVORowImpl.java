package model.vo;

import java.math.BigDecimal;

import model.eo.RecCitiesEOImpl;

import oracle.jbo.server.ViewRowImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Mon Jul 18 16:13:45 IST 2016
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class RecCitiesVORowImpl extends ViewRowImpl {
    public static final int ENTITY_RECCITIESEO = 0;

    /**
     * AttributesEnum: generated enum for identifying attributes and accessors. DO NOT MODIFY.
     */
    public enum AttributesEnum {
        CityId,
        CityName,
        StateId;
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
    public static final int CITYID = AttributesEnum.CityId.index();
    public static final int CITYNAME = AttributesEnum.CityName.index();
    public static final int STATEID = AttributesEnum.StateId.index();

    /**
     * This is the default constructor (do not remove).
     */
    public RecCitiesVORowImpl() {
    }

    /**
     * Gets RecCitiesEO entity object.
     * @return the RecCitiesEO
     */
    public RecCitiesEOImpl getRecCitiesEO() {
        return (RecCitiesEOImpl) getEntity(ENTITY_RECCITIESEO);
    }

    /**
     * Gets the attribute value for CITY_ID using the alias name CityId.
     * @return the CITY_ID
     */
    public BigDecimal getCityId() {
        return (BigDecimal) getAttributeInternal(CITYID);
    }

    /**
     * Sets <code>value</code> as attribute value for CITY_ID using the alias name CityId.
     * @param value value to set the CITY_ID
     */
    public void setCityId(BigDecimal value) {
        setAttributeInternal(CITYID, value);
    }

    /**
     * Gets the attribute value for CITY_NAME using the alias name CityName.
     * @return the CITY_NAME
     */
    public String getCityName() {
        return (String) getAttributeInternal(CITYNAME);
    }

    /**
     * Sets <code>value</code> as attribute value for CITY_NAME using the alias name CityName.
     * @param value value to set the CITY_NAME
     */
    public void setCityName(String value) {
        setAttributeInternal(CITYNAME, value);
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
}

