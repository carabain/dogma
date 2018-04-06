package nl.dogma.service;

import nl.dogma.domain.oracle.domain.DutchBrOracle;
import nl.dogma.domain.oracle.domain.DutchBrOracleFactory;
import org.web3j.crypto.CipherException;
import org.web3j.crypto.Credentials;
import org.web3j.crypto.WalletUtils;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.methods.response.Web3ClientVersion;
import org.web3j.protocol.http.HttpService;
import rx.Subscription;

import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.io.IOException;

import static org.web3j.tx.Contract.GAS_LIMIT;
import static org.web3j.tx.ManagedTransaction.GAS_PRICE;

public class DogmaServiceImpl implements DogmaService {

    @Override
    @Path("/getOracles")
    @Produces(MediaType.APPLICATION_JSON)
    public DutchBrOracle getDutchBrOracle() {
        return DutchBrOracleFactory.getInstance().getDutchBrOracle();
    }

    // Start sending requests
    public void x() {
        Web3j web3 = Web3j.build(new HttpService());  // defaults to http://localhost:8545/

        // To send synchronous requests:
        Web3ClientVersion web3ClientVersion = null;
        try {
            web3ClientVersion = web3.web3ClientVersion().send();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // To send asynchronous requests using a CompletableFuture (Future on Android):
        // Web3ClientVersion web3ClientVersion = web3.web3ClientVersion().sendAsync().get();

        // To use an RxJava Observable:
        web3.web3ClientVersion().observable().subscribe(x -> {
            String clientVersion = x.getWeb3ClientVersion();
            //...
        });

        String clientVersion = web3ClientVersion.getWeb3ClientVersion();

        // When you no longer need a Web3j instance you need to call the shutdown method to close resources used by it.
        //web3.shutdown();
    }

    public void createAnddeployAndSendContract() {
        Web3j web3 = Web3j.build(new HttpService());  // defaults to http://localhost:8545/

        String password = "xxx";
        String pathToWallet = "C:\\ws\\blockchain\\DogmaChain\\data\\keystore\\UTC--2018-04-06T11-03-20.029808300Z--fc61e2bc9cd8aea24246dba83fc14807fba2460b";
        String message = "Hallo Dogma! Lekkere cocktails ;-)";

        try {
            Credentials credentials = WalletUtils.loadCredentials(password, pathToWallet);
            Greeter contract = Greeter.deploy( web3, credentials,  GAS_PRICE, GAS_LIMIT, message).send();

//            final Event event = new Event("callbackDummy",
//                    Arrays.<TypeReference<?>>asList(),
//                    Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint8>() {}));
//            EthFilter filter = new EthFilter(DefaultBlockParameterName.EARLIEST, DefaultBlockParameterName.LATEST,
//                    contract.getContractAddress().substring(2));
//            filter.addSingleTopic(EventEncoder.encode(event));
//
//            web3.ethLogObservable(filter).subscribe(log -> {
//                System.out.println("log.toString(): " +  log.toString());
//            });

            Subscription subscription = web3.blockObservable(false).subscribe(block -> {
                String ls = null; ls.toString();
                System.out.println("log.toString(): " + block.toString());
            });

//            Subscription subscription = web3.transactionObservable().subscribe(tx -> {
//                System.out.println("log.toString(): " + tx.toString());
//            });
            if (!subscription.isUnsubscribed()) {
                System.out.println("dfgjkdfjgdfs");
            }
            contract.greet();
            //TimeUnit.MINUTES.sleep(1);
            //subscription.unsubscribe();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (CipherException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
