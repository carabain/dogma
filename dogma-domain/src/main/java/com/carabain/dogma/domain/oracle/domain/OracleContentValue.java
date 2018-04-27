package com.carabain.dogma.domain.oracle.domain;

public class OracleContentValue {

    private String id;
    private String description;
    private DataType datatype;
    private String value;

    /**
     * Constructor.
     *
     * @param id          identifier gegeven
     * @param description beschrijving
     * @param datatype    type data
     */
    public OracleContentValue(String id, String description, DataType datatype) {
        this.id = id;
        this.description = description;
        this.datatype = datatype;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public DataType getDatatype() {
        return datatype;
    }

    public void setDatatype(DataType datatype) {
        this.datatype = datatype;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
