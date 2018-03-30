package nl.belastingdienst.blockchain.oracle.domain;

public enum OracleId {

	BDBASISINKOMEN("BasisInkomen"), BDBELASTBAARINKOMEN("Belastbaarinkomen"), BRKGEGEVENSHUIS(
			"Basis gegevens huis"), GBABASISGEGEVENSPERSOON("Basis gegevens persoon");

	private String naam;

	private OracleId(String naam) {
		this.naam = naam;
	}

	public String getNaam() {
		return naam;
	}	
}
