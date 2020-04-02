package com.jason.entity.myexport;


import java.util.Date;

/**
 * @Auther: Jason
 * @Date: 2020/3/31 14:34
 * 不使用注解
 * @Description:
 */
public class ExportNoUseAnno {

    private Integer aInteger;

    private Long aLong;

    private Short aShort;

    private Byte aByte;

    private Double aDouble;

    private Float aFloat;

    private Boolean aBoolean;

    private Character aCharacter;

    private ExportNoUseAnno parent;

    private String template;

    private Date date;

    public Integer getaInteger() {
        return aInteger;
    }

    public ExportNoUseAnno setaInteger(Integer aInteger) {
        this.aInteger = aInteger;
        return this;
    }

    public Long getaLong() {
        return aLong;
    }

    public ExportNoUseAnno setaLong(Long aLong) {
        this.aLong = aLong;
        return this;
    }

    public Short getaShort() {
        return aShort;
    }

    public ExportNoUseAnno setaShort(Short aShort) {
        this.aShort = aShort;
        return this;
    }

    public Byte getaByte() {
        return aByte;
    }

    public ExportNoUseAnno setaByte(Byte aByte) {
        this.aByte = aByte;
        return this;
    }

    public Double getaDouble() {
        return aDouble;
    }

    public ExportNoUseAnno setaDouble(Double aDouble) {
        this.aDouble = aDouble;
        return this;
    }

    public Float getaFloat() {
        return aFloat;
    }

    public ExportNoUseAnno setaFloat(Float aFloat) {
        this.aFloat = aFloat;
        return this;
    }

    public Boolean getaBoolean() {
        return aBoolean;
    }

    public ExportNoUseAnno setaBoolean(Boolean aBoolean) {
        this.aBoolean = aBoolean;
        return this;
    }

    public Character getaCharacter() {
        return aCharacter;
    }

    public ExportNoUseAnno setaCharacter(Character aCharacter) {
        this.aCharacter = aCharacter;
        return this;
    }

    public ExportNoUseAnno getParent() {
        return parent;
    }

    public ExportNoUseAnno setParent(ExportNoUseAnno parent) {
        this.parent = parent;
        return this;
    }

    public String getTemplate() {
        return template;
    }

    public ExportNoUseAnno setTemplate(String template) {
        this.template = template;
        return this;
    }

    public Date getDate() {
        return date;
    }

    public ExportNoUseAnno setDate(Date date) {
        this.date = date;
        return this;
    }
}
