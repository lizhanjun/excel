package com.jason.base;

import com.alibaba.druid.util.StringUtils;

import java.io.Serializable;

/**
 * @Auther: Jason
 * @Date: 2019/12/30 15:35
 * @Description:
 */
public abstract class BaseEntity<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    protected String id;

    /**
     * 分页对象
     */
    protected Page<T> page;

    /**
     * 删除标记 0：正常 1：删除
     */
    protected final String DELETE_FLAG_NORMAL = "0";
    protected final String DELETE_FLAG_DELETE = "1";

    protected boolean isNewData;

    /**
     * 排序字段
     */
    protected String orderBy;

    /**
     * 是否为升序排列
     */
    protected boolean isAsc;

    public BaseEntity(){

    }

    public BaseEntity(String id){
        this.id = id;
    }

    /**
     * 插入记录前的操作
     */
    public abstract void preInsert();

    /**
     * 修改记录前的操作
     */
    public abstract void preUpdate();


    public String getId() {
        return id;
    }

    public BaseEntity<T> setId(String id) {
        this.id = id;
        return this;
    }

    public Page<T> getPage() {
        return page;
    }

    public BaseEntity<T> setPage(Page<T> page) {
        this.page = page;
        return this;
    }

    public String getOrderBy() {
        return orderBy;
    }

    public BaseEntity<T> setOrderBy(String orderBy) {
        this.orderBy = orderBy;
        return this;
    }

    public boolean isAsc() {
        return isAsc;
    }

    public BaseEntity<T> setAsc(boolean asc) {
        isAsc = asc;
        return this;
    }

    public boolean isNewData() {
        return isNewData || StringUtils.isEmpty(id);
    }

    public BaseEntity<T> setNewData(boolean newData) {
        isNewData = newData;
        return this;
    }

    public String getDbName(){
        return PropertiesLoader.getProperty("jdbc.type");
    }
}
