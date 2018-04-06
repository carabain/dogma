package nl.dogma.domain.oracle.domain;

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
	private String description;
	private LocalDate creationDate;

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

	public void addValue(OracleContentValue contentValue) {
		this.values.add(contentValue);
	}

	public void setCreationDate(LocalDate creationDate) {
		this.creationDate = creationDate;
	}
}
