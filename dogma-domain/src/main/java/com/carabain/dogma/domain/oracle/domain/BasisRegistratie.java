package com.carabain.dogma.domain.oracle.domain;

/**
 * Beschrijving (definitie) van een basisregistratie.
 */
public enum BasisRegistratie {

	BAG("BAG", "Basisregistraties Adressen en gebouwen", "Bevat gemeentelijke basisgegevens van alle adressen en gebouwen in een gemeente."),
	BGT("BGT", "Basisregistratie Grootschalige Topografie", "Bevat alle fysieke objecten zoals gebouwen, wegen, water en groen die eenduidig zijn vastgelegd in een gedetailleerde grootschalige digitale kaart van Nederland."),
	BRI("BRI", "Basisregistratie Inkomen", "Bevat het verzamelinkomen of het belastbaar jaarloon van iedereen die aangifte inkomstenbelasting  doet."),
	BRK("BRK", "Kadaster", "Bevat informatie over percelen, eigendom, hypotheken, beperkte rechten (zoals recht van erfpacht, opstal en vruchtgebruik) en leidingnetwerken. Daarnaast staan er kadastrale kaarten in met perceel, perceelnummer, oppervlakte, kadastrale grens en de grenzen van het rijk, de provincies en gemeenten"),
	BRO("BRO", "Basisregistratie Ondergrond", "Bevat publieke gegevens van de Nederlandse ondergrond."),
	BRP("BRP", "Basisregistratie Personen", "Bevat persoonsgegevens zoals onder andere om naam, geboortedatum, geboorteplaats, verblijfplaats en familierelaties."),
	BRT("BRT", "Kadaster", "Bevat digitale topografische bestanden op verschillende schaalniveaus."),
	BRV("BRV", "Basisregistratie Voertuigen", "Bevat gegevens van voertuigen, kentekenbewijzen en personen aan wie het kentekenbewijs is afgegeven."),
	HR("HR", "Handelsregister", "Bevat alle bedrijven en rechtspersonen en alle overige organisaties die deelnemen aan het economisch verkeer."),
	WOZ("WOZ", "Basisregistratie Waardering Onroerende Zaken", "Bevat gegevens die nodig zijn waarde te relateren aan zowel een onroerende zaak als aan een belanghebbende.");

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
