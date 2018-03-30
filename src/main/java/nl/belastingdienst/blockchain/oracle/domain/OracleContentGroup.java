package nl.belastingdienst.blockchain.oracle.domain;

import java.util.ArrayList;

public class OracleContentGroup {

	private String id;
	private String description;
	private ArrayList<OracleContentGroup> oracleContentGroups = new ArrayList<OracleContentGroup>();
	private ArrayList<OracleContentValue> oracleContentValues = new ArrayList<OracleContentValue>();

	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public ArrayList<OracleContentGroup> getOracleContentGroups() {
		return oracleContentGroups;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public void addOracleContentGroup(OracleContentGroup oracleContentGroup) {
		this.oracleContentGroups.add(oracleContentGroup);
	}
	public void addOracleContentValue(OracleContentValue oracleContentValue) {
		this.oracleContentValues.add(oracleContentValue);
	}
	public ArrayList<OracleContentValue> getOracleContentValues() {
		return oracleContentValues;
	}
}
