package com.carabain.dogma.domain.registration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.carabain.dogma.domain.oracle.domain.BrOracleFactory;

/**
 * Defines an in-memory database containing all registrations grouped by userid.
 */
public class RegistrationDb {

    private static RegistrationDb instance;

    private Map<String, List<Registration>> registrations = new HashMap<>();

    private RegistrationDb() {
        super();
    }

    public static RegistrationDb getInstance() {
        if (instance == null) {
            instance = new RegistrationDb();
        }
        return instance;
    }

    public void addRegistration(Registration registration) {
        List<Registration> regs = registrations.get(registration.getUserid());
        if (regs == null) {
            regs = new ArrayList<>();
            registrations.put(registration.getUserid(), regs);
        }

        // templates van oracles toevoegen vanuit db
        for (String id : registration.getOracleIds()) {
            registration.getOracles().add(BrOracleFactory.getInstance().createBrOracle(id));
        }

        regs.add(registration);
    }

    public List<Registration> getRegistrations(String userid) {
        return registrations.get(userid);
    }

    public void clear() {
        this.registrations.clear();
    }

    public void removeRegistration(Registration registration) {
        List<Registration> registrations = this.registrations.get(registration.getUserid());
        if (registrations != null) {
            for (Registration reg : registrations) {
                if (reg.getId().equals(registration.getId())) {
                    registrations.remove(reg);
                    break;
                }
            }
        }
    }
}
