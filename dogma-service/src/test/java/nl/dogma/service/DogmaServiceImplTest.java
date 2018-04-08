package nl.dogma.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import nl.dogma.domain.oracle.domain.*;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.Test;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.http.HttpService;
import org.web3j.protocol.ipc.WindowsIpcService;
import rx.Subscription;

import java.util.concurrent.TimeUnit;

import java.time.LocalDate;

public class DogmaServiceImplTest {

    private Subscription subscription;

    @Test
    public void indienObjectDanJsonFormaat() throws JsonProcessingException {
        BrOracle brOracle = new BrOracle();
        brOracle.setBasisRegistratie(BasisRegistratie.BAG);
        brOracle.setInfoType(ObjectType.PERSON);
        brOracle.addValue(new OracleContentValue("naam", "naam", DataType.STRING));
        brOracle.addValue(new OracleContentValue("naam", "naam", DataType.STRING));
        brOracle.setCreationDate(LocalDate.now());


        DutchBrOracle dutchBrOracle = new DutchBrOracle();
        dutchBrOracle.addBrOracle(ObjectType.INCOME, brOracle);


        ObjectMapper mapper = new ObjectMapper();
        String jsonInString = mapper.writeValueAsString(dutchBrOracle);

        Assert.assertTrue(jsonInString.contains("BAG"));
    }

    @Test
    public void test() {
        DogmaService service = new DogmaServiceImpl();
        DogmaServiceImpl.Xxx xxx = service.createAnddeployContract();
        service.callContract(xxx);
    }

    @Test
    @Ignore
    public void test2() throws Exception {
        Web3j web3 = Web3j.build(new HttpService());
        //Web3j web3 = Web3j.build(new WindowsIpcService("\\\\.\\pipe\\geth.ipc"));
        subscription = web3.blockObservable(true).subscribe(block -> {
            System.out.println("Sweet, block number " + block.getBlock().getNumber() + " has just been created");
        }, Throwable::printStackTrace);
        TimeUnit.MINUTES.sleep(1);
        subscription.unsubscribe();

        System.out.println("here");
        //TimeUnit.MINUTES.sleep(1);
    }
}
