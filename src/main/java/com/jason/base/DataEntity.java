package com.jason.base;

import com.jason.anno.ExcelField;
import com.jason.util.IDUtils;

import java.util.Date;

/**
 * @Auther: Jason
 * @Date: 2020/1/1 16:52
 * @Description:
 */
public abstract class DataEntity<T> extends BaseEntity<T> {

    private static final long serialVersionUID = 1L;

    protected String remarks;//备注
    protected String createBy;//创建者id
    protected Date createDate;//创建日期
    protected String updateBy;//修改者id
    protected Date updateDate;//修改日期
    protected String delFlag = DELETE_FLAG_NORMAL;

    public DataEntity(){

    }

    public DataEntity(String id){
        super(id);
    }

    @Override
    public void preInsert(){
        if(!isNewData){
            setId(IDUtils.getUUID());
        }
        Date now = new Date();
        this.createDate = now;
        this.updateDate = now;
    }

    @Override
    public void preUpdate(){
        this.updateDate = new Date();
    }

    public String getRemarks() {
        return remarks;
    }

    public DataEntity<T> setRemarks(String remarks) {
        this.remarks = remarks;
        return this;
    }

    public String getCreateBy() {
        return createBy;
    }

    public DataEntity<T> setCreateBy(String createBy) {
        this.createBy = createBy;
        return this;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public DataEntity<T> setCreateDate(Date createDate) {
        this.createDate = createDate;
        return this;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public DataEntity<T> setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
        return this;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public DataEntity<T> setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
        return this;
    }

    public String getDelFlag() {
        return delFlag;
    }

    public DataEntity<T> setDelFlag(String delFlag) {
        this.delFlag = delFlag;
        return this;
    }
}
