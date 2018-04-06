package nl.dogma.service;

import nl.dogma.domain.oracle.domain.DutchBrOracle;

public interface DogmaService {

    void createAnddeployAndSendContract();

    DutchBrOracle getDutchBrOracle();
}
