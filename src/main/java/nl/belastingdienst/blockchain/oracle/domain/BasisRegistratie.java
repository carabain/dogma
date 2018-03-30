package nl.belastingdienst.blockchain.oracle.domain;

/**
 * Beschrijving (definitie) van een basisregistratie.
 */
public enum BasisRegistratie {

	BRK("BRK", "Kadaster", "Bevat informatie over percelen, eigendom, hypotheken, beperkte rechten (zoals recht van erfpacht, opstal en vruchtgebruik) en leidingnetwerken. Daarnaast staan er kadastrale kaarten in met perceel, perceelnummer, oppervlakte, kadastrale grens en de grenzen van het rijk, de provincies en gemeenten"),
	BAG("BAG", "Basisregistraties Adressen en gebouwen", "Bevat gemeentelijke basisgegevens van alle adressen en gebouwen in een gemeente.");
	
	private String description;
	private String name;
	private String code;

	/**
	 * Constructor.
	 * 
	 * @param code
	 * @param name
	 * @param description
	 */
	private BasisRegistratie(String code, String name, String description) {
		this.code = code;
		this.name = name;
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

	public String getName() {
		return name;
	}

	public String getCode() {
		return code;
	}
}
