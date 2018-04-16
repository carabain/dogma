package com.carabain.dogma.domain.oracle.connect;

import java.util.ArrayList;
import java.util.List;

/**
 * Defines a request to an oracle.
 */
public class OracleRequest {

    // van --> het smartContract
    private Long hashBlockChain;
    private String adressBlockChain;

    // naar --> het DutchBrOracle
    private String endpointOracle;
    private List<String> requestedOracles = new ArrayList<>();


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

    public List<String> getRequestedOracles() {
        return requestedOracles;
    }

    public void setRequestedOracles(List<String> requesteOracles) {
        this.requestedOracles = requesteOracles;
    }

    public String getEndpointOracle() {
        return endpointOracle;
    }

    public void setEndpointOracle(String endpointOracle) {
        this.endpointOracle = endpointOracle;
    }
}
