package com.comm;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class Filter {
    private static final long serialVersionUID = -8712382358441065075L;
    private static final boolean defaultIgnoreCase = false;
    private String property;
    private Filter.Operator operator;
    private Object value;
    private Boolean ignoreCase = Boolean.valueOf(defaultIgnoreCase);

    public Filter() {
    }

    public Filter(String property, Filter.Operator operator, Object value) {
        this.property = property;
        this.operator = operator;
        this.value = value;
    }

    public Filter(String property, Filter.Operator operator, Object value,
            boolean ignoreCase) {
        this.property = property;
        this.operator = operator;
        this.value = value;
        this.ignoreCase = Boolean.valueOf(ignoreCase);
    }

    public static Filter eq(String property, Object value) {
        return new Filter(property, Filter.Operator.eq, value);
    }

    public static Filter eq(String property, Object value, boolean ignoreCase) {
        return new Filter(property, Filter.Operator.eq, value, ignoreCase);
    }

    public static Filter ne(String property, Object value) {
        return new Filter(property, Filter.Operator.ne, value);
    }

    public static Filter ne(String property, Object value, boolean ignoreCase) {
        return new Filter(property, Filter.Operator.ne, value, ignoreCase);
    }

    public static Filter gt(String property, Object value) {
        return new Filter(property, Filter.Operator.gt, value);
    }

    public static Filter lt(String property, Object value) {
        return new Filter(property, Filter.Operator.lt, value);
    }

    public static Filter ge(String property, Object value) {
        return new Filter(property, Filter.Operator.ge, value);
    }

    public static Filter le(String property, Object value) {
        return new Filter(property, Filter.Operator.le, value);
    }

    public static Filter like(String property, Object value) {
        return new Filter(property, Filter.Operator.like, value);
    }

    public static Filter in(String property, Object value) {
        return new Filter(property, Filter.Operator.in, value);
    }

    public static Filter isNull(String property) {
        return new Filter(property, Filter.Operator.isNull, null);
    }

    public static Filter isNotNull(String property) {
        return new Filter(property, Filter.Operator.isNotNull, null);
    }

    public Filter ignoreCase() {
        this.ignoreCase = Boolean.valueOf(true);
        return this;
    }

    public String getProperty() {
        return this.property;
    }

    public void setProperty(String property) {
        this.property = property;
    }

    public Filter.Operator getOperator() {
        return this.operator;
    }

    public void setOperator(Filter.Operator operator) {
        this.operator = operator;
    }

    public Object getValue() {
        return this.value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public Boolean getIgnoreCase() {
        return this.ignoreCase;
    }

    public void setIgnoreCase(Boolean ignoreCase) {
        this.ignoreCase = ignoreCase;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        Filter localFilter = (Filter) obj;
        return new EqualsBuilder()
                .append(getProperty(), localFilter.getProperty())
                .append(getOperator(), localFilter.getOperator())
                .append(getValue(), localFilter.getValue()).isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder(17, 37).append(getProperty())
                .append(getOperator()).append(getValue()).toHashCode();
    }

    public enum Operator {
        eq, ne, gt, lt, ge, le, like, in, isNull, isNotNull, or, notin;

        public static Operator fromString(String value) {
            return valueOf(value.toLowerCase());
        }
    }
}
