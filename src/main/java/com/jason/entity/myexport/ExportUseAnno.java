package com.jason.entity.myexport;

import com.jason.anno.ExcelField;
import com.jason.base.DataEntity;

import java.util.Date;

/**
 * @Auther: Jason
 * @Date: 2020/3/31 14:34
 * 使用注解
 * @Description:
 */
public class ExportUseAnno extends DataEntity<ExportUseAnno> {

    @ExcelField(excelTile = "Integer",isImport = false,sort = 100000000)
    private Integer aInteger;

    @ExcelField(excelTile = "Long",isImport = false,sort = 1)
    private Long aLong;

    @ExcelField(excelTile = "Short",isImport = false,sort = 2)
    private Short aShort;

    @ExcelField(excelTile = "Byte",isImport = false,sort = 3)
    private Byte aByte;

    @ExcelField(excelTile = "Double",isImport = false,sort = 4)
    private Double aDouble;

    @ExcelField(excelTile = "Float",isImport = false,sort = 5)
    private Float aFloat;

    @ExcelField(excelTile = "aBoolean",isImport = false,sort = 6)
    private Boolean aBoolean;

    @ExcelField(excelTile = "Char",isImport = false,sort = 7)
    private Character aCharacter;

    private ExportUseAnno parent;

    @ExcelField(excelTile = "字典数据",isImport = false,sort = 9,useTemplate = true)
    private String template;

    @ExcelField(excelTile = "date",isImport = false,sort = 10)
    private Date date;

    public Integer getaInteger() {
        return aInteger;
    }

    public ExportUseAnno setaInteger(Integer aInteger) {
        this.aInteger = aInteger;
        return this;
    }

    public Long getaLong() {
        return aLong;
    }

    public ExportUseAnno setaLong(Long aLong) {
        this.aLong = aLong;
        return this;
    }

    public Short getaShort() {
        return aShort;
    }

    public ExportUseAnno setaShort(Short aShort) {
        this.aShort = aShort;
        return this;
    }

    public Byte getaByte() {
        return aByte;
    }

    public ExportUseAnno setaByte(Byte aByte) {
        this.aByte = aByte;
        return this;
    }

    public Double getaDouble() {
        return aDouble;
    }

    public ExportUseAnno setaDouble(Double aDouble) {
        this.aDouble = aDouble;
        return this;
    }

    public Float getaFloat() {
        return aFloat;
    }

    public ExportUseAnno setaFloat(Float aFloat) {
        this.aFloat = aFloat;
        return this;
    }

    public Boolean getaBoolean() {
        return aBoolean;
    }

    public ExportUseAnno setaBoolean(Boolean aBoolean) {
        this.aBoolean = aBoolean;
        return this;
    }

    public Character getaCharacter() {
        return aCharacter;
    }

    public ExportUseAnno setaCharacter(Character aCharacter) {
        this.aCharacter = aCharacter;
        return this;
    }

    @ExcelField(excelTile = "parent",isImport = false,sort = 8)
    public String getParent() {
        return parent.template;
    }

    public ExportUseAnno setParent(ExportUseAnno parent) {
        this.parent = parent;
        return this;
    }

    public String getTemplate() {
        return template;
    }

    public ExportUseAnno setTemplate(String template) {
        this.template = template;
        return this;
    }

    public Date getDate() {
        return date;
    }

    public ExportUseAnno setDate(Date date) {
        this.date = date;
        return this;
    }
}
