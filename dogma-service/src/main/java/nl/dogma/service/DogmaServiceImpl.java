package nl.dogma.service;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

import nl.dogma.domain.oracle.domain.BrOracle;
import nl.dogma.domain.oracle.domain.DutchBrOracleFactory;
import nl.dogma.domain.registration.Registration;
import nl.dogma.domain.registration.RegistrationDb;

@Path("/rest")
public class DogmaServiceImpl implements DogmaService {

    @Override
    @Path("/oracles")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<BrOracle> getDutchBrOracle() {
        return DutchBrOracleFactory.getInstance().getDutchBrOracle().getOracles();
    }

    @Override
    @Path("/data")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public void pushData(Registration registration) {
        // hier pushen naar het contract.
    }

    @Override
    @Path("/registration")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public void addRegistration(Registration registration) {
        RegistrationDb.getInstance().addRegistration(registration);
    }

    @Override
    @Path("/registration/{user}/{id}")
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    public void removeRegistration(@PathParam("registration") Registration registration) {
        RegistrationDb.getInstance().removeRegistration(registration);
    }

    @Override
    @Path("/registration/{user}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Registration> getRegistrations(@PathParam("user") String userid) {
        return RegistrationDb.getInstance().getRegistrations(userid);
    }
}
