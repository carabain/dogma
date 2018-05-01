package com.carabain.dogma.web;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

import com.carabain.dogma.domain.oracle.domain.BrOracle;
import com.carabain.dogma.domain.oracle.domain.DutchBrOracleFactory;
import com.carabain.dogma.domain.registration.Registration;
import com.carabain.dogma.domain.registration.RegistrationDb;

/**
 * REST implementation of {@link DogmaService}.
 */
@Path("/service")
// TODO: It's good practice to include a version number in the path.
// So you can have multiple versions deployed at once. That way consumers
// don't need to upgrade right away if things are working for them.
public class DogmaServiceImpl implements DogmaService {

    @GET
    @Path("/oracles")
    @Produces(MediaType.APPLICATION_JSON)
    @Override
    public List<BrOracle> getDutchBrOracle() {
        return DutchBrOracleFactory.getInstance().getDutchBrOracle().getOracles();
    }

    @POST
    @Path("/data")
    @Produces(MediaType.APPLICATION_JSON)
    @Override
    public void pushData(Registration registration) {
        // hier pushen naar het contract.
    }

    @POST
    @Path("/registration")
    @Produces(MediaType.APPLICATION_JSON)
    @Override
    public void addRegistration(Registration registration) {
        RegistrationDb.getInstance().addRegistration(registration);
    }

    @DELETE
    @Path("/registration/{user}/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Override
    public void removeRegistration(@PathParam("registration") Registration registration) {
        RegistrationDb.getInstance().removeRegistration(registration);
    }

    @GET
    @Path("/registration/{user}")
    @Produces(MediaType.APPLICATION_JSON)
    @Override
    public List<Registration> getRegistrations(@PathParam("user") String userid) {
        return RegistrationDb.getInstance().getRegistrations(userid);
    }
}
