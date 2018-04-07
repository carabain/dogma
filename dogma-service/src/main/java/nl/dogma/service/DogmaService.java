package nl.dogma.service;

import nl.dogma.domain.oracle.domain.BrOracle;
import nl.dogma.domain.registration.Registration;

import java.util.List;

public interface DogmaService {

    void createAnddeployAndSendContract();

    List<BrOracle> getDutchBrOracle();

    void pushData(String userid, List<BrOracle> oracledata);

    List<Registration> getRegistrations(String userid);

    void addRegistration(Registration registration);

    void removeRegistration(String userid, String registration);
}
