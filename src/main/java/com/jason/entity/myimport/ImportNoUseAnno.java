package com.jason.entity.myimport;

import com.jason.base.DataEntity;

import java.util.Date;

/**
 * @Auther: Jason
 * @Date: 2020/3/31 14:34
 * 不使用注解
 * @Description:
 */
public class ImportNoUseAnno extends DataEntity<ImportNoUseAnno> {

    private Integer aInteger;

    private Long aLong;

    private Short aShort;

    private Byte aByte;

    private Double aDouble;

    private Float aFloat;

    private Boolean aBoolean;

    private Character aCharacter;

    private ImportUseAnno parent;

    private String template;

    private Date date;

    public Integer getaInteger() {
        return aInteger;
    }

    public ImportNoUseAnno setaInteger(Integer aInteger) {
        this.aInteger = aInteger;
        return this;
    }

    public Long getaLong() {
        return aLong;
    }

    public ImportNoUseAnno setaLong(Long aLong) {
        this.aLong = aLong;
        return this;
    }

    public Short getaShort() {
        return aShort;
    }

    public ImportNoUseAnno setaShort(Short aShort) {
        this.aShort = aShort;
        return this;
    }

    public Byte getaByte() {
        return aByte;
    }

    public ImportNoUseAnno setaByte(Byte aByte) {
        this.aByte = aByte;
        return this;
    }

    public Double getaDouble() {
        return aDouble;
    }

    public ImportNoUseAnno setaDouble(Double aDouble) {
        this.aDouble = aDouble;
        return this;
    }

    public Float getaFloat() {
        return aFloat;
    }

    public ImportNoUseAnno setaFloat(Float aFloat) {
        this.aFloat = aFloat;
        return this;
    }

    public Boolean getaBoolean() {
        return aBoolean;
    }

    public ImportNoUseAnno setaBoolean(Boolean aBoolean) {
        this.aBoolean = aBoolean;
        return this;
    }

    public Character getaCharacter() {
        return aCharacter;
    }

    public ImportNoUseAnno setaCharacter(Character aCharacter) {
        this.aCharacter = aCharacter;
        return this;
    }

    public ImportUseAnno getParent() {
        return parent;
    }

    public ImportNoUseAnno setParent(ImportUseAnno parent) {
        this.parent = parent;
        return this;
    }

    public String getTemplate() {
        return template;
    }

    public ImportNoUseAnno setTemplate(String template) {
        this.template = template;
        return this;
    }

    public Date getDate() {
        return date;
    }

    public ImportNoUseAnno setDate(Date date) {
        this.date = date;
        return this;
    }

    @Override
    public String toString() {
        return "ImportNoUseAnno{" +
                "aInteger=" + aInteger +
                ", aLong=" + aLong +
                ", aShort=" + aShort +
                ", aByte=" + aByte +
                ", aDouble=" + aDouble +
                ", aFloat=" + aFloat +
                ", aBoolean=" + aBoolean +
                ", aCharacter=" + aCharacter +
                ", parent=" + parent +
                ", template='" + template + '\'' +
                ", date=" + date +
                '}';
    }
}
