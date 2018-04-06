package nl.dogma.service;


import nl.dogma.domain.oracle.domain.DutchBrOracle;
import nl.dogma.domain.oracle.domain.DutchBrOracleFactory;
import nl.dogma.domain.registration.Registration;
import nl.dogma.domain.registration.RegistrationDb;

import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

public class DogmaServiceImpl implements DogmaService {
    
    @Override
    @Path("/getOracles")
    @Produces(MediaType.APPLICATION_JSON)
    public DutchBrOracle getDutchBrOracle() {
        return DutchBrOracleFactory.getInstance().getDutchBrOracle();
    }

    @Override
    @Path("/addRegistration")
    @Produces(MediaType.APPLICATION_JSON)
    public void pushData(String userid, Registration registration) {
        RegistrationDb.getInstance().addRegistration(userid, registration);
    }

    @Override
    @Path("/getRegistrations")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Registration> getRegistrations(String userid) {
        return RegistrationDb.getInstance().getRegistrations(userid);
    }
}
