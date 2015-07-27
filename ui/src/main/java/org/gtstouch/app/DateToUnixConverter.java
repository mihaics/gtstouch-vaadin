/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.gtstouch.app;

import com.vaadin.data.util.converter.Converter;
import java.util.Date;
import java.util.Locale;

/**
 *
 * @author mihai
 */
public class DateToUnixConverter implements Converter<Date, Integer> {

    /*
     * (non-Javadoc)
     *
     * @see
     * com.vaadin.data.util.converter.Converter#convertToModel(java.lang.Object,
     * java.lang.Class, java.util.Locale)
     */
    @Override
    public Integer convertToModel(Date value, Class<? extends Integer> targetType,
            Locale locale) {
        if (value == null) {
            return null;
        }

        return Integer.parseInt(Integer.toString(Math.round(value.getTime() / 1000)));
    }

    /*
     * (non-Javadoc)
     *
     * @see
     * com.vaadin.data.util.converter.Converter#convertToPresentation(java.lang
     * .Object, java.lang.Class, java.util.Locale)
     */
    @Override
    public Date convertToPresentation(Integer value,
            Class<? extends Date> targetType, Locale locale) {
        if (targetType != getPresentationType()) {
            throw new ConversionException("Converter only supports "
                    + getPresentationType().getName() + " (targetType was "
                    + targetType.getName() + ")");
        }
        if (value == null) {
            return null;
        }

        return new Date((Long.valueOf(value) * 1000));

    }

    /*
     * (non-Javadoc)
     *
     * @see com.vaadin.data.util.converter.Converter#getModelType()
     */
    @Override
    public Class<Integer> getModelType() {
        return Integer.class;
    }

    /*
     * (non-Javadoc)
     *
     * @see com.vaadin.data.util.converter.Converter#getPresentationType()
     */
    @Override
    public Class<Date> getPresentationType() {
        return Date.class;
    }

}
