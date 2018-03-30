package nl.belastingdienst.blockchain.oracle.domain;

import java.util.ArrayList;
import java.util.List;

/**
 *	Beschrijft de gegevens die een Oracle beschikbaar stelt.
 */
public class OracleContent {

	private List<OracleContentGroup> oracleContentGroups = new ArrayList<OracleContentGroup>();
	private ObjectType objectType;


	public List<OracleContentGroup> getOracleContentGroups() {
		return oracleContentGroups;
	}
	public void setOracleContentGroups(List<OracleContentGroup> oracleContentGroups) {
		this.oracleContentGroups = oracleContentGroups;
	}
	public void addOracleContentGroup(OracleContentGroup oracleContentGroup) {
		this.oracleContentGroups.add(oracleContentGroup);
	}
	public ObjectType getObjectType() {
		return objectType;
	}
	public void setObjectType(ObjectType objectType) {
		this.objectType = objectType;
	}
}
