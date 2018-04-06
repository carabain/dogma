package nl.dogma.domain.oracle.domain;

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
	private HashMap<ObjectType, ArrayList<BrOracle>> oraclePerObjectType = new HashMap<ObjectType, ArrayList<BrOracle>>();
//	private HashMap<BasisRegistratie, ArrayList<BrOracle>> oraclePerBasisRegistratie = new HashMap<BasisRegistratie, ArrayList<BrOracle>>();


	public String getDescription() {
		return description;
	}

	public HashMap<ObjectType, ArrayList<BrOracle>> getOraclePerObjectType() {
		return oraclePerObjectType;
	}

//	public HashMap<BasisRegistratie, ArrayList<BrOracle>> getOraclePerBasisRegistratie() {
//		return oraclePerBasisRegistratie;
//	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void addBrOracle(ObjectType objectType, BasisRegistratie basisRegistratie, BrOracle brOracle ) {
//		ArrayList<BrOracle> brOraclesBr = oraclePerBasisRegistratie.get(basisRegistratie);
//		if (brOracle == null) {
//			brOraclesBr  = new ArrayList<BrOracle>();
//			oraclePerBasisRegistratie.put(basisRegistratie, brOraclesBr);
//		}
//		brOraclesBr.add(brOracle);

		ArrayList<BrOracle> brOraclesOb = oraclePerObjectType.get(objectType);
		if (brOraclesOb == null) {
			brOraclesOb  = new ArrayList<BrOracle>();
			oraclePerObjectType.put(objectType, brOraclesOb);
		}
		brOraclesOb.add(brOracle);
	}
}
