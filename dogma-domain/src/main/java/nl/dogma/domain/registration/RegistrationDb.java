package nl.dogma.domain.registration;

import nl.dogma.domain.oracle.domain.BrOracleDb;
import nl.dogma.domain.oracle.domain.BrOracleFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    public void addRegistration( Registration registration) {
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

    public void removeRegistration(String userid, String id) {
        List<Registration> registrations = this.registrations.get(userid);
        if (registrations != null) {
            for (Registration reg : registrations) {
                if (reg.getId().equals(id)) {
                    registrations.remove(reg);
                    break;
                }
            }
        }
    }
}
