package com.carabain.dogma.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameterName;
import org.web3j.protocol.http.HttpService;
import rx.Subscription;

import static org.web3j.tx.Contract.GAS_LIMIT;
import static org.web3j.tx.ManagedTransaction.GAS_PRICE;

/**
 * Default implementation of {@link DogmaChainService}.
 */
public class DogmaChainServiceImpl implements DogmaChainService {

    final Logger logger = LoggerFactory.getLogger(DogmaChainServiceImpl.class);

    @Override
    public void callContract(String address, Credentials credentials) {
        Web3j web3 = Web3j.build(new HttpService());  // defaults to http://localhost:8545/

        Personal contract = Personal.load(address, web3, credentials, GAS_PRICE, GAS_LIMIT);
        logger.info("Loaded contract: {}", contract.getContractAddress());

        logger.info("Subscribing to contract event 'Alive requested'...");
        Subscription aliveRequestedSubscription = contract.aliveRequestedEventObservable(
                DefaultBlockParameterName.EARLIEST, DefaultBlockParameterName.LATEST)
                .subscribe(event -> {
                    handleAliveRequested(contract);
                }, Throwable::printStackTrace);

        logger.info("Subscribing to contract event 'Alive updated'...");
        Subscription aliveUpdatedSubscription = contract.aliveUpdatedEventObservable(
                DefaultBlockParameterName.EARLIEST, DefaultBlockParameterName.LATEST)
                .subscribe(event -> {
                    handleAliveUpdated(contract);
                }, Throwable::printStackTrace);
    }

    private void handleAliveRequested(Personal contract) {
        logger.info("Received event: Request for 'isAlive'.");

        logger.info("Processing request...");
        // hier gegevens bepalen (database internet? etc/ etc/)
        boolean alive = true;

        logger.info("Updating contract...");
        contract.setAlive(alive).sendAsync();
    }

    private void handleAliveUpdated(Personal contract) {
        logger.info("Received event: Contract updated.");
    }
}
