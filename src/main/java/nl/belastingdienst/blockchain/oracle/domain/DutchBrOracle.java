package nl.belastingdienst.blockchain.oracle.domain;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Beschrijft welke Oracles per type Object de Nederlandse BasisRegistraties beschikbaar stellen.
 * 
 */
public class DutchBrOracle {

	private String description = "Beschrijft welke gegevens door middel van een of meer Oracles "
							   + "door de verschillende Basis Registraties beschikbaar worden gesteld.";
	private URL endpoint;
	private HashMap<ObjectType, ArrayList<BrOracle>> oraclePerObjectType = new HashMap<ObjectType, ArrayList<BrOracle>>();
	private HashMap<BasisRegistratie, ArrayList<BrOracle>> oraclePerBasisRegistratie = new HashMap<BasisRegistratie, ArrayList<BrOracle>>();
	

	public URL getEndpoint() {
		return endpoint;
	}

	public String getDescription() {
		return description;
	}

	public HashMap<ObjectType, ArrayList<BrOracle>> getOraclePerObjectType() {
		return oraclePerObjectType;
	}

	public HashMap<BasisRegistratie, ArrayList<BrOracle>> getOraclePerBasisRegistratie() {
		return oraclePerBasisRegistratie;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setEndpoint(URL endpoint) {
		this.endpoint = endpoint;
	}

	public void setOraclePerObjectType(HashMap<ObjectType, ArrayList<BrOracle>> oraclePerObjectType) {
		this.oraclePerObjectType = oraclePerObjectType;
	}

	public void setOraclePerBasisRegistratie(HashMap<BasisRegistratie, ArrayList<BrOracle>> oraclePerBasisRegistratie) {
		this.oraclePerBasisRegistratie = oraclePerBasisRegistratie;
	}
}
