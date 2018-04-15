package com.carabain.dogma.web;

import java.util.List;

import com.carabain.dogma.domain.oracle.domain.BrOracle;
import com.carabain.dogma.domain.registration.Registration;

/**
 * Describes the possibilities of Dogma.
 */
public interface DogmaService {

    /**
     * @return
     */
    List<BrOracle> getDutchBrOracle();

    /**
     * @param registration
     */
    void pushData(Registration registration);

    /**
     * @param userid
     * @return
     */
    List<Registration> getRegistrations(String userid);

    /**
     * @param registration
     */
    void addRegistration(Registration registration);

    /**
     * @param registration
     */
    void removeRegistration(Registration registration);
}
