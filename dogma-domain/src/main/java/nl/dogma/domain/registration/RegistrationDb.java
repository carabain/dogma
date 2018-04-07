package nl.dogma.domain.registration;

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
            regs.add(registration);
        }
        registrations.put(registration.getUserid(), regs);
    }

    public List<Registration> getRegistrations(String userid) {
        return registrations.get(userid);
    }
}
