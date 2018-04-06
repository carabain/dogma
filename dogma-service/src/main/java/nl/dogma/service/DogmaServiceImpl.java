package nl.dogma.service;


import nl.dogma.domain.oracle.domain.DutchBrOracle;
import nl.dogma.domain.oracle.domain.DutchBrOracleFactory;

import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

public class DogmaServiceImpl
        implements DogmaService {


    @Override
    @Path("/getOracles")
    @Produces(MediaType.APPLICATION_JSON)
    public DutchBrOracle getDutchBrOracle() {
        return DutchBrOracleFactory.getInstance().getDutchBrOracle();
    }

}
