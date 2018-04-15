package com.carabain.dogma.service;

/**
 * Describes the chain related possibilities of Dogma.
 */
public interface DogmaChainService {

    /**
     *
     * @return
     */
    DogmaChainServiceImpl.Xxx createAnddeployContract();

    /**
     *
     * @param xxx
     */
    void callContract(DogmaChainServiceImpl.Xxx xxx);
}
