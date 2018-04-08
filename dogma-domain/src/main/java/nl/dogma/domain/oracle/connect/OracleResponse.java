package nl.dogma.domain.oracle.connect;

import java.util.HashMap;
import java.util.Map;

import nl.dogma.domain.oracle.domain.BrOracle;

public class OracleResponse {
	
	// van --> het DutchBdOracle
	private Map<String, BrOracle> requestedOracles = new HashMap<>();

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
	public Map<String, BrOracle> getRequestedOracles() {
		return requestedOracles;
	}
	public void setRequestedOracles(Map<String, BrOracle> requestedOracles) {
		this.requestedOracles = requestedOracles;
	}
}
