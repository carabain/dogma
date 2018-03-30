package nl.belastingdienst.blockchain.oracle.domain;

import org.junit.Test;

import nl.belastingdienst.blockchain.oracle.util.OracleContentGroupDescribe;

public class OracleContentTest {

	@Test
	public void indien() {
		// given
		OracleContent oracleContent = new OracleContent();
		oracleContent.setObjectType(ObjectType.PERSON);
		
		OracleContentGroup persoon = new OracleContentGroup();
		persoon.setId("idPersoon");
		persoon.setDescription("Wezen dat rondloopt");
		persoon.addOracleContentValue(new OracleContentValue("id", "naam", DataType.STRING));
		persoon.addOracleContentValue(new OracleContentValue("gsl", "geslacht", DataType.STRING));
		
		OracleContentGroup ledematen = new OracleContentGroup();
		ledematen.setId("idLedematen");
		ledematen.setDescription("Bevat de ledematen");
		ledematen.addOracleContentValue(new OracleContentValue("larm", "linkerarm", DataType.STRING));
		ledematen.addOracleContentValue(new OracleContentValue("rarm", "rechterarm", DataType.STRING));
		ledematen.addOracleContentValue(new OracleContentValue("lbeen", "linkerbeen", DataType.STRING));
		ledematen.addOracleContentValue(new OracleContentValue("rbeen", "rechterbeen", DataType.STRING));
		persoon.addOracleContentGroup(ledematen);
		
		oracleContent.addOracleContentGroup(persoon);
		
		// when
		System.out.println(OracleContentGroupDescribe.describe(persoon));
		
		// then
	}
}
