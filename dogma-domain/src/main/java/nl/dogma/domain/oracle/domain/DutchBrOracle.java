package nl.dogma.domain.oracle.domain;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Beschrijft welke Oracles per type Object de Nederlandse BasisRegistraties beschikbaar stellen.
 * 
 */
public class DutchBrOracle {

	private String description = "Beschrijft welke gegevens door middel van een of meer Oracles "
							   + "door de verschillende Basis Registraties beschikbaar worden gesteld.";
	private List<BrOracle> oracles = new ArrayList<BrOracle>();

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void addBrOracle(ObjectType objectType, BrOracle brOracle ) {
		oracles.add(brOracle);
	}

	public List<BrOracle> getOracles() {
		return oracles;
	}
}
