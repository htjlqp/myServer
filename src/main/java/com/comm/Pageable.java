package com.comm;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import com.comm.Filter.Operator;
import com.mossle.core.query.PropertyFilter;
import com.mossle.core.util.StringUtils;
import com.myLanguage.Myif;

public class Pageable {

    private static final long serialVersionUID = -3930180379790344299L;
    private static final Long DEFAULT_PAGE_NUMBER = 1L;

    private static final Long DEFAULT_PAGE_SIZE = 20L;
    private static final int MAX_PAGESIZE = 1000;
    private Long pageNumber = DEFAULT_PAGE_NUMBER;
    private Long pageSize = DEFAULT_PAGE_SIZE;
    private String searchProperty;
    private String searchValue;
    private String orderProperty;
    private List<Filter> orFilters = new ArrayList<Filter>();
    private Order.Direction orderDirection;
    private List<Filter> filters = new ArrayList<Filter>();
    private List<Order> orders = new ArrayList<Order>();
    private Long pageNo = 1L;
    
    private Operator retOperator(String filterName){
    		if(filterName.startsWith("EQS"))
    			return Operator.eq;
    		else if(filterName.startsWith("LIKES"))
    			return Operator.like;
    		return Operator.eq;
    }
    private void build(Map<String, Object> filterParamMap) {
        // 分析参数Map,构造PropertyFilter列表
        for (Map.Entry<String, Object> entry : filterParamMap.entrySet()) {
            String filterName = entry.getKey();
            Object filterValue = entry.getValue();
            String value = null;
            if (filterValue instanceof String[]) {
                value = ((String[]) filterValue)[0];
            } else {
                value = (String) filterValue;
            }
            // 如果value值为空,则忽略此filter.
            if (StringUtils.isNotBlank(value)) {
            		String[] str=filterName.split("_");
                addFilter(str[1], retOperator(str[0]), value);
            }
        }
    }
    private void buildFromMap(
            Map<String, Object> parameterMap, String filterPrefix) {
        Map<String, Object> filterParamMap = new TreeMap<String, Object>();
        for (Map.Entry<String, Object> entry : parameterMap.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            if (key.startsWith(filterPrefix))
                filterParamMap.put(key.substring(filterPrefix.length()), value);
        }
        build(filterParamMap);
    }
    public void addFilter(Map<String, Object> parameterMap){
    		buildFromMap(parameterMap, "filter_");
    }
    public Long getPageNo() {
		return pageNumber;
	}

	public void setPageNo(Long pageNo) {
		this.pageNumber=this.pageNo = pageNo;
	}

	public static Pageable createMaxSizePageable() {
        return new Pageable(1, Integer.MAX_VALUE);
    }

    public Pageable() {
    }

    public Pageable(Integer pageNumber, Integer pageSize) {
        if ((pageNumber != null) && (pageNumber.intValue() >= 1)) {
            this.pageNumber = pageNumber.longValue();
        }
        if ((pageSize != null) && (pageSize.intValue() >= 1)
                && (pageSize.intValue() <= MAX_PAGESIZE)) {
            this.pageSize = pageSize.longValue();
        }
    }

    public List<Filter> getOrFilters() {
        return orFilters;
    }

    public void setOrFilters(List<Filter> orFilters) {
        this.orFilters = orFilters;
    }

    public Long getPageNumber() {
        return this.pageNumber;
    }

    public void setPageNumber(Long pageNumber) {
        if (pageNumber < 1) {
            pageNumber = DEFAULT_PAGE_NUMBER;
        }
        this.pageNumber = pageNumber;
    }

    public Long getPageSize() {
        return this.pageSize;
    }

    public void setPageSize(Long pageSize) {
        if ((pageSize < 1) || (pageSize > MAX_PAGESIZE)) {
            pageSize = DEFAULT_PAGE_SIZE;
        }
        this.pageSize = pageSize;
    }

    public String getSearchProperty() {
        return this.searchProperty;
    }

    public void setSearchProperty(String searchProperty) {
        this.searchProperty = searchProperty;
    }

    public String getSearchValue() {
        return this.searchValue;
    }

    public void setSearchValue(String searchValue) {
        this.searchValue = searchValue;
    }

    public String getOrderProperty() {
        return this.orderProperty;
    }

    public void setOrderProperty(String orderProperty) {
        this.orderProperty = orderProperty;
    }

    public Order.Direction getOrderDirection() {
        return this.orderDirection;
    }

    public void setOrderDirection(Order.Direction orderDirection) {
        this.orderDirection = orderDirection;
    }

    public List<Filter> getFilters() {
        return this.filters;
    }

    public void setFilters(List<Filter> filters) {
        this.filters = filters;
    }

    public List<Order> getOrders() {
        return this.orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public void addFilter(String property, Filter.Operator op, Object value) {
        Filter filter = new Filter();
        filter.setProperty(property);
        filter.setOperator(op);
        filter.setValue(value);
        this.getFilters().add(filter);
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
        Pageable pageable = (Pageable) obj;
        return new EqualsBuilder()
                .append(getPageNumber(), pageable.getPageNumber())
                .append(getPageSize(), pageable.getPageSize())
                .append(getSearchProperty(), pageable.getSearchProperty())
                .append(getSearchValue(), pageable.getSearchValue())
                .append(getOrderProperty(), pageable.getOrderProperty())
                .append(getOrderDirection(), pageable.getOrderDirection())
                .append(getFilters(), pageable.getFilters())
                .append(getOrders(), pageable.getOrders()).isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder(17, 37).append(getPageNumber())
                .append(getPageSize()).append(getSearchProperty())
                .append(getSearchValue()).append(getOrderProperty())
                .append(getOrderDirection()).append(getFilters())
                .append(getOrders()).toHashCode();
    }
}
