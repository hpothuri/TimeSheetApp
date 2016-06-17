package model.vo;

import java.math.BigDecimal;

import java.sql.Timestamp;

import model.eo.TimeSheetWeekHoursEOImpl;

import oracle.jbo.domain.DBSequence;
import oracle.jbo.server.ViewRowImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Tue Jun 14 12:00:57 IST 2016
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class TimeSheetWeekHoursVORowImpl extends ViewRowImpl {
    public static final int ENTITY_TIMESHEETWEEKHOURSEO = 0;

    /**
     * AttributesEnum: generated enum for identifying attributes and accessors. DO NOT MODIFY.
     */
    public enum AttributesEnum {
        TimeSheetId,
        DayId,
        Day,
        HoursPerDay,
        Notes;
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
    public static final int DAYID = AttributesEnum.DayId.index();
    public static final int DAY = AttributesEnum.Day.index();
    public static final int HOURSPERDAY = AttributesEnum.HoursPerDay.index();
    public static final int NOTES = AttributesEnum.Notes.index();

    /**
     * This is the default constructor (do not remove).
     */
    public TimeSheetWeekHoursVORowImpl() {
    }

    /**
     * Gets TimeSheetWeekHoursEO entity object.
     * @return the TimeSheetWeekHoursEO
     */
    public TimeSheetWeekHoursEOImpl getTimeSheetWeekHoursEO() {
        return (TimeSheetWeekHoursEOImpl) getEntity(ENTITY_TIMESHEETWEEKHOURSEO);
    }

    /**
     * Gets the attribute value for TIME_SHEET_ID using the alias name TimeSheetId.
     * @return the TIME_SHEET_ID
     */
    public BigDecimal getTimeSheetId() {
        return (BigDecimal) getAttributeInternal(TIMESHEETID);
    }

    /**
     * Sets <code>value</code> as attribute value for TIME_SHEET_ID using the alias name TimeSheetId.
     * @param value value to set the TIME_SHEET_ID
     */
    public void setTimeSheetId(BigDecimal value) {
        setAttributeInternal(TIMESHEETID, value);
    }

    /**
     * Gets the attribute value for DAY_ID using the alias name DayId.
     * @return the DAY_ID
     */
    public DBSequence getDayId() {
        return (DBSequence) getAttributeInternal(DAYID);
    }

    /**
     * Sets <code>value</code> as attribute value for DAY_ID using the alias name DayId.
     * @param value value to set the DAY_ID
     */
    public void setDayId(DBSequence value) {
        setAttributeInternal(DAYID, value);
    }

    /**
     * Gets the attribute value for DAY using the alias name Day.
     * @return the DAY
     */
    public Timestamp getDay() {
        return (Timestamp) getAttributeInternal(DAY);
    }

    /**
     * Sets <code>value</code> as attribute value for DAY using the alias name Day.
     * @param value value to set the DAY
     */
    public void setDay(Timestamp value) {
        setAttributeInternal(DAY, value);
    }

    /**
     * Gets the attribute value for HOURS_PER_DAY using the alias name HoursPerDay.
     * @return the HOURS_PER_DAY
     */
    public BigDecimal getHoursPerDay() {
        return (BigDecimal) getAttributeInternal(HOURSPERDAY);
    }

    /**
     * Sets <code>value</code> as attribute value for HOURS_PER_DAY using the alias name HoursPerDay.
     * @param value value to set the HOURS_PER_DAY
     */
    public void setHoursPerDay(BigDecimal value) {
        setAttributeInternal(HOURSPERDAY, value);
    }

    /**
     * Gets the attribute value for NOTES using the alias name Notes.
     * @return the NOTES
     */
    public String getNotes() {
        return (String) getAttributeInternal(NOTES);
    }

    /**
     * Sets <code>value</code> as attribute value for NOTES using the alias name Notes.
     * @param value value to set the NOTES
     */
    public void setNotes(String value) {
        setAttributeInternal(NOTES, value);
    }
}

