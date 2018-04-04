package nl.dogma.domain.smartcontract.proxy;

import nl.dogma.domain.oracle.connect.OracleRequest;
import nl.dogma.domain.oracle.connect.OracleResponse;

public class SmartContractProxy {

	private SmartContract smartcontract;
	private OracleRequest request;

	public SmartContractProxy(SmartContract smartcontract, OracleRequest request) {
		this.smartcontract = smartcontract;
		this.request = request;
	}

	public void procesOracleResponse(OracleResponse reponse) {
		// validation
		if (!request.getHash().equals(reponse.getHash())) {
			return;
		}
		if (!request.getAdress().equals(reponse.getAdress())) {
			return;
		}
		
		// initialize for next request
		this.request = null;
	}
	
	public void procesOracleRequest(OracleRequest request) {
		// initialize for validation
		request.setHash(smartcontract.getHash());
		this.request = request;

		// check autorization
		
		// send

	}
}
