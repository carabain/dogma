package nl.belastingdienst.blockchain.oracle.util;

import nl.belastingdienst.blockchain.oracle.domain.OracleContentGroup;
import nl.belastingdienst.blockchain.oracle.domain.OracleContentValue;

public class OracleContentGroupDescribe {

	private static String tab = "   ";

	public static String describe(OracleContentGroup oracleContentGroup) {
		String loctab = tab;
		StringBuffer content = new StringBuffer();
		return OracleContentGroupDescribe.describe(oracleContentGroup, content, loctab);
	}

	private static String describe(OracleContentGroup oracleContentGroup, StringBuffer content, String loctab) {
		content.append("\n");
		// welke is het
		appendValue(content, oracleContentGroup.getId(), loctab);
		content.append("\n");
		appendValue(content, oracleContentGroup.getDescription(), loctab);
		content.append("\n");
		
		// eerst waarden
		for (OracleContentValue contentvalue : oracleContentGroup.getOracleContentValues()) {
			appendValue(content, contentvalue.getDescription() + ":" + contentvalue.getDatatype(), loctab + " ");
			content.append("\n");
		}

		// dan onderliggende groepen
		for (OracleContentGroup group : oracleContentGroup.getOracleContentGroups()) {
			String nextlev = loctab + tab;
			OracleContentGroupDescribe.describe(group, content, nextlev);
		}
		content.append("");
		content.append("\n");

		return content.toString();
	}
	
	private static void appendValue(StringBuffer content, String value, String tab) {
		String toadd = tab + value;
		content.append(toadd);
	}
}
