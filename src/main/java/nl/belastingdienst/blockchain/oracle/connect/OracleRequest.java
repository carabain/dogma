package nl.belastingdienst.blockchain.oracle.connect;

import java.util.ArrayList;
import java.util.List;

import nl.belastingdienst.blockchain.oracle.domain.OracleId;

public class OracleRequest {

	// van --> het smartContract
	private Long hashBlockChain;
	private String adressBlockChain;

	// naar --> het DutchBrOracle
	private String endpointOracle;
	private List<OracleId> requestedOracles = new ArrayList<OracleId>();

	
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
	public List<OracleId> getRequestedOracles() {
		return requestedOracles;
	}
	public void setRequestedOracles(List<OracleId> requesteOracles) {
		this.requestedOracles = requesteOracles;
	}
	public String getEndpointOracle() {
		return endpointOracle;
	}
	public void setEndpointOracle(String endpointOracle) {
		this.endpointOracle = endpointOracle;
	}
}
