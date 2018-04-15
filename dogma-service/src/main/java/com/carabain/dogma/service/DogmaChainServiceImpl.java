package com.carabain.dogma.service;

import org.web3j.crypto.CipherException;
import org.web3j.crypto.Credentials;
import org.web3j.crypto.WalletUtils;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameterName;
import org.web3j.protocol.core.methods.response.Web3ClientVersion;
import org.web3j.protocol.http.HttpService;
import rx.Subscription;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static org.web3j.tx.Contract.GAS_LIMIT;
import static org.web3j.tx.ManagedTransaction.GAS_PRICE;

/**
 * Default implementation of {@link DogmaChainService}.
 */
public class DogmaChainServiceImpl implements DogmaChainService {

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

    public Xxx createAnddeployContract() {
        Web3j web3 = Web3j.build(new HttpService());  // defaults to http://localhost:8545/

        String password = "xxx";
        String pathToWallet = "C:\\ws\\blockchain\\DogmaChain\\data\\keystore\\UTC--2018-04-07T09-07-27.336619000Z--8f4203671809e42f10c8dc6a406816e98c5e2828";
        String message = "Hallo Dogma! Lekkere cocktails ;-)";

        try {
            Credentials credentials = WalletUtils.loadCredentials(password, pathToWallet);
            // Greeter contract = Greeter.deploy(web3, credentials, GAS_PRICE, GAS_LIMIT, message).send();

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

//            Subscription subscription = web3.blockObservable(false).subscribe(block -> {
//                String ls = null;
//                ls.toString();
//                System.out.println("log.toString(): " + block.toString());
//            });

//            Subscription subscription = web3.transactionObservable().subscribe(tx -> {
//                System.out.println("log.toString(): " + tx.toString());
//            });
//            if (!subscription.isUnsubscribed()) {
//                System.out.println("dfgjkdfjgdfs");
//            }
//            contract.greet();
            //TimeUnit.MINUTES.sleep(1);
            //subscription.unsubscribe();

//            Greeter contract = Greeter.deploy( web3, credentials,  GAS_PRICE, GAS_LIMIT, message).send();
//            System.out.println("Deployed contract: " + contract.getContractAddress());
//
//            Xxx xxx = new Xxx();
//            xxx.address = contract.getContractAddress();
//            xxx.credentials = credentials;
//            return xxx;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (CipherException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    public void callContract(Xxx xxx) {
        Web3j web3 = Web3j.build(new HttpService());  // defaults to http://localhost:8545/

        try {
            Mortal contract = Mortal.load(
                    xxx.address, web3, xxx.credentials, GAS_PRICE, GAS_LIMIT);
            System.out.println("Loaded contract: " + contract.getContractAddress());

            System.out.println("Subscribing to contract...");
            Subscription subscription = contract.greetedEventObservable(
                    DefaultBlockParameterName.EARLIEST, DefaultBlockParameterName.LATEST)
                    .subscribe(evento -> {
                        System.out.println("Event Received");
                        System.out.println("Thread Name " + Thread.currentThread().getName());
                    }, Throwable::printStackTrace);

            Subscription anotherSubscription = contract.greetedAnotherEventObservable(
                    DefaultBlockParameterName.EARLIEST, DefaultBlockParameterName.LATEST)
                    .subscribe(evento -> {
                        System.out.println("Another Event Received");
                        System.out.println("Thread Name " + Thread.currentThread().getName());
                    }, Throwable::printStackTrace);

            TimeUnit.SECONDS.sleep(10);
            System.out.println("Calling contract...");
            contract.greet().send();
            System.out.println("Done.");
            TimeUnit.SECONDS.sleep(10);

            System.out.println("Calling contract.another...");
            contract.greetAnother().send();
            System.out.println("Done.");
            TimeUnit.SECONDS.sleep(10);

            System.out.println("Unsubscribing.");
            subscription.unsubscribe();
            anotherSubscription.unsubscribe();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static class Xxx {

        String address;
        Credentials credentials;
    }
}
