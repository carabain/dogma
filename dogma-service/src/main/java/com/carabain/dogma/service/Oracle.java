package com.carabain.dogma.service;

import org.web3j.tx.Contract;

/**
 * Desribes the possibilities of an oracle.
 *
 * @param <T> the type of contract this oracle operates on
 */
public interface Oracle<T extends Contract> {

    /**
     * Deploys a contract on the chain.
     *
     * @param ownerAddress the address of the account creating the contract
     * @return a web3j generated wrapper for the deployed contract
     */
    abstract T deployContract(String ownerAddress);

    /**
     * Loads a contract deployed on the chain.
     *
     * @param contractAddress the address of the contract
     * @param ownerAddress    the address of the account interacting with the contract
     * @return a web3j generated wrapper for the loaded contract
     */
    abstract T loadContract(String contractAddress, String ownerAddress);

    /**
     * Subscribes to the events which are part of the contract.
     *
     * @param contract the contract
     */
    abstract void subscribeToEvents(T contract);

}
