package nl.dogma.domain.oracle.connect;

import java.util.HashMap;
import java.util.Map;

import nl.dogma.domain.oracle.domain.BrOracle;
import nl.dogma.domain.oracle.domain.OracleId;

public class OracleResponse {
	
	// van --> het DutchBdOracle
	private Map<OracleId, BrOracle> requestedOracles = new HashMap<OracleId, BrOracle>();

	// naar --> het smartContract
	private Long hashBlockChain;
	private String adressBlockChain;
	
	
	public Long getHash() {
		return hashBlockChain;
	}
	public void setHash(Long hash) {
		this.hashBlockChain = hash;
	}
	public String getAdress() {
		return adressBlockChain;
	}
	public void setAdress(String adress) {
		this.adressBlockChain = adress;
	}
	public Map<OracleId, BrOracle> getRequestedOracles() {
		return requestedOracles;
	}
	public void setRequestedOracles(Map<OracleId, BrOracle> requestedOracles) {
		this.requestedOracles = requestedOracles;
	}
}
