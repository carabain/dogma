package com.carabain.dogma.service;

import org.web3j.crypto.Credentials;

/**
 * Describes the chain related possibilities of Dogma.
 */
public interface DogmaChainService {

    /**
     *
     * @param address
     * @param credentials
     */
    void callContract(String address, Credentials credentials);
}
