package nl.dogma.service;


import nl.dogma.domain.oracle.domain.BrOracle;
import nl.dogma.domain.oracle.domain.DutchBrOracleFactory;
import nl.dogma.domain.registration.Registration;
import nl.dogma.domain.registration.RegistrationDb;
import org.web3j.abi.EventEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Event;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.abi.datatypes.generated.Uint8;
import org.web3j.crypto.CipherException;
import org.web3j.crypto.Credentials;
import org.web3j.crypto.WalletUtils;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameterName;
import org.web3j.protocol.core.methods.request.EthFilter;
import org.web3j.protocol.core.methods.response.Web3ClientVersion;
import org.web3j.protocol.http.HttpService;
import rx.Observable;
import rx.Subscription;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.util.List;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.web3j.tx.Contract.GAS_LIMIT;
import static org.web3j.tx.ManagedTransaction.GAS_PRICE;

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
