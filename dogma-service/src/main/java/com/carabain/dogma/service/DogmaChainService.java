package com.carabain.dogma.service;

import org.web3j.crypto.Credentials;

/**
 * Describes the chain related possibilities of Dogma.
 */
public interface DogmaChainService {

    /**
     * Calls a contract on the chain.
     *
     * @param address     the address of the contract
     * @param credentials the credentials of the caller
     */
    void callContract(String address, Credentials credentials);
}
