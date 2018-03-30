package nl.belastingdienst.blockchain.oracle.domain;

/**
 * Objecten waarover (de Basis Registraties) informatie beschikbaar stellen.
 */
public enum ObjectType {

	ADRESS("Een adres is de door de bevoegde gemeente toegekende benaming, "
			+ "bestaande uit de naam van een openbare ruimte, een nummeraanduiding en woonplaats. "
		 	+ "Adressen worden toegekend aan adresseerbare objecten uit de Basisregistratie."), 
	BUILDING("Gebouwen zijn alle panden, verblijfsobjecten, standplaatsen en ligplaatsen. "
			+ "Deze 'objecttypen' zijn afgebakend en voorzien van een unieke aanduiding."),  
	INCOME("Beschrijft het verzamelinkomen of het belastbaar jaarloon van iedereen die aangifte inkomstenbelasting doet"),  
	CADASTRAL("Bevat een digitale kaart van heel Nederland. "
		    + "Alle fysieke objecten zoals gebouwen, wegen, water en groen zijn hier eenduidig op vastgelegd"),  
	SUBSOIL("Gegevens over geologische en bodemkundige opbouw en voor zover van belang voor het "
			+ "benutten van natuurlijke hulpbronnen in de ondergrond, ondergrondse constructies en gebruiksrechten."),  
	PERSON("Persoonsgegevens over alle ingezetenen van Nederland en over personen die niet in Nederland wonen – "
			+ "of hier slechts kort verblijven – maar die een relatie hebben met de Nederlandse overheid, "
			+ "de ‘niet-ingezetenen’."),  
	TOPOGRAPHY("Digitale topografische bestanden op verschillende schaalniveaus."), 
	VEHICLE("Voertuigen, kentekenbewijzen en personen aan wie het kentekenbewijs is afgegeven."), 
	BUSINESS("Rechtspersonen en ondernemingen in Nederland"), 
	PROPERTY("Authentieke gegeven “vastgestelde waarde” (WOZ-waarde)"
			+ " ook uit de gegevens die nodig zijn om deze waarde aan zowel "
			+ "een onroerende zaak te relateren als aan een belanghebbende.");
	
	private String description;

	private ObjectType(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}
}
