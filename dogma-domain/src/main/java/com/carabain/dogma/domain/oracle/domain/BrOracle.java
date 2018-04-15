package com.carabain.dogma.domain.oracle.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Beschrijving (definitie) van een Oracle.<br>
 * <br>
 * Beschrijft welke (type) informatie door wie (Basis Registratie) beschikbaar wordt gesteld.
 */
public class BrOracle {

	private String id;
	private String name;
	private String description;
	private LocalDate creationDate;

	/** daar waar het oracle geregistreerd kan worden */
	private String endpoint;

	private ObjectType infoType;
	private BasisRegistratie basisRegistratie;

	private List<OracleContentValue> values = new ArrayList<>();


	public BasisRegistratie getBasisRegistratie() {
		return basisRegistratie;
	}

	public void setBasisRegistratie(BasisRegistratie basisRegistratie) {
		this.basisRegistratie = basisRegistratie;
	}

	public List<OracleContentValue> getValues(){ return values;}

	public String getId() {
		return id;
	}

	public String getDescription() {
		return description;
	}

	public ObjectType getInfoType() {
		return infoType;
	}

	public LocalDate getCreationDate() {
		return creationDate;
	}

	public void setInfoType(ObjectType infoType) {
		this.infoType = infoType;
	}

	public void setEndpoint(String endpoint) {
		this.endpoint = endpoint;
	}

	public String getEndpoint() {
		return endpoint;
	}

	public void addValue(OracleContentValue contentValue) {
		this.values.add(contentValue);
	}

	public void setCreationDate(LocalDate creationDate) {
		this.creationDate = creationDate;
	}

    public void setDescription(String description) {
        this.description = description;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
