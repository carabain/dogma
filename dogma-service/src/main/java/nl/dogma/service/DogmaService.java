package nl.dogma.service;

import java.util.List;

import nl.dogma.domain.oracle.domain.BrOracle;
import nl.dogma.domain.registration.Registration;

public interface DogmaService {

    List<BrOracle> getDutchBrOracle();

    void pushData(Registration registration);

    List<Registration> getRegistrations(String userid);

    void addRegistration(Registration registration);

    void removeRegistration(Registration registration);
}
