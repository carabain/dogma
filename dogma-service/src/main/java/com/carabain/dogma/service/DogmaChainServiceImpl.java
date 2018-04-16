package com.carabain.dogma.service;

import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameterName;
import org.web3j.protocol.http.HttpService;
import rx.Subscription;

import java.util.concurrent.TimeUnit;

import static org.web3j.tx.Contract.GAS_LIMIT;
import static org.web3j.tx.ManagedTransaction.GAS_PRICE;

/**
 * Default implementation of {@link DogmaChainService}.
 */
public class DogmaChainServiceImpl implements DogmaChainService {

    @Override
    public void callContract(String address, Credentials credentials) {
        Web3j web3 = Web3j.build(new HttpService());  // defaults to http://localhost:8545/

        try {
            Mortal contract = Mortal.load(address, web3, credentials, GAS_PRICE, GAS_LIMIT);
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
}
