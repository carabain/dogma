package nl.dogma.domain.oracle.domain;

import java.time.LocalDate;

/**
 * Beschrijving (definitie) van een Oracle.<br>
 * <br>
 * Beschrijft welke (type) informatie door wie (Basis Registratie) beschikbaar wordt gesteld.
 */
public class BrOracle {

	private OracleId id;
	private String description;
	private LocalDate creationDate;
	private Long hashSmartContract;

	private ObjectType infoType;
	private BasisRegistratie basisRegistratie;

	private OracleContent oracleContent;

	public BasisRegistratie getBasisRegistratie() {
		return basisRegistratie;
	}

	public void setBasisRegistratie(BasisRegistratie basisRegistratie) {
		this.basisRegistratie = basisRegistratie;
	}

	public OracleContent getOracleContent() {
		return oracleContent;
	}

	public OracleId getId() {
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

	public Long getHashSmartContract() {
		return hashSmartContract;
	}

	public void setHashSmartContract(Long hashSmartContract) {
		this.hashSmartContract = hashSmartContract;
	}
}
