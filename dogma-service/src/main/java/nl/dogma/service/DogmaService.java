package nl.dogma.service;

import nl.dogma.domain.oracle.domain.DutchBrOracle;
import nl.dogma.domain.registration.Registration;

import java.util.List;

public interface DogmaService {

    DutchBrOracle getDutchBrOracle();

    void pushData(String userid, Registration registration);

    List<Registration> getRegistrations(String userid);
}
